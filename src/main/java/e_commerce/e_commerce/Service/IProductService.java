package e_commerce.e_commerce.Service;

import java.util.List;

import e_commerce.e_commerce.Entity.Product;

public interface IProductService {
   String addProduct(final Product product);
    String updateProduct(final Product product);
    String deleteProduct(final Long productId);
    Product getProduct(final Long productId);  
    List<Product> getAllProducts();
    List<Product> getProductsBySellerId(final Long sellerId);
    String updateProductStocks(final Long id,final Long productId,final int quantity);
}
