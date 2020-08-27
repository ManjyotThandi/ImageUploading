package com.amigoscode.awsimageupload.filestore;

import java.io.InputStream;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;

@Service
public class FileStore {

	// Spring will look for a bean that returns AmazonS3
	private final AmazonS3 s3;

	// You can either put @Autowired on the constructor or on the field. When used
	// on the constructor an instance of this class can't be made
	// without having the correct dependency ready for injection.
	@Autowired
	public FileStore(AmazonS3 s3) {
		this.s3 = s3;
	}

	public void save(String path, String fileName, Optional<Map<String, String>> optionalMetadata,
			InputStream inputStream) {

		ObjectMetadata metadata = new ObjectMetadata();

		// if the optional map is present take each value in the map and perform
		// metadata.addUserMetadata(k,v)
		optionalMetadata.ifPresent(map -> {
			if (!map.isEmpty()) {
				map.forEach((k, v) -> {
					// We can also use method reference here instead of lambda
					metadata.addUserMetadata(k, v);
				});
			}
		});

		// uploads a new object to the bucket
		try {
			s3.putObject(path, fileName, inputStream, metadata);
		} catch (AmazonServiceException e) {
			throw new IllegalStateException("Failed to store file to s3", e);
		}
	}
}
