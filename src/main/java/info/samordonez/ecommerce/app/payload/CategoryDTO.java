package info.samordonez.ecommerce.app.payload;


public class CategoryDTO
{
    private Long categoryId;
    private String categoryName;

    public CategoryDTO()
    {
    }

    public CategoryDTO(Long categoryId,
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
        return "CategoryDTO{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
