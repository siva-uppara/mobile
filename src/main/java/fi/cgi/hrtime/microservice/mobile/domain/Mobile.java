package fi.cgi.hrtime.microservice.mobile.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Mobile
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal    id;

    private String    mobileName;

    private String    company;
}
