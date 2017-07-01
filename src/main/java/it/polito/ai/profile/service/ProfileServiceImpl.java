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
	public String getNickname(String username) {
		return profileRepository.findOneByUsername(username).getNickname();
	}

	@Override
	public boolean createProfile(Profile profile) {
		
		// Check if there is already a profile with the same username
		if (profileRepository.findOneByUsername(profile.getUsername()) != null) {
			return false;
		}
		
		profileRepository.save(profile);
		
		return true;
	}

	@Override
	public Profile updateProfile(String username, Profile profile) {
		
		// Check if the profile exists
		if (profileRepository.findOneByUsername(username) == null) {
			return null;
		}
		
		// Set the profile id and username
		String profileId = profileRepository.findOneByUsername(username).getProfileId();
		profile.setProfileId(profileId);
		profile.setUsername(username);
		
		return profileRepository.save(profile);
	}

}
