package application.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import application.Main;
import application.models.Jogador;
import application.models.Missao;
import application.utils.Validacao;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class EscolheMissaoController implements Initializable{

	
	Validacao v = new Validacao();
	private ObservableList<Missao> missoes;
	
    @FXML
    private BorderPane rootPane;


	@FXML
	private TableColumn<Missao, String> clmDescricao;

	@FXML
	private TableColumn<Missao, Integer> clmIdMissao;

	@FXML
	private TableColumn<Missao, Boolean> clmStatus;
	@FXML
	private TableColumn<Missao, Integer> clmQuantidade;
	@FXML
	private TableColumn<Missao, String> clmTipo;


	@FXML
	private TableView<Missao> tabMissao;


    @FXML
    void handleCancelar(ActionEvent event) {
    	Main.loadScene("ListaJogador");
    }
    
    private void geraLista() {
		 Jogador joga =(Jogador) rootPane.getUserData();
		 
		JogadorMissaoDAO jmDAO = new JogadorMissaoDAO();
		joga.setMissoes(jmDAO.listDados(joga));

		missoes = FXCollections.observableArrayList(jmDAO.listMissaoNaoSelecionada(joga));
		tabMissao.setItems( this.missoes);
		


	}

 
    @FXML
    void handleSelecionaMissao() {
	 Jogador joga = (Jogador) rootPane.getUserData();
	
	 Missao alvo = this.tabMissao.getSelectionModel().getSelectedItem();
	 JogadorMissaoDAO jmDAO = new JogadorMissaoDAO();
	 MissaoDAO mDAO = new MissaoDAO();
	
	 
	
	 if (alvo != null) {
			var alertJuncao = new Alert(AlertType.CONFIRMATION);

			alertJuncao.setHeaderText(joga.getNome()+" tem certeza que deseja escolher a missão :"+alvo.getDescricao());
			alertJuncao.setContentText("Escolha com sabedoria");
			alertJuncao.setTitle("Atenção");

			alertJuncao.showAndWait().ifPresent(response -> {
				if (response == ButtonType.OK) {
					joga.setMissoes(mDAO.listById(alvo.getIdMissao()));
					jmDAO.insert(joga);
				}
			});

			Main.loadScene("ListaJogador");
		} else {
			var alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Missão não selecionada");
			alert.setContentText("selecione uma missão");
			alert.setTitle("Atenção");
			alert.show();

		}

    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Platform.runLater(() ->geraLista());
		setaCampos();
	
		
	}
	private void setaCampos() {
	

		clmIdMissao.setCellValueFactory(new PropertyValueFactory<>("idMissao"));
		clmDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		clmStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
		clmTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		clmQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
		
	

	}

}
