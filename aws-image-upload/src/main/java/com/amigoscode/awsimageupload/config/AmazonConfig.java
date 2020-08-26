package com.amigoscode.awsimageupload.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

// @Configuration lets Spring know that there are beans in here
@Configuration
public class AmazonConfig {

	// Spring will instantiate this class so we can inject it into other classes
	@Bean
	public AmazonS3 s3() {
		AWSCredentials awsCredentials = new BasicAWSCredentials("AKIAIIWCIBXQZ6EVSBJQ", "5N3S9b/mVaZwbUxUsNb0kt4obUsqVbGfeNhxOrBO");
		
		return AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();
	}
	
	
}
