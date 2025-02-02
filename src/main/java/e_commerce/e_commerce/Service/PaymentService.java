package e_commerce.e_commerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import e_commerce.e_commerce.Entity.Order;
import e_commerce.e_commerce.Entity.OrderStatus;
import e_commerce.e_commerce.Entity.Payment;
import e_commerce.e_commerce.Entity.PaymentMethod;
import e_commerce.e_commerce.Entity.PaymentStatus;
import e_commerce.e_commerce.Entity.Product;
import e_commerce.e_commerce.Repository.OrderRepository;
import e_commerce.e_commerce.Repository.PaymentRepository;

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
