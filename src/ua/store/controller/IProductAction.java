package ua.store.controller;

import ua.store.model.Product;
import ua.store.model.ProductType;

import java.util.List;

/**
 * Created by Alexander on 21.01.2017.
 */
public interface IProductAction {
    boolean add(int id, String name, int price, ProductType type);
    Product remove(int id);
    void cleanBD();
    List<Product> sortByName();
    List<Product> sortByPrice();
    List<Product> sortByDate();
    List<Product> sortByType();

}
