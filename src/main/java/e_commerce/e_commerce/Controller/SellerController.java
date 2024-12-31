package e_commerce.e_commerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import e_commerce.e_commerce.Entity.Seller;
import e_commerce.e_commerce.Service.ISellerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class SellerController {

    @Autowired
    private ISellerService sellerService;

    @PostMapping("seller")
    public String addSeller(@RequestBody Seller entity) {
        //TODO: process POST request
        
        return sellerService.addSeller(entity);
    }
    
    
}
