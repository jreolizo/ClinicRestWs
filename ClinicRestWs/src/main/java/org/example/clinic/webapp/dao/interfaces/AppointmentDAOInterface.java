	package org.example.clinic.webapp.dao.interfaces;

import org.example.clinic.webapp.io.*;

public interface AppointmentDAOInterface {
	GetAllAppointmentsResp getAllAppointments();
	GetAppointmentByIdResp getAppointmentById(GetAppointmentByIdReq req);
	RequestAppointmentResp requestAppointment(RequestAppointmentReq req);
	UpdateAppointmentStatusByIdResp updateAppointmentStatusById(UpdateAppointmentStatusByIdReq req);
	DeleteAppointmentByIdResp deleteAppointmentById(DeleteAppointmentByIdReq req);
}
