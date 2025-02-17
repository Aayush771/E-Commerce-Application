package quickcart.quickcart.Service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



import org.springframework.web.client.RestTemplate;

import quickcart.quickcart.Entity.Category;
import quickcart.quickcart.Entity.Product;
import quickcart.quickcart.Entity.ProductDTO;
import quickcart.quickcart.Entity.Role;
import quickcart.quickcart.Entity.RoleName;
import quickcart.quickcart.Entity.Seller;
import quickcart.quickcart.Repository.CategoryRepository;
import quickcart.quickcart.Repository.ProductRepository;
import quickcart.quickcart.Repository.RoleRepository;
import quickcart.quickcart.Repository.SellerRepository;

import org.springframework.http.ResponseEntity;

import java.util.*;



@Component
public class DataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final SellerRepository sellerRepository;
    private final CategoryRepository categoryRepository;
    private final RestTemplate restTemplate;
    private final RoleRepository roleRepository;

    public DataLoader(ProductRepository productRepository, SellerRepository sellerRepository, CategoryRepository categoryRepository, RoleRepository roleRepository) {
        this.productRepository = productRepository;
        this.sellerRepository = sellerRepository;
        this.categoryRepository = categoryRepository;
        this.restTemplate = new RestTemplate();
        this.roleRepository = roleRepository;
    }   

   
    

    @Override
    public void run(String... args) throws Exception {

        
        for (RoleName roleName : RoleName.values()) {
            System.out.println("Inserting role: " + roleName);

            Optional<Role> optRole = roleRepository.findByRoleName(roleName);

            if (optRole.isEmpty()) {
                Role role = new Role();
                role.setRoleName(roleName);
                roleRepository.save(role);
            }
           // System.out.println(optRole.get());
        }
        int existingProductCount = (int) productRepository.count();

        // Check if the database already has 100 products
        if (existingProductCount >= 500) {
           // System.out.println("Database already has " + existingProductCount + " products. Skipping insert.");
            return;
        }
        String apiUrl = "https://dummyjson.com/products?limit=500";

        // Fetch products from API
        ResponseEntity<ProductResponse> response = restTemplate.getForEntity(apiUrl, ProductResponse.class);
        
        if (response.getBody() == null || response.getBody().products == null) {
            System.out.println("Failed to fetch products!");
            return;
        }

        List<ProductDTO> productList = response.getBody().products;
         // 🔹 Bulk fetch existing product titles to avoid multiple DB queries
         Set<String> existingProductTitles = new HashSet<>(productRepository.findAllTitles());
        Map<String, Seller> sellerMap = new HashMap<>();

        List<Product> productsToSave = new ArrayList<>();

        for (ProductDTO productDTO : productList) {


            if (existingProductTitles.contains(productDTO.title)) {
               // System.out.println("Skipping duplicate product: " + productDTO.title);
                continue;
            }
            // Check if Category exists, else create
            Category category = categoryRepository.findByCategoryName(productDTO.category)
                    .orElseGet(() -> {
                        Category newCategory = new Category();
                        newCategory.setCategoryName(productDTO.category);
                        return categoryRepository.save(newCategory);
                    });

            // Ensure each category has a unique seller
            Seller seller = sellerMap.computeIfAbsent(productDTO.category, cat -> {
                Seller newSeller = new Seller();
                newSeller.setStoreName("Store of " + cat);
                newSeller.setStoreDescription("Top quality products in " + cat);
                newSeller.setContactEmail(cat.toLowerCase() + "@dummy.com");
                newSeller.setContactPhone("9999999999");
                return sellerRepository.save(newSeller);
            });

            // Create and Map Product
            Product product = new Product();
            product.setTitle(productDTO.title);
            product.setDescription(productDTO.description);
            product.setPrice(productDTO.price);
            product.setDiscount(productDTO.discountPercentage);
            product.setStocks(productDTO.stock);
            product.setBrand(productDTO.brand);
            product.setImage(productDTO.thumbnail);
            product.setCategory(category);
            product.setSeller(seller);

            productsToSave.add(product);
        }

        // Save all products in batch
        productRepository.saveAll(productsToSave);

        System.out.println("Loaded " + productsToSave.size() + " products successfully!");
    }

    // Helper DTO classes for API response
    static class ProductResponse {
        public List<ProductDTO> products;
    }

   
}
