package com.github.dashboard.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CompanyVsProductionByYearServiceTest {

    @Autowired
    CompanyVsProductionByYearService companyVsProductionByYearService;

    @Test
    void findAll() {
        companyVsProductionByYearService.findAll();
    }
}