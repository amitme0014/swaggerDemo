package com.mkyong.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.mkyong.Mapper.UserRowMapper;
import com.mkyong.bean.Topics;
import com.mysql.jdbc.Statement;


@Repository
public class TopicRepository implements TopicRepoInterface {
	
	
	 @Autowired
	 private JdbcTemplate jdbcTemplate; 

	 
	@Override
	public List<Topics> findAll() {
		// TODO Auto-generated method stub
		
		
		 return jdbcTemplate.query("select * from topics", 
                new UserRowMapper());
	}

	@Override
	public Topics findUserByTopicId(int TopicId) {
		// TODO Auto-generated method stub
		  return jdbcTemplate.queryForObject(
		            "select * from topics where TopicId=?",
		            new Object[]{TopicId}, new UserRowMapper());
		
		
	}
	
	


	@Override
	public Topics create(Topics topic) {
		
		final String sql = "insert into topics(topicName,topicDescription) values(?,?)";
		 KeyHolder holder = new GeneratedKeyHolder();
		  jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				// TODO Auto-generated method stub
				  PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				  ps.setString(1, topic.getTopicName());
	                ps.setString(2, topic.getTopicDescription());
				return ps;
			}
		
		
	},holder);
		  int newTopicId = holder.getKey().intValue();
	        topic.setTopicId(newTopicId);
	        return topic;
	        
	}

	@Override
	public Topics updateById(Topics topic, int TopicId) {
		// TODO Auto-generated method stub
		final String sql ="update Topics set TopicName=?,TopicDescription=? where TopicId=?";
		// KeyHolder holder = new GeneratedKeyHolder();
		  jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				// TODO Auto-generated method stub
				 PreparedStatement ps = connection.prepareStatement(sql);
				ps.setInt(1, topic.getTopicId());
				 ps.setString(2, topic.getTopicName());
				 ps.setString(3, topic.getTopicDescription());
				
				return ps;
			}
			  
			  
		  });
		  
		
	        return topic;
		
		
	        
	        
		//jdbcTemplate.update(sql,topic.getTopicId(),topic.getTopicName(),topic.getTopicDescription());
		
	}
	
	
	
	
	
	
	
	

}
