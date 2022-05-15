package application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.models.Jogador;
import application.models.Missao;
import dao.JogadorMissaoDAO;
import dao.MissaoDAO;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class ListaMissaoJogadorController implements Initializable{
	private ObservableList<Missao> missoes;
    @FXML
    private TableColumn<Missao, String> clmDescricao;

    @FXML
    private TableColumn<Missao, Boolean> clmFinalizada;

    @FXML
    private BorderPane rootPane;

    @FXML
    private TableColumn<Missao, Integer> clmIdMissao;

    @FXML
    private TableColumn<Missao, Integer> clmTipo;
    @FXML
    private TableView<Missao> tableMissaoJogador;
    @FXML
    private Label lbId;

    @FXML
    private Label lbNome;
 
    @FXML
    void handleDeletarMissao(ActionEvent event) {
    	Jogador joga =(Jogador) rootPane.getUserData();
    	Missao alvo = this.tableMissaoJogador.getSelectionModel().getSelectedItem();
    	
		if (alvo != null) {
			var alertDelete = new Alert(AlertType.CONFIRMATION);

			alertDelete.setHeaderText(joga.getNome()+" tem certeza que deseja Excluir a missão"+alvo.getDescricao()+ "?");
			alertDelete.setContentText("exclusão não tem volta");
			alertDelete.setTitle("Atenção");

			alertDelete.showAndWait().ifPresent(response -> {
				if (response == ButtonType.OK) {
					JogadorMissaoDAO jmDAO = new JogadorMissaoDAO();
					jmDAO.delete(alvo.getIdMissao(),joga.getIdJogador());
				}
			});

			Main.loadScene("ListaJogador");
		} else {
			var alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Missão não selecionada");
			alert.setContentText("selecione para poder excluir");
			alert.setTitle("Atenção");

			alert.show();

		}
    }

    @FXML
    void handleListaJogadores(ActionEvent event) {
    	Main.loadScene("ListaJogador");
    }

    @FXML
    void handleListaMissao(ActionEvent event) {
    	Main.loadScene("ListaMissao");
    }
  

	private void geraLista() {
		 Jogador joga =(Jogador) rootPane.getUserData();
	
		JogadorMissaoDAO jmDAO = new JogadorMissaoDAO();
	
		
		
		joga.setMissoes(jmDAO.listDados(joga));
		missoes = FXCollections.observableArrayList(jmDAO.listDados(joga));
		tableMissaoJogador.setItems( this.missoes);

		lbId.setText("Código: "+joga.getIdJogador());
		lbNome.setText("Nome do jogador: "+joga.getNome());

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Platform.runLater(() ->geraLista());
		setaCampos();
		
		
	}

private void setaCampos() {

	 clmDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		clmFinalizada.setCellValueFactory(new PropertyValueFactory<>("status"));
		 clmIdMissao.setCellValueFactory(new PropertyValueFactory<>("idMissao"));
		 clmTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
}
}
