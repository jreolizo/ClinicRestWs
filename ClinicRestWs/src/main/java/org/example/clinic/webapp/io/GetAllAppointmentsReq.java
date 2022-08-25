package org.example.clinic.webapp.io;

import java.io.Serializable;

import lombok.Data;

@Data
public class GetAllAppointmentsReq implements Serializable  {

	private static final long serialVersionUID = 2126873381950673274L;
	
	private long id;
}