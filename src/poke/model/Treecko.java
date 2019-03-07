package poke.model;

public class Treecko extends Pokemon implements Grass
{
	public Treecko()
	{
		super(252, "Treecko");
	}
	
	public Treecko(String name)
	{
		super(252, name);
	}
	
	public Treecko(int number, String name)
	{
		super(number, name);
	}
	
	public int gigaDrain()
	{
		int damage = 3;
		return damage;
	}
	
	public boolean sleepPowder()
	{
		boolean isAsleep = true;
		return isAsleep;
	}
}