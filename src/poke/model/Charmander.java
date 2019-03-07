package poke.model;

public class Charmander extends Pokemon implements Fire
{
	public Charmander()
	{
		super(4, "Charmander");
	}
	
	public Charmander(String name)
	{
		super(4, name);
	}
	
	public Charmander(int number, String name)
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