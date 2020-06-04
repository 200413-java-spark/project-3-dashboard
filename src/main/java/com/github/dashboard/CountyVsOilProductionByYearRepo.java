package com.github.dashboard;

import com.github.dashboard.CountyVsOilProductionByYear;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountyVsOilProductionByYearRepo extends JpaRepository<CountyVsOilProductionByYear, Integer>{

	// getAllTopics()
	// getTopic(String id)
	// updateTopic(Topic t)
	// deleteTopic(String id)
}
