package info.samordonez.ecommerce.app.payload;

public class APIResponse
{
    public String message;
    public boolean status;

    public APIResponse()
    {
    }

    public APIResponse(final String message,
                       final boolean status)
    {
        this.message = message;
        this.status = status;
    }

    public String getMessage()
    {
        return message;
    }

    public boolean isStatus()
    {
        return status;
    }

    public void setMessage(final String message)
    {
        this.message = message;
    }

    public void setStatus(final boolean status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "APIResponse{" +
                "message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
