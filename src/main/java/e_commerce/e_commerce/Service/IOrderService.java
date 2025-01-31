package e_commerce.e_commerce.Service;

import e_commerce.e_commerce.Entity.Order;

public interface IOrderService {
    
    Order createOrder(Long cartId);
}
