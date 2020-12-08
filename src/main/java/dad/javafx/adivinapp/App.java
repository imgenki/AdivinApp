package dad.javafx.adivinapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
	
	private AdivinController adivinController;
	
	public void start(Stage primaryStage) throws Exception {
		
		adivinController = new AdivinController();

		Scene escena = new Scene(adivinController.getView(), 320, 200);

		primaryStage.setScene(escena);
		primaryStage.setTitle("AdivinApp");
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}

