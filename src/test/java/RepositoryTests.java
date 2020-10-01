import com.gimeno.jarvis.models.GroceryProduct;
import com.gimeno.jarvis.models.Repository;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Optional;

import static junit.framework.TestCase.assertTrue;

public class RepositoryTests {

    private static Repository repo = Repository.getInstance();

    @BeforeClass
    public static void fetchProducts() {
        repo.fetchGroceryProducts();
    }

    @Test
    public void searchProductByBarCode() {
        Optional<GroceryProduct> product =  repo.searchByBarCode(1234);

        assertTrue(product.isPresent());
    }

}
