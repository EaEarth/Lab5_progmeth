package gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import gui.InputField;
import gui.CataloguePane;

public class ControlPane extends VBox {
	
	private CataloguePane catalogue;
	private InputField amountInputField;
	private Button addButton;
	
	public ControlPane () {

		// TODO Implements CataloguePane's constructor
		
		setBorder(new Border(new BorderStroke(Color.LIGHTGRAY,BorderStrokeStyle.SOLID, 
		CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setAlignment(Pos.CENTER);
		this.setSpacing(15);
		this.setPrefWidth(200);
		
		Label catalogueTitle = new Label();
		catalogueTitle.setText("Choose an item");
		catalogueTitle.setFont(new Font("Ariel",18));
		this.catalogue = new CataloguePane();
		this.amountInputField = new InputField("Amount to add","Input number here");
		addButton = new Button("Add");
		addButton.setPrefWidth(150);
		
		this.getChildren().addAll(catalogueTitle,catalogue,amountInputField,addButton);
		
	}

	public CataloguePane getCatalogue() {
		return catalogue;
	}

	public InputField getAmountInputField() {
		return amountInputField;
	}

	public Button getAddButton() {
		return addButton;
	}
	
	
}
