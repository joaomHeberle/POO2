package application.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import application.models.Jogador;
import application.models.Missao;
import dao.JogadorDAO;
import dao.JogadorMissaoDAO;
import dao.MissaoDAO;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;

public class Validacao {
	
	
	public <T> void arrumaData(TableColumn<T, LocalDate> nome) {

		DateTimeFormatter Formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		nome.setCellFactory(cell -> {

			return new TableCell<T, LocalDate>() {

				@Override
				protected void updateItem(LocalDate item, boolean empty) {
					super.updateItem(item, empty);
					if (!empty && item != null) {

						setText(Formater.format(item));

					} else {
						setText("");
						setGraphic(null);
					}
				}
			};
		});

	}


}
