import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Scanner;

/**
 * JUnit test class for testing the buy and sell operations in the InventorySystem.
 * 
 * Student Name: Nikitaben Chaudhari
 * Student Number: 041109670
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * 
 * @Author/Professor Narges Taber
 */
public class BuySellTests {

    /**
     * Tests the buy operation in the InventorySystem.
     */
    @Test
    public void testBuyOperation() {
        Inventory inventory = new Inventory (new Scanner(System.in));
        Fruit fruit = new Fruit();
        fruit.itemCode = 1;
        fruit.itemName = "Mango";
        fruit.itemQuantityInStock = 20;
        fruit.itemCost = 2.50f;
        fruit.itemPrice = 3.00f;
        inventory.addItem(fruit);

        /** Test successful buy operation*/
        assertTrue("Buy operation should succeed", inventory.updateQuantity(1, 5, true));
        assertEquals("Inventory should have 25 apples now", 25, fruit.itemQuantityInStock);

        /** Test buy operation on non-existing item*/
        assertFalse("Buy operation should fail on non-existing item", inventory.updateQuantity(2, 5, true));
    }

    /**
     * Tests the sell operation in the InventorySystem.
     */
    @Test
    public void testSellOperation() {
        Inventory inventory = new Inventory(new Scanner(System.in));
        Vegetable vegetable = new Vegetable();
        vegetable.itemCode = 2;
        vegetable.itemName = "Brocoli";
        vegetable.itemQuantityInStock = 10;
        vegetable.itemCost = 0.30f;
        vegetable.itemPrice = 3.80f;
        inventory.addItem(vegetable);

        /**Test successful sell operation*/
        assertTrue("Sell operation should succeed", inventory.updateQuantity(2, 5, false));
        assertEquals("Inventory should have 5 Brocoli now", 5, vegetable.itemQuantityInStock);

        /** Test sell operation when trying to sell more than available stock*/
        assertFalse("Sell operation should fail when trying to sell more than available", inventory.updateQuantity(2, 10, false));
    }
}
