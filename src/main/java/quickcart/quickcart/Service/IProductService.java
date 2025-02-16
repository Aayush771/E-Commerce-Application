package quickcart.quickcart.Service;

import java.util.List;

import quickcart.quickcart.Entity.Product;

public interface IProductService {
   String addProduct(final Product product);
    String updateProduct(final Product product);
    String deleteProduct(final Long productId);
    Product getProduct(final Long productId);  
    List<Product> getAllProducts();
    List<Product> getProductsBySellerId(final Long sellerId);
    String updateProductStocks(final Long id,final Long productId,final int quantity);
}
