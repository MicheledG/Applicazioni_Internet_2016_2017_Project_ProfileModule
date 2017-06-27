package it.polito.ai.profilemodule.exception;

public class FailedToSignupException extends Exception {
	
	private static final long serialVersionUID = -7142933930424015256L;

	public FailedToSignupException() {
        super("Failed to signup");
    }
	
}
