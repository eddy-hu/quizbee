package com.demo.quizbee.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class QuizbeeJavaFXApplication extends Application {

	private static BorderPane rootPane;
	
	@Override
	public void start(Stage primaryStage){	
	   // Display Splash Screen
	   setRootPane("Welcome to Quizbee");
	   getRootPane().setTop(Controls.getMenuBar(primaryStage));
	   Scene scene =  new Scene(getRootPane(), 1024, 512);
	   primaryStage.setTitle("Quizbee");
	   primaryStage.setScene(scene);
	   primaryStage.show();	
	}
	
	public static void main(String[] args){
		Application.launch(args);
	}
	void setRootPane(String welcomeString){
		rootPane = new BorderPane();
		Text splashscreen = new Text(welcomeString);
		splashscreen.setFont(Font.font ("Verdana", 40));;
		rootPane.setCenter(splashscreen);
	}
	 BorderPane getRootPane(){
		return rootPane;
	}
}