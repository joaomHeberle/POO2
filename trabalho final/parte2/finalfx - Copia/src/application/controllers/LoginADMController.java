package application.controllers;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class LoginADMController {
	private String usuario = "root";
	private String senha = "root";
	@FXML
	private Button btnEntrar;

	@FXML
	private Button btnVoltar;

	@FXML
	private PasswordField txtSenhaADM;

	@FXML
	private TextField txtUsuarioLG;

	@FXML
	void handleEntrar(ActionEvent event) {
		if (txtUsuarioLG.getText().equals(usuario) && txtSenhaADM.getText().equals(senha)) {
			Main.loadScene("ListaJogador");
		} else {
			var alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Senha e/ou Usuario incorreto");
			alert.setContentText("Contate o administrador");
			alert.setTitle("Cuidado");

			alert.show();
		}
	}

	@FXML
	void handleVoltar(ActionEvent event) {
		Main.loadScene("Inicio");
	}

}
