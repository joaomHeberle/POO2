package application.controllers;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;


public class InicioController{

	@FXML
	private Button btnCadAdmin;

	@FXML
	private Button btnCadJogador;

	@FXML
	void handleAdicionaJogador(ActionEvent event) {

		Main.loadScene("ListaJogador");

	}

	@FXML
	void handleAdicionaMissao(ActionEvent event) {
		Main.loadScene("ListaMissao");
	}

}
