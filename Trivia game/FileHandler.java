import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

abstract public class FileHandler 
{
	Scanner input;
	protected void readFromFile() 
	{
		try {
		      File myObj = new File("trivia.txt");
		       input = new Scanner(myObj);
		   
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	protected String getLineFromFile()
	{
		   if(input.hasNextLine()) 
		   {
		        String data = input.nextLine();
		        return data;
		   }
		   return null;
	}
	protected void closeFile()
	{
		 input.close();
	}

}
