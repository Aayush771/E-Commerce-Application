package quickcart.quickcart.Service;

import java.util.Set;

import quickcart.quickcart.Entity.Order;
import quickcart.quickcart.Entity.OrderItem;

public interface IOrderService {
    
    Order createOrder(Long cartId);
    Double reCalculateTotalAmount(Set<OrderItem> orderItems);
}
