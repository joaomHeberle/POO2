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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class FormularioController implements Initializable {
	
	private ObservableList<Jogador> jogadores;
    @FXML
    private TableColumn<Jogador, Integer> clmExperiencia;
 
    @FXML
    private TableColumn<Jogador, Integer> clmId;
    @FXML
    private Button btnAlterarJogador;
   
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
    
    @FXML
    private Button btnExcluiJogador;
    
    
    private void geraLista() {
    	JogadorDAO jDao = new JogadorDAO();
    	jogadores = FXCollections.observableArrayList(jDao.list(10,0));
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
    	Main.loadScene("AddJogador");
    }
    
    @FXML
    void handleExcluiJogador(ActionEvent event) {
    	Jogador alvo = this.tabJogador.getSelectionModel().getSelectedItem();
    	if(alvo!=null) {
    		var alertDelete = new Alert(AlertType.CONFIRMATION);
    
    		alertDelete.setHeaderText("Você tem certeza que deseja Excluir ?");
    		alertDelete.setContentText("exclusão não tem volta");
    		alertDelete.setTitle("Atenção");
    		
   		 alertDelete.showAndWait().ifPresent(response -> {
		     if (response == ButtonType.OK) {
		     	JogadorDAO jDAO = new JogadorDAO();
		     	jDAO.delete(alvo.getIdJogador());
		     }
		 });
    		
   	

    	Main.loadScene("Sample");
    	}else {
    		var alert= new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("Jogador não selecionado");
    		alert.setContentText("selecione para poder excluir");
    		alert.setTitle("Atenção");
    		
    		alert.show();
    		
    	}
    	
    }
	 @FXML
	    void handleAlteraJogador(ActionEvent event) {
		 Jogador alvo = this.tabJogador.getSelectionModel().getSelectedItem();
	    	if(alvo!=null) {
	    
		     	Main.loadScene("AddJogador",alvo);
	    		
	    	}else {
	    		var alert= new Alert(AlertType.INFORMATION);
	    		alert.setHeaderText("Jogador não selecionado");
	    		alert.setContentText("selecione para poder Alterar");
	    		alert.setTitle("Atenção");
	    		
	    		alert.show();
	    		
	    	}
	    }
}

