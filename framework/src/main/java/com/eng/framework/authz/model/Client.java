package com.eng.framework.authz.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Arrays;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.eng.framework.bd.PropertiesControl;

//+---------------+--------------+------+-----+---------+-------+
//| Field         | Type         | Null | Key | Default | Extra |
//+---------------+--------------+------+-----+---------+-------+
//| id            | int(11)      | NO   | PRI | NULL    |       |
//| name          | varchar(66)  | YES  |     | NULL    |       |
//| date_birth    | date         | YES  |     | NULL    |       |
//| email         | varchar(100) | YES  |     | NULL    |       |
//| document      | int(15)      | YES  |     | NULL    |       |
//| avatar        | blob         | YES  |     | NULL    |       |
//| phone         | int(15)      | YES  |     | NULL    |       |
//| secret        | varchar(250) | YES  |     | NULL    |       |
//| ctrl_date_add | date         | YES  |     | NULL    |       |
//| ctrl_date_up  | date         | YES  |     | NULL    |       |
//| ctrl_user_add | varchar(80)  | YES  |     | NULL    |       |
//| ctrl_user_up  | varchar(80)  | YES  |     | NULL    |       |
//| ctrl_last_ip  | varchar(80)  | YES  |     | NULL    |       |
//+---------------+--------------+------+-----+---------+-------+

@Entity
@Table(name="CORE_CLIENTS")
public class Client implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id")
	private Long idClient;
	
	@NotNull
	@Column(name="name")
	private String name;
	
	@Column(name="date_birth")
	private Date birth;
	
	@Column(name="email") 
	private String email;
	
	@Column(name="document")  
	private Long document;
	
	@Column(name="avatar")
	@Lob
	@Basic(fetch=FetchType.LAZY)
	private byte[] avatar;
	
	@Column(name="phone")  
	private Long phone;
	
	@Column(name="secret")
	private String password;
	
	@Embedded
	PropertiesControl propertiesControl;
	
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

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(avatar);
		result = prime * result + ((birth == null) ? 0 : birth.hashCode());
		result = prime * result + ((document == null) ? 0 : document.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((idClient == null) ? 0 : idClient.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((propertiesControl == null) ? 0 : propertiesControl.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (!Arrays.equals(avatar, other.avatar))
			return false;
		if (birth == null) {
			if (other.birth != null)
				return false;
		} else if (!birth.equals(other.birth))
			return false;
		if (document == null) {
			if (other.document != null)
				return false;
		} else if (!document.equals(other.document))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idClient == null) {
			if (other.idClient != null)
				return false;
		} else if (!idClient.equals(other.idClient))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (propertiesControl == null) {
			if (other.propertiesControl != null)
				return false;
		} else if (!propertiesControl.equals(other.propertiesControl))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", name=" + name + ", birth=" + birth + ", email=" + email
				+ ", document=" + document + ", avatar=" + Arrays.toString(avatar) + ", phone=" + phone + ", password="
				+ password + ", propertiesControl=" + propertiesControl + "]";
	}
}
