package quickcart.quickcart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import quickcart.quickcart.Entity.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {
}
