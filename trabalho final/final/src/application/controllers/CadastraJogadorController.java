package application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.models.Jogador;
import dao.JogadorDAO;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class CadastraJogadorController implements Initializable {
	private boolean isAltera;  
	@FXML
	    private BorderPane rootPane;
	@FXML
	private TextField txtExp;

	@FXML
	private TextField txtMoedas;

	@FXML
	private TextField txtNome;

	@FXML
	private Button btnSalvar;

	@FXML
	private Button btnVoltar;

	@FXML
	private Spinner<Integer> btnSpinnerNivel;
	SpinnerValueFactory<Integer> gradesValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);

	@FXML
	void handleSalvar() {
		Jogador j;
		if(this.isAltera) j =(Jogador)rootPane.getUserData();
		else j = new Jogador();
		j.setExpNovoNivel(Integer.parseInt(txtExp.getText()));
		j.setNivel(btnSpinnerNivel.getValue());
		j.setQtdMoedas(Integer.parseInt(txtMoedas.getText()));
		j.setNome(txtNome.getText());
		
		JogadorDAO jDAO = new JogadorDAO();
		if(this.isAltera)jDAO.update(j);
		else jDAO.insert(j);
		handleVoltar();
		
	}

	@FXML
	void handleVoltar() {
		Main.loadScene("Sample");
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		btnSpinnerNivel.setValueFactory(gradesValueFactory);
	
		Platform.runLater(()->runAltera());
	}
	private void runAltera() {
		var joga = (Jogador)rootPane.getUserData();
		if(joga==null) this.isAltera=false;
		else {
			this.isAltera=true;
			txtExp.setText(""+joga.getExpNovoNivel());
			txtMoedas.setText(""+joga.getQtdMoedas());
			txtNome.setText(joga.getNome());
			SpinnerValueFactory<Integer> gradesValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(joga.getNivel(), 10, 1);
			btnSpinnerNivel.setValueFactory(gradesValueFactory);
		}
	}
}
