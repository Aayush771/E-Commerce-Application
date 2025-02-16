package quickcart.quickcart.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quickcart.quickcart.Entity.Order;
import quickcart.quickcart.Entity.Payment;
import quickcart.quickcart.Entity.PaymentMethod;
import quickcart.quickcart.Entity.PaymentStatus;
import quickcart.quickcart.Entity.OrderStatus;
import quickcart.quickcart.Repository.OrderRepository;
import quickcart.quickcart.Repository.PaymentRepository;

@Service
public class PaymentService implements IPaymentService{

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private OrderRepository orderRepository;

    public Payment processPayment(Long orderId, String paymentMethod) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        
        Payment payment = new Payment();
        payment.setOrder(order);
        payment.setAmount(order.getTotalAmount());
        payment.setPaymentMethod(PaymentMethod.valueOf(paymentMethod));
        payment.setPaymentStatus(PaymentStatus.SUCCESS); 
        order.setPayment(payment);
        order.setOrderStatus(OrderStatus.PLACED);

        paymentRepository.save(payment);
        orderRepository.save(order);

        return payment;
    }

    
}
