package Prototype;


public class ProtectionPrototype implements Prototype,Cloneable{

	private String type = null;
	private String name = null;
	private int health = 0;
	private double weight = 0.0;
	private double playerClass = 0.0;
	private String material = null;
	private String owner = null;
	private String spawnPlace = null;
	
	private String configFile = "./Helpful/ProtectionConfig.txt";
	
	public ProtectionPrototype()	{};
	
	public ProtectionPrototype(String type)	{
		this.type = type;
	};
	
	/**
	 * 
	 */
	
	@Override
	public Prototype clone()	{
		return new ProtectionPrototype(this.type);
	}
	
	// Getter and Setter
	
	public void setType(String name)	{
		this.type = name;
	}
	
	public String getType()	{
		return this.type;
	}
	
	public void setHealth(int value)	{
		this.health = value;
	}
	
	public int getHealth()	{
		return this.health;
	}
	
	public void setWeight(double value)	{
		this.weight = value;
	}
	
	public double getWeight()	{
		return this.weight;
	}
	
	public void setPlayerClass(double value)	{
		this.playerClass = value;
	}
	
	public double getPlayerClass()	{
		return this.playerClass;
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
	
	public void build(String name, String material, int health, double weight, double playerClass)	{
		this.name = name;
		this.material = material;
		this.health = health;
		this.weight = weight;
		this.playerClass = playerClass;
	}
	
	public String getConfigPath()	{
		return this.configFile;
	}
	
	public String printSpecs()	{
		String data = null;
		
		data = this.type + " | N: " + this.name + " | M: " + this.material + " | C: " + this.playerClass + " | W: " + this.weight + " | ";
		data += "O: " + this.owner + " | SP: " + this.spawnPlace + " | H: " + this.health;
		
		return data;
	}
	
	public void spawn(String place)	{
		this.spawnPlace = place;
	}
	
	public void pickUp(String finder)	{
		this.owner = finder;
	}
	
	
}
