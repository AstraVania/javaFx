

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;



public class MyProjectController implements Initializable{
	 @FXML
	private Canvas can;
	 @FXML
	private ComboBox<String> box;
	 @FXML
	    private Label progress;
	 @FXML
	    private Label wrongGuess;
	 
	private GraphicsContext deadMan;	
	private final int SIZE = 80;//size of drowning
	private String guessWord;//the word that was not guessed
	private String userOutput = "";//output to user
	private String noInword;//not in the word output to user
	private int newLine;//new line 
	private int wrogGuess;//number of wrong guess
	private final int win = 100;//Define win
	private String userChooses;//latter from user
	private String wordFromBank;//the word form the bank
	private String Temp;
	
	private final String [] ABC = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		deadMan = can.getGraphicsContext2D();
		wordStorage rendomWord = new wordStorage();//get word
		guessWord = rendomWord.getWord();
		
		makehHangMan();//Draw stick
		
	    box.getItems().addAll(ABC); //init list
	   for(int i = 0; i< guessWord.length() ; i++)//make out put to user
	   {
		   userOutput += "_ ";
		   
	   }
	   noInword = "NOT IN THE WORD:\n";
	   wrongGuess.setText(noInword);
	   progress.setText(userOutput);
	   wordFromBank = guessWord;
	   newLine = 0;
	   wrogGuess = 0;
    }
	private void makehHangMan()//Draw the stick
	{
		deadMan.setFill(Color.BLACK);
		deadMan.strokeLine(can.getWidth()/2 + SIZE/2 , SIZE*2, can.getWidth()/2 + SIZE/2, SIZE/2);
		deadMan.strokeLine(can.getWidth()/2 + SIZE/2, SIZE/2 , can.getWidth()/2 + SIZE*4 , SIZE/2);
		deadMan.strokeLine(can.getWidth()/2 + SIZE*4 , SIZE/2 , can.getWidth()/2 + SIZE*4 , SIZE*5.2);
		deadMan.fillRect(can.getWidth()/3 , can.getWidth()/2 + SIZE/2, SIZE*7, SIZE/4);
		
	}
   private void wrongLatterOutPut()//add letters that not in the word
   {
	  
   		newLine++;
   		if(newLine%6 == 0)
   		{
   			noInword  += Temp+"\n";
   		}
   		else
   		{
   			noInword  += Temp+" ";
   		}
   		wrongGuess.setText(noInword );
   }
   
   private void checkAnswer()//Check number of answers and change patern
   {
	   int index = guessWord.indexOf(Temp);//find if char is in string
	   
	   if(index == -1)//not in string
	   {
		   wrongLatterOutPut();//put in table 
		   wrogGuess++;
	   }
	   while(index!=-1)//more then one char
	   {
		   
		   char[] charArray = userOutput.toCharArray();
		   char[] guessWordArray = guessWord.toCharArray();
		   char[] charInWord = Temp.toCharArray();
		   guessWordArray[index] = '_';
		   guessWord = new String(guessWordArray);
		   charArray[index*2] = charInWord[0];
		   userOutput  = new String(charArray);
		   progress.setText(userOutput);	 
		   index = guessWord.indexOf(Temp);
		   String trimGuess = userOutput.replaceAll("\\s","");
		  
		   if(trimGuess.equals(wordFromBank))
		   {
			   wrogGuess = win;
		   }
				   
	   }
	   switch(wrogGuess) {
	   case 0:	  
	     break;
	   case 1:
		   deadMan.setFill(Color.BLACK);
		   deadMan.fillOval( can.getWidth()/2, SIZE*2, SIZE, SIZE);
	     break;
	   case 2:
		   deadMan.strokeLine(can.getWidth()/2 + SIZE/2 , SIZE*2, can.getWidth()/2 + SIZE/2, SIZE*4);
		   break;
	   case 3:
		   deadMan.strokeLine(can.getWidth()/2 + SIZE/2 , SIZE*3.3, can.getWidth()/2 -SIZE/4, SIZE*3);
		   break;
	   case 4:
		   deadMan.strokeLine(can.getWidth()/2 + SIZE/2 , SIZE*3.3, can.getWidth()/2 +(SIZE/4)*5, SIZE*3);
		   break;
	   case 5:
		   deadMan.strokeLine(can.getWidth()/2 + SIZE/2 , SIZE*2, can.getWidth()/2 + SIZE/2, SIZE*4);
		   break;
	   case 6:
		   deadMan.strokeLine(can.getWidth()/2 + SIZE/2, SIZE*4, can.getWidth()/2 +(SIZE/4)*5, SIZE*5);
		   break;
	   case 7 :
		   deadMan.strokeLine(can.getWidth()/2 + SIZE/2, SIZE*4, can.getWidth()/2 -SIZE/4, SIZE*5);
		   break;
	   case 8 :
		   progress.setText("YOU LOST TRY AGAIN");
		   box.setVisible(false);
		   noInword +="\nWord is " + wordFromBank;
		   wrongGuess.setText(noInword );
		   break;
	   case 100 :
		   progress.setText("YOU WIN START OVER");
		   box.setVisible(false);
		   noInword +="\nWord is " + wordFromBank;
		   wrongGuess.setText(noInword );
		   break;
	   default:
		 
	 }
   }
    @FXML
    void Start_Over(ActionEvent event) //star game over
    {
    	deadMan.clearRect(0, 0, can.getWidth(), can.getHeight());
    	box.getItems().removeAll(ABC);
    	box.setVisible(true);
    	userOutput = "";
    	initialize(null, null) ;
    }
  
    @FXML
    void useGuess(ActionEvent event) //get user input
    {
    	userChooses = box.getValue();
    	Temp = new String(userChooses);
        if (userChooses != null) 
        {  	   
         	    checkAnswer();
           
        }
        
    }


}
