package application;

import java.io.FileInputStream;

import javafx.application.Application;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import javafx.stage.Stage;

public class Main extends Application {

	
	@Override
	public void start(Stage primaryStage) {
		try {
			Image imagem = new Image(new FileInputStream("src/application/1.png")); 
			 ImageView imageView = new ImageView(imagem); 
			 imageView.setFitHeight(400); 
		      imageView.setFitWidth(300);  
			
			
			Label lblTexto = new Label("ola");
			Label lblNome = new Label("digite seu Nome");
			Label imag = new Label();
			
			TextField txtNome = new TextField();
			Button btnOk = new Button("OK");
		
	         imag.setLayoutX (50 );
	        
	         imag.setLayoutY ( 90 );
	         
			imag.setGraphic(new ImageView ( imagem ) );

			btnOk.setOnAction(e -> lblTexto.setText("olá " + txtNome.getText()+" voce ainda não abriu a sala de entrega :)"));
		
		
			HBox agrupaHorizontal = new HBox();
			agrupaHorizontal.setSpacing(20);
			agrupaHorizontal.setAlignment(Pos.BASELINE_LEFT);
			agrupaHorizontal.getChildren().addAll(lblNome, txtNome,btnOk,imageView);
		
			
			
			BorderPane layout = new BorderPane();
			layout.setTop(agrupaHorizontal);
			
			layout.setCenter(lblTexto);
			Scene scene = new Scene(layout, 400, 400);
		
			primaryStage.setScene(scene);
			
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
