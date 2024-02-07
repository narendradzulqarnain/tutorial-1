package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class ProductTest {
    Product product;
    @BeforeEach
    void setup() {
        this.product = new Product();
        this.product.setProductId("0");
        this.product.setProductName("Sampo Cap Bambang");
        this.product.setQuantity(100);
        
    }
    @Test
    void testGetProductId() {
        assertEquals("0", this.product.getProductId());
    }
    @Test
    void testGetProductName() {
        assertEquals("Sampo Cap Bambang", this.product.getProductName());
    }
    @Test
    void testGetProductQuantity() {
        assertEquals(100, this.product.getProductQuantity());
    }

}
