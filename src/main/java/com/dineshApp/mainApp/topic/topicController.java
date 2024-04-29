package com.dineshApp.mainApp.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class topicController {

	@Autowired
	topicService tService;

	@RequestMapping("/topics")
	public List<topicDao> getTopics() {
		return tService.getAllTopics();
	}

	@RequestMapping("/topics/{id}")
	public topicDao getTopicWithId(@PathVariable int id) {
		return tService.getTopicWithID(id);

	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void addTopic(@RequestBody topicDao payload) {
		tService.addTopic(payload); 		
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody topicDao payload, @PathVariable int id ) {
		tService.updateTopicWithId(payload, id);
	}
}
