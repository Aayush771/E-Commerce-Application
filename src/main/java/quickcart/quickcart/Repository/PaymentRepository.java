package quickcart.quickcart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import quickcart.quickcart.Entity.Payment;


public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
