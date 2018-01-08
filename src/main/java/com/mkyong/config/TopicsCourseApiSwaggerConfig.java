package com.mkyong.config;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class TopicsCourseApiSwaggerConfig {
	
	
	@Bean
	public Docket postsApi() {
	

		
		
		return new Docket(DocumentationType.SWAGGER_2)   //.groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		// TODO Auto-generated method stub
		return  or(regex("/TC/.*"), regex("/TC.*"));
	}
	
	
	@SuppressWarnings("deprecation")
	private ApiInfo apiInfo() {
		// TODO Auto-generated method stub
		
		return  new ApiInfoBuilder().title("Topics And Course API")
		.description("Sample API Generateed Using SWAGGER")
		.termsOfServiceUrl("www.capgeminicom")
		.contact("java@gmail.com")
		.license("capgemini License")
		.licenseUrl("java@gmail.com").version("1.0")
		.build();
}

	

		
	}

	
	
	

