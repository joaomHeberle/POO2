package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	private static Stage stage2;
	@Override
	public void start(Stage primaryStage) {
		
			
			stage2 = primaryStage;
			
			loadScene("Sample");
			primaryStage.show();
	
	}
	public static void loadScene(String view) {
		view = "/views/"+view+".fxml";
		BorderPane root;
		try {
			root = (BorderPane)FXMLLoader.load(Main.class.getResource(view));
			Scene scene = new Scene(root);
			stage2.setScene(scene);
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		
		
		
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
