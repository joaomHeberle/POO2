package application.controllers;


import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.models.Jogador;
import dao.JogadorDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class FormularioController implements Initializable {
	
	private ObservableList<Jogador> jogadores;
    @FXML
    private TableColumn<Jogador, Integer> clmExperiencia;

    @FXML
    private TableColumn<Jogador, Integer> clmId;

    @FXML
    private TableColumn<Jogador, Integer> clmMoedas;

    @FXML
    private TableColumn<Jogador, Integer> clmNivel;

    @FXML
    private TableColumn<Jogador, String> clmNome;

    @FXML
    private TableView<Jogador> tabJogador;

    @FXML
    private Button btnAddJogador;
    
   
    
    
    private void geraLista() {
    	JogadorDAO jDao = new JogadorDAO();
    	jogadores = FXCollections.observableArrayList(jDao.list());
    	tabJogador.setItems(this.jogadores);
    }



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		geraLista();
		clmId.setCellValueFactory(new PropertyValueFactory<>("idJogador"));
		clmExperiencia.setCellValueFactory(new PropertyValueFactory<>("expNovoNivel"));
		clmMoedas.setCellValueFactory(new PropertyValueFactory<>("qtdMoedas"));
		clmNivel.setCellValueFactory(new PropertyValueFactory<>("nivel"));
		clmNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
	

	
	}
    @FXML
    void handleAdicionaJogador(ActionEvent event) {
    	Main.loadScene("addJogador");
    }

}

