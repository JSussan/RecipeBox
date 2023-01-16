/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RecipeBox;

// Importing Java scanner
import java.util.Scanner;
// Allows us to use dynamic arrays
import java.util.ArrayList;

/*
 * @author  Jonathan Sussan
 * @date    01/15/2023
 * @version 3.0
 * @title   Recipe class
 */

public class Recipe {
    // Private variables
    private String recipeName;
    private int servings;
    private ArrayList<Ingredient> recipeIngredients = new ArrayList<>();
    private double totalRecipeCalories;
    private String recipeInstructions;
    
    // Mutators (setters) and accessors (getters) for each variable
    /**
     * @param recipeName the recipeName to set
     */
    public void setRecipeName(String recipeName){
        this.recipeName = recipeName;
    }
    
    /**
     * @return the recipeName
     */
    public String getRecipeName(){
        return recipeName;
    }
    
    /**
     * @param servings the servings to set
     */
    public void setServings(int servings){
        this.servings = servings;
    }
    
    /**
     * @return the servings
     */
    public int getServings(){
        return servings;
    }

    /**
     * @param recipeIngredients the recipeIngredients to set
     */
    public void setRecipeIngredients(ArrayList<Ingredient> recipeIngredients){
        this.recipeIngredients = recipeIngredients;
    }
    
    /**
     * @return the recipeIngredients
     */
    public ArrayList<Ingredient> getRecipeIngredients(){
        return recipeIngredients;
    }

    /**
     * @param totalRecipeCalories the totalRecipeCalories to set
     */
    public void setTotalRecipeCalories(int totalRecipeCalories){
        this.totalRecipeCalories = totalRecipeCalories;
    }
    
    /**
     * @return the totalRecipeCalories
     */
    public double getTotalRecipeCalories(){
        return totalRecipeCalories;
    }

    /**
     * @param recipeInstructions the recipeInstructions to set
     */
    public void setRecipeInstructions(String recipeInstructions){
        this.recipeInstructions = recipeInstructions;
    }
    
    /**
     * @return the recipeInstructions
     */
    public String getRecipeInstructions(){
        return recipeInstructions;
    }

    // Initialize fields for constructor
    public Recipe(){
        this.recipeName = "";
        this.servings = 0;
        this.recipeIngredients = new ArrayList<>();
        this.totalRecipeCalories = 0;
        this.recipeInstructions = "";
    }
    
    // Overload constructor
    public Recipe(String recipeName, int servings, ArrayList<Ingredient> recipeIngredients, 
            double totalRecipeCalories, String recipeInstructions){
        this.recipeName = recipeName;
        this.servings = servings;
        this.recipeIngredients = recipeIngredients;
        this.totalRecipeCalories = totalRecipeCalories;
        this.recipeInstructions = recipeInstructions;
    }

    // Method to add recipe instructions
    public void recipeInstructions(){
        String instructions = "";
        System.out.println("Please enter recipe instructions: ");
        Scanner scnr = new Scanner(System.in);
        instructions = scnr.nextLine();
        setRecipeInstructions(instructions);
    }

    // Prints recipe
    public void printRecipe() {
        double singleServingCalories = totalRecipeCalories / servings;
        System.out.println("Recipe name: " + recipeName);
        System.out.println("Servings: " + servings);
        System.out.println("Calories per serving: " + singleServingCalories);
        System.out.println("Total calories: " + totalRecipeCalories);
        System.out.println("List of ingredients: ");
        
        // For loop to iterate through the ingredients
        for (int i = 0; i < recipeIngredients.size(); i++) {  
            System.out.println((i+1) + ". " + recipeIngredients.get(i).getNameOfIngredient() 
                    + ": " + recipeIngredients.get(i).getTotalCalories() + " calories.");
        }
        System.out.println("List of instructions: " + recipeInstructions);
    }

    // Method to add a new recipe
    public Recipe addRecipe() {
        boolean addMoreIngredients = true;
        Ingredient newIngredient = new Ingredient();
        
        Scanner scnr = new Scanner(System.in);
        
        System.out.println("Please enter the recipe name: ");
        recipeName = scnr.nextLine();
        setRecipeName(recipeName);
        
        System.out.println("Please enter the number of servings: ");
        servings = scnr.nextInt();
        setServings(servings);
        
        // Prompt user to add ingredients
        System.out.println("Please enter an ingredient for " + recipeName + ": ");
        do {
            recipeIngredients.add(newIngredient.addIngredient());
            System.out.println("Would you like to enter another Ingredient for " + recipeName + "?");
            System.out.println("Enter 'y' for Yes or 'n' for no.");
            String input = scnr.next();
            if (input.equalsIgnoreCase("n")){
                addMoreIngredients = false;
            }
            else {
                addMoreIngredients = true;
            }
        }
        while(addMoreIngredients);
        
        // Calculate the total calories
        for (int i = 0; i < recipeIngredients.size(); i++){
            Ingredient currIngredient = recipeIngredients.get(i);
            double currIngredientCalories  = currIngredient.getTotalCalories();
            totalRecipeCalories += currIngredientCalories;
        }
        System.out.println(recipeName + " has a total of " + totalRecipeCalories + " calories.");
        
        // Ask user for recipe instructions
        recipeInstructions();

        Recipe newRecipe = new Recipe(getRecipeName(), getServings(), 
                getRecipeIngredients(), getTotalRecipeCalories(), 
                getRecipeInstructions());
        
        return newRecipe;
    }
}