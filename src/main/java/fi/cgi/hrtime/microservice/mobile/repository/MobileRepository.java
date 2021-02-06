package fi.cgi.hrtime.microservice.mobile.repository;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import fi.cgi.hrtime.microservice.mobile.domain.Mobile;

public interface MobileRepository
    extends
    CrudRepository<Mobile, BigDecimal>
{

}
