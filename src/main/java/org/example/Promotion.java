package org.example;

import java.util.HashMap;

// object class for each promotion pricing rule
public class Promotion {
    private String item;
    private Integer itemsCount;
    private Integer discountPrice;

    public Promotion(String item, Integer itemsCount, Integer discountPrice) {
        this.item = item;
        this.itemsCount = itemsCount;
        this.discountPrice = discountPrice;
    }

    public Integer calculateDiscount(HashMap<String, Integer> shoppingCart, Items items) {
        Integer discount = 0;
        if (shoppingCart.containsKey(item)) {
            Integer currentItemAmount = shoppingCart.get(item);
            while (currentItemAmount >= itemsCount) {
                discount = discount + (itemsCount * items.getPrice(item) - discountPrice);
                currentItemAmount = currentItemAmount - itemsCount;
            }
        }
        return discount;
    }
}
