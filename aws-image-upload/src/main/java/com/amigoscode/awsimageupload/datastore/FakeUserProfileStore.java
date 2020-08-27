package com.amigoscode.awsimageupload.datastore;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.amigoscode.awsimageupload.profile.UserProfile;

@Repository
public class FakeUserProfileStore {

	private static final List<UserProfile> USER_PROFILES = new ArrayList<>();

	// When the class is loaded this static block will run
	static {
		USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "Manjyot", null));
		USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "Keen", null));
		USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "Track", null));
	}

	public List<UserProfile> getUserProfiles() {
		return USER_PROFILES;
	}
}
