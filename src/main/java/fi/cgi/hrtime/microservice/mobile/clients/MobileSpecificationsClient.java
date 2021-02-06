package fi.cgi.hrtime.microservice.mobile.clients;

import java.math.BigDecimal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fi.cgi.hrtime.microservice.mobile.clients.json.GenericResponse;
import fi.cgi.hrtime.microservice.mobile.clients.json.Specification;

@FeignClient(name = "mobile-specifications", url = "localhost:9001")
public interface MobileSpecificationsClient
{
    @GetMapping("specifications/{id}")
    public GenericResponse<Specification> get(
            @PathVariable BigDecimal id);
}
