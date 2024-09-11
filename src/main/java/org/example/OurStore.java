package org.example;
import java.util.Scanner;


public class OurStore {
    public static void main(String[] args) {
        ProductRepo productRepo = new ProductRepo();
        OrderListRepo orderListRepo = new OrderListRepo();

        productRepo.addProduct(new Product("Rubber Duck", "FunStuff Co.", "Sometimes your code doesn't work, don't you need someone to talk to?", 10, 1, 10));
        productRepo.addProduct(new Product("Magic 8 Ball", "MysticToys", "Just as accurate Fortune-telling as your zodiac sign", 15, 2, 10));
        productRepo.addProduct(new Product("Pet Rock", "NatureToys", "As the name says", 7, 3, 10));
        productRepo.addProduct(new Product("Invisible Ink Pen", "SpyGadgets", "Useless pen", 8, 4, 10));
        productRepo.addProduct(new Product("Tiny Hands", "PrankWorld", "Use them for good or evil, we don't care", 12, 5, 10));


        System.out.println("Welcome to Our Store! Here's what we have available:");
        for (Product product : productRepo.getProductList()) {
            System.out.println("ID: " + product.id() + " | Name: " + product.name() + " | Brand: " + product.brand() + " | Description: " + product.description() + " | Price: $" + product.price());
        }

        orderListRepo.addOrder(ShopService.placeNewOrder(productRepo));
        if (orderListRepo.getOrderList() != null) {
            System.out.println(orderListRepo.getOrderList());
        }
        else {
            System.out.println("Please try again");
        }

    }
    }
