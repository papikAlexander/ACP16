package ua.store.dao;

import ua.store.model.Product;

import java.util.List;

/**
 * Created by Alexander on 21.01.2017.
 */
public interface IProductDao {
    boolean addProduct(Product product);
    boolean removeProduct(Product product);
    List<Product> read();
}
