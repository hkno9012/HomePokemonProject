package poke.model;

public class Chimchar extends Pokemon implements Fire
{
	public Chimchar()
	{
		super(390, "Chimchar");
	}
	
	public Chimchar(String name)
	{
		super(390, name);
	}
	
	public Chimchar(int number, String name)
	{
		super(number, name);
	}
	
	public int flamethrower()
	{
		int damage = 3;
		return damage;
	}
	
	public boolean will_o_wisp()
	{
		boolean isBurned = true;
		return isBurned;
	}
}