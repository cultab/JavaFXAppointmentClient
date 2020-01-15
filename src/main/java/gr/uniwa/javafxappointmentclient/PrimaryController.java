package gr.uniwa.javafxappointmentclient;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable {


	@FXML
	TextField appPatientTF;
	@FXML
	TextField appDoctorTF;
	@FXML
	TextField appRoomTF;
	@FXML
	TextField appDateTF;
	@FXML
	TextField appTimeTF;
	@FXML
	TextField patPatientTF;
	@FXML
	TextField patAddressTF;
	@FXML
	TextField patPhoneTF;
	@FXML
	TextField docDoctorTF;
	@FXML
	TextField docSpecTF;

	int appIndex = 0;
	int patIndex = 0;
	int docIndex = 0;

	List<Appointment> appList;
	List<Patient> patList;
	List<Doctor> docList;

	public PrimaryController() {
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		try (var client = new RestJerseyClient()) {
			appList = client.getAllAppointments();
			patList = client.getAllPatients();
			docList = client.getAllDoctors();
		}
	}

	@FXML
	void appNext() {
		if (appIndex < appList.size() -1) {
			appIndex++;
			updateAppUI();
		}
	}
		
	@FXML
	void appPrev() {
		if (appIndex > 0) {
			appIndex--;
			updateAppUI();
		}
	}

	@FXML
	void updateAppUI() {
		if (appList == null) {
			try (var client = new RestJerseyClient()) {
				appList = client.getAllAppointments();
			}
		}
		var app = appList.get(appIndex);

		appDateTF.setText(app.getDate());
		appTimeTF.setText(app.getTime());

		try (var client = new RestJerseyClient()) {
			appPatientTF.setText(client.getPatient(app.getPatient_id()).getFullname());
			appDoctorTF.setText(client.getDoctor(app.getDoctor_id()).getFullname());
			appRoomTF.setText(client.getRoom(app.getRoom_id()).getDescription());
		}
	}

	@FXML
	void patNext() {
		if (patIndex < patList.size() -1) {
			patIndex++;
			updatePatUI();
		}
	}
		
	@FXML
	void patPrev() {
		if (patIndex > 0) {
			patIndex--;
			updatePatUI();
		}
	}

	@FXML
	void updatePatUI() {
		var pat = patList.get(patIndex);
		patPatientTF.setText(pat.getFullname());
		patAddressTF.setText(pat.getAddress());
		patPhoneTF.setText(pat.getPhone_num());

	}

	@FXML
	void docNext() {
		if (docIndex < docList.size() -1) {
			docIndex++;
			updateDocUI();
		}
	}
		
	@FXML
	void docPrev() {
		if (docIndex > 0) {
			docIndex--;
			updateDocUI();
		}
	}

	@FXML
	void updateDocUI() {
		var doc = docList.get(docIndex);
		docDoctorTF.setText(doc.getFullname());

		try (var client = new RestJerseyClient()) {
			docSpecTF.setText(client.getSpeciality(doc.getSpec_id()).getDescription());

		}
	}
}
