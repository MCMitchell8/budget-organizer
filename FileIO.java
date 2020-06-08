/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BudgetUI;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author melissacmitchell
 */
//reads and writes the budget and transactions
public class FileIO {
    
    //reads the current budget
    public static double readCurrentBudget() {
        double currentBudget = 0;
        
        try {
            FileInputStream fileInput;
            ObjectInputStream objectInput;
            
            fileInput = new FileInputStream("/tmp/currentBudget");
            objectInput = new ObjectInputStream(fileInput);
            
            currentBudget = (Double)objectInput.readObject();
            
            objectInput.close();
            fileInput.close();

        } catch (IOException error) {
            error.printStackTrace();
            return currentBudget;
        } catch (ClassNotFoundException error) {
            System.out.println("Couldn't find Transaction class.");
            error.printStackTrace();
            return currentBudget;
        }

        return currentBudget;
    }
    
    //writes the current budget
    public static void writeCurrentBudget(double budget) {
        try {
            FileOutputStream fileOutput;
            ObjectOutputStream objectOutput;
            
            fileOutput = new FileOutputStream("/tmp/currentBudget");
            objectOutput = new ObjectOutputStream(fileOutput);
            
            objectOutput.writeObject(budget);
            
            objectOutput.close();
            fileOutput.close();
            
            //.println("Saved budget to disk.");
            
        } catch (IOException error) {
            error.printStackTrace();
        }
 
    }      
      
    //reads the current transactions
    public static ArrayList<Transaction> readTransactions() {
        ArrayList<Transaction> transactionsToReturn = null;
        
        try {
            FileInputStream fileInput;
            ObjectInputStream objectInput;
            
            fileInput = new FileInputStream("/tmp/transactions");
            objectInput = new ObjectInputStream(fileInput);
            
            transactionsToReturn = (ArrayList<Transaction>) objectInput.readObject();
            
            objectInput.close();
            fileInput.close();
            
            //System.out.println("Read data for object array.");

        } catch (IOException error) {
            error.printStackTrace();
            return transactionsToReturn;
        } catch (ClassNotFoundException error) {
            System.out.println("Couldn't find Transaction class.");
            error.printStackTrace();
            return transactionsToReturn;
        }
        
        return transactionsToReturn;
    }
    
    //writes the current transactions
    public static void writeTransactions(ArrayList<Transaction>  transactions) {
        
        try {
            
            FileOutputStream fileOutput;
            ObjectOutputStream objectOutput;
            
            fileOutput = new FileOutputStream("/tmp/transactions");
            objectOutput = new ObjectOutputStream(fileOutput);
            
            objectOutput.writeObject(transactions);
            
            objectOutput.close();
            fileOutput.close();
            
        } catch (IOException error) {
            error.printStackTrace();
        }
        
    }

}
