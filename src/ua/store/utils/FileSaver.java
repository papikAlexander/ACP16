package ua.store.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ua.store.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<Integer, Product> read() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            Map<Integer, Product> contacts = gson.fromJson(br, new TypeToken<Map<Integer, Product>>(){}.getType());
            if (contacts == null){
                contacts = new HashMap<>();
            }
            return contacts;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void save(Map<Integer, Product> contacts){

        String json = gson.toJson(contacts);

        try (FileWriter writer = new FileWriter(path)){
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Product delete(int id){
        Map<Integer, Product> contacts = read();
        Product res = contacts.remove(id);
        save(contacts);
        return res;
    }

    public void cleanBD(){
        Map<Integer, Product> emptyMap = new HashMap<>();
        save(emptyMap);
    }
}
