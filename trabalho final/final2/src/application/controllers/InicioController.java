package application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class InicioController implements Initializable{

    @FXML
    private Button btnCadAdmin;

    
    @FXML
    private Button btnCadJogador;

    
    

    @FXML
    void handleAdicionaJogador(ActionEvent event) {
    	Main.loadScene("Sample");
    }

    @FXML
    void handleAdicionaJogadorADM(ActionEvent event) {
    	Main.loadScene("LoginADM");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
