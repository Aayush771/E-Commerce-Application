package e_commerce.e_commerce.Service;

import e_commerce.e_commerce.Entity.Payment;

public interface IPaymentService {
    Payment processPayment(Long cartId, String paymentMethod);
}
