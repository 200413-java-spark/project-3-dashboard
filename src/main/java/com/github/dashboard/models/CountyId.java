package com.github.dashboard.models;

import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable
public class CountyId implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String county;
    private Integer reportingyear;
 
    public CountyId(){}
 
    public CountyId(String county, Integer reportingyear) {
        this.county = county;
        this.reportingyear = reportingyear;
    }
 
    // getters, equals() and hashCode() methods
}