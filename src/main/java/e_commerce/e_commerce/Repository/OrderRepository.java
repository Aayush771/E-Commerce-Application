package e_commerce.e_commerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import e_commerce.e_commerce.Entity.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {
}
