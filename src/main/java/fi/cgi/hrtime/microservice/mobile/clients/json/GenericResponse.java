package fi.cgi.hrtime.microservice.mobile.clients.json;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericResponse<T>
{
    private String  message;

    private Integer status;

    private List<T> data;
}
