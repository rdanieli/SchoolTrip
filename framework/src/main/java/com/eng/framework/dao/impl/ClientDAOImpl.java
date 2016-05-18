package com.eng.framework.dao.impl;

import javax.inject.Named;

import com.eng.framework.authz.model.Client;
import com.eng.framework.dao.ClientDAO;

@Named
public class ClientDAOImpl extends FrameworkDAOImpl<Client, Long> implements ClientDAO {
}
