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
 * @title   RecipeBox class
 */

public class RecipeBox {
    // Private variables
    private ArrayList<Recipe> listOfRecipes;

    /**
     * @param listOfRecipes the listOfRecipes to set
     */
    public void setListOfRecipes(ArrayList<Recipe> listOfRecipes) {
        this.listOfRecipes = listOfRecipes;
    }
    
    /**
     * @return the listOfRecipes
     */
    public ArrayList<Recipe> getListOfRecipes() {
        return listOfRecipes;
    }
    
    // Initialize fields for constructor

    /**
     *
     */
    public RecipeBox() {
        this.listOfRecipes = new ArrayList();
    }
    
    // Overload constructor

    /**
     *
     * @param listOfRecipes
     */
    public RecipeBox(ArrayList<Recipe> listOfRecipes){
        this.listOfRecipes = listOfRecipes;
    }
    
    // Print all recipe names method to screen 

    /**
     *
     */
    public void printAllRecipeNames(){
        System.out.println("List of recipes you have created: ");
        if (listOfRecipes.isEmpty()) {
            System.out.println("There are currently no recipes saved.");
        }
        else {
            for (int i = 0; i < listOfRecipes.size(); i++) {
                System.out.println((i + 1) + ". " + listOfRecipes.get(i).getRecipeName());
            }
        }
        System.out.println("");
    }
    
    // Print all recipe details method to screen 

    /**
     *
     * @param selectedRecipe
     */
    public void printAllRecipeDetails(String selectedRecipe) {
        for (int j = 0; j < listOfRecipes.size(); j++) {
            if (listOfRecipes.get(j).getRecipeName().equals(selectedRecipe)) {
                listOfRecipes.get(j).printRecipe();
            }
        }
        System.out.println("");
    }
    
    // Add a new recipe

    /**
     *
     */
    public void newRecipe() {
        listOfRecipes.add(new Recipe().addRecipe());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RecipeBox recipeVault = new RecipeBox();
        boolean vaultRunning = true;
        Scanner menuScanner = new Scanner(System.in);

        do {
            // Print a menu for the user to select one of the 5 options
            System.out.println("""
                               Recipe Box Menu
                               1. Add a recipe
                               2. Print all recipes
                               3. Find a recipe
                               4. Delete a recipe
                               5. Exit program
                           
                               Please select a menu item:""");
            
            int menuInput = menuScanner.nextInt();
        
            switch(menuInput) {
                case 1:
                    recipeVault.newRecipe();
                    break;
                case 2:
                    recipeVault.printAllRecipeNames();
                    break;
                case 3:
                    recipeVault.printAllRecipeNames();
                    System.out.println("Enter the recipe you would like to print: ");
                    Scanner inputScanner = new Scanner(System.in);
                    String inputRecipe = inputScanner.nextLine();
                    recipeVault.printAllRecipeDetails(inputRecipe);
                    break;
                case 4:
                    recipeVault.printAllRecipeNames();
                    System.out.println("Enter the recipe number you would like to delete: ");
                    int recipeDelete = menuScanner.nextInt();
                    recipeDelete = recipeDelete - 1;
                    recipeVault.listOfRecipes.remove(recipeDelete);
                    break;
                case 5:
                    System.out.println("Exiting program... Goodbye.");
                    System.exit(0);
                default:
                    System.out.println("Invalid input, please enter number 1, 2, 3, 4, or 5 to continue: ");
                    System.out.println("");
                    break;
            }      
        } while (vaultRunning == true);
    }
}
