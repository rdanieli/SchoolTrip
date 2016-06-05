package com.eng.framework.authz.model;

import java.io.Serializable;

import javax.persistence.Embedded;

import com.eng.framework.bd.PropertiesControl;

public class BaseDAO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Embedded
	private PropertiesControl propertiesControl;

	public PropertiesControl getPropertiesControl() {
		return propertiesControl;
	}

	public void setPropertiesControl(PropertiesControl propertiesControl) {
		this.propertiesControl = propertiesControl;
	}
}
