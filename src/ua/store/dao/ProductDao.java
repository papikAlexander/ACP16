package ua.store.dao;

import ua.store.controller.ProductAction;
import ua.store.model.Product;
import ua.store.utils.FileSaver;

import java.util.List;
import java.util.Map;

/**
 * Created by Alexander on 21.01.2017.
 */
public class ProductDao implements IProductDao{
    private FileSaver fileSaver;

    public ProductDao(FileSaver fileSaver) {
        this.fileSaver = fileSaver;
    }

    @Override
    public boolean addProduct(int id, Product product) {
        Map<Integer, Product> products = fileSaver.read();

        if (!products.containsKey(id)) {
            products.put(id, product);
            fileSaver.save(products);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Product removeProduct(int id) {
        return fileSaver.delete(id);
    }

    @Override
    public Map<Integer, Product> read() {
        return fileSaver.read();
    }

    @Override
    public void cleanBD() {
        fileSaver.cleanBD();
    }
}
