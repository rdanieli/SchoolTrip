package com.eng.schooltrip.authz.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonProperty;

@Entity
@Table(name="client_tokens")
public class Token implements Serializable {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@OneToOne
	@JoinColumn(name="client_id")
	private Client client;
	
	@Column(name="token")
	@JsonProperty("access_token")
	public String token;
	
	@Column(name="creation")
	@JsonProperty("creation_date")
	public Date creationDate;
	
}
