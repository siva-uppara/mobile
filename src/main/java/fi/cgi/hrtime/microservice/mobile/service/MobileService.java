package fi.cgi.hrtime.microservice.mobile.service;

import static java.util.Arrays.asList;
import static org.springframework.http.HttpStatus.OK;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.cgi.hrtime.microservice.mobile.clients.MobileSpecificationsClient;
import fi.cgi.hrtime.microservice.mobile.clients.json.Specification;
import fi.cgi.hrtime.microservice.mobile.domain.Mobile;
import fi.cgi.hrtime.microservice.mobile.exception.MobileNotFoundException;
import fi.cgi.hrtime.microservice.mobile.json.ApiResponse;
import fi.cgi.hrtime.microservice.mobile.json.request.MobileRequest;
import fi.cgi.hrtime.microservice.mobile.json.response.MobileResponse;
import fi.cgi.hrtime.microservice.mobile.repository.MobileRepository;

/**
 * @author harshavardhanreddy.y
 */
@Service
public class MobileService
{
    @Autowired
    private MobileRepository           mobileRepository;

    @Autowired
    private MobileSpecificationsClient client;

    public ApiResponse findById(BigDecimal id) throws MobileNotFoundException
    {

        final Mobile mobile = mobileRepository.findById(id).orElseThrow(
                () -> new MobileNotFoundException("Mobile is not found"));

        final Specification specification = client.get(id).getData().get(0);
        
        return toApiResponse(mobile, specification);

    }

    private ApiResponse toApiResponse(Mobile mobile)
    {
        return new ApiResponse(OK.getReasonPhrase(), OK.value(),
                asList(toMobileResponse(mobile)));
    }

    private ApiResponse toApiResponse(Mobile mobile,
            Specification specification)
    {
        return new ApiResponse(OK.getReasonPhrase(), OK.value(),
                asList(toMobileResponse(mobile, specification)));
    }

    private MobileResponse toMobileResponse(Mobile mobile,
            Specification specification)
    {
        final MobileResponse mobileResponse = new MobileResponse();
        mobileResponse.setId(mobile.getId());
        mobileResponse.setCompany(mobile.getCompany());
        mobileResponse.setMobileName(mobile.getMobileName());
        mobileResponse.setSpecification(specification);
        return mobileResponse;
    }

    private MobileResponse toMobileResponse(Mobile mobile)
    {
        final MobileResponse mobileResponse = new MobileResponse();
        mobileResponse.setId(mobile.getId());
        mobileResponse.setCompany(mobile.getCompany());
        mobileResponse.setMobileName(mobile.getMobileName());
        return mobileResponse;
    }

    public ApiResponse save(MobileRequest request)
    {
        final Mobile mobile = toMobile(request);
        final Mobile savedMobile = mobileRepository.save(mobile);
        return toApiResponse(savedMobile);
    }

    private Mobile toMobile(MobileRequest request)
    {
        final Mobile mobile = new Mobile();
        mobile.setCompany(request.getCompany());
        mobile.setMobileName(request.getMobileName());
        return mobile;
    }

}
