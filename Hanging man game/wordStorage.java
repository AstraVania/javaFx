
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;


public class wordStorage 
{

private String rendomWard;

  public wordStorage() 
  {
	  randomWordFromFile();
  }
  
  private String getWord()//get the random word the where chosen
  {
	  return rendomWard;
  }
  private void randomWordFromFile()
  {
	  long lines = 0;
	  final Random random = new Random();
	  try {

		  Path path = Paths.get("wordbank.txt");
	      lines = Files.lines(path).count();
	      rendomWard = Files.readAllLines(Paths.get("wordbank.txt")).get(random.nextInt((int)lines));//count number of lines and find rend word
	      
	      } 
	      catch (IOException e) 
	      {
	    	  System.out.println("FILE NOT FOUND");	      
	      }
  }
  }

