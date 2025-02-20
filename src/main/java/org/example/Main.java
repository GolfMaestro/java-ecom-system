package org.example;

import java.security.Permission;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<Product> catalog = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();

        Customer customer1 = new Customer("Vlad", 1, "vlad2004e@gmail.com");

        Customer customer2 = new Customer("Dude", 2, "lastnamesdude@gmail.com");

        Product product1 = new Product(1, "keyboard", 19.99, 10);

        Product product2 = new Product(2, "mouse", 5.00, 12);

        customers.add(customer1);
        customers.add(customer2);

        catalog.add(product1);
        catalog.add(product2);

        for (int i = 0; i < customers.size(); i++) {
            customers.get(i).customer_info();
        }

        for (int i = 0; i < catalog.size(); i++) {
            catalog.get(i).show_info();
        }

        customers.get(0).add_to_card(catalog.get(0));
        customers.get(0).show_shopping_card();
        customers.get(0).add_to_card(catalog.get(1));
        customers.get(0).show_shopping_card();
        customers.get(0).remove_from_card(catalog.get(0));
        customers.get(0).show_shopping_card();

    }
}