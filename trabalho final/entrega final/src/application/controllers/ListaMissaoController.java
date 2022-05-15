package application.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class ListaMissaoController implements Initializable {

	
	
	Validacao v = new Validacao();
	private ObservableList<Missao> missoes;
	@FXML
	private TableColumn<Missao, LocalDate> clmDataFim;
    @FXML
    private BorderPane rootPane;
	@FXML
	private TableColumn<Missao, LocalDate> clmDataIni;

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
	private ComboBox<String> comboTipo;

	@FXML
	private TableView<Missao> tabMissao;

	@FXML
	private TextArea txtDescricao;
	@FXML
	private DatePicker pickerDataFim;

	@FXML
	private DatePicker pickerDataIni;

	@FXML
	private Spinner<Integer> btnSpinerQuantidade;
	SpinnerValueFactory<Integer> gradesValueFactoryQtd = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 99, 1);

	@FXML
	void handleAlterarMissao() {
		Missao alvo = this.tabMissao.getSelectionModel().getSelectedItem();
		if (alvo != null) {

			Main.loadScene("UpdateMissao", alvo);

		} else {
			var alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Missão não selecionada");
			alert.setContentText("selecione para poder Alterar");
			alert.setTitle("Atenção");

			alert.show();

		}

	}

	@FXML
	void handleCadastrar() {
		if (!(txtDescricao.getText().equals("")) && (pickerDataIni.getValue() != null)
				&& (comboTipo.getValue() != null)) {
			Missao m;

			m = new Missao();
			m.setDescricao(txtDescricao.getText());
			m.setDataInicio(pickerDataIni.getValue());
			if (pickerDataIni.getValue().isBefore(pickerDataFim.getValue())) {
				m.setDataFim(pickerDataFim.getValue());
				m.setQuantidade(btnSpinerQuantidade.getValue());
				m.setTipo(comboTipo.getValue());

				MissaoDAO mDAO = new MissaoDAO();

				mDAO.insert(m);
				atualizar();
			} else {
				var alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Data errada");
				alert.setContentText("Voce deve preencher uma data fim maior que a data de inicio");
				alert.setTitle("Atenção");
				alert.show();
				Main.loadScene("ListaMissao");
			}

		} else {
			var alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Campo vazio");
			alert.setContentText("Voce deve preencher todos os campos");
			alert.setTitle("Atenção");

			alert.show();
		}
	}

	private void atualizar() {
		Main.loadScene("ListaMissao");
	}

	@FXML
	void handleDeletarMissao() {
		Missao alvo = this.tabMissao.getSelectionModel().getSelectedItem();
		if (alvo != null) {
			var alertDelete = new Alert(AlertType.CONFIRMATION);

			alertDelete.setHeaderText("Você tem certeza que deseja Excluir a missão "+alvo.getDescricao() +"?");
			alertDelete.setContentText("exclusão não tem volta");
			alertDelete.setTitle("Atenção");

			alertDelete.showAndWait().ifPresent(response -> {
				if (response == ButtonType.OK) {
					MissaoDAO mDAO = new MissaoDAO();
					mDAO.delete(alvo.getIdMissao());
				}
			});

			Main.loadScene("ListaMissao");
		} else {
			var alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Missão não selecionada");
			alert.setContentText("selecione para poder excluir");
			alert.setTitle("Atenção");

			alert.show();

		}

	}

	private void geraLista() {
		MissaoDAO mDao = new MissaoDAO();
		missoes = FXCollections.observableArrayList(mDao.list(16, 0));
		tabMissao.setItems(this.missoes);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		geraLista();

		clmIdMissao.setCellValueFactory(new PropertyValueFactory<>("idMissao"));
		clmDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		clmDataIni.setCellValueFactory(new PropertyValueFactory<>("dataInicio"));
		v.arrumaData(clmDataIni);
		clmDataFim.setCellValueFactory(new PropertyValueFactory<>("dataFim"));
		v.arrumaData(clmDataFim);
		clmStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
		clmTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		clmQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));

		btnSpinerQuantidade.setValueFactory(gradesValueFactoryQtd);
		ObservableList<String> list = FXCollections.observableArrayList("Eliminação", "Sobrevivencia");
		comboTipo.setItems(list);

	}
	

	

	
	   @FXML
	    void handleVoltaJogadores(ActionEvent event) {
		   Main.loadScene("ListaJogador");
	    }

}
