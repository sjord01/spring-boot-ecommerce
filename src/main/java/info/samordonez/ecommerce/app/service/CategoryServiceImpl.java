package info.samordonez.ecommerce.app.service;

import info.samordonez.ecommerce.app.exceptions.APIException;
import info.samordonez.ecommerce.app.exceptions.ResourceNotFoundException;
import info.samordonez.ecommerce.app.model.Category;
import info.samordonez.ecommerce.app.payload.CategoryDTO;
import info.samordonez.ecommerce.app.payload.CategoryResponse;
import info.samordonez.ecommerce.app.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
//import java.util.concurrent.atomic.AtomicLong;

@Service
public class CategoryServiceImpl implements CategoryService
{
    //private List<Category> categories = new ArrayList<>();
    // AtomicLong to ensure thread-safe auto-increment of categoryId
    //private AtomicLong categoryIdCounter = new AtomicLong(1);

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryResponse getAllCategories()
    {
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty()) {
            throw new APIException("No category found");
        }

        List<CategoryDTO> categoryDTOList = categories.stream().
                map(c -> modelMapper.map(c, CategoryDTO.class)).toList();
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setCategoryDTOList(categoryDTOList);
        return categoryResponse;
    }

    @Override
    public CategoryDTO addCategory(final CategoryDTO categoryDTO)
    {
        Category category = modelMapper.map(categoryDTO, Category.class);

        Category savedCategoryFromDB = categoryRepository.findByCategoryName(category.getCategoryName());
        if (savedCategoryFromDB != null) {
            throw new APIException("Category with name " + category.getCategoryName() + " already exists");
        }
        categoryRepository.save(category);

        Category savedCategory = categoryRepository.save(category);
        return modelMapper.map(savedCategory, CategoryDTO.class);
    }

    @Override
    public CategoryDTO deleteCategory(Long categoryId)
    {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
        categoryRepository.delete(category);
        return modelMapper.map(category, CategoryDTO.class);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO,
                                   Long categoryId)
    {
        Category savedCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
        Category category = modelMapper.map(categoryDTO, Category.class);
        category.setCategoryId(categoryId);
        savedCategory = categoryRepository.save(category);
        return modelMapper.map(savedCategory, CategoryDTO.class);
    }

    public Category getCategoriesByName(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }

}
