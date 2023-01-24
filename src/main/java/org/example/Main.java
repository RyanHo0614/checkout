package org.example;

import java.util.Scanner;

/* The flow start with entering the items one by one, then set up the pricing rule, then scan the bought item to
calculate the total sum of price
Written by Ryan Ho
*/
public class Main {
    public static void main(String[] args) {
        try {
                Promotions promotions = new Promotions();
                Items items = new Items();

                // Handle items configuration
                System.out.println("Plz Enter item & its price one by one e.g. 'A 50' Input DONE when done.");

                Scanner in = new Scanner(System.in);
                String s;
                while (!(s = in.nextLine()).equalsIgnoreCase("DONE")) {
                    String[] result = s.split(" ");
                    if (result.length != 2) throw new IllegalArgumentException("Wrong Input!");
                    String name = result[0];
                    Integer price = Integer.parseInt(result[1]);
                    items.addItems(name, price);
                    System.out.println("Item added: " + name + " Price: " + price);
                }

                // Handle promotion configuration
                System.out.println("Here comes promotion configuration");
                System.out.println("Plz enter promotion in format: item quantity discountedPrice e.g. A 3 130");
                System.out.println("This would result in 'Buy 3 item A with price 130'");
                System.out.println("Input DONE when done");

                while (!(s = in.nextLine()).equalsIgnoreCase("DONE")) {
                    String[] result = s.split(" ");
                    if (result.length != 3) throw new IllegalArgumentException("Wrong argument number!");
                    String name = result[0];
                    Integer quant = Integer.parseInt(result[1]);
                    Integer price = Integer.parseInt(result[2]);
                    promotions.createPromotion(name, quant, price);
                    System.out.println("Promotion added: ITEM " + name + " Quantity at " + quant + " With Price " + price);
                }

                // Handle Shopping
                System.out.println("Here comes shopping");
                System.out.println("Plz input your items one by one e.g. A");
                System.out.println("Input DONE when done");
                Checkout checkout = new Checkout(promotions.getAllPromotions(), items);
                while (!(s = in.nextLine()).equalsIgnoreCase("DONE")) {
                    checkout.scan(s);
                    System.out.println("Shopping cart added: " + s);
                    System.out.println("Current : " + checkout.totalSum());

                }
                System.out.println("Total : " + checkout.totalSum());

        } catch (IllegalArgumentException exception) {
            System.out.println("Plz try again!");
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}
