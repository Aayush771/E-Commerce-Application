package e_commerce.e_commerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import e_commerce.e_commerce.Entity.Cart;
import e_commerce.e_commerce.Entity.CartItem;
import e_commerce.e_commerce.Entity.Product;
import e_commerce.e_commerce.Repository.CartItemRepository;
import e_commerce.e_commerce.Repository.ProductRepository;
import jakarta.transaction.Transactional;
@Transactional
@Service
public class CartItemService implements ICartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Cart addCartItem(Cart cart, Long productId, int quantity) {
        Product product = productRepository.findById(productId)
                          .orElseThrow(() -> new RuntimeException("Product not found"));

        if (product.getQuantity() < quantity) {
            throw new RuntimeException("Not enough stock available");
        }

        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        cartItem.setProductPrice(product.getSpecialPrice());
        cartItem.setDiscount(product.getDiscount());
        cartItem.setItemTotalPrice(product.getSpecialPrice() * quantity);

        CartItem savedCartItem = cartItemRepository.save(cartItem);
        cart.getCartCartItems().add(savedCartItem);

        return cart;
    }

    @Override
    public void removeCartItem(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

    @Override
    public CartItem updateCartItemQuantity(Long cartItemId, int quantity) {
        CartItem cartItem = cartItemRepository.findById(cartItemId)
                            .orElseThrow(() -> new RuntimeException("Cart Item not found"));
        cartItem.setQuantity(quantity);
        cartItem.setItemTotalPrice(cartItem.getProductPrice() * quantity);
       return cartItemRepository.save(cartItem);
    }

   

   
  
}
