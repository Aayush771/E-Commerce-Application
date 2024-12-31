package e_commerce.e_commerce.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import e_commerce.e_commerce.Entity.Category;
import e_commerce.e_commerce.Entity.Product;
import e_commerce.e_commerce.Service.ICatagoryService;
import e_commerce.e_commerce.Service.IProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class ProductController {
    
    @Autowired
    private IProductService productService;
    @Autowired
    private ICatagoryService catagoryService;
    @PostMapping("/products")
    public String addProducts(@RequestBody Product entity) {
        return productService.addProduct(entity);
    }
    @GetMapping("/products/all")
    public List<Product> getAllProducts() {
        return  productService.getAllProducts();
    }
    
    @PostMapping("/catagories")
    private String addCatagory(@RequestBody Category category) {
        return catagoryService.addCatagory(category);
    }

    @GetMapping("/catagories/all")
    public List<Category> getAllCatagories() {
        return catagoryService.getAllCatagories();
    }
    
}
