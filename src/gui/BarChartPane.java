package gui;

import static javafx.scene.layout.BorderStrokeStyle.SOLID;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class BarChartPane extends VBox {

	private ObservableList<Data<String, Number>> barChartDataList = FXCollections.observableArrayList();;
	
	public BarChartPane () {
		
		// TODO Implements BarChartPane's contructor

		this.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, SOLID, 
		CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setAlignment(Pos.TOP_CENTER);
		this.prefWidth(400);
		this.setPadding(new Insets(10));
		this.setSpacing(10);
		
		this.barChartDataList.add(new XYChart.Data<String,Number>("Wood",0));
		this.barChartDataList.add(new XYChart.Data<String,Number>("Iron",0));
		this.barChartDataList.add(new XYChart.Data<String,Number>("Iron Plate",0));
		this.barChartDataList.add(new XYChart.Data<String,Number>("Iron Sword",0));
		this.barChartDataList.add(new XYChart.Data<String,Number>("Gem",0));
		this.barChartDataList.add(new XYChart.Data<String,Number>("Other",0));
		
		this.getChildren().addAll( createHeaderLabel(),createBarChart());
		
	}
	
	public int addItem(String item, int amount) {

		// TODO Implements addItem(String item, int amount)
		int amountItem = 0;
		for(Data<String, Number> data:barChartDataList) {
			if(data.getXValue() == item) {
				data.setYValue((int)data.getYValue()+amount);
				amountItem = (int)data.getYValue();
				return amountItem;
			}else if(data.getXValue() == "Other") {
				data.setYValue((int)data.getYValue()+amount);
				amountItem = (int)data.getYValue();
			}
		}
		if(amountItem >= 0 ) {
			return amountItem;
		}
		return -1;
	}
	
	public Label createHeaderLabel() {
		
		Label nameChart = new Label();
		nameChart.setText("Item Summary");
		nameChart.setFont(new Font("Ariel",24));
		return nameChart;

	}
	
	public BarChart<String, Number> createBarChart() {
		
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		BarChart<String,Number> bc = new BarChart<String,Number>(xAxis,yAxis);
		xAxis.setLabel("Item");
		yAxis.setLabel("Amount");
		
		XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
		for(Data<String, Number> s: barChartDataList) {
			series.getData().add(s);
		}
		
		bc.getData().add(series);
		bc.setLegendVisible(false);
		
		return bc;

	}
	
}
