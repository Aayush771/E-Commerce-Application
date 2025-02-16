package quickcart.quickcart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import quickcart.quickcart.Entity.CartItem;


public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
