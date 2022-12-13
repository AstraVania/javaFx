import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TriviaFromFile extends FileHandler
{
	
	private List<TriviaCard> triviaCards = new ArrayList<>();

	public TriviaFromFile()
	{
		super.readFromFile();
		setTrivaia();
	}
	private void setTrivaia() 
	{
		
		for(String question = getLineFromFile() ; question!=null ;question = getLineFromFile())
		{
			List<Answer> answers = new ArrayList<>();
			answers.addAll(Arrays.asList(new Answer(getLineFromFile() , true), new Answer(getLineFromFile() , false) , new Answer(getLineFromFile() , false),new Answer(getLineFromFile() , false)));
			Collections.shuffle(answers);
			triviaCards.add(new TriviaCard (question , answers));
			Collections.shuffle(triviaCards);
			
		}


	}
    public List<TriviaCard> getTrivaiaCards()
    {
    	return triviaCards;
    }
	public void finishTrivia()
	{
		super.closeFile();
	}

}
