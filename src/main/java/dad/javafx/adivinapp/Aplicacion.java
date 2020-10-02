package dad.javafx.adivinapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Aplicacion extends Application {

	private Button comprobarButton;
	private TextField numeroText;
	private Label instruccionesLabel;
	private Label aciertoComplementario;
	private Alert acierto;
	private Alert fallo;
	private Alert numeroNoValido;
	int numAdivinar = (int) ((Math.random() * 100) + 1); // TODO no se genera el número correctamente
	int numIntentos = 0;

	@Override
	public void start(Stage primaryStage) throws Exception {

		numeroText = new TextField();
		numeroText.setPrefColumnCount(5);
		numeroText.setPromptText("Introduce un número del 1 al 100");
		numeroText.setMaxWidth(150);

		comprobarButton = new Button();
		comprobarButton.setText("Comprobar");
		comprobarButton.setOnAction(e -> onComprobarButtonAction(e));
		comprobarButton.setDefaultButton(true);

		instruccionesLabel = new Label();
		instruccionesLabel.setTranslateY(-80);
		instruccionesLabel.setText("Introduce un número del 1 al 100");

		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(numeroText, comprobarButton, instruccionesLabel);

		Scene escena = new Scene(root, 320, 200);

		primaryStage.setScene(escena);
		primaryStage.setTitle("AdivinApp");
		primaryStage.show();

	}

	private void onComprobarButtonAction(ActionEvent e) {

		String textIntroducido = numeroText.getText();
		String mayorMenor = "";

		if (validate(textIntroducido)) {
			int numIntroducido = Integer.parseInt(numeroText.getText());
			if (numIntroducido > 0 && numIntroducido <= 100) {
				if (numAdivinar == numIntroducido) {
					numIntentos++;
					acierto = new Alert(AlertType.INFORMATION);
					acierto.setTitle("AdivinApp");
					acierto.setHeaderText("¡Has ganado!");
					acierto.setContentText("Sólo has necesitado " + numIntentos + " intentos" + "\n\nVuelve a jugar y hazlo mejor");
					acierto.showAndWait();
				} else if (numAdivinar != numIntroducido) {
					numIntentos++;
					if (numIntroducido < numAdivinar)
						mayorMenor = "mayor";
					else
						mayorMenor = "menor";
					
					fallo = new Alert(AlertType.WARNING);
					fallo.setTitle("AdivinApp");
					fallo.setHeaderText("¡Has fallado!");
					fallo.setContentText("El número a adivinar es " + mayorMenor + " que " + numIntroducido);

					fallo.showAndWait();
				}
			} else {
				numeroNoValido();
			}
		} else {
			numeroNoValido();
		}
	}

	private boolean validate(String text) {
		return text.matches("[0-9]*");
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void numeroNoValido() {
		numeroNoValido = new Alert(AlertType.ERROR);
		numeroNoValido.setTitle("AdivinApp");
		numeroNoValido.setHeaderText("Error");
		numeroNoValido.setContentText("El número introducido no es válido");

		numeroNoValido.showAndWait();
	}

}