package info.samordonez.ecommerce.app.payload;

import java.util.List;

public class CategoryResponse
{
    private List<CategoryDTO> categoryDTOList;
    private Integer pageNumber;
    private Integer pageSize;
    private Long totalElements;
    private Integer totalPages;
    private boolean isLastPage;


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

    public Integer getPageNumber()
    {
        return pageNumber;
    }

    public Integer getPageSize()
    {
        return pageSize;
    }

    public Long getTotalElements()
    {
        return totalElements;
    }

    public Integer getTotalPages()
    {
        return totalPages;
    }

    public boolean isLastPage()
    {
        return isLastPage;
    }

    public void setPageNumber(final Integer pageNumber)
    {
        this.pageNumber = pageNumber;
    }

    public void setPageSize(final Integer pageSize)
    {
        this.pageSize = pageSize;
    }

    public void setTotalElements(final Long totalElements)
    {
        this.totalElements = totalElements;
    }

    public void setTotalPages(final Integer totalPages)
    {
        this.totalPages = totalPages;
    }

    public void setIsLastPage(final boolean lastPage)
    {
        isLastPage = lastPage;
    }

    @Override
    public String toString()
    {
        return "CategoryResponse{" +
                "categoryDTOList=" + categoryDTOList +
                '}';
    }
}
