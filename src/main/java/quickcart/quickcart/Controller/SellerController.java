package quickcart.quickcart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import quickcart.quickcart.Entity.Seller;
import quickcart.quickcart.Service.ISellerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
public class SellerController {

    @Autowired
    private ISellerService sellerService;

    @PostMapping("seller")
    public String addSeller(@RequestBody Seller entity) {
 
        return sellerService.addSeller(entity);
    }
    @GetMapping("/all")
    public List<Seller> getAllSellers() {
        return sellerService.getAllSellers();
    }
    @PutMapping("seller/{id}")
    public String updateSeller(@RequestBody Seller entity) {
        return sellerService.updateSeller(entity);    
    }
   
    
}
