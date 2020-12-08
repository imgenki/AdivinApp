package dad.javafx.adivinapp;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinView extends VBox{
	private Button comprobarButton;
	private TextField numeroText;
	private Label instruccionesLabel;
	private Alert acierto;
	private Alert fallo;
	private Alert numeroNoValido;
	
	public AdivinView (){
		super();
		// Campo de texto
		numeroText = new TextField();
		numeroText.setPrefColumnCount(5);
		numeroText.setPromptText("Introduce un número del 1 al 100");
		numeroText.setMaxWidth(150);
		// Botón
		comprobarButton = new Button();
		comprobarButton.setText("Comprobar");
		comprobarButton.setDefaultButton(true);
		// Label
		instruccionesLabel = new Label();
		instruccionesLabel.setTranslateY(-80);
		instruccionesLabel.setText("Introduce un número del 1 al 100");

		setSpacing(5);
		setAlignment(Pos.CENTER);
		getChildren().addAll(numeroText, comprobarButton, instruccionesLabel);


	}
	
	public TextField getNumeroText() {
		return numeroText;
	}
	
	public Button getComprobarButton() {
		return comprobarButton;
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
}
