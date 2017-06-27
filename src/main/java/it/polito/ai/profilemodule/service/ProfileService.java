package it.polito.ai.profilemodule.service;

import it.polito.ai.profilemodule.model.Profile;

public interface ProfileService {

	public Profile getProfile(String username);

	public void addProfile(Profile profile);

	public String getNickname(String username);

}
