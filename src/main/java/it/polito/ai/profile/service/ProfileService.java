package it.polito.ai.profile.service;

import it.polito.ai.profile.model.Profile;

public interface ProfileService {

	public Profile getProfile(String username);

	public void addProfile(Profile profile);

	public String getNickname(String username);

	public void createProfile(Profile profile);

}
