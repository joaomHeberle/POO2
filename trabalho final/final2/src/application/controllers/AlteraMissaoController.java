package application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.models.Jogador;
import application.models.Missao;
import dao.MissaoDAO;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class AlteraMissaoController  implements Initializable{


    @FXML
    private Spinner<Integer> btnSpinerQuantidadeAlt;
    SpinnerValueFactory<Integer> gradesValueFactoryQtd = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 99, 1);
    @FXML
    private DatePicker pickerDataFimAlt;
    @FXML
    private DatePicker pickerDataIniAlt;
    @FXML
    private ComboBox<String> comboTipoAlt;


    @FXML
    private BorderPane rootPane;

    @FXML
    private TextArea txtDescricaoAlt;

    @FXML
    void handleConfirmaAlterar(ActionEvent event) {

    	MissaoDAO mDAO = new MissaoDAO();
    	var m = (Missao) rootPane.getUserData();
    	
    	m.setDescricao(txtDescricaoAlt.getText());
		m.setDataInicio(pickerDataIniAlt.getValue());
		m.setDataFim(pickerDataFimAlt.getValue());
		m.setQuantidade(btnSpinerQuantidadeAlt.getValue());
		m.setTipo(comboTipoAlt.getValue());
		mDAO.update(m);
		Main.loadScene("ListaMissao");
    }

  

    
    private void runAltera() {
    	Missao missa;
    	missa = (Missao) rootPane.getUserData();
    	
			SpinnerValueFactory<Integer> gradesValueFactory= new SpinnerValueFactory.IntegerSpinnerValueFactory(1,
					99, missa.getQuantidade());
			btnSpinerQuantidadeAlt.setValueFactory(gradesValueFactory);
			txtDescricaoAlt.setText(missa.getDescricao());
			pickerDataIniAlt.setValue(missa.getDataInicio());
			pickerDataFimAlt.setValue(missa.getDataFim());
			comboTipoAlt.setValue(missa.getTipo());

		}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<String> list = FXCollections.observableArrayList("Eliminação", "Sobrevivencia");
		comboTipoAlt.setItems(list);
		Platform.runLater(() -> runAltera());
		
	}
	 @FXML
	    void handleVoltar(ActionEvent event) {
			Main.loadScene("ListaMissao");
	    }

}
