package info.samordonez.ecommerce.app.service;

import info.samordonez.ecommerce.app.model.Category;
import info.samordonez.ecommerce.app.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//import java.util.concurrent.atomic.AtomicLong;

@Service
public class CategoryServiceImpl implements CategoryService
{
    private List<Category> categories = new ArrayList<>();
    // AtomicLong to ensure thread-safe auto-increment of categoryId
    //private AtomicLong categoryIdCounter = new AtomicLong(1);

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories()
    {
        return categoryRepository.findAll();
    }

    @Override
    public void addCategory(final Category category)
    {
        /*
        We use AtomicLong for generating unique categoryIds. This ensures that even if the
        application is multi-threaded, the IDs will be generated safely without race conditions.
        It starts from 1 and increments by 1 with each new category added.
         */
//        Long generatedId = categoryIdCounter.getAndIncrement();
//        category.setCategoryId(generatedId);
//        categories.add(category);
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId)
    {
//        Category category = categories.stream()
//                .filter(c -> c.getCategoryId().equals(categoryId))
//                .findFirst()
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, ("Category " + categoryId + " does not exist")));
//        categories.remove(category);
//        return "Category " + categoryId + " deleted successfully";

        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            // If exists, delete it
            categoryRepository.deleteById(categoryId);
            return "Category " + categoryId + " deleted successfully";
        } else {
            // If not found, throw an exception
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category " + categoryId + " does not exist");
        }
    }

    @Override
    public Category updateCategory(Category category,
                                   Long categoryId)
    {
//        Optional<Category> optionalCategory = categories.stream()
//                .filter(c -> c.getCategoryId().equals(categoryId))
//                .findFirst();
//        if (optionalCategory.isPresent())
//        {
//            Category existingCategory = optionalCategory.get();
//            existingCategory.setCategoryName(category.getCategoryName());
//            return existingCategory;
//        } else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ("Category " + categoryId + " does not exist"));
//        }

        Optional<Category> existingCategoryOpt = categoryRepository.findById(categoryId);
        if (existingCategoryOpt.isPresent()) {
            Category existingCategory = existingCategoryOpt.get();
            // Update the fields of the existing category
            existingCategory.setCategoryName(category.getCategoryName());
            // Save the updated category back to the database
            return categoryRepository.save(existingCategory);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category " + categoryId + " does not exist");
        }
    }

    public List<Category> getCategoriesByName(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }

}
