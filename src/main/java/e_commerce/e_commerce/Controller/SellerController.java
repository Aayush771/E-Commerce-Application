package e_commerce.e_commerce.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import e_commerce.e_commerce.Entity.Seller;
import e_commerce.e_commerce.Service.ISellerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



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
