

public class LivingSpace {


	private static final int BIRTH = 0;
	private static final int DEATH = 1;
	private static final int EXISTENCE = 2;
	private static final int DEAD = 0;
	private static final int ALIVE = 1;
	private static final int OVERPOPULATION = 4;
	private static final int LONELY = 1;
	private static final int LIFE = 3;
	
	private int alive;
	private int nextLifeState;
	
	LivingSpace()
	{
		//empty contractor
	}

	
	public int IsAlive()//return if cell is alive
	{
		return this.alive;
	}
	
		
	public void firestLiving(int state)//init at first run cell state dead or alive
	{
		if(state%EXISTENCE == BIRTH)
		{
			this.alive = ALIVE;
		}
		else
		{
			this.alive = DEAD;
		}
	}
	
	public void setLiving()//set dead or alive for next gen
	{
		if(this.nextLifeState == BIRTH)
		{
			this.alive = ALIVE;
		}
		if(this.nextLifeState == DEATH)
		{
			this.alive = DEAD;
		}
		if(this.nextLifeState == EXISTENCE)
		{
			return;
		}
	}
	public void setNextGen(int neighbors)//COUNT neighbors and set status for next gen
	{
		if(this.alive == DEAD && neighbors == LIFE)
		{
			this.nextLifeState = BIRTH;
		}
		else if(this.alive == ALIVE && neighbors <= LONELY || this.alive == ALIVE && neighbors >= OVERPOPULATION)
		{
			this.nextLifeState = DEATH;
		}
		else
		{
			this.nextLifeState = EXISTENCE;
		}
				
	}
}
