package fi.cgi.hrtime.microservice.mobile.json.response;

import java.math.BigDecimal;

import fi.cgi.hrtime.microservice.mobile.clients.json.Specification;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MobileResponse
{
    private BigDecimal id;

    private String     mobileName;

    private String     company;
    
    private Specification specification;
}
