import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public class TriviaController  
{ 
		@FXML
		private Button NextButton;
	    @FXML
	    private Text answer1, answer2 , answer3 , answer4 ,question;
	    @FXML
	    private Label Score;
	    private int cardNumber = -1;       
		private List<TriviaCard> TriviaDeck = new ArrayList<>();
		private int scoreCounter;
		private int deckSize;
		private boolean click;
		 public void initialize() 
		 {
			 	  click = false;
			      scoreCounter = 0;
			      Score.setText("Score: " + scoreCounter);
			      TriviaFromFile  newTrivia = new TriviaFromFile();
			      TriviaDeck = newTrivia.getTrivaiaCards();	
			      deckSize =  TriviaDeck.size();
			      nextCard();	        						
		 }
		 @FXML
		 void clickInput(MouseEvent event) 
		 {
			 if(!click)
			 {
			 int answerNumber = 0;
			 Point2D click = new Point2D(event.getX(),event.getY());		
			 Text userInput = new Text();
			 if(answer1.getBoundsInParent().contains(click))
			 {
				 userInput = answer1;
				 answerNumber = 1;
				 
			 }
			 else if(answer2.getBoundsInParent().contains(click))
			 {
				 answerNumber = 2;
				 userInput = answer2;
			 }
			 else if(answer3.getBoundsInParent().contains(click))
			 {
				 answerNumber = 3;
				 userInput = answer3;
			 }
			 else if(answer4.getBoundsInParent().contains(click))
			 {
				 answerNumber = 4;
				 userInput = answer4;
			 }
			 chekcAnswer(answerNumber-1 , userInput);
			 }
			
		 }

		 void nextCard()
		 {
			 if(cardNumber<deckSize -1)
			 {	 
			  cardNumber++;
			  question.setText(TriviaDeck.get(cardNumber).getQuestion());
		      answer1.setText(TriviaDeck.get(cardNumber).getAnswerNumber(0));
		      answer2.setText(TriviaDeck.get(cardNumber).getAnswerNumber(1));
		      answer3.setText(TriviaDeck.get(cardNumber).getAnswerNumber(2));
		      answer4.setText(TriviaDeck.get(cardNumber).getAnswerNumber(3));
		      answer1.setFill(Color.BLACK);
		      answer2.setFill(Color.BLACK);
		      answer3.setFill(Color.BLACK);
		      answer4.setFill(Color.BLACK);		      
			 }
			 else
			 {
				 click = true;
				 question.setText("No more question start over");
			 }
			 NextButton.setVisible(false);
		 }
		 void chekcAnswer(int answerNumber , Text clickedAnswer)
		 {		
			 
			 if(TriviaDeck.get(cardNumber).isAnswerNumberRight(answerNumber))
			 {
				 clickedAnswer.setFill(Color.GREEN);
				 scoreCounter += 10;
			 }
			 else
			 {
				 clickedAnswer.setFill(Color.RED);

				 scoreCounter -= 5;
			 }
			 NextButton.setVisible(true);
			 click = true;
			 Score.setText("Score: " + scoreCounter);
				 
		 }
		 @FXML
		    void Next_question(ActionEvent event) 
		 {
			 click = false;
			 nextCard();
		 }
		 @FXML
		 void NewGame(ActionEvent event) 
		 {
			 initialize();
		 }

	 }
      
    

    	 


