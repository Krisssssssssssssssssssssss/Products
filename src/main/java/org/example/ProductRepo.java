package org.example;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo {
    private List<Product> productList = new ArrayList<>();

    public List<Product> getProductList() {
        return productList;
    }
    public void addProduct(Product product) {
        productList.add(product);
    }
    public void removeProduct(Product product) {
        productList.remove(product);
    }
    public Product getProduct(int id) {
        for (Product product : productList) {
            if (product.id() == id) {
                return product;
            }
        }
        return null;
    }
}
