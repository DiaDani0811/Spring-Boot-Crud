package com.dineshApp.mainApp.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class topicService {
	private List<topicDao> listOfTopics = new ArrayList<topicDao>(Arrays.asList(
			new topicDao(1, "spring", "Spring FrameWORK"), new topicDao(2, "Angular", "angular FrameWORK"),
			new topicDao(3, "React", "React FrameWORK"), new topicDao(4, "kotlin", "kotlin FrameWORK")));

	public List<topicDao> getAllTopics() {
		return listOfTopics;
	}

	public topicDao getTopicWithID(int id) {
		return listOfTopics.stream().filter(item -> item.getId() == id).findFirst().get();

	}

	public void addTopic(topicDao payload) {
		listOfTopics.add(payload);
	}
	
	public void updateTopicWithId(topicDao payload, int id) {
		for(int i =0; i < listOfTopics.size(); i++) {
			topicDao obj = listOfTopics.get(i);
			if(obj.getId() == id)
				listOfTopics.set(i, obj); 
		}
	}
}

//https://www.youtube.com/watch?v=aww-VqG3uuE&list=WL&index=1&t=3772s