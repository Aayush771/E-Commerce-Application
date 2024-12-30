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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateProduct'");
    }

    @Override
    public String deleteProduct(Long productId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProduct'");
    }

    @Override
    public Product getProduct(Long productId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProduct'");
    }

    @Override
    public List<Product> getAllProducts() {
       return productRepository.findAll();
    }

    @Override
    public Seller getSeller(Long sellerId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSeller'");
    }
    
}
