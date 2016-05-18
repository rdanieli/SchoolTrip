package com.eng.framework.bd;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PropertiesControl {
	
	@Column(name="ctrl_date_add")
	private Date dateAdd;
	
	@Column(name="ctrl_date_up")
	private Date dateUpdate;

	@Column(name="ctrl_user_add")
	private String userAdd;

	@Column(name="ctrl_user_up")
	private String userUpdate;

	@Column(name="ctrl_last_ip")
	private String lastIp;

	public Date getDateAdd() {
		return dateAdd;
	}

	public void setDateAdd(Date dateAdd) {
		this.dateAdd = dateAdd;
	}

	public Date getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
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
