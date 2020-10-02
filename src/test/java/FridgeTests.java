import com.gimeno.jarvis.models.*;
import com.gimeno.jarvis.models.exceptions.GroceryItemNotFoundException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class FridgeTests {

    private Fridge fridge;

    private GroceryProduct milk = new GroceryProduct(1234, "Milk", GroceryCategory.DAIRY);
    private GroceryProduct bread = new GroceryProduct(4321, "Bread", GroceryCategory.BREAD);
    private GroceryProduct ketchup = new GroceryProduct(3412, "Ketchup", GroceryCategory.CONDIMENT);
    private GroceryProduct water = new GroceryProduct(2143, "Water", GroceryCategory.DRINK);

    @Before
    public void createFridge() {
        fridge = new Fridge();
    }

    @Test
    public void addItemToFridge() {
        addItemsToFridge();

        assertTrue(fridge.findItem(milk).isPresent());
    }

    @Test
    public void removeItemFromFridge() {
        addItemsToFridge();

        fridge.removeGroceryProduct(milk);
        fridge.removeGroceryProduct(milk);
        fridge.removeGroceryProduct(milk);

        GroceryItem milkItem = fridge.findItem(milk).orElseThrow(GroceryItemNotFoundException::new);

        assertEquals(1, milkItem.getQuantity());
    }

    @Test(expected = GroceryItemNotFoundException.class)
    public void itemNotFound() {
        addItemsToFridge();

        fridge.removeGroceryProduct(water);
    }

    @Test
    public void removeLastUnit() {
        addItemsToFridge();

        fridge.removeGroceryProduct(ketchup);

        assertFalse(fridge.findItem(ketchup).isPresent());
    }

    private void addItemsToFridge() {
        // Milks
        for(int i = 1; i <= 4; i++) {
            fridge.addGroceryProduct(milk);
        }

        //Bread
        for(int i = 1; i <= 15; i++) {
            fridge.addGroceryProduct(bread);
        }

        //Ketchup
        fridge.addGroceryProduct(ketchup);
    }

}
