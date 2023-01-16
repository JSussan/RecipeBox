/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RecipeBox;

// Importing Java scanner
import java.util.Scanner;

/*
 * @author  Jonathan Sussan
 * @date    01/15/2023
 * @version 3.0
 * @title   Ingredient class
 */

public class Ingredient {
    // Private variables
    private String nameOfIngredient;    // Initialized to string for sequence of characters
    private float numberCups;           // Initialized to float for decimal value
    private double numberCaloriesPerCup;// Initialized to double for decimal value
    private double totalCalories;       // Initialized to double for decimal value

    // Mutators (setters) and accessors (getters) for each variable
    /**
     * @param nameOfIngredient the nameOfIngredient to set
     */
    public void setNameOfIngredient(String nameOfIngredient){
        this.nameOfIngredient = nameOfIngredient;
    }
    
    /**
     * @return the nameOfIngredient
     */
    public String getNameOfIngredient(){
        return nameOfIngredient;
    }

    /**
     * @param numberCups the numberCups to set
     */
    public void setNumberCups(float numberCups){
        this.numberCups = numberCups;
    }
    
    /**
     * @return the ingredientAmount
     */
    public float getNumberCups(){
        return numberCups;
    }

    /**
     * @param numberCaloriesPerCup the numberCaloriesPerCup to set
     */
    public void setNumberCaloriesPerCup(double numberCaloriesPerCup){
        this.numberCaloriesPerCup = numberCaloriesPerCup;
    }
    
    /**
     * @return the numberCaloriesPerCup
     */
    public double getNumberCaloriesPerCup(){
        return numberCaloriesPerCup;
    }

    /**
     * @param totalCalories the totalCalories to set
     */
    public void setTotalCalories(double totalCalories){
        this.totalCalories = numberCaloriesPerCup * numberCups;
    }
    
    /**
     * @return the totalCalories
     */
    public double getTotalCalories(){
        return totalCalories;
    }

    // Constructor
    public Ingredient(){
        this.nameOfIngredient = "";
        this.numberCups = 0;
        this.numberCaloriesPerCup = 0.0;
        this.totalCalories = 0.0;
    }
    
    // Overload constructor
    public Ingredient(String nameOfIngredient, float numberCups, 
            double numberCaloriesPerCup, double totalCalories){
        this.nameOfIngredient = nameOfIngredient;
        this.numberCups = numberCups;
        this.numberCaloriesPerCup = numberCaloriesPerCup;
        this.totalCalories = totalCalories;
    }

    // Method to add new ingredient
    public Ingredient addIngredient() {
        Scanner scnr = new Scanner(System.in);

        // Validate ingredient name, user is asked to input ingredient name
        System.out.println("Enter ingredient name: ");
        nameOfIngredient = scnr.nextLine();
        setNameOfIngredient(nameOfIngredient);

        // Validate ingredient amount
        System.out.println("Please enter the amount of cups required for ingredient " 
                + nameOfIngredient + ": ");
        numberCups = scnr.nextFloat();
        setNumberCups(numberCups);

        // Validate number of calories per unit
        System.out.println("Please enter the amount of calories per cup of ingredient " 
                + nameOfIngredient + ": ");
        numberCaloriesPerCup = scnr.nextFloat();
        setNumberCaloriesPerCup(numberCaloriesPerCup);

        // Expression to find totalCalories
        setTotalCalories(getNumberCups() * getNumberCaloriesPerCup());

        // Validate ingredient has been added successfully
        System.out.println(nameOfIngredient + " contains a total of " + totalCalories + " calories.");
        System.out.println(nameOfIngredient + " has been added successfully!");

        Ingredient newIngredient = new Ingredient(getNameOfIngredient(), 
                getNumberCups(), getNumberCaloriesPerCup(), 
                getTotalCalories());
        
        return newIngredient;
    }
}