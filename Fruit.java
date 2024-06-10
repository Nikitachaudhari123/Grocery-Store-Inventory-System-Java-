import java.util.Scanner;
/**
 * Fruit class for fruits the buy and sell operations in the InventorySystem.
 * 
 * Student Name: Nikitaben Chaudhari
 * Student Number: 041109670
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * 
 * @Author/Professor Narges Taber
 */
/**
 * Class representing a type of food item known as Fruit.
 * Contains an additional attribute for the orchard supplier.
 */
public class Fruit extends FoodItem {
    private String orchardName;

    /**
     * Constructor for the Fruit class.
     * Initializes a new instance of Fruit.
     */
    public Fruit() {
        super();
    }

    /**
     * Returns the type of the item.
     * 
     * @return A string representing the item type, which is "Fruit".
     */
    @Override
    public String getItemType() {
        return "Fruit";
    }

    /**
     * Returns a string representation of the Fruit object,
     * including the orchard supplier.
     * 
     * @return A string with details about the fruit.
     */
    @Override
    public String toString() {
        return super.toString() + ", Orchard Supplier: " + orchardName;
    }

    /**
     * Adds a new Fruit item by prompting the user for details.
     * Extends the addItem method from the FoodItem class to include
     * the orchard supplier.
     * 
     * @param scanner The Scanner object to read user input.
     * @return true if the item was successfully added, false otherwise.
     */
    @Override
    public boolean addItem(Scanner scanner) {
        if (!super.addItem(scanner)) {
            return false;
        }
        System.out.print("Enter the name of the orchard supplier: ");
        orchardName = scanner.next();
        return true;
    }
}
