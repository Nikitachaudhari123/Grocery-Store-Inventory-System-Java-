import java.util.Scanner;
/**
 * Assign 1 class for  operations in the InventorySystem.
 * 
 * Student Name: Nikitaben Chaudhari
 * Student Number: 041109670
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * 
 * @Author/Professor Narges Taber
 */
public class Assign1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory system = new Inventory(scanner);
        boolean running = true;

        while (running) {
            try {
                displayMenu();
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid choice");
                    scanner.next(); 
                    continue;
                }
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        system.addItemToInventory();
                        break;

                    case 2:
                        system.displayInventory();
                        break;

                    case 3:
                        system.updateInventory(true);
                        break;

                    case 4:
                        system.updateInventory(false);
                        break;

                    case 5:
                        running = false;
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

        scanner.close();
    }

    /** 
     * display method for menu
     * */
    public static void displayMenu() {
        System.out.println("Please select one of the following:");
        System.out.println("1: Add Item to Inventory");
        System.out.println("2: Display Current Inventory");
        System.out.println("3: Buy Item(s)");
        System.out.println("4: Sell Item(s)");
        System.out.println("5: To Exit");
        System.out.print("> ");
    }
}