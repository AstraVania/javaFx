import java.util.Calendar;  
import static java.util.Calendar.DAY_OF_WEEK;   
import static java.util.Calendar.LONG;
import static java.util.Calendar.SHORT; 
import static java.util.Calendar.JANUARY;  
import static java.util.Calendar.SATURDAY;
import static java.util.Calendar.DECEMBER;
import static java.util.Calendar.SUNDAY;
import static java.util.Calendar.MONTH; 
import java.util.Locale;

import static java.util.Calendar.DAY_OF_MONTH;  
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;


public class CalendarController {


	@FXML
	private GridPane calendar_interface;

	@FXML
	private ComboBox<String> monthBox ,yearBox;
	private int GridNum = 0;
	final private int ROWS = 7 ,COLUMNS = 7 ,YEAR_RANGE = 20;
	private Button [] btns = new Button[ROWS*COLUMNS];
	private MeetingsTree Storage = new MeetingsTree();
	public void initialize() 
	{ 
		Calendar setBoX = Calendar.getInstance();
		for (int month = JANUARY; month <= DECEMBER; month++) 
		{  	
			setBoX.set(MONTH, month);
			monthBox.getItems().add(setBoX.getDisplayName(MONTH, LONG, Locale.US));
		}
		setBoX = Calendar.getInstance();
		monthBox.setValue(setBoX.getDisplayName(MONTH, LONG, Locale.US)); 

		for (int minYear = setBoX.get(Calendar.YEAR) - YEAR_RANGE ,maxYear = minYear +YEAR_RANGE*2 ; minYear < maxYear; minYear++) 
		{  	
			yearBox.getItems().add(minYear+"");
		}
		yearBox.setValue(setBoX.get(Calendar.YEAR)+"");
		for (int day = SUNDAY; day <= SATURDAY; day++ ,GridNum++) 
		{  		
			setBoX.set(DAY_OF_WEEK, day);
			setButtonMetrix(setBoX.getDisplayName(DAY_OF_WEEK, SHORT, Locale.US));

		}
		setBoX = Calendar.getInstance();
		setCalendarOutPut(setBoX.get(Calendar.YEAR) , setBoX.get(MONTH));	
	}
	private void setButtonMetrix(String TextOnCell)
	{
		btns[GridNum] = new Button(TextOnCell);
		btns[GridNum].setPrefSize(calendar_interface.getPrefWidth()/(COLUMNS+2.35), calendar_interface.getPrefHeight()/(ROWS));
		calendar_interface.add(btns[GridNum], GridNum%ROWS, GridNum/(COLUMNS));
	}
	private void handleButton(ActionEvent event)
	{
		int id = getid(Integer.valueOf(((Button)event.getSource()).getText()));
		Storage.saveKey(id);		
		if (Storage.findMeeting(id))
		{
			@SuppressWarnings("unused")
			MeetingEditor editor  = new MeetingEditor(Storage , Storage.getMetting(id) , id);
		}
		else
		{
			@SuppressWarnings("unused")
			MeetingEditor editor = new MeetingEditor(Storage , id);

		}

	}
	private void setCalendarOutPut(int year , int month)
	{
		Calendar setCal = Calendar.getInstance();
		setCal.set(year, month,1);

		for(int dayOfWeeK = 0;  btns[dayOfWeeK].getText() != setCal.getDisplayName(DAY_OF_WEEK, SHORT, Locale.US) ; GridNum++,dayOfWeeK++ )
		{
			setButtonMetrix("");

		}
		for(int dayOfMonth = 1 , maxDayInMonth = setCal.getActualMaximum(DAY_OF_MONTH) ; dayOfMonth <= maxDayInMonth ; dayOfMonth++ ,GridNum++ )
		{

			setButtonMetrix((dayOfMonth)+"");
			if(Storage.findMeeting(getid(Integer.valueOf(btns[GridNum].getText()))))
			{
				btns[GridNum].setStyle("-fx-background-color: Green");
			}
			btns[GridNum].setOnAction(new EventHandler<ActionEvent>() 
			{
				@Override
				public void handle(ActionEvent event) 
				{
					handleButton(event);

				}
			});
		}      

	}
	void changeCalendar()
	{
		for(int i = 7 ; i < btns.length ; i++)
		{
			calendar_interface.getChildren().removeAll(btns[i]);
		}
		GridNum= 7;
		setCalendarOutPut(Integer.valueOf(yearBox.getValue()) , monthBox.getItems().indexOf(monthBox.getValue()));

	}
	private int getid(int buttonNum)
	{
		return ((Integer.valueOf(yearBox.getValue())*100 + monthBox.getItems().indexOf(monthBox.getValue()) + 1)*100)+ buttonNum;
	}

	@FXML
	void getCalendar() 
	{
		changeCalendar();
	}


}




