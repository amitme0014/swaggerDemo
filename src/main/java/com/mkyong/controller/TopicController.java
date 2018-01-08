package com.mkyong.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mkyong.Repository.TopicRepoInterface;
import com.mkyong.bean.Response;
import com.mkyong.bean.Topics;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/TC")
@EnableAutoConfiguration
@Api(value="/TC")

public class TopicController {
	private Logger logger = LoggerFactory.getLogger(TopicController.class);
	private ObjectMapper mapper = new ObjectMapper();
	
	
	
	@Autowired
	 private TopicRepoInterface service;

	@RequestMapping("/findAll")
	@ApiParam(value="/findAll")
	@ApiResponses(value = {@ApiResponse(code = 400, message = "could not find details"),
		      @ApiResponse(code = 404, message = "data not found") })
	public Response findAll(){
	
		Response response = new Response();
		List<Topics> topics = null;
		
		
		try {
			topics = service.findAll();
			logger.debug("response  for findAll() method is {}",
					mapper.writeValueAsString(topics));
			if(!topics.isEmpty()) {
				response.setTopic(topics);
				response.setSuccess(true);
				response.setStatus("success");
			}
			else {
				response.setSuccess(false);
				response.setStatus("Failure");
			}
		} catch (JsonProcessingException  e) {
			// TODO Auto-generated catch block
			logger.error("Error while getAll : " + e.getMessage());
			
		}
		
		return response;
		
				
				
				
		
	}
	
	
	 @RequestMapping("/findTopicById/{TopicId}")
	 @ApiParam(value="/findTopicById/{TopicId}")
	 @ApiResponses(value = {@ApiResponse(code = 400, message = "wrong id supplied"),
		      @ApiResponse(code = 404, message = "data not found") })
	 public Response  findTopicByTopicId( @PathVariable("TopicId") int TopicId) {
		 Response response = new Response();
		 
		 Topics topic= service.findUserByTopicId(TopicId);
		 
		 try {
			logger.debug("response  for findAll() method is {}",
						mapper.writeValueAsString(topic));
			
			if(topic!=null) {
				response.setTopics(topic);
				response.setSuccess(true);
				response.setStatus("success");
			}
			else {
				response.setSuccess(false);
				response.setStatus("Failure");
			}
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
		
			logger.error("error while getting a topic {}", e.getMessage());
		}
		 
		 
		 
		 return  response;
	 }
	 
	 
	 @RequestMapping(value="/update/{TopicId}", method=RequestMethod.POST)
	 @ApiParam(value="/update/{TopicId}")
	 @ApiResponses(value = {@ApiResponse(code = 400, message = "wrong data supplied"),
		      @ApiResponse(code = 404, message = "could not be updated") })
	  public Response updateById( @RequestBody Topics topic, @PathVariable("TopicId") int TopicId) {
		 Response response = new Response();
		 
		 try {
			 Topics topics = service.updateById(topic, TopicId);
			logger.debug("response  for findAll() method is {}",
						mapper.writeValueAsString(topics));
			
			if(topics!=null) {
				response.setTopics(topics);
				response.setSuccess(true);
				response.setStatus("success");
			}
			else {
				response.setSuccess(false);
				response.setStatus("Failure");
			}
		} catch (JsonProcessingException e ) {
			// TODO Auto-generated catch block
			logger.error("error while updating employee {}", e.getMessage());
			
		}

		 
		 
		return response;
	 }
	 
	 
	 
	 
	 
	 @RequestMapping(value="/add", method=RequestMethod.POST)
	 @ApiParam(value="/add")
	 @ApiResponses(value = {@ApiResponse(code = 400, message = "wrong data supplied"),
		      @ApiResponse(code = 404, message = "could not be updated") })
	  public Response add( @RequestBody Topics topic) {
		 Response response = new Response();
		 
		 try {
			 Topics topics = service.create(topic);
			logger.debug("response  for findAll() method is {}",
						mapper.writeValueAsString(topics));
			
			if(topics!=null) {
				response.setTopics(topics);
				response.setSuccess(true);
				response.setStatus("success");
			}
			else {
				response.setSuccess(false);
				response.setStatus("Failure");
			}
		} catch (JsonProcessingException e ) {
			// TODO Auto-generated catch block
			logger.error("error while updating employee {}", e.getMessage());
			
		}

		 
		 
		return response;
	 }
	 
	 
}
