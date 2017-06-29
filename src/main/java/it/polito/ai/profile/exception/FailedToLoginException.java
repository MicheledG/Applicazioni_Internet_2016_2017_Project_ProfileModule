package it.polito.ai.profile.exception;

import static java.lang.String.format;

public class FailedToLoginException extends Exception {
	
	private static final long serialVersionUID = -8314456679783572936L;

	public FailedToLoginException(String username) {
        super(format("Failed to login with username %s", username));
    }
	
}
