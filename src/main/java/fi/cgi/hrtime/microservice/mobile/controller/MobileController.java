package fi.cgi.hrtime.microservice.mobile.controller;

import static org.springframework.http.HttpStatus.CREATED;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fi.cgi.hrtime.microservice.mobile.exception.MobileNotFoundException;
import fi.cgi.hrtime.microservice.mobile.json.ApiResponse;
import fi.cgi.hrtime.microservice.mobile.json.request.MobileRequest;
import fi.cgi.hrtime.microservice.mobile.service.MobileService;
import lombok.AllArgsConstructor;

/**
 * @author harshavardhanreddy.y
 */
@RestController
@RequestMapping("mobiles")
@AllArgsConstructor
public class MobileController
{
    private final MobileService service;
    
    @GetMapping("{id}")
    public ApiResponse findById(@PathVariable BigDecimal id)
            throws MobileNotFoundException {
        return service.findById(id);
    }
    
    @PostMapping
    @ResponseStatus(CREATED)
    public ApiResponse save(@RequestBody MobileRequest request) {
        return service.save(request);
    }
   
}
