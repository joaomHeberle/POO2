package application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;

public class InicioController implements Initializable {

	@FXML
	private Button btnCadAdmin;

	@FXML
	private Button btnCadJogador;

	@FXML
	void handleAdicionaJogador(ActionEvent event) {

		Main.loadScene("LoginADM");

	}

	@FXML
	void handleAdicionaMissao(ActionEvent event) {
		var alert = new Alert(AlertType.ERROR);
		alert.setHeaderText("Botão ainda não implementado");
		alert.setContentText("Contate o administrador");
		alert.setTitle("Cuidado");

		alert.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
}
