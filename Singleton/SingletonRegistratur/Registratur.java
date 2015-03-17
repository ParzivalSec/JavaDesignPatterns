package SingletonRegistratur;

import java.util.HashMap;

public class Registratur {

	// Singleton instance
	private static Registratur instance = null;
	// HashMap to hold registered objects
	private HashMap<String,Object> objectList = new HashMap<String,Object>();
	
	// Private constructor to prevent initialization
	private Registratur() {};
	
	// Return one and only singleton instance and creates it at first use
	public static Registratur getInstance()	{
		if(Registratur.instance == null)	{
			Registratur.instance = new Registratur();
		}
		return Registratur.instance;
	};
	
	// Return object per name
	public Object getObject(String name)	{
		return objectList.get(name);
	};
	
	// Register object and save to objectList
	public void register(String name, Object object)	{
		objectList.put(name, object);
	}
	
	// Returns full HashMap for testing purposes
	public HashMap<String,Object> getHashMap()	{
		return this.objectList;
	}
}
