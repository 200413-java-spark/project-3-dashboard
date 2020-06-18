package com.github.dashboard.controllers;

import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.dashboard.services.CountyVsOilProductionByYearService;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@SpringBootTest
public class CountyVsOilProductionByYearControllerTest {
   
    @Autowired
	private CountyVsOilProductionByYearController controller;

	@Test
	public void contexLoads() throws Exception {
		assertThat(controller).isNotNull();
	}


}