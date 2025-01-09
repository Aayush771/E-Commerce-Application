package e_commerce.e_commerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import e_commerce.e_commerce.Entity.Product;
import e_commerce.e_commerce.Entity.Seller;


public interface ProductRepository extends JpaRepository<Product, Long> {
    Seller findBySellerId(Long sellerId);
}
