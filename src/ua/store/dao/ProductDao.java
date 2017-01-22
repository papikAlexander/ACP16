package ua.store.dao;

import ua.store.model.Product;
import ua.store.utils.FileSaver;

import java.util.List;

/**
 * Created by Alexander on 21.01.2017.
 */
public class ProductDao implements IProductDao{
    private FileSaver fileSaver;

    public ProductDao(FileSaver fileSaver) {
        this.fileSaver = fileSaver;
    }

    @Override
    public boolean addProduct(Product product) {
        List<Product> products = fileSaver.read();

        if (!products.contains(product)) {
            products.add(product);
            fileSaver.save(products);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeProduct(Product product) {
        return fileSaver.delete(product);
    }

    @Override
    public List<Product> read() {
        return fileSaver.read();
    }
}
