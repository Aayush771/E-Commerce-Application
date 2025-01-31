package e_commerce.e_commerce.Service;

import java.util.Set;

import e_commerce.e_commerce.Entity.Order;
import e_commerce.e_commerce.Entity.OrderItem;

public interface IOrderService {
    
    Order createOrder(Long cartId);
    Double reCalculateTotalAmount(Set<OrderItem> orderItems);
}
