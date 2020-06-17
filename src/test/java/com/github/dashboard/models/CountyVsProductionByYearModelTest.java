package com.github.dashboard.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CountyVsProductionByYearModelTest {

CountyVsProductionByYearModel countyVsProductionByYearModel = new CountyVsProductionByYearModel("Allegany", 100.0, 234.0, 500.0, "2001" );

    @Test
    void getCounty() {
    assertEquals("Allegany", countyVsProductionByYearModel.getCounty());
    }

    @Test
    void getTotaloil() {
        assertEquals(100.0, countyVsProductionByYearModel.getTotaloil());
    }

    @Test
    void getTotalwater() {
        assertEquals(234.0, countyVsProductionByYearModel.getTotalwater());
    }

    @Test
    void getTotalgas() {
        assertEquals(500.0, countyVsProductionByYearModel.getTotalgas());
    }

    @Test
    void getReportingyear() {
        assertEquals("2001", countyVsProductionByYearModel.getReportingyear());
    }
}