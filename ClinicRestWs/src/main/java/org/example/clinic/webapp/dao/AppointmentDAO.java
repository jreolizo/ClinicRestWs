package org.example.clinic.webapp.dao;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.clinic.webapp.dao.interfaces.AppointmentDAOInterface;
import org.example.clinic.webapp.io.*;
import org.example.clinic.webapp.model.Appointment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
* (Data Access Object) 
* Database manipulation is done here.
* Persistence is already initiated at Service class.
* 
* @author      https://github.com/jreolizo
* @version     %I%, %G%
* @since       1.0
*/
@Repository
public class AppointmentDAO implements AppointmentDAOInterface {
	List<Character> statusList = Arrays.asList('p','c','r','d');
	
	private static final Logger LOGGER = LogManager.getLogger(AppointmentDAO.class);  
	
    @Autowired
    private SessionFactory sessionFactory;
 
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

	@Override
	public GetAllAppointmentsResp getAllAppointments() {
		LOGGER.debug("GetAllAppointmentsResp START");
		Session session = this.sessionFactory.getCurrentSession();
		LOGGER.info("GetAllAppointmentsResp: createQuery");
        List appList = session.createQuery("from Appointment").list();
        
        GetAllAppointmentsResp resp = new GetAllAppointmentsResp(true, appList);
        LOGGER.debug("GetAllAppointmentsResp END");
        return resp;
	}

	@Override
	public GetAppointmentByIdResp getAppointmentById(GetAppointmentByIdReq req) {
		LOGGER.debug("GetAppointmentByIdResp START");
		Session session = this.sessionFactory.getCurrentSession();
		LOGGER.info("GetAppointmentByIdResp: session.get");
        Appointment appoint = (Appointment) session.get(Appointment.class, req.getId());
        
        GetAppointmentByIdResp resp = new GetAppointmentByIdResp(true, appoint);
        LOGGER.debug("GetAppointmentByIdResp END");
		return resp;
	}

	@Override
	public RequestAppointmentResp requestAppointment(RequestAppointmentReq req) {
		LOGGER.debug("RequestAppointmentResp START");
		Session session = this.sessionFactory.getCurrentSession();
		Appointment appoint = new Appointment(req.getName(), req.getPhone(), req.getAdate(), req.getAtime());
		
		LOGGER.info("RequestAppointmentResp: session.persist");
        session.persist(appoint);
        
        RequestAppointmentResp resp = new RequestAppointmentResp(true, appoint);
        LOGGER.debug("RequestAppointmentResp END");
        return resp;
	}

	@Override
	public UpdateAppointmentStatusByIdResp updateAppointmentStatusById(UpdateAppointmentStatusByIdReq req) {
		LOGGER.debug("UpdateAppointmentStatusByIdResp START");
		Session session = this.sessionFactory.getCurrentSession();
		LOGGER.info("UpdateAppointmentStatusByIdResp: session.get");
        Appointment appoint = (Appointment) session.get(Appointment.class, req.getId());
        if (!statusList.contains(req.getStat())) {
        	appoint = null;
        }
        
        boolean success = false;
        
        if (null != appoint) {
        	success = true;
        	appoint.setStatus(req.getStat());
        	
        	session.update(appoint);
        }
        
        UpdateAppointmentStatusByIdResp resp = new UpdateAppointmentStatusByIdResp(success, appoint);
        LOGGER.debug("UpdateAppointmentStatusByIdResp END");

        return resp;
	}

	@Override
	public DeleteAppointmentByIdResp deleteAppointmentById(DeleteAppointmentByIdReq req) {
		LOGGER.debug("DeleteAppointmentByIdResp START");
        Session session = this.sessionFactory.getCurrentSession();
        LOGGER.info("DeleteAppointmentByIdResp: session.get");
        Appointment appoint = (Appointment) session.get(Appointment.class, req.getId());
        
        boolean success = false;
        
        if (null != appoint) {
        	success = true;
        	//session.delete(p);
        	appoint.setStatus('d');
        	
        	session.update(appoint);
        }
        
        DeleteAppointmentByIdResp resp = new DeleteAppointmentByIdResp(success, appoint);
        LOGGER.debug("DeleteAppointmentByIdResp END");
        
        return resp;
	}
  
    
}
