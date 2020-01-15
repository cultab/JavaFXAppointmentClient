/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.uniwa.javafxappointmentclient;

import java.io.Closeable;
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
 *        RestJerseyClient client = new RestJerseyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author evan
 */
public class RestJerseyClient implements Closeable
{

	private WebTarget webTarget;
	private Client client;
	private static final String BASE_URI = "http://localhost:8080/AppointmentManagement/";

	public RestJerseyClient() {
		client = javax.ws.rs.client.ClientBuilder.newClient();
		webTarget = client.target(BASE_URI).path("service");
	}

	public List<Appointment> getAppointments(String room_id, String doctor_id, String patient_id) throws ClientErrorException {
		WebTarget resource = webTarget;
		if (room_id != null) {
			resource = resource.queryParam("room_id", room_id);
		}
		if (doctor_id != null) {
			resource = resource.queryParam("doctor_id", doctor_id);
		}
		if (patient_id != null) {
			resource = resource.queryParam("patient_id", patient_id);
		}
		resource = resource.path("appointments");
		return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(List.class);
	}

	public List<Appointment> getAllAppointments() throws ClientErrorException {
		var list = new GenericType<List<Appointment>>() {};
		WebTarget resource = webTarget;
		resource = resource.path("appointments");
		return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(list);
	}

	public Appointment getAppointment(int id) throws ClientErrorException {
		WebTarget resource = webTarget;
		resource = resource.path(java.text.MessageFormat.format("appointment/{0}", new Object[]{id}));
		return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(Appointment.class);
	}

	public void createSpeciality(Object requestEntity) throws ClientErrorException {
		webTarget.path("specialities").request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
	}

	public List<Doctor> getAllDoctors() throws ClientErrorException {
		var list = new GenericType<List<Doctor>>() {};
		WebTarget resource = webTarget;
		resource = resource.path("doctors");
		return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(list);
	}

	public List<Patient> getAllPatients() throws ClientErrorException {
		var list = new GenericType<List<Patient>>() {};
		WebTarget resource = webTarget;
		resource = resource.path("patients");
		return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(list);
	}

	public void deletePatient(String id) throws ClientErrorException {
		webTarget.path(java.text.MessageFormat.format("patient/{0}", new Object[]{id})).request().delete();
	}

	public void deleteDoctor(String id) throws ClientErrorException {
		webTarget.path(java.text.MessageFormat.format("doctor/{0}", new Object[]{id})).request().delete();
	}

	public void updateDoctor(Object requestEntity, String id) throws ClientErrorException {
		webTarget.path(java.text.MessageFormat.format("doctor/{0}", new Object[]{id})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
	}

	public void deleteRoom(int id) throws ClientErrorException {
		webTarget.path(java.text.MessageFormat.format("room/{0}", new Object[]{id})).request().delete();
	}

	public void createRoom(Object requestEntity) throws ClientErrorException {
		webTarget.path("rooms").request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
	}

	public Patient getPatient(int id) throws ClientErrorException {
		WebTarget resource = webTarget;
		resource = resource.path(java.text.MessageFormat.format("patient/{0}", new Object[]{id}));
		return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(Patient.class);
	}

	public Speciality getSpeciality(int id) throws ClientErrorException {
		WebTarget resource = webTarget;
		resource = resource.path(java.text.MessageFormat.format("specialitiy/{0}", new Object[]{id}));
		return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(Speciality.class);
	}

	public void updateAppointment(Object requestEntity, String id) throws ClientErrorException {
		webTarget.path(java.text.MessageFormat.format("appointment/{0}", new Object[]{id})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
	}

	public void createPatient(Object requestEntity) throws ClientErrorException {
		webTarget.path("doctors").request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
	}

	public Doctor getDoctor(int id) throws ClientErrorException {
		WebTarget resource = webTarget;
		resource = resource.path(java.text.MessageFormat.format("doctor/{0}", new Object[]{id}));
		return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(Doctor.class);
	}

	public void updatePatient(Object requestEntity, String id) throws ClientErrorException {
		webTarget.path(java.text.MessageFormat.format("patient/{0}", new Object[]{id})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
	}

	public Room getRoom(int id) throws ClientErrorException {
		WebTarget resource = webTarget;
		resource = resource.path(java.text.MessageFormat.format("room/{0}", new Object[]{id}));
		return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(Room.class);
	}

	public void createAppointment(Object requestEntity) throws ClientErrorException {
		webTarget.path("appointments").request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
	}

	public void deleteAppointment(String id) throws ClientErrorException {
		webTarget.path(java.text.MessageFormat.format("appointment/{0}", new Object[]{id})).request().delete();
	}

	public List<Room> getAllRooms() throws ClientErrorException {
		var list = new GenericType<List<Room>>() {};
		WebTarget resource = webTarget;
		resource = resource.path("rooms");
		return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(list);
	}

	public void deleteSpeciality(String id) throws ClientErrorException {
		webTarget.path(java.text.MessageFormat.format("speciality/{0}", new Object[]{id})).request().delete();
	}

	public List<Speciality> getAllSpecialitys() throws ClientErrorException {
		var list = new GenericType<List<Speciality>>() {};
		WebTarget resource = webTarget;
		resource = resource.path("specialities");
		return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(list);
	}

	public void updateSpeciality(Object requestEntity, String id) throws ClientErrorException {
		webTarget.path(java.text.MessageFormat.format("speciality/{0}", new Object[]{id})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
	}

	public void updateRoom(Object requestEntity, String id) throws ClientErrorException {
		webTarget.path(java.text.MessageFormat.format("room/{0}", new Object[]{id})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
	}

	@Override
	public void close() {
		client.close();
	}
	
}
