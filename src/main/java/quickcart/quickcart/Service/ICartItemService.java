package quickcart.quickcart.Service;


import quickcart.quickcart.Entity.Cart;
import quickcart.quickcart.Entity.CartItem;

public interface ICartItemService {
    CartItem addCartItem(Cart cart, Long productId, int quantity);
    void removeCartItem(Long cartItemId);
    CartItem updateCartItemQuantity(Long cartItemId, int quantity);
  
}
