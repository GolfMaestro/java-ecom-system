package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Product> catalog = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();

        int customer_id = 0;
        int current_customer = -1;
        int product_id = 0;
        int exit = 0;

        while (exit != 1) {

            Scanner scanner = new Scanner(System.in);
            int action;

            System.out.println("Choose action:");
            System.out.println("1. Create user");
            System.out.println("2. Choose user");
            System.out.println("3. Show user info");
            System.out.println("4. Show catalog");
            System.out.println("5. Add product by id");
            System.out.println("6. Delete product by id");
            System.out.println("7. Show shopping card");
            System.out.println("8. Add product");
            System.out.println("9. Leave");

            action = is_valid_int(scanner);

            switch (action) {
                case 1:
                    System.out.println("Enter name:");
                    String name1 = scanner.nextLine();
                    System.out.println("Enter email:");
                    String email1 = scanner.nextLine();

                    Customer customer1 = new Customer(name1, customer_id, email1);
                    customer_id = customer_id + 1;
                    customers.add(customer1);
                    break;
                case 2:
                    System.out.println("Enter user id:");
                    current_customer = is_valid_int(scanner);
                    if ((current_customer < 0) || (current_customer > (customers.size() - 1))) {
                        System.out.println("Wrong user id. Try again");
                        current_customer = -1;
                    }
                    break;
                case 3:
                    if (current_customer == -1) {
                        System.out.println("You forgot to choose user. Try again");
                    }
                    else {
                        customers.get(current_customer).customer_info();
                    }
                    break;

                case 4:
                    for (int i = 0; i < catalog.size(); i++) {
                        catalog.get(i).show_info();
                        System.out.println("------------------------------");
                    }
                    break;
                case 5:
                    if (current_customer == -1) {
                        System.out.print("You forgot to choose user. Try again");
                    }
                    else {
                        int i;
                        i = is_valid_int(scanner);
                        customers.get(current_customer).add_to_card(catalog.get(i));
                    }
                    break;
                case 6:
                    if (current_customer == -1) {
                        System.out.println("You forgot to choose user. Try again");
                    }
                    else {
                        int d;
                        d = is_valid_int(scanner);
                        customers.get(current_customer).remove_from_card(catalog.get(d));
                    }
                    break;
                case 7:
                    if (current_customer == -1) {
                        System.out.println("You forgot to choose user. Try again");
                    }
                    else {
                        customers.get(current_customer).show_shopping_card();
                    }
                    break;
                case 8:
                    System.out.println("Enter name:");
                    String name2 = scanner.nextLine();
                    System.out.println("Enter cost:");
                    double cost1;
                    cost1 = is_valid_float(scanner);
                    System.out.println("Enter stock:");
                    int stock1;
                    stock1 = is_valid_int(scanner);
                    Product product1 = new Product(product_id, name2, cost1, stock1);
                    product_id = product_id + 1;
                    catalog.add(product1);
                    break;
                case 9:
                    exit = 1;
                    break;
                default:
                    System.out.println("Wrong input. Try again");
                    break;
            }
        }

    }

    public static int is_valid_int(Scanner scanner) {
        int val;
        while (true) {
            try {
                val = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong input. Try again:");
            }
        }
        return val;
    }

    public static double is_valid_float(Scanner scanner) {
        double val;
        while (true) {
            try {
                val = Float.parseFloat(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong input. Try again:");
            }
        }
        return val;
    }
}