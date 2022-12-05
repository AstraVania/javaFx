import java.util.Random;

public class MetrixOfLiving 
{

	
	private static final int size = 10;
	private LivingSpace [][] livingMetrix = new LivingSpace[size][size];
	private final Random random = new Random();
	
	public MetrixOfLiving()//Matrix contractor make random life and set status for next gen
	{
		for(int i = 0 ; i <size ; i++)
		{
			for(int j = 0 ; j <size ; j++)
			{
				livingMetrix[i][j] = new LivingSpace();
				livingMetrix[i][j].firestLiving(random.nextInt(size+1));//its batter it was 1 but its not working whit 1 so form 0-11 the number of odd equal to not odd
			}
		}
		lookForNeighbors();	
	}
	
	public int getLive(int row , int col)//return life status at cell
	{
		return livingMetrix[row][col].IsAlive();
	}
	
	public void setMetrix()//setting life status in new gen and determining next
	{
		for(int i = 0 ; i <size ; i++)
		{
			for(int j = 0 ; j <size ; j++)
			{
				livingMetrix[i][j].setLiving();
			}
		}
		lookForNeighbors();
	}
	public void lookForNeighbors()//looking for number of neighbors first in corners then in sides then inside its better to make 11*11 matrix so the function in essayer
	{
		livingMetrix[0][0].setNextGen(livingMetrix[0][1].IsAlive() + livingMetrix[1][1].IsAlive() + livingMetrix[1][0].IsAlive() ); //corners
		livingMetrix[0][9].setNextGen(livingMetrix[0][8].IsAlive() + livingMetrix[1][9].IsAlive() + livingMetrix[1][8].IsAlive() );
		livingMetrix[9][0].setNextGen(livingMetrix[8][0].IsAlive() + livingMetrix[9][1].IsAlive() + livingMetrix[8][1].IsAlive() );
		livingMetrix[9][9].setNextGen(livingMetrix[9][8].IsAlive() + livingMetrix[8][8].IsAlive() + livingMetrix[8][9].IsAlive() );
		for(int i = 1 ; i <size-1 ; i++)
		{
			livingMetrix[i][0].setNextGen(livingMetrix[i+1][1].IsAlive() + livingMetrix[i][1].IsAlive() + livingMetrix[i+1][1].IsAlive() + 
					                      livingMetrix[i+1][0].IsAlive() + livingMetrix[i-1][0].IsAlive()); //left side
			
			livingMetrix[i][9].setNextGen(livingMetrix[i-1][8].IsAlive() + livingMetrix[i][8].IsAlive() + livingMetrix[i+1][8].IsAlive() + 
										  livingMetrix[i+1][9].IsAlive() + livingMetrix[i-1][9].IsAlive()); //right side
		
			livingMetrix[0][i].setNextGen(livingMetrix[1][i-1].IsAlive() + livingMetrix[1][i].IsAlive() + livingMetrix[1][i+1].IsAlive() + 
                    					  livingMetrix[0][i-1].IsAlive() + livingMetrix[0][i+1].IsAlive()); //up side
			
			livingMetrix[9][i].setNextGen(livingMetrix[8][i-1].IsAlive() + livingMetrix[8][i].IsAlive() + livingMetrix[8][i+1].IsAlive() + 
									  livingMetrix[9][i-1].IsAlive() + livingMetrix[9][i+1].IsAlive());//down side
		
			for(int j = 1 ; j<size -1 ;j++)//inside
			{
					livingMetrix[i][j].setNextGen(livingMetrix[i][j+1].IsAlive() + livingMetrix[i][j-1].IsAlive() + livingMetrix[i-1][j].IsAlive() + 
											  		livingMetrix[i+1][j].IsAlive() + livingMetrix[i-1][j-1].IsAlive()+ livingMetrix[i+1][j+1].IsAlive()+ 
											  		livingMetrix[i-1][j+1].IsAlive() + livingMetrix[i+1][j-1].IsAlive()); 
			}
		}				
	}
	
}
