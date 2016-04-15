package com.eng.schooltrip.business.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.eng.schooltrip.authz.BasicAuthCredentials;
import com.eng.schooltrip.authz.model.Client;
import com.eng.schooltrip.dao.ClientDAO;

@Named
public class ClientBusinessImpl implements SimpleCRUD<Client, Long>{
	
	@Inject
	private ClientDAO clientDAO;


	@Override
	public void create(Client newInstance) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public Client read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void update(Client transientObject) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void delete(Client persistentObject) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<Client> find(Client seachEntity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Client checkClientCredentials(BasicAuthCredentials authCredentials){
		Client searchClient = new Client();
		searchClient.setEmail(authCredentials.getUsername());
		searchClient.setPassword(authCredentials.getPassword());
		
		List<Client> clients = clientDAO.find(searchClient);
		
		if(clients != null && !clients.isEmpty()) {
			return clients.get(0);
		}
		
		return null;
	}
	
	/**
	 * @param clientDAO the clientDAO to set
	 */
	public void setClientDAO(ClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}
}
