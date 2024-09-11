package org.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class OurStore {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static void main(String[] args) {
        ProductRepo productRepo = new ProductRepo();
        OrderListRepo orderListRepo = new OrderListRepo();
        Client client1 = new Client("John", "Doe", 1);
        Client client2 = new Client("Jack", "Smith", 2);
        Client client3 = new Client("Kris", "Kris", 3);
        List<Client> clientList = new ArrayList<>(Arrays.asList(client1, client2, client3));
        BankService.openAccount(clientList);

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
