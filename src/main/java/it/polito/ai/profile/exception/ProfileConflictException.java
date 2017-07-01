package it.polito.ai.profile.exception;

import static java.lang.String.format;

public class ProfileConflictException extends Exception {

	private static final long serialVersionUID = 1513348982774618142L;

	public ProfileConflictException(String username) {
        super(format("Conflict, profile with username %s already exists.", username));
    }
	
}
