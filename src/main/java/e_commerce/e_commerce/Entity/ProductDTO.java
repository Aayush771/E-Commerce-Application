package e_commerce.e_commerce.Entity;

public class ProductDTO {
        public String title;
        public String description;
        public double price;
        public double discountPercentage;
        public String category;
        public String brand;
        public int stock;
        public String thumbnail;
        public ProductDTO(String title, String description, double price, double discountPercentage, String category,
                String brand, int stock, String thumbnail) {
            this.title = title;
            this.description = description;
            this.price = price;
            this.discountPercentage = discountPercentage;
            this.category = category;
            this.brand = brand;
            this.stock = stock;
            this.thumbnail = thumbnail;
        }
        public ProductDTO() {
        }

        
    }