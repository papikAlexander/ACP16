package ua.store.model;

import java.util.Date;

/**
 * Created by Alexander on 21.01.2017.
 */
public class Product {
    private String name;
    private int price;
    private Date date;
    private int id;
    private ProductType type;

    public Product(String name, int price, ProductType type) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.date = new Date();
        this.id = (int)(Math.random()*1000);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product types = (Product) o;

        if (price != types.price) return false;
        if (name != null ? !name.equals(types.name) : types.name != null) return false;
        return date != null ? date.equals(types.date) : types.date == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + price;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    public int getId() {
        return id;
    }
}
