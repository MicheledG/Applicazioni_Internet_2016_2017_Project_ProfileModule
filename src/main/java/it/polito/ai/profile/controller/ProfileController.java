package it.polito.ai.profile.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.polito.ai.profile.model.Profile;
import it.polito.ai.profile.service.ProfileService;

/**
 * RestController for handling profiles:
 * - retrieve information about a profile;
 * - update profile information;
 * - change the password.
 */
@RestController
@CrossOrigin(origins="*")
@RequestMapping("/profile")
public class ProfileController {
	
	@Autowired
	private ProfileService profileService;
	
	/**
	 * Returns the profile of the currently logged user.
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public Profile getProfile() {
		
		Profile profile;
		
		// Get the username of the authenticated user from the SecurityContext
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		
		profile = profileService.getProfile(username);
		return profile;
		
	}
	
	/**
	 * Create a new profile given a username and a nickname.
	 * 
	 * @param requestBody
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void createProfile(@RequestBody Map<String, String> requestBody) {
		
		String username = requestBody.get("username");
		String nickname = requestBody.get("nickname");
		
		Profile profile = new Profile(username, nickname);
		
		profileService.createProfile(profile);
		
	}

}
