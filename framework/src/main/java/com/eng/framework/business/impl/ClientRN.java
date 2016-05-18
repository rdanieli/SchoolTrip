package com.eng.framework.business.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.eng.framework.authz.BasicAuthCredentials;
import com.eng.framework.authz.model.Client;
import com.eng.framework.dao.impl.ClientDAOImpl;
import com.eng.framework.infra.RNException;

@Named
public class ClientRN implements FrameworkCRUD<Client, Long>{
	
	@Inject
	private ClientDAOImpl clientDAO;
	
	@Override
	public void create(Client newInstance) {
	}

	@Override
	public Client read(Long id) {
		return clientDAO.read(id);
	}

	@Override
	public void update(Client transientObject) {
	}

	@Override
	public void delete(Client persistentObject) {
	}
	
	@Override
	public List<Client> find(Client seachEntity) {
		return null;
	}
	
	public Client checkClientCredentials(BasicAuthCredentials authCredentials) throws RNException{
		Client searchClient = new Client();
		searchClient.setEmail(authCredentials.getUsername());
		searchClient.setPassword(authCredentials.getPassword());
		
		Client client = clientDAO.findUnique(searchClient);
		
		if(client == null){
			throw new RNException("User not found");
		}
		
		return client;
	}

	public ClientDAOImpl getClientDAO() {
		return clientDAO;
	}

	public void setClientDAO(ClientDAOImpl clientDAO) {
		this.clientDAO = clientDAO;
	}
	
	public void setEntityManager(EntityManager entityManager ){
		clientDAO.setEntityManager(entityManager);
	}
}
