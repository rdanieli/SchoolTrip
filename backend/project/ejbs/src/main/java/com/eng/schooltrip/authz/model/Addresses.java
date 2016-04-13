package com.eng.schooltrip.authz.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="addresses")
public class Addresses implements Serializable {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Long ref_student;
	
	@Column
	private Long ref_university;
	
	@Column
	private Long sequence;
	
	@Column
	private String street;
	
	@Column
	private String neighborhood;
	
	@Column String number;
	
	
}
