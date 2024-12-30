package e_commerce.e_commerce.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import e_commerce.e_commerce.Entity.Category;
import e_commerce.e_commerce.Repository.CategoryRepository;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCatagory'");
    }

    @Override
    public String deleteCatagory(Long categoryId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCatagory'");
    }

    @Override
    public List<Category> getAllCatagories() {
        // TODO Auto-generated method stub
        return catagoryRepository.findAll();
    }
    
    
}
