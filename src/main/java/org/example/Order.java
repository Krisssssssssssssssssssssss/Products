package org.example;

public record Order(String firstName, String lastName, String address, Product product, int id, int bankDetails, int quantity) {
}
