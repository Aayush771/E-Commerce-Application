package quickcart.quickcart.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import quickcart.quickcart.Entity.Product;


    public interface ProductRepository extends JpaRepository<Product, Long> {
        // Use the relationship 'seller' in Product and field 'sellerId' in Seller
        List<Product> findBySeller_SellerId(Long sellerId);
        @Query("SELECT p.title FROM Product p") // Bulk fetch all titles
        List<String> findAllTitles();
    }
    

