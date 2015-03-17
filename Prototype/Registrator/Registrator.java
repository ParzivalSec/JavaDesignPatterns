package Registrator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;

import Prototype.ProtectionPrototype;
import Prototype.Prototype;
import Prototype.WeaponPrototype;

public class Registrator implements RegistratorInterface {

	private static RegistratorInterface instance = null; 
	private HashMap<String,Prototype> registry = new HashMap<String,Prototype>();
	private HashMap<String,Prototype> weaponRegistry = new HashMap<String,Prototype>();
	private HashMap<String,Prototype> protectionRegistry = new HashMap<String,Prototype>();
	
	
	protected Registrator() {}

	public static RegistratorInterface getInstance()	{
		if(Registrator.instance == null)	{
			Registrator.instance = new Registrator();
		}
		
		return Registrator.instance;
	}
	
	public HashMap<String, Prototype> getWeaponMap()	{
		return this.weaponRegistry;
	}
	
	public HashMap<String, Prototype> getProtectionMap()	{
		return this.protectionRegistry;
	}
	
	public void clearRegistry()	{
		registry.clear();
		weaponRegistry.clear();
		protectionRegistry.clear();
	}
	
	@Override
	public HashMap<String, Prototype> getPrototypes() {
		return registry;
	}

	@Override
	public void register(String name, Prototype proto) {
		registry.put(name, proto);
	}

	@Override
	public Prototype getPrototype(String name) {
		return registry.get(name);
	}

	@Override
	public Set<String> getRegistryKeys() {
		return registry.keySet();
	}

	/**
	 * Shall parse config files for Prototypes and create their special types 
	 * 
	 * Opens the config files and parses 
	 */
	
	
	
	@Override
	public void init() {
		LinkedList<Prototype> initialProtos = new LinkedList<Prototype>();
		
		System.out.println("[START]: Initialise Registrator");
		// Add all prototypes to an initial list to produce their special types
		
		initialProtos.add(new WeaponPrototype());
		initialProtos.add(new ProtectionPrototype());
		
		// Parse the config for each item in the list
		
		initialProtos.forEach(item -> parseConfig(item));
		
		// Create partial maps
		
		weaponRegistry = createWeaponsList(registry);
		protectionRegistry = createProtectionList(registry);
	}
	
	private void parseConfig(Prototype protoItem)	{

		try {
			Prototype current = null;
			String currName = null;
			
			System.out.println("- [INFO]: Registrator: Load config: " + protoItem.getConfigPath());
			
			BufferedReader br = new BufferedReader(new FileReader((protoItem.getConfigPath())));
			
			String line = null;
			
			while((line=br.readLine()) != null)	{
			
				if(line.startsWith("#"))	{
					String pair[]	= line.split("#");
					// Creates a new class of the specific prototype type
					// and add it to the registry
					
					if(pair[1] != null)	{
						currName = pair[1];
						//System.out.println("New Proto --> " + pair[1]);
						
						Class<?> clazz = Class.forName(protoItem.getClass().getName());
						Constructor<?> constr = clazz.getConstructor(String.class);
						current = (Prototype) constr.newInstance(new Object[] { pair[1] });
						
						if(current instanceof Prototype)	{
							System.out.println("- [INFO]: Registrator: Loaded Class " + clazz.getName() + " from type " + pair[1]);
						}
						
						//System.out.println("Archive Proto");
						registry.put(currName, current);
					}
				}	
			}
			
			br.close();
			
		} catch (FileNotFoundException e) {
			System.err.println("File not found - Please be sure that all configs are in their place");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private HashMap<String,Prototype> createWeaponsList(HashMap<String,Prototype> startMap)	{
		HashMap<String,Prototype> newMap = new HashMap<String,Prototype>();
		newMap.putAll(startMap);
		
	    for(Iterator<Map.Entry<String, Prototype>> it = newMap.entrySet().iterator(); it.hasNext(); ) {
	        Map.Entry<String, Prototype> entry = it.next();
	        if(entry.getValue().getClass().equals(ProtectionPrototype.class)) {
	          it.remove();
	        }
	    }
		return newMap;
	}
	
	private HashMap<String,Prototype> createProtectionList(HashMap<String,Prototype> startMap)	{
		HashMap<String,Prototype> newMap = new HashMap<String,Prototype>();
		newMap.putAll(startMap);
		
	    for(Iterator<Map.Entry<String, Prototype>> it = newMap.entrySet().iterator(); it.hasNext(); ) {
	        Map.Entry<String, Prototype> entry = it.next();
	        if(entry.getValue().getClass().equals(WeaponPrototype.class)) {
	          it.remove();
	        }
	    }
		return newMap;
	}

}
