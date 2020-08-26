package com.amigoscode.awsimageupload.bucket;

public enum BucketName {

	PROFILE_IMAGE("mytestbucketimageupload");

	private final String bucketName;

	// constructor must be private or package scoped(default)
	BucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	public String getBucketName() {
		return bucketName;
	}

}
