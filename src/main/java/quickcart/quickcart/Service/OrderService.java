package quickcart.quickcart.Service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quickcart.quickcart.Entity.Cart;
import quickcart.quickcart.Entity.Order;
import quickcart.quickcart.Entity.OrderItem;
import quickcart.quickcart.Entity.Product;
import quickcart.quickcart.Entity.Users;
import quickcart.quickcart.Exception.OrderException;
import quickcart.quickcart.Repository.OrderRepository;
@Service
public class OrderService implements IOrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ICartService cartService;

    @Override
    public Order createOrder(Long cartId) {
      
        Cart cart = cartService.getCart(cartId).orElseThrow(() -> new OrderException("Cart not found for id: " + cartId));
                
        Users user = cart.getUser();
        Order order = new Order();
       
    
        // Convert CartItems to OrderItems
        Set<OrderItem> orderItems = cart.getCartCartItems().stream().map(cartItem -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setDiscount(cartItem.getDiscount());
            orderItem.setItemTotalPrice(cartItem.getItemTotalPrice());
            orderItem.setOrderedProductPrice(cartItem.getProductPrice());
            orderItem.setQuantity(cartItem.getQuantity());
            Product product = cartItem.getProduct();
            if (product.getSeller() == null) {
                throw new OrderException("Seller not found for product: " + product.getProductId());
            }
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setSeller(cartItem.getProduct().getSeller());
            return orderItem;
        }).collect(Collectors.toSet());
    
        // Ensure Order contains OrderItems
        order.setOrderOrderItems(orderItems);
        order.setEmail(user.getEmail());
        order.setOrderDate(java.time.LocalDate.now());
        Double totalAmount = reCalculateTotalAmount(order.getOrderOrderItems());
        order.setTotalAmount(totalAmount);
        // Save the Order
        return orderRepository.save(order);
    }

    @Override
    public Double reCalculateTotalAmount(Set<OrderItem> orderItems) {
        return orderItems.stream().mapToDouble(OrderItem::getItemTotalPrice).sum();
    }
    
    
}
