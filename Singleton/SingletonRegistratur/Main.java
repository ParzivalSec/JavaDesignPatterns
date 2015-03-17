package SingletonRegistratur;

import java.util.HashMap;
import java.util.LinkedList;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		System.out.println("+++++ SINGLETON REGISTRATUR MAIN +++++");
		
		// Get instance of registratur singleton
		Registratur reg = Registratur.getInstance();
		
		// Register a hashmap against the registratur
		System.out.println("+!+ Create HashMap and register it +!+");
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("One", "TestOne");
		map.put("Two" , "TestTwo");
		
		reg.register("HashMap" , map);
		
		// Register a linkedlist against the registratur
		System.out.println("+!+ Create LinkedList and register it +!+ ");
		LinkedList<String> list = new LinkedList<String>();
		list.add("Eins");
		list.add("Zwei");
		
		reg.register("LinkedList" , list);
		
		// Check if registratur contains proper values
		
		System.out.println("=== Get Hashmap AND HashMap content");
		HashMap<String,String> newOne = (HashMap<String,String>)reg.getObject("HashMap");
		System.out.println(newOne.get("One"));
		System.out.println(newOne.get("Two"));
		
		System.out.println("=== Get List AND list content");
		LinkedList<String> newTwo = (LinkedList<String>)reg.getObject("LinkedList");
		newTwo.forEach(content -> System.out.println(content));
	}

}
