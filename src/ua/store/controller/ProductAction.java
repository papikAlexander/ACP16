package ua.store.controller;

import ua.store.dao.IProductDao;
import ua.store.dao.ProductDao;
import ua.store.model.Product;
import ua.store.model.ProductType;
import ua.store.utils.FileSaver;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
    public boolean add(int id, String name, int price, ProductType type) {
        Product newProduct = new Product(name, price, type);
        return dao.addProduct(id, newProduct);
    }



    @Override
    public Product remove(int id) {
        return dao.removeProduct(id);
    }

    @Override
    public void cleanBD() {
        dao.cleanBD();
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
