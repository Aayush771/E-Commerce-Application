package quickcart.quickcart.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quickcart.quickcart.Entity.Category;
import quickcart.quickcart.Repository.CategoryRepository;
@Service
public class CatagoryService implements ICatagoryService{

    @Autowired
    private CategoryRepository catagoryRepository;

    @Override
    public String addCatagory(Category category) {
        catagoryRepository.save(category);
        return "Catagory added successfully";
    }

    @Override
    public String updateCatagory(Category category) {
       Category catagory = catagoryRepository.findById(category.getCategoryId()).orElseThrow(()-> new RuntimeException("Catagory not found"));
       if(category.getCategoryName() != null) {
           catagory.setCategoryName(category.getCategoryName());
           catagoryRepository.save(catagory);
           return "Catagory updated successfully";
       }
       return "Catagory not updated";
    }

    @Override
    public String deleteCatagory(Long categoryId) {
        // TODO Auto-generated method stub
        catagoryRepository.findById(categoryId).orElseThrow(()-> new RuntimeException("Catagory not found"));
        catagoryRepository.deleteById(categoryId);
        return "Catagory deleted successfully"; 
    }

    @Override
    public List<Category> getAllCatagories() {
        // TODO Auto-generated method stub
        return catagoryRepository.findAll();
    }
    
    
}
