package e_commerce.e_commerce.Service;

import java.util.List;
import java.util.Set;

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
    public CartItem addCartItem(Cart cart, Long productId, int quantity) {
        Product product = productRepository.findById(productId)
                          .orElseThrow(() -> new RuntimeException("Product not found"));

        if (product.getQuantity() < quantity) {
            throw new RuntimeException("Not enough stock available");
        }

        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        cartItem.setProductPrice(getSpecialPrice(product.getPrice(),product.getDiscount()));
        cartItem.setDiscount(product.getDiscount());
        cartItem.setItemTotalPrice(cartItem.getProductPrice() * quantity);

        CartItem savedCartItem = cartItemRepository.save(cartItem);

        return savedCartItem;      
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

   
    public Double getSpecialPrice(Double price, Double discount) {
        return price - (price * discount / 100);
    }
   
  
}
