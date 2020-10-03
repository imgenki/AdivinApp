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
	private Alert acierto;
	private Alert fallo;
	private Alert numeroNoValido;
	int numAdivinar = (int) ((Math.random() * 100) + 1); // Generador del número a Adivinar
	int numIntentos = 0;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Campo de texto
		numeroText = new TextField();
		numeroText.setPrefColumnCount(5);
		numeroText.setPromptText("Introduce un número del 1 al 100");
		numeroText.setMaxWidth(150);
		// Botón
		comprobarButton = new Button();
		comprobarButton.setText("Comprobar");
		comprobarButton.setOnAction(e -> onComprobarButtonAction(e));
		comprobarButton.setDefaultButton(true);
		// Label
		instruccionesLabel = new Label();
		instruccionesLabel.setTranslateY(-80);
		instruccionesLabel.setText("Introduce un número del 1 al 100");
		// Caja
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
		if (validate(textIntroducido)) {
			int numIntroducido = Integer.parseInt(numeroText.getText());
			if (numIntroducido > 0 && numIntroducido <= 100) {
				if (numAdivinar == numIntroducido) {
					numIntentos++;
					acierto(numIntentos);
				} else {
					numIntentos++;
					if (numIntroducido < numAdivinar)
						fallo("mayor", numIntroducido);
					else
						fallo("menor", numIntroducido);
				}
			} else {
				numeroNoValido();
			}
		} else {
			numeroNoValido();
		}
	}

	// Validador
	private boolean validate(String text) {
		return text.matches("[0-9]*");
	}
	// Ventana de error
	public void numeroNoValido() {
		numeroNoValido = new Alert(AlertType.ERROR);
		numeroNoValido.setTitle("AdivinApp");
		numeroNoValido.setHeaderText("Error");
		numeroNoValido.setContentText("El número introducido no es válido");

		numeroNoValido.showAndWait();
	}
	
	// Ventana en caso de acierto
	public void acierto(int numIntentos) {
		acierto = new Alert(AlertType.INFORMATION);
		acierto.setTitle("AdivinApp");
		acierto.setHeaderText("¡Has ganado!");
		acierto.setContentText("Sólo has necesitado " + numIntentos + " intentos" + "\n\nVuelve a jugar y hazlo mejor");

		acierto.showAndWait();
	}
	
	// Ventana en caso de fallo
	public void fallo(String mayorMenor, int numIntroducido) {
		fallo = new Alert(AlertType.WARNING);
		fallo.setTitle("AdivinApp");
		fallo.setHeaderText("¡Has fallado!");
		fallo.setContentText("El número a adivinar es " + mayorMenor + " que " + numIntroducido);

		fallo.showAndWait();

	}

	public static void main(String[] args) {
		launch(args);
	}

}