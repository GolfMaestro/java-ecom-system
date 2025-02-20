package org.example;

public class Product {
    private int id;
    private String name;
    private double cost;
    private int stock;

    public Product(int id, String name, double cost, int stock) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.stock = stock;
    }

    public void show_info() {
        System.out.printf("ID: %d\n", id);
        System.out.printf("NAME: %s\n", name);
        System.out.printf("COST: %.2f\n", cost);
        System.out.printf("STOCK: %d\n", stock);
    }

    public void show_card_info () {
        System.out.printf("NAME: %s\n", name);
        System.out.printf("COST PER ONE: %.2f\n", cost);
    }

    public void stock_update(int quantity) {
        if (stock > quantity) {
            stock = stock - quantity;
        }
        else {
            System.out.println("There is no this amount of product");
        }
    }

}
