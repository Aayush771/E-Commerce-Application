package quickcart.quickcart.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quickcart.quickcart.Entity.Product;
import quickcart.quickcart.Exception.ProductException;
import quickcart.quickcart.Repository.ProductRepository;
@Service
public  class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public String addProduct(Product product) {
        productRepository.save(product);
        return "Product added successfully";
    }

    @Override
    public String updateProduct(Product product) {
       Product product2 = productRepository.findById(product.getProductId()).orElseThrow(() -> new ProductException("Product not found"));
       if(product.getTitle() != null) {   
           product2.setTitle(product.getTitle());
    }
       if(product.getDescription() != null) {
           product2.setDescription(product.getDescription());
       }
       if(product.getImage() != null) {
           product2.setImage(product.getImage());
       }
       if(product.getPrice() != null) {
           product2.setPrice(product.getPrice());
       }
      
       if(product.getStocks() != null) {
           product2.setStocks(product.getStocks());
       }
       if(product.getDiscount() != null) {
           product2.setDiscount(product.getDiscount());
       }
       productRepository.save(product2);
       return "Product updated successfully";
    }

    @Override
    public String deleteProduct(Long productId) {
      Product product = productRepository.findById(productId).orElseThrow(() -> new ProductException("Product not found"));
      productRepository.delete(product);
      return "Product deleted successfully";
    }

    @Override
    public Product getProduct(Long productId) {
        // TODO Auto-generated method stub
        return productRepository.findById(productId).orElseThrow(() -> new ProductException("Product not found"));
    }

    @Override
    public List<Product> getAllProducts() {
       return productRepository.findAll();
    }

     @Override
    public List<Product> getProductsBySellerId(Long sellerId) {
        // TODO Auto-generated method stub
     return productRepository. findBySeller_SellerId(sellerId);
    }
    @Override
    public String updateProductStocks(Long id, Long productId, int quantity) {
        // TODO Auto-generated method stub
        Product product = productRepository.findById(id).orElseThrow(()-> new ProductException("Product not found"));
        if(product.getSeller().getSellerId() != id){
            throw new ProductException("Seller not found for product: " + productId);
        }
        product.setStocks(product.getStocks() + quantity);
        productRepository.save(product);
        return "Product stock updated successfully";
    }
}
