package com.eng.schooltrip.manager;

import java.sql.Date;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.eng.schooltrip.authz.BasicAuthCredentials;
import com.eng.schooltrip.authz.model.Client;
import com.eng.schooltrip.authz.model.Token;
import com.eng.schooltrip.business.impl.ClientBusinessImpl;
import com.eng.schooltrip.infra.RNException;
import com.eng.schooltrip.security.SecurityTokenGeneration;

@Stateless
public class AuthorizationBean {
	
	@Inject
	private ClientBusinessImpl clientBusiness;
	
	public Token login(BasicAuthCredentials credentials) throws RNException, EJBException{
		try {
			Client c = clientBusiness.checkClientCredentials(credentials);
			
			Token token = null;
			if(c != null){
				token = new Token();
				token.setCreationDate(new Date(System.currentTimeMillis()));
				token.setClient(c);
				token.setToken(SecurityTokenGeneration.generateToken());
			}
			
			return token;
		} catch (RNException | EJBException e) {
			throw new RNException(e.getMessage());
		}
	}

	/**
	 * @param clientBusiness the clientBusiness to set
	 */
	public void setClientBusiness(ClientBusinessImpl clientBusiness) {
		this.clientBusiness = clientBusiness;
	}
}
