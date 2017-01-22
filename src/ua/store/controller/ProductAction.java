package ua.store.controller;

import ua.store.dao.IProductDao;
import ua.store.dao.ProductDao;
import ua.store.model.Product;
import ua.store.model.ProductType;
import ua.store.utils.FileSaver;

import java.util.Date;
import java.util.List;

/**
 * Created by Alexander on 21.01.2017.
 */
public class ProductAction implements IProductAction{
    private FileSaver fileSaver;
    private IProductDao dao;

    public ProductAction(FileSaver fileSaver, IProductDao dao) {
        this.fileSaver = fileSaver;
        this.dao = dao;
    }

    @Override
    public boolean add(String name, int price, ProductType type) {
        Product newProduct = new Product(name, price, type);
        return dao.addProduct(newProduct);
    }

    @Override
    public boolean remove(int id) {
        List<Product> products = dao.read();

        return dao.removeProduct(findProduct(id, products));
    }

    private Product findProduct(int id, List<Product> products){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id)
                return products.get(i);
        }
        System.err.println("Not found product");
        return null;
    }

    @Override
    public List<Product> sortByName() {
        return null;
    }

    @Override
    public List<Product> sortByPrice() {
        return null;
    }

    @Override
    public List<Product> sortByDate() {
        return null;
    }

    @Override
    public List<Product> sortByType() {
        return null;
    }

}
