package com.github.dashboard.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CompanyVsProductionByYearModelTest {


    CompanyVsProductionByYearModel companyVsProductionByYearModel = new CompanyVsProductionByYearModel("Yahn & Yahn Inc.",29.0, 34.0, 1.0, "2001" );

    @Test
    void getCompanyname() {
        assertEquals("Yahn & Yahn Inc.", companyVsProductionByYearModel.getCompanyname());
    }

    @Test
    void getTotaloil() {
        assertEquals(29.0, companyVsProductionByYearModel.getTotaloil());
    }

    @Test
    void getTotalwater() {
        assertEquals(34.0, companyVsProductionByYearModel.getTotalwater());
    }

    @Test
    void getgastotal() {
        assertEquals(1.0, companyVsProductionByYearModel.getgastotal());
    }

    @Test
    void getyear() {
        assertEquals("2001", companyVsProductionByYearModel.getyear());
    }

}