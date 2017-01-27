package ua.store.dao;

import ua.store.model.Product;

import java.util.List;
import java.util.Map;

/**
 * Created by Alexander on 21.01.2017.
 */
public interface IProductDao {
    boolean addProduct(int id, Product product);
    Product removeProduct(int id);
    Map<Integer, Product> read();
    void cleanBD();
}
