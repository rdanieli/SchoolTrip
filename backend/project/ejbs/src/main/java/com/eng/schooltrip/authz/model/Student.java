package com.eng.schooltrip.authz.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student extends BaseClient implements Serializable  {
	
	private List<Addresses> addresses;
}
