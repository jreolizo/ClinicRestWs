package org.example.clinic.webapp.io;

import java.io.Serializable;

import lombok.Data;

@Data
public class DeleteAppointmentByIdReq implements Serializable  {

	private static final long serialVersionUID = 2126873381950673274L;
	
	private long id;
	
	public DeleteAppointmentByIdReq() {
		this.id = 0;
	}
	
	public DeleteAppointmentByIdReq(long id) {
		this.id = id;
	}
}