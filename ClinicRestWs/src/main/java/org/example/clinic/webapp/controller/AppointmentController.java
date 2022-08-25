package org.example.clinic.webapp.controller;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.clinic.webapp.io.DeleteAppointmentByIdReq;
import org.example.clinic.webapp.io.DeleteAppointmentByIdResp;
import org.example.clinic.webapp.io.GetAllAppointmentsResp;
import org.example.clinic.webapp.io.GetAppointmentByIdReq;
import org.example.clinic.webapp.io.GetAppointmentByIdResp;
import org.example.clinic.webapp.io.RequestAppointmentReq;
import org.example.clinic.webapp.io.RequestAppointmentResp;
import org.example.clinic.webapp.io.UpdateAppointmentStatusByIdReq;
import org.example.clinic.webapp.io.UpdateAppointmentStatusByIdResp;
import org.example.clinic.webapp.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
* This class will receive all incoming request, 
* based on the configuration, then reply is send after processing it.
* 
* <ul>
* <li>{@literal @}RestController indicates that the data returned by each method 
*     will be written straight into the response body instead of rendering a template.
* <li>{@literal @}RequestMapping  is used to map web requests to Spring Controller methods
* </ul>
* 
* @author      https://github.com/jreolizo
* @version     %I%, %G%
* @since       1.0
*/
@RestController
public class AppointmentController {
	private static final Logger LOGGER = LogManager.getLogger(AppointmentController.class);  
	
	@Autowired
	AppointmentService appService;
	
	/**
	* Request to get list of all appointments.
	* 
	* Request: Get All Appointment
	*   Endpoint: "/getAllAppointments"
	*   Method:   GET
	* Response: GetAllAppointmentsResp object (JSON)
	*
	* @param text  the string to display.  If the text is null, 
	*              the tool tip is turned off for this component.
	*/
	@RequestMapping(value = "/getAllAppointments", method = RequestMethod.GET)
	public GetAllAppointmentsResp getAllAppointments() {
		LOGGER.info("Received: getAllAppointments");
        GetAllAppointmentsResp resp = appService.getAllAppointments();
        
        LOGGER.info("Reply: getAllAppointments");
        return resp;
    }
	
	/**
	* Request to get appointment description based on id.
	* 
	* Request: Get Appointment By Id
	*   Endpoint: "/getAppointmentById"
	*   Method:   GET
	* Response: GetAllAppointmentsResp object (JSON)
	*
	* @param id    requested appointment number.  
	*              Parameter included on query parameter.
	*              ex. ...//getAppointmentById?id=1
	*/
    @RequestMapping(value = "/getAppointmentById", method = RequestMethod.GET)
    public GetAppointmentByIdResp getAppointmentById(@RequestParam("id") Long id) {
    	LOGGER.info("Received: getAppointmentById");
    	GetAppointmentByIdReq req = new GetAppointmentByIdReq(id);
    	GetAppointmentByIdResp resp = appService.getAppointmentById(req);
    	
    	LOGGER.info("Reply: getAppointmentById");
    	return resp;
    }
    
	/**
	* Request to an appointment to log.
	* 
	* Request: Get Appointment By Id
	*   Endpoint: "/requestAppointment"
	*   Method:   POST
	* Response: GetAllAppointmentsResp object (JSON)
	*
	* @param id    requested appointment number.  
	*              Parameter included on query parameter.
	*              ex. ...//getAppointmentById?id=1
	*/
    @RequestMapping(value = "/requestAppointment", method = RequestMethod.POST)
     public RequestAppointmentResp requestAppointment(@RequestBody RequestAppointmentReq req) {
    	LOGGER.info("Received: requestAppointment");
    	RequestAppointmentResp resp = appService.requestAppointment(req);
    	
    	LOGGER.info("Reply: requestAppointment");
        return resp;
    }
    
    /**
	* Request to get appointment description based on id.
	* 
	* Request: Get Appointment By Id
	*   Endpoint: "/getAppointmentById"
	*   Method:   POST
	* Response: GetAllAppointmentsResp object (JSON)
	*
	* @param id    requested appointment number.  
	*              Parameter included on query parameter.
	*              ex. ...//getAppointmentById?id=1
	*/
    @RequestMapping(value = "/updateAppointmentStatusById", method = RequestMethod.POST)
    public UpdateAppointmentStatusByIdResp updateAppointmentStatusById(@RequestParam Map<String,String> requestParams) throws Exception {
    	LOGGER.info("Received: updateAppointmentStatusById");
    	if(requestParams.containsKey("id") && requestParams.containsKey("status")) {
    		UpdateAppointmentStatusByIdReq req = new UpdateAppointmentStatusByIdReq();
    		req.setId(Integer.parseInt(requestParams.get("id")));
    		req.setStat(Character.toLowerCase(requestParams.get("status").charAt(0)));
        	
        	UpdateAppointmentStatusByIdResp resp = appService.updateAppointmentStatusById(req);
            
        	LOGGER.info("Reply: updateAppointmentStatusById");
        	return resp;
    	} else {
    		UpdateAppointmentStatusByIdResp resp = new UpdateAppointmentStatusByIdResp(false, null);

    		LOGGER.info("Reply: updateAppointmentStatusById");
    		return resp;
    	}
    }
    
    /**
	* Delete an appointment description based on id.
	* 
	* Request: Delete Appointment By Id
	*   Endpoint: "/deleteAppointmentById"
	*   Method:   POST
	* Response: DeleteAppointmentByIdResp object (JSON)
	*
	* @param id    appointment number.  
	*              Parameter included on query parameter.
	*              ex. ...//deleteAppointmentById?id=1
	*/
    @RequestMapping(value = "/deleteAppointmentById", method = RequestMethod.POST)
    public DeleteAppointmentByIdResp deleteAppointmentById(@RequestParam("id") Long id) {
    	LOGGER.info("Received: deleteAppointmentById");
    	DeleteAppointmentByIdReq req = new DeleteAppointmentByIdReq(id);
    	
    	DeleteAppointmentByIdResp resp = appService.deleteAppointmentById(req);
        
    	LOGGER.info("Reply: updateAppointmentStatusById");
    	return resp;
    }
}
