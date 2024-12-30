package e_commerce.e_commerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import e_commerce.e_commerce.Entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
