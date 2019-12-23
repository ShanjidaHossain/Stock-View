package com.hossainshanjida.stocks.fxml;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StockMain extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("StockView.fxml"));
			stage.setTitle("Stock View");
			
			Scene scene = new Scene(root);
			stage.setScene(scene);
			
			/* Based on this code the filename.css should be in the same package */
			URL url = this.getClass().getResource("stock.css");
			
			if (url == null) {
				System.out.println("Resource not found. Aborting");
				System.exit(-1);
			}			
			
			String css = url.toExternalForm();
			scene.getStylesheets().add(css);
			stage.setResizable(false);
			stage.show();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		Application.launch(StockMain.class, args);
	}

}
