package e_commerce.e_commerce.Service;

import e_commerce.e_commerce.Entity.OrderItem;

public class OrderItemService implements IOrderItemService{
    @Override
   public OrderItem savOrderItem(final OrderItem orderItem) {
       return null;
   }



@Override
public OrderItem updateOrderItem(OrderItem orderItem) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'updateOrderItem'");
}

@Override
public void deleteOrderItem(Long orderItemId) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteOrderItem'");
}

@Override
public OrderItem getOrderItem(Long orderItemId) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getOrderItem'");
}

@Override
public Iterable<OrderItem> getAllOrderItems() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAllOrderItems'");
}
}
