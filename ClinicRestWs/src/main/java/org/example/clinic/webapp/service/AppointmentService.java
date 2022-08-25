package org.example.clinic.webapp.service;

import org.example.clinic.webapp.dao.AppointmentDAO;
import org.example.clinic.webapp.io.DeleteAppointmentByIdReq;
import org.example.clinic.webapp.io.DeleteAppointmentByIdResp;
import org.example.clinic.webapp.io.GetAllAppointmentsResp;
import org.example.clinic.webapp.io.GetAppointmentByIdReq;
import org.example.clinic.webapp.io.GetAppointmentByIdResp;
import org.example.clinic.webapp.io.RequestAppointmentReq;
import org.example.clinic.webapp.io.RequestAppointmentResp;
import org.example.clinic.webapp.io.UpdateAppointmentStatusByIdReq;
import org.example.clinic.webapp.io.UpdateAppointmentStatusByIdResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* (Business Logic) The main function of the program
* If there is no need for Database (Spring AOP),
* Transactional annotation should not be present.
* Otherwise, connection to DAO class is needed.
* 
* @author      https://github.com/jreolizo
* @version     %I%, %G%
* @since       1.0
*/
@Service("appointmentService")
public class AppointmentService {
	
    @Autowired
    AppointmentDAO appDAO;
    
    @Transactional
	public GetAllAppointmentsResp getAllAppointments() {
		return appDAO.getAllAppointments();
	}

    @Transactional
	public GetAppointmentByIdResp getAppointmentById(GetAppointmentByIdReq req) {
    	return appDAO.getAppointmentById(req);
	}

    @Transactional
	public RequestAppointmentResp requestAppointment(RequestAppointmentReq req) {
		return appDAO.requestAppointment(req);
	}

    @Transactional
	public UpdateAppointmentStatusByIdResp updateAppointmentStatusById(UpdateAppointmentStatusByIdReq req) {
		return appDAO.updateAppointmentStatusById(req);
	}

    @Transactional
	public DeleteAppointmentByIdResp deleteAppointmentById(DeleteAppointmentByIdReq req) {
		return appDAO.deleteAppointmentById(req);
	} 
}
