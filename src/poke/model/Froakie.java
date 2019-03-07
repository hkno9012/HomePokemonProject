package poke.model;

public class Froakie extends Pokemon implements Water
{
	public Froakie()
	{
		super(656, "Froakie");
	}
	
	public Froakie(String name)
	{
		super(656, name);
	}
	
	public Froakie(int number, String name)
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