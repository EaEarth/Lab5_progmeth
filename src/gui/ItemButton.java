package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class ItemButton extends Button {
	
	private String item;
	
	public ItemButton (String item) {
		
		// TODO Completes ItemButton's constructor\
		this.item = item;
		this.setPadding(new Insets(5));

		setBorder(new Border(new BorderStroke(Color.GRAY,BorderStrokeStyle.SOLID, 
		CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		String url;
		switch(item) {
			case "Wood" : url = "Wood.png"; break;
			case "Iron" : url = "Iron_ore.png"; break;
			case "Iron Plate" : url = "Iron_plate.png"; break;
			case "Iron Sword" : url = "Iron_Sword.png"; break;
			case "Gem"	: url = "Gem.png"; break;
			default : url = "Other.png";
			
		}
		String image_path = ClassLoader.getSystemResource(url).toString();
		ImageView graphic = new ImageView(new Image(image_path));
		
		this.setGraphic(graphic);
		this.unhighlight();
				
	}
	
	public void highlight() {
		
		this.setStyle("-fx-background-color: #7FFFD4; ");

	}
	
	public void unhighlight() {

		this.setStyle("-fx-background-color: #FFFFFF; ");
		
	}
	
	public String getItem() {
		return this.item;
	}
	
}
