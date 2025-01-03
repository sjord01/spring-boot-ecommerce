package info.samordonez.ecommerce.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity (name = "sjo_categories")
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Optional: for auto-incremented primary key
    private Long categoryId;

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
