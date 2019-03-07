package poke.model;

public class Totodile extends Pokemon implements Water
{
	public Totodile()
	{
		super(158, "Totodile");
	}
	
	public Totodile(String name)
	{
		super(158, name);
	}
	
	public Totodile(int number, String name)
	{
		super(number, name);
	}
	
	public int waterPulse()
	{
		int damage = 3;
		return damage;
	}
	
	public boolean aquaRing()
	{
		boolean isProtected = true;
		return isProtected;
	}
}