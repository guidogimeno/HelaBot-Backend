import com.gimeno.jarvis.models.*;
import com.gimeno.jarvis.models.exceptions.GroceryItemNotFoundException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class FridgeTests {

    private Fridge frigde;

    private GroceryProduct milk = new GroceryProduct(1234, "Milk", GroceryCategory.DAIRY);
    private GroceryProduct bread = new GroceryProduct(4321, "Bread", GroceryCategory.BREAD);
    private GroceryProduct ketchup = new GroceryProduct(3412, "Ketchup", GroceryCategory.CONDIMENT);
    private GroceryProduct water = new GroceryProduct(2143, "Water", GroceryCategory.DRINK);

    @Before
    public void createFridge() {
        frigde = new Fridge();
    }

    @Test
    public void addItemInTheFridge() {
        addItemsToTheFridge();

        assertTrue(frigde.findItem(milk).isPresent());
    }

    @Test
    public void removeItemOfTheFridge() {
        addItemsToTheFridge();

        frigde.removeGroceryProduct(milk);
        frigde.removeGroceryProduct(milk);
        frigde.removeGroceryProduct(milk);

        GroceryItem milkItem = frigde.findItem(milk).orElseThrow(GroceryItemNotFoundException::new);

        assertEquals(1, milkItem.getQuantity());
    }

    @Test(expected = GroceryItemNotFoundException.class)
    public void itemNotFound() {
        addItemsToTheFridge();

        frigde.removeGroceryProduct(water);
    }

    @Test
    public void removeLastUnit() {
        addItemsToTheFridge();

        frigde.removeGroceryProduct(ketchup);

        assertFalse(frigde.findItem(ketchup).isPresent());
    }

    private void addItemsToTheFridge() {
        // Milks
        for(int i = 1; i <= 4; i++) {
            frigde.addGroceryProduct(milk);
        }

        //Bread
        for(int i = 1; i <= 15; i++) {
            frigde.addGroceryProduct(bread);
        }

        //Ketchup
        frigde.addGroceryProduct(ketchup);
    }

}
