
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class MyProjectController implements Initializable 
{
	
    private final Random random = new Random();
    private int [] userArr = new int[4];
    private int guessCount = 0;
    private int [] numberArr = new int[]{-1,-2,-3,-4};
    private int  bull = 0;
    private int  cow ;
    
    @FXML
    private TableView<User> score;
    @FXML
    private TableColumn<User, Integer> guess_num;
    @FXML
    private TableColumn<User, String> input;
    @FXML
    private TableColumn<User, Integer> Bulls;
    @FXML
    private TableColumn<User, Integer> Cows;
    @FXML
    private TextField guess;
    @FXML
    private Text guessCounterText;
    @FXML
    private Button Start_over;
    @FXML
    private Button exit;
    

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) 
    {
    	guess_num.setCellValueFactory(new PropertyValueFactory<User, Integer>("InputGus"));
    	input.setCellValueFactory(new PropertyValueFactory<User, String>("InputNum"));//init table
    	Cows.setCellValueFactory(new PropertyValueFactory<User, Integer>("cow"));
    	Bulls.setCellValueFactory(new PropertyValueFactory<User, Integer>("bull")); 	
    	guessCounterText.setText(" ");
    	ObservableList<User> list = FXCollections.observableArrayList();
    	score.setItems(list);
    	makeNum();
    }

    @FXML
    void checkGuess(ActionEvent event) 
    {
    	bull = 0;
    	cow = 0;
    	if((guess.getText()).length() != userArr.length) //check valid length
    	{
    		guessCounterText.setText("invilde string lenth try again");
    		return;
    	}
    	try
        {
    		userArr[userArr.length - 1] = Integer.parseInt(guess.getText());//check if its number
        } catch (NumberFormatException ex)
        {
        	guessCounterText.setText("Its not a number try again");
        	return;
        }
    	for (int i = 0 , j = 1000; i < userArr.length - 1; i++ , j/=10) //Subtract the number by 10 to get every number
    	{
    		userArr[i] = userArr[ userArr.length - 1]/j;
        	userArr[ userArr.length - 1]%=j;
        	if(userArr[i] == numberArr[i])//count bulls on the way 
        	{
        		bull++;
        	}
    	}   	
    	if(isDuplicate(userArr))
    	{	
    		guessCounterText.setText("Duplicate is found try again");
    		return;
    	}    	
    	if(userArr[userArr.length-1] == numberArr[numberArr.length-1])//last bull
    	{
    		bull++;
    	}
    	for(int i = 0 ; i < userArr.length ; i++)//find how cows 
    	{
    		for(int j = 0 ; j < userArr.length  ; j++ )
    		{
    			if(i != j && userArr[i] == numberArr[j] )
    			{
    				cow++;
    			}
    		}
    	}
    	guessCount++;
    	User user = new User(guessCount , guess.getText()  ,bull ,cow );//make a line in table
    	score.getItems().add(user); //add the line
        if(bull == 4)//go to win state
        {
        	guessCounterText.setText("You Won in " + guessCount + " Guesses");
        	exit.setVisible(true);
        	guess.setVisible(false);
        	Start_over.setVisible(true);
        }
    }
   //reset table ,cow bulls and new number
    @FXML
    private void reset(ActionEvent event) 
    {
    	guess.setVisible(true);
    	score.getItems().clear();
        guessCount = 0;
        bull = 0;
    	cow = 0;
    	makeNum();
        guessCounterText.setText(" ");
       
    }
    @FXML
    private void exit(ActionEvent event) 
    {	
    	System.exit(0);
    }
    //check if for duplicate in number 
    private Boolean isDuplicate(int arr[])
    {
    
            if(arr[0] == arr[1] ||arr[0] == arr[2] || arr[0] == arr[3]||
               arr[1] == arr[2]	|| arr[1] ==arr[3] || arr[2] == arr[3])
            {
            		return true;
            
            }
            else
            {
            	   return false;
            }
          
    }
    //make a four dig number that whit no repeats
    private void makeNum()
    {
    	for (int i = 0; i < numberArr.length; i++) 
    	{
    		numberArr[i] = random.nextInt(9);
            if(isDuplicate(numberArr))
            {
            	i--;
            }
    	} 
    }
}