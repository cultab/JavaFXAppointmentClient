package gr.uniwa.javafxappointmentclient;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable {

	List<Appointment> appointments;
	int curIndex = 0;

	@FXML
	TextField idTF;
	@FXML
	TextField patientTF;
	@FXML
	TextField doctorTF;
	@FXML
	TextField roomTF;
	@FXML
	TextField dateTF;
	@FXML
	TextField timeTF;

	public PrimaryController() {
		curIndex = 0;

		idTF = new TextField();
		patientTF = new TextField();
		doctorTF = new TextField();
		roomTF = new TextField();
		dateTF = new TextField();
		timeTF = new TextField();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		this.updateList();

		updateUI();
	}

	/**
	 * Updates list of appointments
	 */
	void updateList() {
		var client = new RestJerseyClient();
		appointments = client.getAllAppointments();
		assert(appointments != null);
		client.close();
		
	}

	@FXML
	void updateUI() {

		if (appointments == null || appointments.isEmpty()) {
			idTF.setText("");
			patientTF.setText("");
			doctorTF.setText("");
			roomTF.setText("");
			dateTF.setText("");
			timeTF.setText("");

			return;
		}

		Appointment app = appointments.get(curIndex);

		assert(app != null);
		
		idTF.setText(Integer.toString(app.getId()));
		patientTF.setText(app.getPatient());
		doctorTF.setText(app.getDoctor());
		roomTF.setText(app.getRoom());
		dateTF.setText(app.getDate());
		timeTF.setText(app.getTime());
	}

	@FXML
	void nextAppointment() {
		if (curIndex < appointments.size() - 1) {
			curIndex++;
			this.updateUI();
		}
	}

	@FXML
	void prevAppointment() {
		if (curIndex > 0) {
			curIndex--;
			this.updateUI();
		}
	}

	@FXML
	void createAppointment() {
		var app = new Appointment();
		
		app.setId(-1);
		app.setPatient(patientTF.getText());
		app.setDoctor(doctorTF.getText());
		app.setRoom(roomTF.getText());
		app.setDate(dateTF.getText());
		app.setTime(timeTF.getText());
		
		System.out.println("Create :" + app);

		var client = new RestJerseyClient();
		client.createAppointment(app);
		client.close();

		curIndex = appointments.size();

		this.updateList();
		this.updateUI();
	}

	@FXML
	void retrieveAppointment() {
		this.updateList();
		this.updateUI();
	}

	@FXML
	void updateAppointment() {
		if (appointments.isEmpty()) {
			return;
		}

		Appointment app = appointments.get(curIndex);

		app.setPatient(patientTF.getText());
		app.setDoctor(doctorTF.getText());
		app.setRoom(roomTF.getText());
		app.setDate(dateTF.getText());
		app.setTime(timeTF.getText());

		var client = new RestJerseyClient();

		System.out.println("Update: " + app);
		
		client.updateAppointment(app, Integer.toString(app.getId()));
		client.close();

		this.updateList();
		this.updateUI();
	}

	@FXML
	void deleteAppointment() {
		var client = new RestJerseyClient();
		client.deleteAppointment(idTF.getText());
		client.close();

		this.updateList();

		if (curIndex >= appointments.size() - 1 && curIndex != 0) {
			curIndex--;
		}
		this.updateUI();
	}
}
