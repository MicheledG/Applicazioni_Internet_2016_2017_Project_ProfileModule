package it.polito.ai.profile.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import it.polito.ai.profile.security.JWTAuthenticationEntryPoint;
import it.polito.ai.profile.security.JWTAuthenticationFilter;
import it.polito.ai.profile.security.JWTAuthenticationProvider;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private JWTAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	@Autowired
	private JWTAuthenticationFilter jwtAuthenticationFilter;
	
	@Autowired
    private JWTAuthenticationProvider jwtAuthenticationProvider;
	
	@Override
    public void configure(AuthenticationManagerBuilder auth)  throws Exception {
		// Define a custom authentication provider
        auth.authenticationProvider(jwtAuthenticationProvider);
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			// Disable CSRF protection since tokens are immune to it
			.csrf().disable()
			// If the user is not authenticated, returns 401
			.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and()
			// This is a stateless application, disable sessions
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			// Security policy
			.authorizeRequests()
				// Allow anonymous access for creating a new profile (from AuthModule)
				// TODO add authentication between microservices
				.antMatchers(HttpMethod.POST,"/profile").permitAll()
				// Allow anonymous access to "/profile/nickname" (only POST requests)
				.antMatchers(HttpMethod.GET,"/profile/nickname").permitAll()
				// Excepted for CORS preflighted requests
				.antMatchers(HttpMethod.OPTIONS).permitAll()
				// Any request must be authenticated
				.anyRequest().authenticated().and()
			// Custom filter for authenticating users using tokens
			.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
			// Disable resource caching
			.headers().cacheControl();
	}	

}
