package Registrator;

import java.util.Set;
import java.util.HashMap;

import Prototype.*;

public interface RegistratorInterface {

	/**
	 * Returns a HashMap of all Prototypes registered at the Registrator
	 * @return
	 */
	
	HashMap<String,Prototype> getPrototypes();
	
	/**
	 * Registers a new prototype at the Registrator
	 * @param name
	 * @param proto
	 */
	
	void register(String name, Prototype proto);
	
	/**
	 * Returns a prototype if it exists by its name 
	 * @param name
	 * @return
	 */
	
	Prototype getPrototype(String name);
	
	/**
	 * Returns all keys of the registry HashMap
	 * @retur
	 */
	
	Set<String> getRegistryKeys();
	
	/**
	 * 
	 */
	
	void init();
	
	HashMap<String, Prototype> getWeaponMap();
	
	HashMap<String, Prototype> getProtectionMap();
	
	void clearRegistry();
	
	}
