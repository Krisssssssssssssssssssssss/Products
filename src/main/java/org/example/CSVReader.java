package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

    public static void insertCVS() {
        String path = "/Users/kristijanjakimov/IdeaProjects/Products/products.csv";
        {
            try {
                BufferedReader br = new BufferedReader(new FileReader(path));
                String line = "";
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    String ean = values[0]; // Assuming this is the EAN or similar unique identifier
                    String name = values[1];
                    String brand = values[2];
                    String description = values[3];
                    int price = Integer.parseInt(values[4]); // Price should be an integer
                    int id = Integer.parseInt(values[5]);    // ID is in the 6th position (index 5)
                    int quantity = Integer.parseInt(values[6]); // Quantity is in the 7th position (index 6)

                    // Create a Product object and add it to the ProductRepo
                    Product product = new Product(name, brand, description, price, id, quantity);
                    ProductRepo.productList.add(product);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
