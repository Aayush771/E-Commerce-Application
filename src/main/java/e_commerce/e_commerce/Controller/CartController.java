package e_commerce.e_commerce.Controller;

import org.springframework.web.bind.annotation.RestController;

import e_commerce.e_commerce.Entity.Cart;
import e_commerce.e_commerce.Service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CartController {
    @Autowired
    private CartService cartService;
    
    @PostMapping("cart")
    public String createCart(@RequestParam Long userId) {
        //TODO: process POST request

       Cart cart =  cartService.addCart(userId);  
        
        return "Cart created with id "+ cart.getCartId();
       
    }
    @PutMapping("additem")
    public Cart addProductToCart(@RequestParam Long cartId,@RequestParam Long productId,@RequestParam int quantity) {
        //TODO: process POST request
      Cart  cart =  cartService.addItemToCart(cartId, productId, quantity);
       return cart;
    }
    @DeleteMapping("removeitem")
    public Cart removeProductFromCart(@RequestParam Long cartId,@RequestParam Long cartItemId) {
        //TODO: process POST request
        Cart cart =  cartService.removeItemFromCart(cartId, cartItemId);
        return cart;
    }

    @PatchMapping("updateitem")
    public Cart updateProductFromCart(@RequestParam Long cartId,@RequestParam Long cartItemId,@RequestParam int quantity) {
        //TODO: process POST request    
        return cartService.updateCartItemQuantity(cartId, cartItemId, quantity);
       // return cart;
    }
}
