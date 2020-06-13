/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BudgetUI;

import java.util.ArrayList;


/**
 *
 * @author melissacmitchell
 */

//serializes the transactions
public class Transaction implements java.io.Serializable {
    
    //declare variables
    Category category;                                  
    double price;
    int month;
    int year;
    boolean recurring;
    int everyMonth;
    
    //copy constructor
    Transaction(Transaction transactionToCopy) {
        category = transactionToCopy.category;
        price = transactionToCopy.price;
        month = transactionToCopy.month;
        year = transactionToCopy.year;
        recurring = transactionToCopy.recurring;
        everyMonth = transactionToCopy.everyMonth;
    }
    
    //value constructor
    Transaction(Category category, double price, int month, int year, boolean recurring, int everyMonth) {
        this.category = category;
        this.price = price;
        this.month = month;
        this.year = year;
        this.recurring = recurring;
        this.everyMonth = everyMonth;
    }
    
    private void incrementMonth() {
        //increments the month
        month += 1;
        //if the month goes past December, reset to January and increment year
        if (month == 13) {
            month = 1;
            year += 1;
        }
    }
    
    private Transaction next() {
        if (month == 1 && year == 2029) {
            return null;
        }
        
        Transaction transactionToReturn = new Transaction(this);
        
        //if this transaction isn't recurring, set the next one to be null
        if (!recurring) {
            month = 1;
            year = 2029;
        //otherwise, set month to next calendar month
        } else {
            incrementMonth();
        }        
        
        return transactionToReturn;
    }
    
    //creates future transactions for the current transaction
    public void createFuture(ArrayList<Transaction> transactions) {
        Transaction transactionToAdd = next();
        while (transactionToAdd != null) {
            transactions.add(transactionToAdd);
            transactionToAdd = next();
        }
    }
    
    //updates the future transactions for the current transaction
    public void updateFuture(ArrayList<Transaction> transactions, Transaction original) {
        
        int searchMonth = month;
        int searchYear = year;

        // The first increment needs to be outside the while loop
        incrementMonth();
        
        //nested loops to update future transactions
        //while the search year is still in range
        while (searchYear < 2029) {
        
            //for every transaction
            for(Transaction transaction : transactions){
                
                //if the transaction is a future transaction of the original, update it
                if (((transaction.month > original.month && transaction.year == original.year) 
                            || transaction.year > original.year) &&
                        transaction.price == original.price &&
                        transaction.category == original.category &&
                        transaction.recurring == original.recurring &&
                        transaction.everyMonth == original.everyMonth) {

                    transaction.year = searchYear;
                    transaction.month = searchMonth;
                    transaction.price = price;
                    transaction.category = category;
                    transaction.recurring = recurring;
                    transaction.everyMonth = everyMonth;
                    
                    original.month = searchMonth;
                    original.year = searchYear;
                    break;
                }
            }
            
            //the second increment needs to be after a match is found
            incrementMonth();
            
        }

    }
    
    //deletes future transactions
    public void deleteFuture(ArrayList<Transaction> transactions) {
        
        //while year in range
        while (year < 2029) {
            
            //for every transaction, if it matches the original transaction, delete it
            for(Transaction transaction : transactions){
                
                if (((transaction.month > month && transaction.year == year) 
                            || transaction.year > year) &&
                        transaction.price == price &&
                        transaction.category == category &&
                        transaction.recurring == recurring &&
                        transaction.everyMonth == everyMonth) {

                    transactions.remove(transaction);
                    
                    break;

                }
            }
            
            incrementMonth();
        }

    }
    
    //getters and setters
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }
    
    public void setYear(int year) {
        this.category = category;
    }

    public boolean getRecurring() {
        return recurring;
    }

    public void setRecurring(boolean fixed) {
        this.recurring = fixed;
    }
    
    public int getEveryMonth() {
        return everyMonth;
    }

    public void setEveryMonth(int everyMonth) {
        this.everyMonth = everyMonth;
    }
}
