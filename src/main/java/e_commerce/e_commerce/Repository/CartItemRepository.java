package e_commerce.e_commerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import e_commerce.e_commerce.Entity.CartItem;


public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
