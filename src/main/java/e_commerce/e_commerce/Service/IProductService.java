package e_commerce.e_commerce.Service;

import java.util.List;
import java.util.Set;

import e_commerce.e_commerce.Entity.Product;
import e_commerce.e_commerce.Entity.Seller;

public interface IProductService {
   String addProduct(final Product product);
    String updateProduct(final Product product);
    String deleteProduct(final Long productId);
    Product getProduct(final Long productId);  
    List<Product> getAllProducts();
    Seller getSeller(final Long sellerId);
}
