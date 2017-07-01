package it.polito.ai.profile.exception;

import static java.lang.String.format;

public class ProfileCreationConflict extends Exception {

	private static final long serialVersionUID = 1513348982774618142L;

	public ProfileCreationConflict(String username) {
        super(format("Conflict, profile with username %s already exists.", username));
    }
	
}
