package Prototype;


public class WeaponPrototype implements Prototype,Cloneable{

	private String type = null;
	private String name = null;
	private int hitpoints = 0;
	private double weight = 0.0;
	private double range = 0.0;
	private String material = null;
	private String owner = null;
	private String spawnPlace = null;
	
	private String configFile = "./Helpful/WeaponConfig.txt";
	
	public WeaponPrototype()	{};
	
	public WeaponPrototype(String type)	{
		this.type = type;
	};
	
	/**
	 * 
	 */
	
	@Override
	public Prototype clone()	{
		return new WeaponPrototype(this.type);
	}
	
	// Getter and Setter
	
	public void setType(String name)	{
		this.type = name;
	}
	
	public String getType()	{
		return this.type;
	}
	
	public void setHitpoints(int value)	{
		this.hitpoints = value;
	}
	
	public int getHitpoints()	{
		return this.hitpoints;
	}
	
	public void setWeight(double value)	{
		this.weight = value;
	}
	
	public double getWeight()	{
		return this.weight;
	}
	
	public void setRange(double value)	{
		this.range = value;
	}
	
	public double getRange()	{
		return this.range;
	}
	
	public void setMaterial(String value)	{
		this.material = value;
	}
	
	public String getMaterial()	{
		return this.material;
	}
	
	public void setName(String name)	{
		this.name = name;
	}
	
	public String getName()	{
		return this.name;
	}
	
	public void setSpawnPlace(String place)	{
		this.spawnPlace = place;
	}
	
	public String getSpawnPlace()	{
		return this.spawnPlace;
	}
	
	public void setOwner(String owner)	{
		this.owner = owner;
	}
	
	public String getOwner()	{
		return this.owner;
	}
	
	public void build(String name, String material, int hitpoints, double weight, double range)	{
		this.name = name;
		this.material = material;
		this.hitpoints = hitpoints;
		this.weight = weight;
		this.range = range;
	}
	
	public String getConfigPath()	{
		return this.configFile;
	}
	
	public String printSpecs()	{
		String data = null;
		
		data = this.type + " | N: " + this.name + " | H: " + this.hitpoints + " | M: " + this.material + " | R: " + this.range + " | W: " + this.weight + " | ";
		data += "O: " + this.owner + " | SP: " + this.spawnPlace;
		
		return data;
	}
	
	public void spawn(String place)	{
		this.spawnPlace = place;
	}
	
	public void pickUp(String finder)	{
		this.owner = finder;
	}
	
	
}
