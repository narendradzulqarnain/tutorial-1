package id.ac.ui.cs.advprog.eshop.repository;
import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    private int productIdCount = 0;

    public Product create(Product product) {
        productData.add(product);
        product.setProductId(Integer.toString(productIdCount++));
        return product;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public Product findProductbyId(String id) {
        for (Product product : productData) {
            String productId = product.getProductId();
            if (productId.equals(id)) {
                return product;
            }
        }
        return null;
    }

    public void delete(Product product) {
        productData.remove(product);
    }
}
