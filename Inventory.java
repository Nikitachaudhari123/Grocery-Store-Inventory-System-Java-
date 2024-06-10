import java.util.Scanner;
/**
 * inventory class for updating  the buy and sell operations in the InventorySystem.
 * 
 * Student Name: Nikitaben Chaudhari
 * Student Number: 041109670
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * 
 * @Author/Professor Narges Taber
 */

/**
 * Class representing an inventory system for managing food items.
 */
public class Inventory {
    private FoodItem[] inventory;
    private int numItems;
    private Scanner scanner;

    /**
     * Constructor for the Inventory class.
     * Initializes the inventory with a specified size and sets up the Scanner for input.
     * 
     * @param scanner The Scanner object to read user input.
     */
    public Inventory(Scanner scanner) {
        this.inventory = new FoodItem[22]; // Maximum of 22 entries
        this.numItems = 0;
        this.scanner = scanner;
    }

    /**
     * Adds an item to the inventory if it doesn't already exist and there is space.
     * 
     * @param item The food item to be added.
     * @return true if the item was successfully added, false otherwise.
     */
    public boolean addItem(FoodItem item) {
        if (numItems < inventory.length && alreadyExists(item.itemCode) == -1) {
            inventory[numItems++] = item;
            return true;
        }
        return false;
    }

    /**
     * Checks if an item with the given code already exists in the inventory.
     * 
     * @param itemCode The code of the item to check.
     * @return The index of the item if it exists, -1 otherwise.
     */
    public int alreadyExists(int itemCode) {
        for (int i = 0; i < numItems; i++) {
            if (inventory[i].itemCode == itemCode) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Updates the quantity of an item in the inventory based on whether it is being bought or sold.
     * 
     * @param itemCode The code of the item to update.
     * @param quantity The quantity to add (positive) or subtract (negative).
     * @param isBuying true if buying (increasing quantity), false if selling (decreasing quantity).
     * @return true if the quantity was successfully updated, false otherwise.
     */
    public boolean updateQuantity(int itemCode, int quantity, boolean isBuying) {
        int index = alreadyExists(itemCode);
        if (index != -1) {
            return inventory[index].updateItem(isBuying ? quantity : -quantity);
        }
        return false;
    }

    /**
     * Displays the current inventory with details of each item.
     */
    public void displayInventory() {
        System.out.println("Inventory:");
        for (int i = 0; i < numItems; i++) {
            System.out.println(inventory[i]);
        }
    }

    /**
     * Prompts the user to add a new item to the inventory.
     */
    public void addItemToInventory() {
        try {
            System.out.print("Do you wish to add a fruit(f), vegetable(v) or a preserve(p)? ");
            String type = scanner.next();
            FoodItem item = null;
            switch (type.toLowerCase()) {
                case "f":
                    item = new Fruit();
                    break;
                case "v":
                    item = new Vegetable();
                    break;
                case "p":
                    item = new Preserve();
                    break;
                default:
                    System.out.println("Invalid entry");
                    return;
            }
            if (item.addItem(scanner)) {
                if (!addItem(item)) {
                    System.out.println("Failed to add item. Item code may already exist.");
                } else {
                    System.out.println("Item added successfully.");
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred while adding the item: " + e.getMessage());
        }
    }

    /**
     * Prompts the user to update the quantity of an item in the inventory.
     * 
     * @param isBuying true if buying (increasing quantity), false if selling (decreasing quantity).
     */
    public void updateInventory(boolean isBuying) {
        try {
            System.out.print("Enter the item code: ");
            while (!scanner.hasNextInt()) {
                scanner.next(); // clear non-integer input
                System.out.println("Invalid entry. Please enter a valid item code.");
            }
            int code = scanner.nextInt();
            System.out.print("Enter the quantity: ");
            while (!scanner.hasNextInt()) {
                scanner.next(); // clear non-integer input
                System.out.println("Invalid entry. Please enter a valid quantity.");
            }
            int quantity = scanner.nextInt();
            if (quantity > 0) {
                boolean success = updateQuantity(code, quantity, isBuying);
                if (!success) {
                    System.out.println("Operation failed. Item code not found or insufficient stock.");
                } else {
                    System.out.println("Inventory updated successfully.");
                }
            } else {
                System.out.println("Invalid quantity. Quantity must be positive.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while updating the inventory: " + e.getMessage());
        }
    }
}