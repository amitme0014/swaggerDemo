package com.mkyong.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.mkyong.bean.Topics;

public class UserRowMapper implements  RowMapper<Topics> {

	

	@Override
	public Topics mapRow(ResultSet rs, int rownum) throws SQLException {
		// TODO Auto-generated method stub
		
		
		Topics topics = new Topics();
		topics.setTopicId(rs.getInt("TopicId"));
		topics.setTopicName(rs.getString("TopicName"));
		topics.setTopicDescription(rs.getString("TopicDescription"));
	    
	        return topics;
		
	}

}
