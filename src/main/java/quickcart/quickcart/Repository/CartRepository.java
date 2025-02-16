package quickcart.quickcart.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quickcart.quickcart.Entity.Cart;
@Repository


public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findCartByUserUserId(Long userId);
}
