package it.polito.ai.profilemodule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.polito.ai.profilemodule.model.Profile;
import it.polito.ai.profilemodule.service.ProfileService;

/**
 * RestController for handling profiles:
 * - retrieve information about a profile;
 * - update profile information;
 * - change the password.
 */
@RestController
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
		
		//TODO: debug purpose
		//profile = profileService.getProfile(username);
		//return profile;
		
		Profile debugProfile = new Profile();
		debugProfile.setNickname(username);
		return debugProfile;
	}

}
