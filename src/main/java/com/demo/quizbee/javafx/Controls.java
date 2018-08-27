package com.demo.quizbee.javafx;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Controls {
	/**** Generic Menu/Menu Item Properties ****/
	private static MenuItem mnuItm;
	private static Menu mnu;
	
	public static Stage stage;
	public static int currentQuestion = 0;

	/***************** MenuBar *****************/
 
	public static MenuBar getMenuBar(Stage primaryStage) {
		setStage(primaryStage);
		MenuBar menuBar = new MenuBar();
	    menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
	    menuBar.getMenus().addAll(getMnuFile(),getMnuSettings(),getMnuHelp());
		return menuBar;
		
	}
	
	/******************* Menu ******************/

	private static Menu getMnuFile() {
    	 Menu fileMenu = new Menu("File");
    	 fileMenu.getItems().addAll(getMnuItmNewGame(), 
 	            new SeparatorMenuItem(), getMnuItmExit());
    	
		return fileMenu;
    	
    }

	private static Menu getMnuSettings() {
	   	 Menu settingsMenu = new Menu("Settings");
	   	settingsMenu.setDisable(true);
			return settingsMenu;
	   }
 
	private static Menu getMnuHelp() {
	   	 Menu helpMenu = new Menu("Help");
	   	 helpMenu.getItems().add(getMnuItmAbout());
			return helpMenu;
	   }
	
	/***************** MenuItems *****************/

    private static MenuItem getMnuItmNewGame() {
    	MenuItem newMenuItem = new MenuItem("New Game");
    	newMenuItem.setOnAction(actionEvent->{
    		currentQuestion=0;
    		QAPane.finalScore=0;
    		FileUtils.setQAArray("C:/TriviaTime/ComputerTrivia_Java100.trivia", 7);
    		HBox nextQuestion = new HBox();
    		 
    		nextQuestion=getNextQuestionPane();
    		nextQuestion.setPrefHeight(100);
    		nextQuestion.setAlignment(Pos.CENTER_RIGHT);
    		((BorderPane)getStage().getScene().getRoot()).setBottom(nextQuestion);
    		getQaVbox(0);
  	
    		VBox lBufLeft = new VBox();
    		lBufLeft.setPrefWidth(100);
    		((BorderPane)getStage().getScene().getRoot()).setLeft(lBufLeft);
    		
    		VBox lBufRight = new VBox();
    		lBufRight.setPrefWidth(100);
    		((BorderPane)getStage().getScene().getRoot()).setRight(lBufRight);

    		
    	} );
		return newMenuItem;
    	
    }

	private static boolean getQaVbox(int i) {
		QA[] qaAr = new QA[FileUtils.getQAArray().length];
		qaAr=FileUtils.getQAArray();
		QAPane qaPane = new QAPane(qaAr[i]);
		VBox qaVbox = new VBox();
		qaVbox=qaPane.getQAPane();
		qaVbox.setAlignment(Pos.CENTER_LEFT);
		((BorderPane)getStage().getScene().getRoot()).setCenter(qaVbox);
		boolean stopFlag = false;
		if(i==(qaAr.length-1)) {
			stopFlag=true;
		}
			
		return  stopFlag;
	}

	public static void getSummarizes(int score,QA[] qaAr) {
 
		VBox sumarizeVbox = new VBox();
		Label finalScore = new Label("FinalScore "+Integer.toString(score));
		finalScore.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
		sumarizeVbox.getChildren().add(finalScore);
		sumarizeVbox.setSpacing(20);
		for(int i=0;i<qaAr.length;i++) {

			Label lbel = new Label("Question"+Integer.toString(i+1)+":"+(qaAr[i].isCorrect()?"Right":"Wrong"));
			lbel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
			sumarizeVbox.getChildren().add(lbel );
			
		}
		sumarizeVbox.setAlignment(Pos.CENTER_LEFT);
		((BorderPane)getStage().getScene().getRoot()).setCenter(sumarizeVbox);
	}

    private static MenuItem getMnuItmExit() {
    	 MenuItem exitMenuItem = new MenuItem("Exit");
    	 exitMenuItem.setOnAction(actionEvent -> Platform.exit());
  		return exitMenuItem;
      	
      }
	private static MenuItem getMnuItmAbout() {
		/* From Marco Jakob, code.makery, */
		/* http://code.makery.ch/blog/javafx-dialogs-official/ */
		mnuItm = new MenuItem("About");
		mnuItm.setOnAction((ActionEvent e) -> {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("About");
			alert.setHeaderText("About Trivia Time");
			alert.setContentText("Author: Quizbee");
			alert.showAndWait();
		});
		return mnuItm;
	}
	
	public static void setStage(Stage s) {stage= s;}
	static Stage getStage() {return stage;}

	static HBox getNextQuestionPane() {
		HBox hbox = new HBox();
		Button button = new Button("Next Question");
		button.setDisable(true);
		HBox.setMargin(button, new Insets(50,100,50,100));
		button.setOnAction(actionEvent->{
			currentQuestion++;
			if(getQaVbox(currentQuestion)) {
				button.setVisible(false);
			}
			
			button.setDisable(true);
		});
		hbox.getChildren().add(button);
		return hbox;
		
	}
}
