package com.eng.schooltrip.manager;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.eng.schooltrip.authz.BasicAuthCredentials;
import com.eng.schooltrip.authz.model.Token;

@Stateless
public class AuthorizationBean {
	
//	@Inject
//	private AuthorizationDB authorizationDB;
//	
//	public Token login(BasicAuthCredentials credentials){
//		return null;
//	}
//	
//	/**
//	 * @param authorizationDB the authorizationDB to set
//	 */
//	public void setAuthorizationDB(AuthorizationDB authorizationDB) {
//		this.authorizationDB = authorizationDB;
//	}
}
