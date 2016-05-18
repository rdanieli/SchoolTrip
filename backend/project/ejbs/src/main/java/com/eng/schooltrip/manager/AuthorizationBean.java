package com.eng.schooltrip.manager;

import java.sql.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.eng.framework.authz.BasicAuthCredentials;
import com.eng.framework.authz.model.Client;
import com.eng.framework.authz.model.Token;
import com.eng.framework.business.impl.ClientRN;
import com.eng.framework.infra.RNException;
import com.eng.framework.security.SecurityTokenGeneration;

@Stateless
public class AuthorizationBean {
	
	@PersistenceContext
	EntityManager entityManager;

	@Inject
	private ClientRN clientRN;
	
	@PostConstruct
	public void init(){
		clientRN.setEntityManager(entityManager);
	}
	
	public Token login(BasicAuthCredentials credentials) throws RNException, EJBException{
		try {
			Client c = clientRN.checkClientCredentials(credentials);
			
			Token token = null;
			if(c != null){
				token = new Token();
				token.setCreationDate(new Date(System.currentTimeMillis()));
				token.setClient(c);
				token.setToken(SecurityTokenGeneration.generateToken());
				
				//persistir o token
			}
			
			return token;
		} catch (RNException | EJBException e) {
			throw new RNException(e.getMessage());
		}
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
