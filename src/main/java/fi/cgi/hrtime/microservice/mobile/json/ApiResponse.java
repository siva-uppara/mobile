package fi.cgi.hrtime.microservice.mobile.json;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse
{
    private String message;
    
    private Integer status;
    
    private List<Object> data;

    @SuppressWarnings("rawtypes")
    public ApiResponse(String message, Integer status, List data)
    {
        super();
        this.message = message;
        this.status = status;
        this.data = data;
    }
    
    
}
