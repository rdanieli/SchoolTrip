package com.eng.schooltrip.dao.impl;

import javax.inject.Named;

import com.eng.schooltrip.authz.model.Client;
import com.eng.schooltrip.dao.ClientDAO;

@Named
public class ClientDAOImpl extends GenericDaoImpl<Client, Long> implements ClientDAO {
	
}
