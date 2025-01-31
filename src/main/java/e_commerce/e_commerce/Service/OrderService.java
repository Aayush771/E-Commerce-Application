package e_commerce.e_commerce.Service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;


import e_commerce.e_commerce.Entity.Cart;
import e_commerce.e_commerce.Entity.Order;
import e_commerce.e_commerce.Entity.OrderItem;
import e_commerce.e_commerce.Entity.User;
import e_commerce.e_commerce.Repository.OrderRepository;

public class OrderService implements IOrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ICartService cartService;

    @Override
    public Order createOrder(Long cartId) {
        // Fetch cart
        Cart cart = cartService.getCart(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found for id: " + cartId));
    
        User user = cart.getUser();
    
        // Ensure total price is up to date

    
        // Create Order Object
        Order order = new Order();
        order.setEmail(user.getEmail());
        order.setOrderDate(java.time.LocalDate.now());
        order.setTotalAmount(cart.getTotalPrice());
    
        // Convert CartItems to OrderItems
        Set<OrderItem> orderItems = cart.getCartCartItems().stream().map(cartItem -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setDiscount(cartItem.getDiscount());
            orderItem.setItemTotalPrice(cartItem.getItemTotalPrice());
            orderItem.setOrderedProductPrice(cartItem.getProductPrice());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setProduct(cartItem.getProduct());
            return orderItem;
        }).collect(Collectors.toSet());
    
        // Ensure Order contains OrderItems
        order.setOrderOrderItems(orderItems);
    
        // Save the Order
        return orderRepository.save(order);
    }
    
    
}
