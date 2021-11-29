package application.controllers;

import java.awt.image.BufferedImage;
import java.io.File;

import java.net.URL;

import java.util.ResourceBundle;

import application.Main;
import application.models.Jogador;
import dao.JogadorDAO;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class CadastraJogadorController implements Initializable {
	BufferedImage image = null;
	private boolean isAltera;
	@FXML
	private BorderPane rootPane;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtMoeda;

	@FXML
	private Button btnSalvar;

	@FXML
	private ImageView foto;

	@FXML
	private Button btnVoltar;

	@FXML
	private Spinner<Integer> btnSpinnerExp;
	SpinnerValueFactory<Integer> gradesValueFactoryExp = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 99, 1);

	@FXML
	private Spinner<Integer> btnSpinnerNivel;
	SpinnerValueFactory<Integer> gradesValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);

	@FXML
	void handleSalvar() {
		if (!(txtNome.getText().equals(""))) {
			Jogador j;
			if (this.isAltera)
				j = (Jogador) rootPane.getUserData();
			else
				j = new Jogador();
			j.setQtdMoedas(Integer.parseInt(txtMoeda.getText()));
			j.setNivel(btnSpinnerNivel.getValue());
			j.setExpNovoNivel(btnSpinnerExp.getValue());
			j.setNome(txtNome.getText());

			JogadorDAO jDAO = new JogadorDAO();
			if (this.isAltera)
				jDAO.update(j);
			else
				jDAO.insert(j);
			handleVoltar();
		} else {
			var alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Campo vazio");
			alert.setContentText("Voce deve preencher todos os campos");
			alert.setTitle("Atenção");

			alert.show();
		}
	}

	@FXML
	void handleVoltar() {
		Main.loadScene("ListaJogador");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mascaraNumeroInteiro(txtMoeda);
		btnSpinnerExp.setValueFactory(gradesValueFactoryExp);

		btnSpinnerNivel.setValueFactory(gradesValueFactory);

		Platform.runLater(() -> runAltera());
	}

	private void runAltera() {

		var joga = (Jogador) rootPane.getUserData();

		if (joga == null)
			this.isAltera = false;
		else {
			this.isAltera = true;
			SpinnerValueFactory<Integer> gradesValueFactoryExp = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,
					99, joga.getExpNovoNivel());

			txtNome.setText(joga.getNome());
			SpinnerValueFactory<Integer> gradesValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10,
					joga.getNivel());
			btnSpinnerNivel.setValueFactory(gradesValueFactory);
			btnSpinnerExp.setValueFactory(gradesValueFactoryExp);
			txtMoeda.setText("" + joga.getQtdMoedas());

		}
	}

	public static void mascaraNumeroInteiro(TextField textField) {

		textField.textProperty()
				.addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
					if (!newValue.matches("\\d*")) {
						textField.setText(newValue.replaceAll("[^\\d]", ""));
					}
				});

	}

}
