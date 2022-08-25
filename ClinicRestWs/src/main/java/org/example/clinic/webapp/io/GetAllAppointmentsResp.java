package org.example.clinic.webapp.io;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import org.example.clinic.webapp.model.Appointment;

@Data
public class GetAllAppointmentsResp implements Serializable  {

	private static final long serialVersionUID = 2126873381950673274L;
	
	private boolean success;
	
	private int count;

	private List<Appointment> output;
	
	public GetAllAppointmentsResp() {
		this.success = false;
		this.count = 0;
		this.output = null;
	}
	
	public GetAllAppointmentsResp(boolean success, List<Appointment> output) {
		this.success = success;
		this.count = output.size();
		this.output = output;
	}

}