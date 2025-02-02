package e_commerce.e_commerce.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import e_commerce.e_commerce.Entity.Category;
import e_commerce.e_commerce.Entity.Product;
import e_commerce.e_commerce.Service.ICatagoryService;
import e_commerce.e_commerce.Service.IProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RequestMapping("/api")
@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ProductController {
    
    @Autowired
    private IProductService productService;
    @Autowired
    private ICatagoryService catagoryService;
    @PostMapping("/products")
    public String addProducts(@RequestBody Product entity) {
        return productService.addProduct(entity);
    }
    @GetMapping("/products")
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

    @PutMapping("/catagories")
    private String updateCatagory(@RequestBody Category category) {
        return catagoryService.updateCatagory(category);
    }
    @PutMapping("/products")
    private String updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable Long id) {    
        return productService.deleteProduct(id);
    }
     @PatchMapping("seller/{id}/{productId}/{quantity}")
    public String updateProductStock(@PathVariable Long id,@PathVariable Long productId,@PathVariable int quantity) {
        return productService.updateProductStocks(id,productId,quantity);
    }
    
}
