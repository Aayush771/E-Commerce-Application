package quickcart.quickcart.Service;

import quickcart.quickcart.Entity.Payment;

public interface IPaymentService {
    Payment processPayment(Long cartId, String paymentMethod);
}
