package info.samordonez.ecommerce.app.exceptions;

public class ResourceNotFoundException extends RuntimeException
{
    String resourceName;
    String field;
    String fieldName;
    Long fieldId;

    public ResourceNotFoundException()
    {
    }

    public ResourceNotFoundException(final String resourceName,
                                     final String field,
                                     final String fieldName)
    {
        super(String.format("Resource '%s' not found for field '%s': %s", resourceName, field, fieldName));
        this.resourceName = resourceName;
        this.field = field;
        this.fieldName = fieldName;
    }

    public ResourceNotFoundException(final String resourceName,
                                     final String field,
                                     final Long fieldId)
    {
        super(String.format("Resource '%s' not found for field '%s': %d", resourceName, field, fieldId));
        this.resourceName = resourceName;
        this.field = field;
        this.fieldId = fieldId;
    }


}
