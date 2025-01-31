package e_commerce.e_commerce.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import e_commerce.e_commerce.Entity.Product;


    public interface ProductRepository extends JpaRepository<Product, Long> {
        // Use the relationship 'seller' in Product and field 'sellerId' in Seller
        List<Product> findBySeller_SellerId(Long sellerId);
    }
    

