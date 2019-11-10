package main;

import gui.BarChartPane;
import gui.ControlPane;
import gui.EventManager;
import gui.ItemLogPane;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import gui.CataloguePane;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		// TODO Implement Main
		HBox root = new HBox();
		root.setSpacing(10);
		root.setPadding(new Insets(10));
		root.prefHeight(500);
		
		ItemLogPane Ilp = new ItemLogPane();
		BarChartPane Bcp = new BarChartPane();
		ControlPane CtrP = new ControlPane();
		
		
		EventManager Em = new EventManager(Bcp,Ilp,CtrP.getCatalogue());
		Em.setUpAddButtonEvent(CtrP.getAddButton(),CtrP.getAmountInputField());
		
		root.getChildren().addAll(CtrP,Bcp,Ilp);
		
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Blacksmith's Inventory Manager");
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public static void main (String [] args) {
		launch(args);
	}
}
