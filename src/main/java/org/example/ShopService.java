package org.example;
import java.util.Scanner;

public class ShopService {
    public static Order placeNewOrder (ProductRepo productRepo) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter the ID of the product that you would like to purchase:");
        int productId = scanner.nextInt();

        Product chosenProduct = productRepo.getProduct(productId);

        if (chosenProduct != null) {
            System.out.println("You selected: " + chosenProduct.name() + ", | Description: " + chosenProduct.description() + " | Price: $" + chosenProduct.price());

            System.out.println("Please enter the quantity you want to order:");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            if (quantity <= chosenProduct.quantity()) {
                return getCustomerDetails(chosenProduct, quantity);
            }
            else {
                System.out.println("Sorry, the product " + chosenProduct.name() + " is out of stock");
            }
        } else {
            System.out.println("Sorry, the product with ID " + productId + " is not available.");
        }
        scanner.close();
        return null;
    }
    private static Order getCustomerDetails(Product product, int quantity) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your first name:");
        String firstName = scanner.nextLine();

        System.out.println("Please enter your last name:");
        String lastName = scanner.nextLine();

        System.out.println("Please enter your address:");
        String address = scanner.nextLine();

        System.out.println("Please enter your bank details (just the account number):");
        int bankDetails = scanner.nextInt();

        int orderId = (int) (Math.random() * 10000);

        Order order = new Order(firstName, lastName, address, product, orderId, bankDetails, quantity);

        scanner.close();
        System.out.println("Your order has been successfully placed");
        return order;
    }
}
