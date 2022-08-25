package org.example.clinic.webapp.model;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@Table(name = "appointment")
//@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Appointment implements Serializable  {

	private static final long serialVersionUID = 8931229173944252L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long appId;

	@Column(name = "name")
	public String name;

	@Column(name = "phone")
	public String phone;

	@Column(name = "adate")
	public String adate;

	@Column(name = "atime")
	public String atime;

	@Column(name = "status")
	public char status;
	
	public Appointment() {
	   super();
	}
	
	public Appointment(String name, String phone, String adate, String atime) {
		this.name = name;
		this.phone = phone;
		this.adate = adate;
		this.atime = atime;
		this.status = 'p';
	}
}