import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class priorityQueue<T> extends Node<T>
{
	private int maxProperty;
	private int Iterator = -1;
	private ArrayList<Node<T>> NodeInQueue;

	public priorityQueue(int n)
	{ 
		if(n < 1) 
		{      
			throw new ArithmeticException("Max Property is possativ");    
		}

		NodeInQueue  = new ArrayList<Node<T>>();
		maxProperty = n;
	}
	public void add(T data , int Property)
	{
		if(Property < 1 || Property > maxProperty)
		{
			Property = maxProperty;
		}
		NodeInQueue.add(new Node<T>(data , Property));
		Collections.sort(NodeInQueue, Comparator.comparing(Node::getPriority));  
	}
	public Node<T> pool()
	{
		try
		{
			return NodeInQueue.get(0);
		}
		catch (Exception e) 
		{
			return null;
		}
	}
	public boolean contains(T data)
	{
		for(int i = 0 ;  NodeInQueue.size() > i ; i++)
		{
			if(NodeInQueue.get(i).getData().equals(data))
			{
				return true;
			}
		}
		return  false;   
	}
	public boolean remove()
	{
		try
		{
			NodeInQueue.remove(0);
			return true;
		}
		catch (Exception e) 
		{
			return false;
		}
	}
	public int size()
	{
		return NodeInQueue.size();
	}
	public void setIterator()
	{
		Iterator = 0;
	}
	@SuppressWarnings("unchecked")
	public <A> T iterator()
	{
		if(Iterator == -1) 
		{      
			throw new ArithmeticException("set Iterator before use");    
		}
		if(Iterator < NodeInQueue.size())
		{
			return (T)NodeInQueue.get(Iterator++).getData();
		}
		return null;
	}
	public String toString()
	{ 
		return NodeInQueue.toString();
	}

}

