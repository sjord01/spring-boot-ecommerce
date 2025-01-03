package info.samordonez.ecommerce.app.controller;

import info.samordonez.ecommerce.app.model.Category;
import info.samordonez.ecommerce.app.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

//@RestController is considered as a composed controller; it composes of at least 2 or more annotations
//@RestController consists of @@Controller & @ResponseBody, and others
@RestController
@RequestMapping("/api")
public class CategoryController
{
    private CategoryService categoryService;

    public CategoryController(final CategoryService categoryService)
    {
        this.categoryService = categoryService;
    }

    // OR -> @RequestMapping(value = "/public/categories", method = RequestMethod.GET)
    @GetMapping("/public/categories")
    public ResponseEntity<List<Category>> getAllCategories()
    {
        List<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/public/categories")
    public ResponseEntity<String> createCategory(@RequestBody Category category)
    {
        categoryService.addCategory(category);
        return new ResponseEntity<>(("Category " + category.getCategoryId() + " added succesfuly!"), HttpStatus.OK);
    }

    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId)
    {
        try
        {
            String status = categoryService.deleteCategory(categoryId);
            return new ResponseEntity<>(status, HttpStatus.OK);
        }
        catch(ResponseStatusException e)
        {
            return new ResponseEntity<>(e.getMessage(), e.getStatusCode());
        }
    }

    @PutMapping("/public/categories/{categoryId}")
    public ResponseEntity<String> updateCategory(@RequestBody Category category,
                                                 @PathVariable Long categoryId){
        try
        {
            Category updatedCategory = categoryService.updateCategory(category, categoryId);
            return new ResponseEntity<>(("Category updated to " + updatedCategory.getCategoryName()),
                    HttpStatus.OK);
        }
        catch(ResponseStatusException e)
        {
            return new ResponseEntity<>(e.getMessage(), e.getStatusCode());
        }
    }
}
