public class Answer 
{
	  private String answer;
	  private boolean right;
	  
      public Answer(String _answer , boolean _right)
      {
    	  answer= _answer;
    	  right =_right;
      }
      public String getAnswer()
      {
    	  return answer;
      }
      public boolean isRight()
      {
    	  return right;
      }
}
