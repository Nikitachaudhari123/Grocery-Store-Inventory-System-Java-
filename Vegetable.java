import java.util.Scanner;
/**
 * Vegetable class for vegetables the buy and sell operations in the InventorySystem.
 * 
 * Student Name: Nikitaben Chaudhari
 * Student Number: 041109670
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * 
 * @Author/Professor Narges Taber
 */
/**
 * vegetable class
 */
public class Vegetable extends FoodItem {
    private String farmName;
    /**
     * Constructor for the Vegetable class.
     * Initializes a new instance of Vegetable.
     */
    public Vegetable() {
        super();
    }

    /**
     * Returns the type of the item.
     * 
     * @return A string representing the item type, which is "Vegetable".
     */
    @Override
    public String getItemType() {
        return "Vegetable";
    }

    /**
     * Returns a string representation of the Vegetable object, 
     * including the farm supplier.
     * 
     * @return A string with details about the vegetable.
     */
    @Override
    public String toString() {
        return super.toString() + ", Farm Supplier: " + farmName;
    }

    /**
     * Adds a new Vegetable item by prompting the user for details.
     * Extends the addItem method from the FoodItem class to include 
     * the farm supplier.
     * 
     * @param scanner The Scanner object to read user input.
     * @return true if the item was successfully added, false otherwise.
     */
    @Override
    public boolean addItem(Scanner scanner) {
        if (!super.addItem(scanner)) {
            return false;
        }
        System.out.print("Enter the name of the farm supplier: ");
        farmName = scanner.next();
        return true;
    }
}