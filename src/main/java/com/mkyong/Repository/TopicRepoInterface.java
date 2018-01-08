package com.mkyong.Repository;

import java.util.List;

import com.mkyong.bean.Topics;

public interface TopicRepoInterface {
	
	
	public List<Topics> findAll();	
    public Topics findUserByTopicId(int TopicId);
    public Topics create(Topics topic);
    public Topics updateById(Topics topic,int TopicId);
    
    
    

}
