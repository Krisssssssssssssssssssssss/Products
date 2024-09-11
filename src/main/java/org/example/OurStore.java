package org.example;
import java.util.Scanner;


public class OurStore {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static void main(String[] args) {
        ProductRepo productRepo = new ProductRepo();
        OrderListRepo orderListRepo = new OrderListRepo();
        System.out.println();

        CSVReader.insertCVS();

        System.out.println("Welcome to Our Store! Here's what we have available:");
        System.out.println();
        for (Product product : productRepo.getProductList()) {
            System.out.println(ANSI_YELLOW  + "ID: " + product.id() + " | Name: " + product.name() + " | Brand: " + product.brand() + " | Description: " + product.description() + " | Price: $" + product.price() + ANSI_RESET);
        }
        orderListRepo.addOrder(ShopService.placeNewOrder(productRepo));
        if (orderListRepo.getAll() == null) {
            System.out.println("Please try again");
        }
    }
}
