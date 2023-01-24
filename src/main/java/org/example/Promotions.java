package org.example;

import java.util.ArrayList;

// A class for storing Promotion in arraylist
public class Promotions {
    private ArrayList<Promotion> promotions = new ArrayList<>();

    public Promotions() {
    }

    public void createPromotion(String item, Integer itemsCount, Integer discountPrice) {
        Promotion promotion = new Promotion(item, itemsCount, discountPrice);
        promotions.add(promotion);
    }

    public ArrayList<Promotion> getAllPromotions() {
        return promotions;
    }

}
