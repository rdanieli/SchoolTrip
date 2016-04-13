package com.eng.schooltrip.authz.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_auth")
public class UserPermission implements Serializable  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column
	private String permission;
	
	@Embedded
	PropertiesControl propertiesControl;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the permission
	 */
	public String getPermission() {
		return permission;
	}

	/**
	 * @param permission the permission to set
	 */
	public void setPermission(String permission) {
		this.permission = permission;
	}

	/**
	 * @return the propertiesControl
	 */
	public PropertiesControl getPropertiesControl() {
		return propertiesControl;
	}

	/**
	 * @param propertiesControl the propertiesControl to set
	 */
	public void setPropertiesControl(PropertiesControl propertiesControl) {
		this.propertiesControl = propertiesControl;
	}
}
