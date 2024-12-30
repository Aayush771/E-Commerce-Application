package e_commerce.e_commerce.Service;

import java.util.List;

import e_commerce.e_commerce.Entity.Category;

public interface ICatagoryService {
    String addCatagory(Category category);
    String updateCatagory(Category category);
    String deleteCatagory(Long categoryId); 
    List<Category> getAllCatagories();
}
