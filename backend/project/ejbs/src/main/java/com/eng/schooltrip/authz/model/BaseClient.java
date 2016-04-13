package com.eng.schooltrip.authz.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BaseClient implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Long idClient;
	
	@Column
	@NotNull
	private String name;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Calendar birth;
	
	@Column
	private String email;
	
	@Column
	private Long document;
	
	@Column
	@Lob
	@Basic(fetch=FetchType.LAZY)
	private byte[] avatar;
	
	@Column
	private Long phone;
	
	@Embedded
	PropertiesControl propertiesControl;

	@OneToMany
	private List<UserPermission> permissions;
	
	/**
	 * @return the idClient
	 */
	public Long getIdClient() {
		return idClient;
	}

	/**
	 * @param idClient the idClient to set
	 */
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the birth
	 */
	public Calendar getBirth() {
		return birth;
	}

	/**
	 * @param birth the birth to set
	 */
	public void setBirth(Calendar birth) {
		this.birth = birth;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the document
	 */
	public Long getDocument() {
		return document;
	}

	/**
	 * @param document the document to set
	 */
	public void setDocument(Long document) {
		this.document = document;
	}

	/**
	 * @return the avatar
	 */
	public byte[] getAvatar() {
		return avatar;
	}

	/**
	 * @param avatar the avatar to set
	 */
	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

	/**
	 * @return the phone
	 */
	public Long getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(Long phone) {
		this.phone = phone;
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

	/**
	 * @return the permissions
	 */
	public List<UserPermission> getPermissions() {
		return permissions;
	}

	/**
	 * @param permissions the permissions to set
	 */
	public void setPermissions(List<UserPermission> permissions) {
		this.permissions = permissions;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BaseClient [idClient=" + idClient + ", name=" + name + ", birth=" + birth + ", email=" + email + ", document=" + document + ", avatar=" + Arrays.toString(avatar) + ", phone=" + phone + ", propertiesControl=" + propertiesControl + ", permissions=" + permissions + "]";
	}
	
}
