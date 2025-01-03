package info.samordonez.ecommerce.app.repositories;


import info.samordonez.ecommerce.app.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long>
{
    List<Category> findByCategoryName(String categoryName);
}
