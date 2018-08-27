package com.demo.quizbee.javafx;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class QAPane {
   private RadioButton[] rbAr;
   private VBox qaPane;
   public static int finalScore;

   QAPane(QA qa){
	   qaPane = new VBox();
	   
	   Button submit= new Button("That's my answer");
	   Label question = new Label(qa.getQuestion());
	   question.setPrefWidth(800);
	   question.setWrapText(true);
	   question.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
	   
	   Label explanation = new Label("Explanation:"+qa.getExplanation());
	   explanation.setPrefWidth(800);
	   explanation.setWrapText(true);
	   explanation.setFont(Font.font("Verdana", 15));
	   explanation.setTextFill(Color.GRAY);
	   explanation.setVisible(false);
	   String judge = "Wrong";
	   Text judgement = new Text(judge);
	   judgement.setFill(Color.RED);
	   judgement.setVisible(false);
	   judgement.setFont(Font.font("Verdana", 20));
	   
	    VBox answersBox= new VBox();
	   answersBox= getAnswerPane(qa.getAnswers());
	   
	   qaPane.setPadding(new Insets(0,0,0,70));
	   VBox.setMargin(question, new Insets(0,0,20,0));
	   VBox.setMargin(submit, new Insets(20,0,20,500));
	   qaPane.setSpacing(10);
	   
	   rbAr= new RadioButton[answersBox.getChildren().size()];
	   for(int i=0;i<answersBox.getChildren().size();i++) {
		   rbAr[i]= (RadioButton) answersBox.getChildren().get(i);
	   }
	   
	   submit.setOnAction(actionEvent->{
		   if(getRadioButtonSelected(rbAr)>=0) {
		   explanation.setVisible(true);
		   for(RadioButton rb:rbAr) {
			   rb.setDisable(true);
		   }
		   submit.setDisable(true);
		   
		  if(qa.getCorrectAnswerNumber()==getRadioButtonSelected(rbAr)) {
			  qa.setResult(true);
			  finalScore++;
			  judgement.setText("Right");
			  judgement.setFill(Color.GREEN);
		  }
		  judgement.setVisible(true);
		  if((FileUtils.getQAArray().length-1)==Controls.currentQuestion) {
			  Controls.getSummarizes(finalScore, FileUtils.getQAArray());
		  }
		  
		 ((HBox)((BorderPane)Controls.getStage().getScene().getRoot()).getBottom()).getChildren().get(0).setDisable(false);;
		 
	   }});
	   
	   qaPane.getChildren().add(question);
	   qaPane.getChildren().add(answersBox);
	   qaPane.getChildren().add(submit);
	   qaPane.getChildren().add(explanation);
	   qaPane.getChildren().add(judgement);
	   
   }
   VBox getAnswerPane(String[] answers) {
	   VBox answerPane = new VBox();
	   final ToggleGroup group = new ToggleGroup();
	    for(int i=0;i<answers.length;i++) {
	    	 RadioButton rb1 = new RadioButton(answers[i]);
	    	    rb1.setToggleGroup(group);
	    	    rb1.setUserData(i);
	    	    rb1.setFont(Font.font("Arial", FontWeight.BOLD, 14));
	    	    answerPane.getChildren().add(rb1);
	    	    answerPane.setSpacing(10);
	    }
	   return answerPane;
   }
	int getRadioButtonSelected(RadioButton[] rbAr) {
		      int myAnswer =0;
		for(int i=0;i<rbAr.length;i++) {
			if(rbAr[i].isSelected()) {
				myAnswer=i;
				break;
			}
			else {
				myAnswer=-1;
			}
		}
		return myAnswer;
	}
   private void setQAPane(VBox vb) {this.qaPane = vb;}
   public VBox getQAPane() {return qaPane;}
}
