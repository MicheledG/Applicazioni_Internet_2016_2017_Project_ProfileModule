package it.polito.ai.profile.controller;

import java.util.Map;
import java.util.NoSuchElementException;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.polito.ai.profile.exception.ProfileCreationConflict;
import it.polito.ai.profile.model.Profile;
import it.polito.ai.profile.service.ProfileService;

/**
 * RestController for handling profiles:
 * - retrieve information about a profile;
 * - update profile information;
 * - change the password.
 */
@RestController
@CrossOrigin(origins="*", allowedHeaders={"Accept", "Authorization", "Content-Type"})
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
	 * @throws ProfileCreationConflict 
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void createProfile(@Validated @RequestBody Map<String, String> requestBody) throws ProfileCreationConflict {
		
		String username = requestBody.get("username");
		String nickname = requestBody.get("nickname");
		
		Profile profile = new Profile(username, nickname);
		
		// If there is already a profile with the same username => 409
		if (!profileService.createProfile(profile)) {
			throw new ProfileCreationConflict(profile.getUsername());
		}
		
	}
	
	/**
	 * Update the profile of the authenticated user.
	 * 
	 * @param profile
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public Profile updateProfile(@Validated @RequestBody Profile profile) {
		
		// Get the username of the authenticated user from the SecurityContext
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		
		Profile updatedProfile = profileService.updateProfile(username, profile);
		
		// If the profile doesn't exist => 404
		if (updatedProfile == null) {
			throw new NoSuchElementException();
		}
		
		return updatedProfile;
		
	}
	
	@RequestMapping(path = "/nickname", method = RequestMethod.GET)
	public String getNickname(@PathParam(value = "username") String username) {

		String nickname = profileService.getNickname(username);
		
		// If the profile doesn't exist => 404
		if (nickname == null) {
			throw new NoSuchElementException();
		}
		
		return nickname;
	}

}
