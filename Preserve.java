import java.util.Scanner;
/**
 * Preserve class for preserver the buy and sell operations in the InventorySystem.
 * 
 * Student Name: Nikitaben Chaudhari
 * Student Number: 041109670
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * 
 * @Author/Professor Narges Taber
 */

/**
 * Class representing a type of food item known as Preserve.
 * Contains an additional attribute for the size of the jar.
 */
public class Preserve extends FoodItem {
    private int jarSize;

    /**
     * Constructor for the Preserve class.
     * Initializes a new instance of Preserve.
     */
    public Preserve() {
        super();
    }

    /**
     * Returns the type of the item.
     * 
     * @return A string representing the item type, which is "Preserve".
     */
    @Override
    public String getItemType() {
        return "Preserve";
    }

    /**
     * Returns a string representation of the Preserve object,
     * including the jar size.
     * 
     * @return A string with details about the preserve.
     */
    @Override
    public String toString() {
        return super.toString() + ", Jar Size: " + jarSize + "mL";
    }

    /**
     * Adds a new Preserve item by prompting the user for details.
     * Extends the addItem method from the FoodItem class to include
     * the jar size.
     * 
     * @param scanner The Scanner object to read user input.
     * @return true if the item was successfully added, false otherwise.
     */
    @Override
    public boolean addItem(Scanner scanner) {
        if (!super.addItem(scanner)) {
            return false;
        }
        System.out.print("Enter the size of the jar in milliliters: ");
        if (!scanner.hasNextInt() || (jarSize = scanner.nextInt()) < 0) {
            System.out.println("Invalid entry");
            return false;
        }
        return true;
    }
}

