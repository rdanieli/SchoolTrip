package com.eng.schooltrip.authz.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class PropertiesControl {
	
	@Column
	@Temporal(TemporalType.TIME)
	private Calendar dateAdd;
	
	@Column
	@Temporal(TemporalType.TIME)
	private Calendar dateUpdate;

	@Column
	private String userAdd;

	@Column
	private String userUpdate;

	@Column
	private String lastIp;

	/**
	 * @return the dateAdd
	 */
	public Calendar getDateAdd() {
		return dateAdd;
	}

	/**
	 * @param dateAdd the dateAdd to set
	 */
	public void setDateAdd(Calendar dateAdd) {
		this.dateAdd = dateAdd;
	}

	/**
	 * @return the dateUpdate
	 */
	public Calendar getDateUpdate() {
		return dateUpdate;
	}

	/**
	 * @param dateUpdate the dateUpdate to set
	 */
	public void setDateUpdate(Calendar dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	/**
	 * @return the userAdd
	 */
	public String getUserAdd() {
		return userAdd;
	}

	/**
	 * @param userAdd the userAdd to set
	 */
	public void setUserAdd(String userAdd) {
		this.userAdd = userAdd;
	}

	/**
	 * @return the userUpdate
	 */
	public String getUserUpdate() {
		return userUpdate;
	}

	/**
	 * @param userUpdate the userUpdate to set
	 */
	public void setUserUpdate(String userUpdate) {
		this.userUpdate = userUpdate;
	}

	/**
	 * @return the lastIp
	 */
	public String getLastIp() {
		return lastIp;
	}

	/**
	 * @param lastIp the lastIp to set
	 */
	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}
}
