import java.util.Scanner;

/**
 * Abstract class representing a generic food item.
 */
public abstract class FoodItem {
    int itemCode;
    protected String itemName;
    protected float itemPrice;
    protected int itemQuantityInStock;
    protected float itemCost;

    /**
     * Constructor for the FoodItem class.
     */
    public FoodItem() {}

    /**
     * Returns a string representation of the FoodItem object.
     * 
     * @return A string with details about the food item.
     */
    @Override
    public String toString() {
        return "Item Code: " + itemCode + ", Item Name: " + itemName + ", Quantity: " + itemQuantityInStock + ", Price: $" + itemPrice + ", Cost: $" + itemCost;
    }

    /**
     * Prompts the user to enter details for the food item.
     * 
     * @param scanner The Scanner object to read user input.
     * @return true if the item was successfully added, false otherwise.
     */
    public boolean addItem(Scanner scanner) {
        System.out.print("Enter the code for the item: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid entry");
            return false;
        }
        itemCode = scanner.nextInt();

        System.out.print("Enter the name for the item: ");
        itemName = scanner.next();

        System.out.print("Enter the quantity for the item: ");
        if (!scanner.hasNextInt() || (itemQuantityInStock = scanner.nextInt()) < 0) {
            System.out.println("Invalid entry");
            return false;
        }

        System.out.print("Enter the cost of the item: ");
        if (!scanner.hasNextFloat() || (itemCost = scanner.nextFloat()) < 0) {
            System.out.println("Invalid entry");
            return false;
        }

        System.out.print("Enter the sales price of the item: ");
        if (!scanner.hasNextFloat() || (itemPrice = scanner.nextFloat()) < 0) {
            System.out.println("Invalid entry");
            return false;
        }

        return true;
    }

    /**
     * Updates the quantity of the food item in stock.
     * 
     * @param amount The amount to add (positive) or subtract (negative).
     * @return true if the quantity was successfully updated, false otherwise.
     */
    public boolean updateItem(int amount) {
        if (itemQuantityInStock + amount < 0) {
            System.out.println("Insufficient stock in inventory...");
            return false;
        }
        itemQuantityInStock += amount;
        return true;
    }

    /**
     * Checks if two food items are equal based on their item code.
     * 
     * @param item The food item to compare.
     * @return true if the items are equal, false otherwise.
     */
    public boolean isEqual(FoodItem item) {
        return this.itemCode == item.itemCode;
    }

    /**
     * Prompts the user to enter the item code.
     * 
     * @param scanner The Scanner object to read user input.
     * @return true if a valid code was entered, false otherwise.
     */
    public boolean inputCode(Scanner scanner) {
        System.out.print("Enter item code: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid entry");
            return false;
        }
        this.itemCode = scanner.nextInt();
        return true;
    }
    
    /**
     * Returns the type of the item.
     * 
     * @return A string representing the item type.
     */
    public abstract String getItemType();
}