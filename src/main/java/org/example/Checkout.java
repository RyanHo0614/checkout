package org.example;

import java.util.ArrayList;
import java.util.HashMap;

// Class for functioning the checkout procedures, acting as the checkout machine
public class Checkout {
    private HashMap<String, Integer> shoppingCart = new HashMap<>();
    private Items items;
    public ArrayList<Promotion> promotionsList;

    public Checkout(ArrayList<Promotion> promotionsList, Items items){
        this.items = items;
        this.promotionsList = promotionsList;
    }

    public void scan (String item) {
        if (!items.getItems().containsKey(item))
            throw new IllegalArgumentException("We do not have this item");

        if (shoppingCart.containsKey(item)) {
            Integer count = shoppingCart.get(item);
            shoppingCart.put(item, count + 1);
        } else {
            shoppingCart.put(item, 1);
        }
    }

    public Integer totalSum() {
        Integer total = 0;

        for (HashMap.Entry<String, Integer> item : shoppingCart.entrySet()) {
            total = total + items.getPrice(item.getKey()) * item.getValue();
        }

        for (Promotion promotion : promotionsList) {
            total = total - promotion.calculateDiscount(shoppingCart, items);

        }
        return total;
    }
}
