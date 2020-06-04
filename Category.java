/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BudgetUI;

/**
 *
 * @author melissacmitchell
 */

//Enum contains the possible categories
public enum Category {
    BillsAndUtilities, Kids, Dining, Groceries, Entertainment, 
    PersonalCare, HealthAndFitness, GiftsAndDonations, Investments, 
    Miscellaneous;
    
    @Override
    public String toString() {
        String stringToReturn;
        //switch statemrnt converts enum value to string
        switch(this) {
            case BillsAndUtilities:
                stringToReturn = "Bills and Utilities";
                break;
            case Kids:
                stringToReturn = "Kids";
                break;
            case Dining:
                stringToReturn = "Dining";
                break;
            case Groceries:
                stringToReturn = "Groceries";
                break;
            case Entertainment:
                stringToReturn = "Entertainment";
                break;
            case PersonalCare:
                stringToReturn = "Personal Care";
                break;
            case HealthAndFitness:
                stringToReturn = "Health and Fitness";
                break;
            case GiftsAndDonations:
                stringToReturn = "Gifts and Donations";
                break;
            case Investments:
                stringToReturn = "Investments";
                break;
            default:
                stringToReturn = "Miscellaneous";
                break;
        }
        
        return stringToReturn;
    }
    
    public static Category CreateFromString(String value) {
        Category categoryToReturn;
        
        //switch statement converts string to enum value
        
        switch (value) {
            case "Bills and Utilities":
                categoryToReturn = Category.BillsAndUtilities;
                break;
            case "Kids":
                categoryToReturn = Category.Kids;
                break;
            case "Dining":
                categoryToReturn = Category.Dining;
                break;
            case "Groceries":
                categoryToReturn = Category.Groceries;
                break;
            case "Entertainment":
                categoryToReturn = Category.Entertainment;
                break;
            case "Personal Care":
                categoryToReturn = Category.PersonalCare;
                break;
            case "Health and Fitness":
                categoryToReturn = Category.HealthAndFitness;
                break;
            case "Gifts and Donations":
                categoryToReturn = Category.GiftsAndDonations;
                break;
            case "Investments":
                categoryToReturn = Category.Investments;
                break;
            default:
                categoryToReturn = Category.Miscellaneous;
                break;
        }
        
        return categoryToReturn;
    }
}
