package it.polito.ai.profilemodule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.polito.ai.profilemodule.model.Profile;
import it.polito.ai.profilemodule.repository.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private ProfileRepository profileRepository;

	@Override
	public Profile getProfile(String username) {
		return profileRepository.findOneByUsername(username);
	}

	@Override
	public void addProfile(Profile profile) {
		profileRepository.save(profile);
	}

	@Override
	public String getNickname(String username) {
		return profileRepository.findOneByUsername(username).getNickname();
	}

}
