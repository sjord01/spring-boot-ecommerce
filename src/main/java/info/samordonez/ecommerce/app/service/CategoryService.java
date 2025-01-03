package info.samordonez.ecommerce.app.service;

import info.samordonez.ecommerce.app.model.Category;

import java.util.List;

//interface for loose coupling
public interface CategoryService
{
    List<Category> getAllCategories();
    void addCategory(Category category);
    String deleteCategory(Long categoryId);
    Category updateCategory(Category category,
                            Long categoryId);
}
