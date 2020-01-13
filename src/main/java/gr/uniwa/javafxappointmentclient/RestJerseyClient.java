/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.uniwa.javafxappointmentclient;

import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;


/**
 * Jersey REST client generated for REST resource:AppointmentsService
 * [/service]<br>
 * USAGE:
 * <pre>
        RestJerseyClient client = new RestJerseyClient();
        Object response = client.XXX(...);
        // do whatever with response
        client.close();
 </pre>
 *
 * @author evan
 */
public class RestJerseyClient
{

	private WebTarget webTarget;
	private Client client;
	private static final String BASE_URI = "http://localhost:8080/AppointmentManagement/";

	public RestJerseyClient() {
		client = javax.ws.rs.client.ClientBuilder.newClient();
		webTarget = client.target(BASE_URI).path("service");
	}

	public void updateAppointment(Object requestEntity, String id) throws ClientErrorException {
		webTarget.path(java.text.MessageFormat.format("appointment/{0}", new Object[]{id})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
	}

	public List<Appointment> getAllAppointments() throws ClientErrorException {
		GenericType<List<Appointment>> list = new GenericType<List<Appointment>>() {};
		WebTarget resource = webTarget;
		resource = resource.path("appointments");
		return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(list);
	}

	public <T> T getAppointment(Class<T> responseType, String id) throws ClientErrorException {
		WebTarget resource = webTarget;
		resource = resource.path(java.text.MessageFormat.format("appointment/{0}", new Object[]{id}));
		return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
	}

	public void createAppointment(Object requestEntity) throws ClientErrorException {
		webTarget.path("appointments").request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
	}

	public void deleteAppointment(String id) throws ClientErrorException {
		webTarget.path(java.text.MessageFormat.format("appointment/{0}", new Object[]{id})).request().delete();
	}

	public void close() {
		client.close();
	}
	
}
