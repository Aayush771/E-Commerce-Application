package e_commerce.e_commerce.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import e_commerce.e_commerce.Entity.Cart;



public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findCartByUserUserId(Long userId);
}
