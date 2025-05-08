package com.onndoo.ws.sec;

import java.util.Collections;
import java.util.HashSet;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.security.enterprise.credential.Credential;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.IdentityStore;
import static jakarta.security.enterprise.identitystore.CredentialValidationResult.INVALID_RESULT;

@ApplicationScoped
public class InMemoryIdentityStore implements IdentityStore {

	@Override
	public int priority() {
		return 10;
	}

	@Override
	public CredentialValidationResult validate(Credential credential) {

		if (!(credential instanceof UsernamePasswordCredential)) {
			return INVALID_RESULT;
		}

		final UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;
		if (usernamePasswordCredential.compareTo("admin", "1234")) {
			return new CredentialValidationResult("admin", new HashSet<>(Collections.singletonList("USER")));
		}

		if (usernamePasswordCredential.compareTo("iron", "man")) {
			return new CredentialValidationResult("iron", new HashSet<>(Collections.singletonList("avengers")));
		}

		return INVALID_RESULT;
	}

}
