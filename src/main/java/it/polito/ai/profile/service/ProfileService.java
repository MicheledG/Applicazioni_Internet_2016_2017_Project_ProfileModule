package it.polito.ai.profile.service;

import it.polito.ai.profile.model.Profile;

public interface ProfileService {

	public Profile getProfile(String username);

	public String getNickname(String username);

	public boolean createProfile(Profile profile);

	public Profile updateProfile(String username, Profile profile);

}
