package com.amigoscode.awsimageupload.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;

// @Configuration lets Spring know that there are beans in here
public class AmazonConfig {

	public AmazonS3 s3() {
		AWSCredentials awsCredentials = new BasicAWSCredentials();
	}
}
