package com.github.dashboard.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class geolocationModelTest {

    geolocationModel geolocationModel = new geolocationModel("Allegany", "Alma", -78.060759, 42.012207, "0", "0", "0", 2001);

    @Test
    void getCounty() {
        assertEquals("Allegany", geolocationModel.getCounty());
    }

    @Test
    void getTown() {
        assertEquals("Alma", geolocationModel.getTown());

    }

    @Test
    void getLongitude() {
        assertEquals(42.012207, geolocationModel.getLongitude());

    }

    @Test
    void getLatitude() {
        assertEquals(-78.060759, geolocationModel.getLatitude());

    }

    @Test
    void getYear() {
        assertEquals(2001, geolocationModel.getYear());

    }

    @Test
    void getGas() {
        assertEquals("0", geolocationModel.getGas());

    }

    @Test
    void getOil() {
        assertEquals("0", geolocationModel.getOil());

    }

    @Test
    void getWater() {
        assertEquals("0", geolocationModel.getWater());

    }
}