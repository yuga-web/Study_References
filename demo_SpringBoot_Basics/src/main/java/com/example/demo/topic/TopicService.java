package com.example.demo.topic;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
@Service


public class TopicService {
	
	private List<Topic> topics =new ArrayList<>( Arrays.asList(
			new Topic("Spring","Sprg1","Spring Description1"),
			new Topic("Java","Javacore","Spring Description2"),
			new Topic("Php","Fundamentals","Spring ption3"),
			new Topic("Html","code","Spring")
				));
	public List<Topic> getAllTopics()
	{
		return topics;
	}

	
	public Topic getTopic(String id)
	{
		return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
	}
	
	
	public void addTopic(Topic topic) {
		topics.add(topic);
	}
	
	public void updateTopic(String id,Topic topic) {
		
		for(int i=0;i<topics.size();i++) {
			Topic t=topics.get(i);
			if(t.getId().equals(id))
			{
				topics.set(i, topic);
				return;
			}
		}
	}
	
	
	public void deleteTopic(String id)
	{
		topics.removeIf(t->t.getId().equals(id));
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}

}
