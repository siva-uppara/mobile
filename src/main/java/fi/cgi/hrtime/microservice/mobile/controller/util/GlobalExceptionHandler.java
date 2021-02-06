package fi.cgi.hrtime.microservice.mobile.controller.util;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import fi.cgi.hrtime.microservice.mobile.exception.MobileNotFoundException;
import fi.cgi.hrtime.microservice.mobile.json.ApiResponse;

@ControllerAdvice
public class GlobalExceptionHandler
    extends
    ResponseEntityExceptionHandler
{
    
    private ResponseEntity<Object> buildResponseEntity(
            final ApiResponse response, final HttpServletRequest req,
            final Exception ex)
    {
        logger.error(String.format("Response %s for %s @ %s. Message: %s ",
                response.getStatus(), req.getMethod(), req.getRequestURL(),
                response.getMessage()), ex);
        return new ResponseEntity<>(response, NOT_FOUND);
    }
    
    @ExceptionHandler(MobileNotFoundException.class)
    public ResponseEntity<Object> handleMobileNotFoundException(
            final HttpServletRequest req, final Exception ex)
    {
        return buildResponseEntity(new ApiResponse(ex.getMessage(),
                NOT_FOUND.value(), new ArrayList<>()), req, ex);
    }
    
}
