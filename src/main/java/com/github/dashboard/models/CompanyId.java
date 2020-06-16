package com.github.dashboard.models;

import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable
public class CompanyId implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String companyname;
    private Integer year;
 
    public CompanyId(){}
 
    public CompanyId(String companyname, Integer year) {
        this.companyname = companyname;
        this.year = year;
    }
 
    // getters, equals() and hashCode() methods
}