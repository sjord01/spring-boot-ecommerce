package info.samordonez.ecommerce.app.payload;

import java.util.List;

public class CategoryResponse
{
    private List<CategoryDTO> categoryDTOList;

    public CategoryResponse()
    {
    }

    public CategoryResponse(final List<CategoryDTO> categoryDTOList)
    {
        this.categoryDTOList = categoryDTOList;
    }

    public List<CategoryDTO> getCategoryDTOList()
    {
        return categoryDTOList;
    }

    public void setCategoryDTOList(final List<CategoryDTO> categoryDTOList)
    {
        this.categoryDTOList = categoryDTOList;
    }

    @Override
    public String toString()
    {
        return "CategoryResponse{" +
                "categoryDTOList=" + categoryDTOList +
                '}';
    }
}
