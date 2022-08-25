package org.example.clinic.webapp.io;

import org.example.clinic.webapp.model.Appointment;

import lombok.Data;

@Data
public class UpdateAppointmentStatusByIdResp {

	private boolean success;

	private Appointment output;
	
	public UpdateAppointmentStatusByIdResp() {
		this.success = false;
		this.output = null;
	}
	
	public UpdateAppointmentStatusByIdResp(boolean success, Appointment output) {
		this.success = success;
		this.output = output;
	}
}