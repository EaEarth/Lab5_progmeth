package gui;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class InputField extends VBox {
	
	private TextField textField;
	
	public InputField(String title, String promptText) {
		
		this.setPadding(new Insets(10,10,10,10));
		this.textField = new TextField();
		textField.setPromptText(promptText);
		Label label = new Label();
		label.setText(title);
		label.setFont(new Font("Ariel",18));
		this.setAlignment(Pos.CENTER);
		this.setSpacing(5);
		this.getChildren().addAll(label,textField);
		
	}

	public String getText() {

		return textField.getText().trim();

	}
	
}
