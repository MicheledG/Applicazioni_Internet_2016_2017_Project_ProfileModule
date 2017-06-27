package it.polito.ai.profilemodule.security;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.security.core.Authentication;

public interface JWTRemoteService {

	/**
	 * The JWTAuthenticationProvider calls this method to verify the user authentication.
	 * If the token is not valid, the authentication fails and the request will be refused.
	 * 
	 * @param token	An authentication token to verify.
	 * @return
	 * @throws URISyntaxException 
	 * @throws IOException 
	 */
	Authentication getRemoteAuthentication(String token) throws IOException, URISyntaxException;

}
