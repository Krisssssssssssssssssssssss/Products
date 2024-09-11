package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class ProductRepoTest {

    @BeforeEach
    void setup() {
        ProductRepo.productList.clear();
    }

    @Test
    void addProduct_expect_Success() {
        Product product = new Product("Rubber Duck", "FunStuff Co.", "Best friend", 10, 1, 5);
        ProductRepo.addProduct(product);

        assertEquals(1, ProductRepo.getProductList().size());
        assertEquals(product, ProductRepo.getProduct(1));
    }

    @Test
    void getProduct_expect_Null_When_NotFound() {
        Product product = ProductRepo.getProduct(999); // Test for a non-existent product
        assertNull(product);
    }

    @Test
    void deductProductQuantity_expect_Success() {
        Product product = new Product("Magic 8 Ball", "MysticToys", "Fake Fortune-telling toy", 15, 2, 10);
        ProductRepo.addProduct(product);

        Product updatedProduct = ProductRepo.deductProductQuantity(product, 3);
        assertNotNull(updatedProduct);
        assertEquals(7, updatedProduct.quantity());
    }

    @Test
    void deductProductQuantity_expect_Error_When_QuantityInsufficient() {
        Product product = new Product("Magic 8 Ball", "MysticToys", "Fake Fortune-telling toy", 15, 2, 10);
        ProductRepo.addProduct(product);

        Product updatedProduct = ProductRepo.deductProductQuantity(product, 20);
        assertNull(updatedProduct);
    }
}
