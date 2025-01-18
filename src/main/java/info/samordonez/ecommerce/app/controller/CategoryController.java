package info.samordonez.ecommerce.app.controller;

import info.samordonez.ecommerce.app.model.Category;
import info.samordonez.ecommerce.app.payload.CategoryDTO;
import info.samordonez.ecommerce.app.payload.CategoryResponse;
import info.samordonez.ecommerce.app.service.CategoryService;
import jakarta.validation.Valid;
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
    public ResponseEntity<CategoryResponse> getAllCategories()
    {
        CategoryResponse categoryResponse = categoryService.getAllCategories();
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

    @PostMapping("/public/categories")
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO)
    {
        CategoryDTO savedCategoryDTO = categoryService.addCategory(categoryDTO);
        //return new ResponseEntity<>(("Category " + categoryDTO.getCategoryId() + " added succesfuly!"), HttpStatus.OK);
        return new ResponseEntity<>(savedCategoryDTO, HttpStatus.OK);
    }

    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity<CategoryDTO> deleteCategory(@PathVariable Long categoryId)
    {
        CategoryDTO deletedCategory = categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(deletedCategory, HttpStatus.OK);
    }

    @PutMapping("/public/categories/{categoryId}")
    public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO,
                                                 @PathVariable Long categoryId){
        CategoryDTO updatedCategoryDTO = categoryService.updateCategory(categoryDTO, categoryId);
        return new ResponseEntity<>(updatedCategoryDTO, HttpStatus.OK);
    }
}
