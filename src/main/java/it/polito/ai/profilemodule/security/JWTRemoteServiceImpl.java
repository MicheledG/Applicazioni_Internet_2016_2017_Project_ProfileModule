package it.polito.ai.profilemodule.security;

import static java.util.Collections.emptyList;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JWTRemoteServiceImpl implements JWTRemoteService {
	
	private static final String REMOTE_AUTHENTICATION_ENDPOINT = "http://localhost:8081/authenticate";
	
	@Override
	public Authentication getRemoteAuthentication(String token) {
		
		//query the remote /authentication endpoint
		//1) create the request body
		Map<String, String> requestBody = new HashMap<>();
		requestBody.put("token", token);
		
		//2) send the request
		RestTemplate restTemplate = new RestTemplate();
		RemoteAuthentication remoteAuthentication;
		try {
			remoteAuthentication = restTemplate.postForObject(
					REMOTE_AUTHENTICATION_ENDPOINT,
					requestBody,
					RemoteAuthentication.class);
			
		} catch (Exception e) {
			//no authentication obtained
			//TODO: debug!
			System.err.println(e.getMessage());
			return null;
		}
		
		//3) create the UserPasswordAuthenticationToken with the authentication remotely obtained
		String username = remoteAuthentication.getUsername();
		
		if(username == null){
			//no correct authentication obtained
			return null;
		}
		
		Authentication userAuthentication = new UsernamePasswordAuthenticationToken(username, token, emptyList());
		
		return userAuthentication;

	}
}
