package quickcart.quickcart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import quickcart.quickcart.Entity.OrderItem;


public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
