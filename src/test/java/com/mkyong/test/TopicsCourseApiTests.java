package com.mkyong.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mkyong.bean.Response;
import com.mkyong.bean.Topics;



@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicsCourseApiTests {

	private MockMvc mockMvc;
	private ObjectMapper mapper = new ObjectMapper();
	@Autowired(required = true)
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.build();
	}
	
	

	@Test
	public void addTest() throws Exception{
		Topics topic = new Topics();
		topic.setTopicDescription("TopicDescriptionForTest");
		topic.setTopicName("topicNameForTest");
		String request = mapper.writeValueAsString(topic);
		MvcResult result = mockMvc
				.perform(
						post("/TC/add").content(request).contentType(
								MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		Response res = mapper.readValue(resultContent, Response.class);
		Assert.assertTrue(res.isSuccess() == true);
		
		
	}
	
		
	
	@Test
	public void findAllTest() throws Exception{
		MvcResult result = mockMvc
				.perform(
						MockMvcRequestBuilders.get("/TC/findAll")
								.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		Response res = mapper.readValue(resultContent, Response.class);
		Assert.assertTrue(res.isSuccess() == true);
		
		
		
		
	}
	
	@Test
	public void findTopicByTopicIdTest() throws Exception{
		
		//int TopicId= 102;
		MvcResult result = mockMvc
				.perform(
						get("/TC/findTopicById/102").contentType(
								MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		Response res = mapper.readValue(resultContent, Response.class);
		Assert.assertTrue(res.isSuccess() == true);
		
		
	}
	
	@Test
	 public void updateByIdTest() throws Exception{
		 //int TopicId= 103;
		 Topics topic = new Topics();
		 topic.setTopicId(103);
		 topic.setTopicDescription("UpdatedTopicDescriptionForTest");
			topic.setTopicName("UpdatedTopicNameForTest");
			String request = mapper.writeValueAsString(topic);
			MvcResult result = mockMvc
					.perform(
							post("/TC/update/103").content(request).contentType(
									MediaType.APPLICATION_JSON_VALUE))
					.andExpect(status().isOk()).andReturn();
			String resultContent = result.getResponse().getContentAsString();
			Response res = mapper.readValue(resultContent, Response.class);
			Assert.assertTrue(res.isSuccess() == true);
			
		 
	 }
	
	
	
	
}
