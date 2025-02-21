package org.example;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User{

    private final List<Product> products;

    public Customer(String name, int id, String email) {
        super(name, id, email);
        products = new ArrayList<>();
    }

    public void customer_info() {
        System.out.printf("Name: %s\n", name);
        System.out.printf("ID: %d\n", id);
        System.out.printf("Email: %s\n", email);
    }

    public void add_to_card(Product product) {
        products.add(product);
        product.stock_update(1);
    }

    public void remove_from_card(Product product) {
        products.remove(product);
    }

    public void show_shopping_card() {
        for (int i = 0; i < products.size(); i++) {
            products.get(i).show_card_info();
        }
    }

}
