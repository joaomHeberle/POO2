package application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.models.Jogador;
import application.models.Missao;
import dao.JogadorDAO;
import dao.JogadorMissaoDAO;
import dao.MissaoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListaMissaoJogadorController<T> implements Initializable{
	private ObservableList<Jogador> missoes;
    @FXML
    private TableColumn<Missao, String> clmDescricao;

    @FXML
    private TableColumn<Missao, Boolean> clmFinalizada;

    @FXML
    private TableColumn<Jogador, Integer> clmIdJogador;

    @FXML
    private TableColumn<Missao, Integer> clmIdMissao;

    @FXML
    private TableColumn<Jogador, String> clmNome;

    @FXML
    private TableColumn<Missao, Integer> clmTipo;
    @FXML
    private TableView<T> tableMissaoJogador;
    @FXML
    void handleAlterarMissao(ActionEvent event) {

    }

    @FXML
    void handleDeletarMissao(ActionEvent event) {

    }

    @FXML
    void handleListaJogadores(ActionEvent event) {
    	Main.loadScene("ListaJogador");
    }

    @FXML
    void handleListaMissao(ActionEvent event) {
    	Main.loadScene("ListaMissao");
    }
  
	@SuppressWarnings("unchecked")
	private void geraLista() {
		JogadorMissaoDAO jmDAO = new JogadorMissaoDAO();
		Jogador j = new Jogador();
		MissaoDAO mDAO = new MissaoDAO();
		JogadorDAO jDAO = new JogadorDAO();
		j= jDAO.get(21);
		j.setMissoes(jmDAO.listDados(j));
		missoes = FXCollections.observableArrayList(j);
		tableMissaoJogador.setItems((ObservableList<T>) this.missoes);
		System.out.println(j);
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		geraLista();
		
		clmDescricao.setCellValueFactory(new PropertyValueFactory<>("missoes"));
		

		clmNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		


		

		
	}


}
