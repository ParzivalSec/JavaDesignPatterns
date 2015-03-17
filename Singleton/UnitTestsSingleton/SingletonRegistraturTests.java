package UnitTestsSingleton;

import java.util.HashMap;
import java.util.LinkedList;

import SingletonRegistratur.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class SingletonRegistraturTests {

	@Test
	public void can_initialize_registratur() {
		Registratur reg = Registratur.getInstance();
		assertNotNull("Instance of Registratur is null" , reg);
	}
	
	@Test
	public void registratur_is_singleton() {
		Registratur regOne = Registratur.getInstance();
		Registratur regTwo = Registratur.getInstance();
		assertEquals("Registartur is not a singleton" , regOne, regTwo);
	}
	
	@Test
	public void can_register_objects() {
		Registratur reg = Registratur.getInstance();
		HashMap<String,String> newMap = new HashMap<String,String>();
		LinkedList<String> list = new LinkedList<String>();
		
		reg.register("HashMap" , newMap);
		reg.register("LinkedList" , list);
		
		assertEquals("Not all objects registered" , 2 , reg.getHashMap().size());
	}
	
	@Test
	public void return_objects_by_name() {
		Registratur reg = Registratur.getInstance();
		HashMap<String,String> newMap = new HashMap<String,String>();
		LinkedList<String> list = new LinkedList<String>();
		
		reg.register("HashMap" , newMap);
		reg.register("LinkedList" , list);
		
		assertEquals("Object is not HashMap", reg.getObject("HashMap").getClass() , HashMap.class);
		assertEquals("Object is not LinkedList" , reg.getObject("LinkedList").getClass() , LinkedList.class);
	}

	@Test
	public void objects_are_consistent_in_singleton_registratur()	{
		Registratur regOne = Registratur.getInstance();
		HashMap<String,String> newMap = new HashMap<String,String>();
		LinkedList<String> list = new LinkedList<String>();
		
		regOne.register("HashMap" , newMap);
		regOne.register("LinkedList" , list);
		
		Registratur regTwo = Registratur.getInstance();
		
		assertNotNull("Object does not exist" , regTwo.getObject("HashMap"));
		assertEquals("Object is no HashMap" , regTwo.getObject("HashMap").getClass() , HashMap.class);
	};
}
