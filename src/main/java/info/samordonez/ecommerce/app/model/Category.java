package info.samordonez.ecommerce.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity (name = "sjo_categories")
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Optional: for auto-incremented primary key
    private Long categoryId;

    @NotBlank
    @Size(min = 3, message = "Category name must have at least 3 characters")
    private String categoryName;

    // No-argument constructor is required by JPA
    public Category() {
        // Default constructor
    }

    public Category(Long categoryId,
                    String categoryName)
    {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Long getCategoryId()
    {
        return categoryId;
    }

    public String getCategoryName()
    {
        return categoryName;
    }

    public void setCategoryId(final Long categoryId)
    {
        this.categoryId = categoryId;
    }

    public void setCategoryName(final String categoryName)
    {
        this.categoryName = categoryName;
    }

    @Override
    public String toString()
    {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
