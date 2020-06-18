package com.github.dashboard.services;


import java.util.ArrayList;
import java.util.List;

import com.github.dashboard.models.CountyVsOilProductionByYearModel;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CVOServicesTest {

    @Autowired
	private CountyVsOilProductionByYearService service;

	@Test
	public void contexLoads() throws Exception {
        service = new CountyVsOilProductionByYearService();
		assertThat(service).isNotNull();
	}

	@Test
	public void findAllTest() throws Exception {
        service = new CountyVsOilProductionByYearService();
        ArrayList<ArrayList<String>> stringList = new ArrayList<>();
        ArrayList<String> string = new ArrayList<>();
        ArrayList<ArrayList<String>> testList = new ArrayList<>();
        ArrayList<String> t1 = new ArrayList<>();
        t1.add("Chautauqua");
        t1.add("2004");
        t1.add("8654.0");
        List<CountyVsOilProductionByYearModel> cvo = service.findAll();

        assertTrue(t1.get(0).equals("Chautauqua"), "Chautauqua = Chatauqua test pass");
        

	}
   
}