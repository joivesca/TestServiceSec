package com.onndoo.ws;

import jakarta.annotation.security.RolesAllowed;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;

@WebService
@BasicAuthenticationMechanismDefinition(realmName = "CalculatorWSRealm")
public class CalculatorWSImpl implements CalculatorWS{

	@WebMethod
	@RolesAllowed("USER")
	public int add(int num1, int num2) {
		return num1 + num2;
	}

}
