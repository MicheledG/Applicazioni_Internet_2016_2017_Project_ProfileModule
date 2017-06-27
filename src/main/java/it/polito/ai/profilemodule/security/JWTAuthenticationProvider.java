package it.polito.ai.profilemodule.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import it.polito.ai.profilemodule.exception.JWTAuthenticationException;

@Component
public class JWTAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private JWTRemoteService jwtService;

	@Override
	public Authentication authenticate(Authentication tokenAuthentication) throws AuthenticationException {
				
		Authentication userAuthentication;
		
		try {
			userAuthentication = jwtService.getRemoteAuthentication((String)tokenAuthentication.getCredentials());
		} catch(Exception e) {
			throw new JWTAuthenticationException("Token verification failed", e);
		}
				
		return userAuthentication;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
