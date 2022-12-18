import java.util.TreeMap;

public class MeetingsTree 
{
	private TreeMap<Integer, String> meetingStorage = new TreeMap<>();
	private int keyDate = 0;

	public void addMetting(String detail)
	{
		meetingStorage.put(keyDate, detail);
	}	
	public void saveKey(int key)
	{
		keyDate = key;
	}
	public boolean findMeeting(int key)
	{
		return meetingStorage.containsKey(key);
	}
	public String getMetting(int key)
	{
		return meetingStorage.get(key);
	}
	public void delMetting(int key)
	{
		meetingStorage.remove(key);
	}
}
