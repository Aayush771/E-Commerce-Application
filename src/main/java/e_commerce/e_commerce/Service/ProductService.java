package e_commerce.e_commerce.Service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import e_commerce.e_commerce.Entity.Product;
import e_commerce.e_commerce.Entity.Seller;
import e_commerce.e_commerce.Repository.ProductRepository;
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
       Product product2 = productRepository.findById(product.getProductId()).orElseThrow(() -> new RuntimeException("Product not found"));
       if(product.getProductName() != null) {   
           product2.setProductName(product.getProductName());
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
       if(product.getSpecialPrice() != null) {
           product2.setSpecialPrice(product.getSpecialPrice());
       }
       if(product.getQuantity() != null) {
           product2.setQuantity(product.getQuantity());
       }
       if(product.getDiscount() != null) {
           product2.setDiscount(product.getDiscount());
       }
       productRepository.save(product2);
       return "Product updated successfully";
    }

    @Override
    public String deleteProduct(Long productId) {
      Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
      productRepository.delete(product);
      return "Product deleted successfully";
    }

    @Override
    public Product getProduct(Long productId) {
        // TODO Auto-generated method stub
        return productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
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
    
}
