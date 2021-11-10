package application.controllers;



import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

public class CadastraJogadorController implements Initializable{

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnVoltar;
    
    @FXML
    private Spinner<Integer> btnSpinner;
	SpinnerValueFactory<Integer> gradesValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10,1);

    

    @FXML
    void handleSalvar() {

    }

    @FXML
    void handleVoltar() {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		btnSpinner.setValueFactory(gradesValueFactory);
		//btnSpinner.getValue();
	}

}
