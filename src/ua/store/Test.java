package ua.store;

import ua.store.controller.ProductAction;
import ua.store.dao.ProductDao;
import ua.store.model.ProductType;
import ua.store.utils.FileSaver;

/**
 * Created by Alexander on 21.01.2017.
 */
public class Test {
    public static void main(String[] args) {
        FileSaver fileSaver = new FileSaver("C:\\Users\\Alexander\\IdeaProjects\\Prof\\src\\ua\\store\\db");
        ProductAction store = new ProductAction(fileSaver, new ProductDao(fileSaver));
        store.add(5,"mob", 1000, ProductType.ACCESSOR);
        System.out.println(store.remove(5));
    }

}
