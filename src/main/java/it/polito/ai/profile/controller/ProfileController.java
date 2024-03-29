package it.polito.ai.profile.controller;

import it.polito.ai.profile.exception.ProfileConflictException;
import it.polito.ai.profile.model.Nickname;
import it.polito.ai.profile.model.Profile;
import it.polito.ai.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * RestController for handling profiles:
 * - retrieve information about a profile;
 * - update profile information;
 * - change the password.
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = {"Accept", "Authorization", "Content-Type"})
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
    @ResponseStatus(code = HttpStatus.OK)
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
     * @throws ProfileConflictException
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createProfile(@RequestBody Map<String, String> requestBody) throws ProfileConflictException {

        String username = requestBody.get("username");
        String nickname = requestBody.get("nickname");

        Profile profile = new Profile(username, nickname);

        // If there is already a profile with the same username => 409
        if (!profileService.createProfile(profile)) {
            throw new ProfileConflictException(profile.getUsername());
        }

    }

    /**
     * Update the profile of the authenticated user.
     *
     * @param profile
     * @throws ProfileConflictException
     */
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(code = HttpStatus.OK)
    public Profile updateProfile(@Validated @RequestBody Profile profile) throws ProfileConflictException {

        // If the profile fails validation => 400

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

    /**
     * Get the nickname associated with the username passed as a query parameter.
     *
     * @param username
     * @return
     */
    @RequestMapping(path = "/nickname", method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK)
    public String getNickname(@PathParam(value = "username") String username) {

        String nickname = profileService.getNickname(username);

        // If the profile doesn't exist => 404
        if (nickname == null) {
            throw new NoSuchElementException();
        }

        return nickname;
    }
    
    /**
     * Get the nickname of the current authenticated user.
     *
     * @param username
     * @return
     */
    @RequestMapping(path = "/nick", method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK)
    public Nickname getNickname() {
    	
    	// Get the username of the authenticated user from the SecurityContext
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        // Get the nickname associated to the given username
        String nickname = profileService.getNickname(username);

        // If the profile doesn't exist => 404
        if (nickname == null) {
            throw new NoSuchElementException();
        }

        return new Nickname(nickname);
    }

}
