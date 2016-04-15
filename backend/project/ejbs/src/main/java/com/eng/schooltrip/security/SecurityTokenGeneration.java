package com.eng.schooltrip.security;

import java.util.UUID;

public class SecurityTokenGeneration {
	
	public static String generateToken(){
		return UUID.randomUUID().toString();
	}
}
