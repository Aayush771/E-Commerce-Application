package quickcart.quickcart.Service;

import java.util.List;

import quickcart.quickcart.Entity.Category;

public interface ICatagoryService {
    String addCatagory(Category category);
    String updateCatagory(Category category);
    String deleteCatagory(Long categoryId); 
    List<Category> getAllCatagories();
}
