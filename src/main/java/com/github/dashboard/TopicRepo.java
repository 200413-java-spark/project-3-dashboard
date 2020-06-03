package com.github.dashboard;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepo extends CrudRepository<Topic, String>{

	// getAllTopics()
	// getTopic(String id)
	// updateTopic(Topic t)
	// deleteTopic(String id)
}
