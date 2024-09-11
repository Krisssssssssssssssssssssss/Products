package org.example;
import java.util.Scanner;


public class OurStore {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static void main(String[] args) {
        ProductRepo productRepo = new ProductRepo();
        OrderListRepo orderListRepo = new OrderListRepo();
        System.out.println();
        productRepo.addProduct(new Product("Rubber Duck", "FunStuff Co.", "Sometimes your code doesn't work, don't you need someone to talk to?", 10, 1, 10));
        productRepo.addProduct(new Product("Magic 8 Ball", "MysticToys", "Just as accurate Fortune-telling as your zodiac sign", 15, 2, 10));
        productRepo.addProduct(new Product("Pet Rock", "NatureToys", "As the name says", 7, 3, 10));
        productRepo.addProduct(new Product("Invisible Ink Pen", "SpyGadgets", "Useless pen", 8, 4, 10));
        productRepo.addProduct(new Product("Tiny Hands", "PrankWorld", "Use them for good or evil, we don't care", 12, 5, 10));


        System.out.println("Welcome to Our Store! Here's what we have available:");
        System.out.println();
        for (Product product : productRepo.getProductList()) {
            System.out.println(ANSI_YELLOW  + "ID: " + product.id() + " | Name: " + product.name() + " | Brand: " + product.brand() + " | Description: " + product.description() + " | Price: $" + product.price() + ANSI_RESET);
        }
        orderListRepo.addOrder(ShopService.placeNewOrder(productRepo));
        if (orderListRepo.getAll() != null) {
            System.out.println(orderListRepo.getAll());
        }
        else {
            System.out.println("Please try again");
        }

    }
    }
