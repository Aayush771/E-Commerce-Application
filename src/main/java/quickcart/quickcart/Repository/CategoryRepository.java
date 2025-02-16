package quickcart.quickcart.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import quickcart.quickcart.Entity.Category;
import java.util.List;



public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByCategoryName(String categoryName);
}
