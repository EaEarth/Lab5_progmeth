package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

public class CataloguePane extends GridPane {
	
	private ObservableList<ItemButton> itemButtonList = FXCollections.observableArrayList();
	private ItemButton selectedItemButton = null;
	
	public CataloguePane () {
		
		this.setAlignment(Pos.CENTER);
		this.setVgap(10);
		this.setHgap(10);
		
		ItemButton wood = new ItemButton("Wood");
		ItemButton iron = new ItemButton("Iron");
		ItemButton ironPlate = new ItemButton("Iron Plate");
		ItemButton ironSword = new ItemButton("Iron Sword");
		ItemButton gem = new ItemButton("Gem");
		ItemButton other = new ItemButton("Other");
		
		itemButtonList.addAll(wood,iron,ironPlate,ironSword,gem,other);
		
		for(ItemButton x:itemButtonList) {
			x.setOnAction(new EventHandler<ActionEvent>(){
			
				@Override
				public void handle(ActionEvent event) {
					setSelectedButton(x);
				}
			
			});
		}
		
		this.add(wood, 0, 0);
		this.add(iron, 1, 0);
		this.add(ironPlate, 2, 0);
		this.add(ironSword, 0, 1);
		this.add(gem, 1, 1);
		this.add(other, 2,1);
		

	} 
	
	public void setSelectedButton ( ItemButton selectedItemButton ) {
		if(this.selectedItemButton != null) {
			this.selectedItemButton.unhighlight();
		}
		this.selectedItemButton = selectedItemButton;
		selectedItemButton.highlight();
	
	}
	
	public ItemButton getSelectedButton() {
		
		return this.selectedItemButton;
	
	}
	
}
