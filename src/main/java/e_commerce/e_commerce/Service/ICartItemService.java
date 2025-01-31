package e_commerce.e_commerce.Service;

import java.util.Set;

import e_commerce.e_commerce.Entity.Cart;
import e_commerce.e_commerce.Entity.CartItem;

public interface ICartItemService {
    CartItem addCartItem(Cart cart, Long productId, int quantity);
    void removeCartItem(Long cartItemId);
    CartItem updateCartItemQuantity(Long cartItemId, int quantity);
  
}
