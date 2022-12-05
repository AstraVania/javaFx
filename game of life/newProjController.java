
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class newProjController {

    @FXML
    private Canvas can;
    
    private static final int SIZE = 10;
    private static final int ALIVE = 1;
    private MetrixOfLiving livingGame;
    private GraphicsContext alive;
    @FXML
    void button(ActionEvent event) 
    {
    	alive.clearRect(0, 0, can.getWidth(), can.getHeight());//clean canvas
    	livingGame.setMetrix();//set next gen
    	newGen();
   	}
    	
         
    
    public void initialize() 
    {
       
    	livingGame =  new MetrixOfLiving();//make first gen
    	alive = can.getGraphicsContext2D();
    	newGen();  	
    }
    
   
		
	 private void newGen()//drow the metrix and fill whit color in alive cell
    {
    	for(int i = 0; i<SIZE ; i++)
    	{
    		for(int j = 0 ; j<SIZE ; j++)
    		{
    			if(livingGame.getLive(i, j) == ALIVE)
    			{
   				     alive.setFill(Color.BLACK);
    				 alive.fillRect(j*60, i*60, 60, 60);
    				 alive.setFill(Color.GREEN);
    				 alive.fillRect(j*60+0.5, i*60+0.5, 59, 59);
    			}
    			else    				
    			{    	
    				alive.strokeRect(j*60, i*60, 60, 60);
    			}
    		   
    		}
    	}
    }
}
    

