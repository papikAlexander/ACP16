package ua.store.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ua.store.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 21.01.2017.
 */
public class FileSaver {
    private String path;
    private Gson gson;

    public FileSaver(String path) {
        this.path = path;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public List<Product> read() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            List<Product> contacts = gson.fromJson(br, new TypeToken<List<Product>>(){}.getType());
            if (contacts == null){
                contacts = new ArrayList<>();
            }
            return contacts;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void save(List<Product> contacts){

        String json = gson.toJson(contacts);

        try (FileWriter writer = new FileWriter(path)){
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean delete(Product contact){
        List<Product> contacts = read();
        boolean result = contacts.remove(contact);
        save(contacts);
        return result;
    }
}
