package com.amigoscode.awsimageupload.profile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigoscode.awsimageupload.datastore.FakeUserProfileStore;

// This is the layer that communicates with our db (fake one)
@Repository
public class UserProfileDataAccessService {

	private final FakeUserProfileStore fakeUserProfileStore;

	// Spring will inject the bean into here. Reason its on the constructor is so
	// you cant create this class without the correct dependancy
	@Autowired
	public UserProfileDataAccessService(FakeUserProfileStore fakeUserProfileStore) {
		super();
		this.fakeUserProfileStore = fakeUserProfileStore;
	}

	// This is our layer that interacts with our db. This will return all user
	// profiles (called from our controller /). We are currently using a static
	// block to create a user profile list and just returning that
	List<UserProfile> getUserProfiles() {
		return fakeUserProfileStore.getUserProfiles();
	}
}
