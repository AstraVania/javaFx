
public class Node<T> 
{

	private T data;
	private int priority;
	protected Node()
	{

	}	
	protected Node(T data , int priority)
	{
		this.data = data;
		this.priority = priority;
	}
	protected int getPriority()
	{
		return priority;
	}
	public String toString()
	{ 
		return data+" "+priority;
	}
	protected Object getData()
	{
		return data;
	}
}
