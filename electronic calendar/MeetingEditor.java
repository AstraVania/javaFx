
import javax.swing.*;
import java.awt.event.*;

class MeetingEditor implements ActionListener 
{

	private JTextArea textArea;
	private String MeetingInfo;
	private JFrame frame;
	private MeetingsTree bank;
	private int key;
	private final int frameSize = 500;
	private static Boolean open = false;
	
	public MeetingEditor(MeetingsTree storage , String Text , int _key)
	{
		textArea = new JTextArea(Text);
		constract(storage , _key);
	}
	public MeetingEditor(MeetingsTree storage , int _key)
	{
		textArea = new JTextArea();
		constract(storage , _key);
	}
	@SuppressWarnings("deprecation")
	private void constract(MeetingsTree storage , int _key)
	{
		if(open == true)
		{
			return;
		}	
		key = _key;
		bank = storage;
		frame = new JFrame("Meeting editor for "+_key%100+"/"+(_key/100)%100+"/"+_key/10000);
		frame.setDefaultCloseOperation(0);
		JMenuBar menubar = new JMenuBar();
		JMenuItem menuClose = new JMenuItem("Close");
		JMenuItem menuSave = new JMenuItem("Save");
		JMenuItem menuDel = new JMenuItem("Delate");
		menuClose.addActionListener(this);
		menuSave.addActionListener(this);
		menuDel.addActionListener(this);
		menubar.add(menuSave);
		menubar.add(menuClose);
		menubar.add(menuDel);
		frame.setJMenuBar(menubar);
		frame.add(textArea);
		frame.setSize(frameSize, frameSize);
		
		frame.show();
		open = true;
	}
	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand();
		if (s.equals("Save")) 
		{
			MeetingInfo = textArea.getText();			
			bank.addMetting(MeetingInfo);
		}
		else if (s.equals("Close")) 
		{
			MeetingInfo = null;
		}
		else if (s.equals("Delate")) 
		{
			bank.delMetting(key);
		}
		open = false;
		frame.setVisible(false);
	}

}
