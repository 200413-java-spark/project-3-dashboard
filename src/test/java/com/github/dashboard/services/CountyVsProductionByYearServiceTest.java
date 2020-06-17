package com.github.dashboard.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CountyVsProductionByYearServiceTest {

    @Autowired
    CountyVsProductionByYearService countyVsProductionByYearService;

    @Test
    void findAll() {
        countyVsProductionByYearService.findAll();
    }

    @Test
    @Disabled
    void findById() {
        assertEquals("103711", countyVsProductionByYearService.findById(103711).toString());
    }

    @Test
    void findByCounty() {
        countyVsProductionByYearService.findByCounty("Allegany");
    }

    @Test
    void findByreportingyear() {
        countyVsProductionByYearService.findByreportingyear("2001");
    }
}