package application;
	


import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private Stage primaryStage;
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		mainWindow();
		
		}
	

	public void mainWindow() {
		try{
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("Main.fxml"));
			AnchorPane pane =loader.load();
			
			primaryStage.setMinHeight(900);
			primaryStage.setMinWidth(1600);
			
			MainWindowController MainWindowController = loader.getController();
			
			
			Scene scene =new Scene(pane);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		}catch(IOException e) {
			//T0D0 Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		
		
		
	
		
		launch(args);
		
		
	}
}
