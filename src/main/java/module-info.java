module gr.uniwa.javafxappointmentclient {
    requires javafx.controls;
    requires javafx.fxml;
	requires javax.ws.rs.api;

    opens gr.uniwa.javafxappointmentclient to javafx.fxml;
    exports gr.uniwa.javafxappointmentclient;
	requires java.xml.bind;
}