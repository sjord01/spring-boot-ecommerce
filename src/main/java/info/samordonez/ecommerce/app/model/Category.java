package info.samordonez.ecommerce.app.model;

public class Category
{
    private Long categoryId;
    private String categoryName;

    public Category(final Long categoryId,
                    final String categoryName)
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
