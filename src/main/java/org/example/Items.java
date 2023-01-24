package org.example;

import java.util.HashMap;

// Class for storing items as HashMap
public class Items {
    private HashMap<String, Integer> items = new HashMap<>();

    public Items() {}

    public void addItems(String item, Integer price) {
        this.items.put(item, price);
    }

    public HashMap<String, Integer> getItems() {
        return items;
    }

    public Integer getPrice(String item) {
        return items.get(item);
    }

}
