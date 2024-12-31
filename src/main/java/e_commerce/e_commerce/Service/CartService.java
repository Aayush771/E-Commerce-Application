package e_commerce.e_commerce.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import e_commerce.e_commerce.Entity.Cart;
import e_commerce.e_commerce.Entity.CartItem;
import e_commerce.e_commerce.Entity.User;
import e_commerce.e_commerce.Repository.CartRepository;
import e_commerce.e_commerce.Repository.UserRepository;
import jakarta.transaction.Transactional;

@Transactional
@Service
public class CartService implements ICartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Cart addCart(Long userId) {
        Cart cart = new Cart();
        Optional<User> user = userRepository.findById(userId);
        user.ifPresent(u -> {
            cart.setUser(u);
            u.getUserCarts().add(cart);
        });
        return cartRepository.save(cart);
    }

    @Override
    public List<Cart> getCartsByUserId(Long userId) {
        return cartRepository.findCartByUserUserId(userId);
    }
   @Transactional
    @Override
    public Cart addItemToCart(Long cartId, Long productId, int quantity) {
        Optional<Cart> cartOptional = cartRepository.findById(cartId);
        
        Cart cart = cartOptional.orElseThrow(() -> new RuntimeException("Cart not found for id: " + cartId));
       Cart updatedCart =  cartItemService.addCartItem(cart, productId, quantity);
        Set<CartItem> cartItems = updatedCart.getCartCartItems();
      Double cartTotalPrice = cartItems.stream().mapToDouble(cartItem -> cartItem.getItemTotalPrice()).sum();
        cart.setTotalPrice(cartTotalPrice);
        return cartRepository.save(cart);
    }

    // @Override
    // public void clearCart(Long userId) {
    //     Cart cart = getCartByUserId(userId);
    //     cartItemService.clearCartItems(cart.getCartId());
    //     cart.setTotalPrice(0.0);
    //     cartRepository.save(cart);
    // }

    // @Override
    // public double calculateTotalPrice(Long userId) {
    //     Cart cart = getCartByUserId(userId);
    //     return cartItemService.calculateCartTotal(cart.getCartId());
    // }

    @Override
    public Cart removeItemFromCart(Long userId, Long cartItemId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeItemFromCart'");
    }

    @Override
    public Cart updateCartItemQuantity(Long userId, Long cartItemId, int quantity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCartItemQuantity'");
    }
}
