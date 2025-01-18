package info.samordonez.ecommerce.app.service;

import info.samordonez.ecommerce.app.model.Category;
import info.samordonez.ecommerce.app.payload.CategoryDTO;
import info.samordonez.ecommerce.app.payload.CategoryResponse;

//interface for loose coupling
public interface CategoryService
{
    CategoryResponse getAllCategories();
    CategoryDTO addCategory(CategoryDTO categoryDTO);
    CategoryDTO deleteCategory(Long categoryId);
    CategoryDTO updateCategory(CategoryDTO categoryDTO,
                            Long categoryId);
}
