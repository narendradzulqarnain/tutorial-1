package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.model.ProductTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ProductRepositoryTest {
    @InjectMocks
    ProductRepository productRepository;
    @BeforeEach
    void setup() {
    }
    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setProductId("0");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());



    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }
    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductId("0");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("1");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());
        savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());
        assertFalse(productIterator.hasNext());

    }
    @Test
    void testFindProductById() {
        // id di set secara otomatis oleh productRepository.create sehingga tidak perlu di-set manual
        Product product1 = new Product();
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductName("Sampo Cap Wahyu");
        product2.setProductQuantity(200);
        productRepository.create(product2);

        assertEquals(product1, productRepository.findProductById(product1.getProductId()));
        assertEquals(product2, productRepository.findProductById(product2.getProductId()));
        assertNotEquals(product1, productRepository.findProductById(product2.getProductId()));
    }

    @Test
    void testFindProductByIdIfProductNotExist() {
        assertNull(productRepository.findProductById("0"));
    }
    @Test
    void testEditProduct() {
        Product product1 = new Product();
        product1.setProductId("0");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product newProductAttribute = new Product();
        newProductAttribute.setProductId("0");
        newProductAttribute.setProductName("Sampo cap Wahyu");
        newProductAttribute.setProductQuantity(50);
        productRepository.edit(newProductAttribute);

        assertEquals("Sampo cap Wahyu", product1.getProductName());
        assertEquals(50, product1.getProductQuantity());
        assertNotEquals("Sampo cap Bambang", product1.getProductName());
        assertNotEquals(100, product1.getProductQuantity());
    }
    @Test
    void testDeleteProduct() {
        Product product1 = new Product();
        product1.setProductId("0");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        productRepository.delete(product1);
        assertNull(productRepository.findProductById(product1.getProductId()));
    }
}
