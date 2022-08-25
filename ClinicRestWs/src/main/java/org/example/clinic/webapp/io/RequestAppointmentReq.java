package org.example.clinic.webapp.io;

import java.io.Serializable;

import lombok.Data;

@Data
public class RequestAppointmentReq implements Serializable  {

	private static final long serialVersionUID = 2126873381950673274L;

	private String name;

	private String phone;

	private String adate;

	private String atime;

}