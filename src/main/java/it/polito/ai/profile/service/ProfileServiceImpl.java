package it.polito.ai.profile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.polito.ai.profile.model.Profile;
import it.polito.ai.profile.repository.ProfileRepository;

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

	@Override
	public void createProfile(Profile profile) {
		profileRepository.save(profile);
	}

}
