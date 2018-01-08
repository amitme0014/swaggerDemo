package com.mkyong.bean;

public class Topics {
	
	private  Integer TopicId ;
	private String TopicName;
	private String TopicDescription;
	public Integer getTopicId() {
		return TopicId;
	}
	public void setTopicId(Integer topicId) {
		TopicId = topicId;
	}
	public String getTopicName() {
		return TopicName;
	}
	public void setTopicName(String topicName) {
		TopicName = topicName;
	}
	public String getTopicDescription() {
		return TopicDescription;
	}
	public void setTopicDescription(String topicDescription) {
		TopicDescription = topicDescription;
	}
	
	
	public Topics() {
		
	}
	public Topics(Integer topicId, String topicName, String topicDescription) {
		super();
		TopicId = topicId;
		TopicName = topicName;
		TopicDescription = topicDescription;
	}
	
	public Topics(String topicName, String topicDescription) {
		super();
		TopicName = topicName;
		TopicDescription = topicDescription;
	}
	
	
	
	
	
	

}
