package e_commerce.e_commerce.Service;

import java.util.List;

import e_commerce.e_commerce.Entity.Cart;
   public interface ICartService {
    Cart addCart(Long userId);
    List<Cart> getCartsByUserId(Long userId);
    Cart addItemToCart(Long cartId, Long productId, int quantity);
    Cart removeItemFromCart(Long userId, Long cartItemId);
    Cart updateCartItemQuantity(Long userId, Long cartItemId, int quantity);
    
}



