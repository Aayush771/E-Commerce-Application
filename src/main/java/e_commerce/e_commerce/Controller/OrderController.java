package e_commerce.e_commerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import e_commerce.e_commerce.Entity.Order;
import e_commerce.e_commerce.Service.IOrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class OrderController {
    

    @Autowired
    private IOrderService orderService;


    @GetMapping("orders")
    public Order createOrder(@RequestParam Long cartId) {
         return orderService.createOrder(cartId);
    }
    
}
