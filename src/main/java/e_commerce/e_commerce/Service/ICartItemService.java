package e_commerce.e_commerce.Service;

import e_commerce.e_commerce.Entity.Cart;

public interface ICartItemService {
    Cart addCartItem(Cart cart, Long productId, int quantity);
    void removeCartItem(Long cartItemId);
    void updateCartItemQuantity(Long cartItemId, int quantity);
  
}
