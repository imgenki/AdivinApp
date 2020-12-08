package dad.javafx.adivinapp;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class AdivinModel {
	private int numAdivinar=(int) ((Math.random() * 100) + 1); // Generador del número a Adivinar;
	private IntegerProperty numIntroducido = new SimpleIntegerProperty();
	private int numIntentos = 0;
	
	public final IntegerProperty numIntroducidoProperty() {
		return this.numIntroducido;
	}
	
	public final int getNumIntroducido() {
		return this.numIntroducidoProperty().get();
	}
	
	public final void setNumIntroducido(final int numIntroducido) {
		this.numIntroducidoProperty().set(numIntroducido);
	}

	public int getNumAdivinar() {
		return numAdivinar;
	}

	public void setNumAdivinar(int numAdivinar) {
		this.numAdivinar = numAdivinar;
	}

	public int getNumIntentos() {
		return numIntentos;
	}

	public void setNumIntentos(int numIntentos) {
		this.numIntentos = numIntentos;
	}

}
