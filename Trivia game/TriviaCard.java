import java.util.ArrayList;
import java.util.List;

public class TriviaCard 
{
	private String question;
	private List<Answer> answers  = new ArrayList<>();
	
	public TriviaCard(String _question , List<Answer> _answers)
	{
		question = _question;
		answers = _answers;
	}
	
	public String getQuestion()
	{
		return question;
	}
	public String getAnswerNumber(int answer_num)
	{
		return answers.get(answer_num).getAnswer();
	}
	public boolean isAnswerNumberRight(int answer_num)
	{
		return answers.get(answer_num).isRight();
	}

}
