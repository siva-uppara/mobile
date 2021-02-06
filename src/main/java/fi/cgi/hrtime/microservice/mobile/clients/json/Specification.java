package fi.cgi.hrtime.microservice.mobile.clients.json;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Specification
{
    private BigDecimal id;
    
    private String mobileName;

    private String ram;

    private String storage;
}
