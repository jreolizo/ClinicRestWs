package org.example.clinic.webapp.io;

import java.io.Serializable;

import org.example.clinic.webapp.model.Appointment;

import lombok.Data;

@Data
public class RequestAppointmentResp implements Serializable  {

	private static final long serialVersionUID = 2126873381950673274L;
	
	private boolean success;

	private Appointment output;
	
	public RequestAppointmentResp() {
		this.success = false;
		this.output = null;
	}
	
	public RequestAppointmentResp(boolean success, Appointment output) {
		this.success = success;
		this.output = output;
	}
}