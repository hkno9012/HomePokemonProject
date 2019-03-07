package poke.model;

public class Snivy extends Pokemon implements Grass
{
	public Snivy()
	{
		super(495, "Snivy");
	}
	
	public Snivy(String name)
	{
		super(495, name);
	}
	
	public Snivy(int number, String name)
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