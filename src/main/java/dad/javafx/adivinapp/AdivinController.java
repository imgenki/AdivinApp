package dad.javafx.adivinapp;
import javafx.event.ActionEvent;
import javafx.util.converter.NumberStringConverter;

public class AdivinController {
	private AdivinView view = new AdivinView();
	private AdivinModel model = new AdivinModel();

	public AdivinController() {
		view.getComprobarButton().setOnAction(e -> onComprobarButtonAction(e));
	}
	public AdivinView getView() {
		return view;
	}

	public AdivinModel getModel() {
		return model;
	}

	private void onComprobarButtonAction(ActionEvent e) {
	model.setNumIntroducido(Integer.parseInt(view.getNumeroText().textProperty().get()));
	
	String textIntroducido = view.getNumeroText().getText();
	if (validate(textIntroducido)) {
		int numIntroducido = Integer.parseInt(view.getNumeroText().getText());
		if (numIntroducido > 0 && numIntroducido <= 100) {
			if (model.getNumAdivinar() == model.getNumIntroducido()) {
				model.numIntentosProperty().add(1);
				view.acierto(model.getNumIntentos());
			} else {
				model.numIntentosProperty().add(1);
				if (model.getNumIntroducido() < model.getNumAdivinar())
					view.fallo("mayor", model.getNumIntroducido());
				else
					view.fallo("menor", model.getNumIntroducido());
			}
		} else {
			view.numeroNoValido();
		}
	} else {
		view.numeroNoValido();
	}
}
	private boolean validate(String text) {
		return text.matches("[0-9]*");
	}
}
