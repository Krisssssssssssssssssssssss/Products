package org.example;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo {
    public static List<Product> productList = new ArrayList<>();

    public static List<Product> getProductList() {
        return productList;
    }
    public static void addProduct(Product product) {
        productList.add(product);
    }
    public static void removeProduct(Product product) {
        productList.remove(product);
    }
    public static Product getProduct(int id) {
        for (Product product : productList) {
            if (product.id() == id) {
                return product;
            }
        }
        return null;
    }
    public static Product deductProductQuantity(Product product, int quantityToDeduct) {
        for (Product p : productList) {
            if (p.id() == product.id()) {
                if (p.quantity() >= quantityToDeduct) {
                    int newQuantity = p.quantity() - quantityToDeduct;
                    Product updatedProduct = new Product(p.name(), p.brand(), p.description(), p.price(), p.id(), newQuantity);
                    productList.remove(p);
                    productList.add(updatedProduct);
                    return updatedProduct;
                } else {
                    System.out.println("Error: Not enough stock to deduct " + quantityToDeduct + " units from product: " + p.name());
                }
            }
        }
        System.out.println("Product not found in the list.");
        return null;
    }

    public static void deductProductQuantities(List<Product> products, int quantityToDeduct) {
        for (Product product : products) {
            deductProductQuantity(product, quantityToDeduct);
        }
    }
}
