package e_commerce.e_commerce.Service;

import e_commerce.e_commerce.Entity.OrderItem;

public interface IOrderItemService {
     OrderItem savOrderItem(OrderItem orderItem);

     OrderItem updateOrderItem(OrderItem orderItem);

     void deleteOrderItem(Long orderItemId);    

     OrderItem getOrderItem(Long orderItemId);

     Iterable<OrderItem> getAllOrderItems();

}
