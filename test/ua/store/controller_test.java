package ua.store;

import org.junit.*;
import org.junit.Test;
import ua.store.controller.ProductAction;
import ua.store.dao.ProductDao;
import ua.store.model.Product;
import ua.store.model.ProductType;
import ua.store.utils.FileSaver;

/**
 * Created by Alexander on 27.01.2017.
 */
public class controller_test {

    static FileSaver fileSaver;
    static ProductAction store;

    @Before
    public void create_bd(){
         fileSaver = new FileSaver("C:\\Users\\Alexander\\IdeaProjects\\Prof\\test\\ua\\store\\db_test_json");
         store = new ProductAction(fileSaver, new ProductDao(fileSaver));
    }

    @AfterClass
    public static void cleanBD_test(){
        store.cleanBD();
    }
    @Test
    public void add_new_product_test(){

        Assert.assertTrue(store.add(1, "laptop", 1000, ProductType.NOTEBOOK));
    }

    @Test
    public void add_same_product_test(){
        store.add(1, "laptop", 1000, ProductType.NOTEBOOK);
        Assert.assertFalse(store.add(1, "laptop", 1000, ProductType.NOTEBOOK));
    }

    @Test
    public void remove_product_test(){
        store.add(1, "laptop", 1000, ProductType.NOTEBOOK);
        Product product = store.remove(1);
        Assert.assertTrue(product.getName().equals("laptop") &&
                product.getPrice() == 1000 &&
                product.getType().equals(ProductType.NOTEBOOK));

    }
}
