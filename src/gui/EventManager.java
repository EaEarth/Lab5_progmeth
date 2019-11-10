package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import gui.BarChartPane;

public class EventManager {

	private BarChartPane barChartPane;
	private ItemLogPane itemLogPane;
	private CataloguePane cataloguePane;

	public EventManager(BarChartPane barChartPane, ItemLogPane itemLogPane, CataloguePane cataloguePane) {
		this.barChartPane = barChartPane;
		this.itemLogPane = itemLogPane;
		this.cataloguePane = cataloguePane;
	}

	public void setUpAddButtonEvent(Button addButton, InputField amountInput) {
		addButton.setOnAction(new AddButtonEventHandler(amountInput));
	}

	private class AddButtonEventHandler implements EventHandler<ActionEvent> {

		private InputField amountInput;

		public AddButtonEventHandler(InputField amountInput) {
			this.amountInput = amountInput;
		}

		@Override
		public void handle(ActionEvent arg0) {
			try {
				if (cataloguePane.getSelectedButton() == null) {
					Alert selectedNone = new Alert(AlertType.INFORMATION);
					selectedNone.setContentText("Please Select An Item to Be Added");
					selectedNone.showAndWait();
					return;
				}
				int amount = Integer.parseInt(amountInput.getText()); 
				if (amount <= 0) {
					Alert negative = new Alert(AlertType.ERROR);
					negative.setContentText("Please Fill In Positive Amount");
					negative.showAndWait();
				} else {
					int totalAmount = barChartPane.addItem(cataloguePane.getSelectedButton().getItem(), amount);
					itemLogPane.addData(cataloguePane.getSelectedButton().getItem(), amount, totalAmount);
				}
			} catch (NumberFormatException e) {
				if (amountInput.getText().equals("")) {
					Alert empty = new Alert(AlertType.INFORMATION);
					empty.setContentText("Amount Cannot Be Empty");
					empty.showAndWait();
				} else {
					Alert error = new Alert(AlertType.ERROR);
					error.setContentText("Incorrect Input Format");	
					error.showAndWait();
				}
			}
		}

	}
}
