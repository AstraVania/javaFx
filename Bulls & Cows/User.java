//user class to hold all the info that user need in the game progression
public class User 
{
	private String input;
	private int input_guess;
	private int  bulls;
    private int  cows ;
    
    public User(int input_guess,String input ,int  bulls , int  cows  )
    {
    	this.input = input;
    	this.input_guess = input_guess;
    	this.bulls = bulls;
    	this.cows = cows;  
    }
    public String getInputNum()
    {
    	return input;
    }
    public int getInputGus()
    {
    	return input_guess;
    }
    public int getBull()
    {
    	return bulls;
    }
    public int getCow()
    {
    	return cows;
    }
}
