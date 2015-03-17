package DemoApp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.UUID;

import Prototype.ProtectionPrototype;
import Prototype.WeaponPrototype;
import Registrator.Registrator;
import Registrator.RegistratorInterface;

public class DemoApp {
	
	private String materials[] = {"Iron" , "Steel" , "Wood" , "Cristal" , "Glass" , "Dragonsteel"};
	private String owners[] = {"JohnTheKing" , "MiaMagic" , "PaulPanther" , "Sissi_12_Poy"};
	private String places[] = {"Castle of Glass" , "Green Wood Lodge" , "Yellow Stone Park" , "Red Moon River"};

	public DemoApp() {
		System.out.println("[INFO]: DemoApp started...");
	};
	
	public static int randInt(int min, int max) {

	    // NOTE: Usually this should be a field rather than a method
	    // variable so that it is not re-seeded every call.
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	public LinkedList<WeaponPrototype> spawnWeapons(int elements , WeaponPrototype item)	{
		
		//System.out.println("[DEBUG]: INSIDE SPAWNER");
		LinkedList<WeaponPrototype> weaponList = new LinkedList<WeaponPrototype>();
		
		for(int i=0;i<elements;i++)	{
			WeaponPrototype currItem = (WeaponPrototype)item.clone();
			
			currItem.build(UUID.randomUUID().toString(), materials[randInt(0, 5)], randInt(1,1000), randInt(1,100), randInt(1,1000));
			
			if(i % 2 == 0)	{
				currItem.setOwner(owners[randInt(0, 3)]);
				currItem.setSpawnPlace(places[randInt(0, 3)]);
			}
			
			weaponList.add(currItem);
			
		}
		return weaponList;
	}
	
	public LinkedList<ProtectionPrototype> spawnProtection(int elements , ProtectionPrototype item)	{
		
		//System.out.println("[DEBUG]: INSIDE SPAWNER");
		LinkedList<ProtectionPrototype> protectionList = new LinkedList<ProtectionPrototype>();
		
		for(int i=0;i<elements;i++)	{
			ProtectionPrototype currItem = (ProtectionPrototype)item.clone();
			
			currItem.build(UUID.randomUUID().toString(), materials[randInt(0, 5)], randInt(1,1000), randInt(1,100), randInt(1,1000));
			
			if(i % 2 == 0)	{
				currItem.setOwner(owners[randInt(0, 3)]);
				currItem.setSpawnPlace(places[randInt(0, 3)]);
			}
			
			protectionList.add(currItem);
			
		}
		return protectionList;
	}
	
	public void start()	{
		System.out.println("[START]: Demo Game Object Creation App - Prototype Pattern");
		//System.out.println("- [INFO]: Environment is set to \"" + env + "\" mode");
		
		RegistratorInterface reg = Registrator.getInstance();
		
		
		// Initialize the Registartor to watch over Prototype instances
		reg.init();
		
		//if(env == "Debug")	{
			//reg.getPrototypes().forEach((k , v) -> System.out.println("Type in Map --> " + v.getType()));
		//}
		//else	{
			reg.getPrototypes().forEach((k , v) -> System.out.println("[INFO]: Type: " + v.getType() + " ( " + v.getClass().getName() + " )"));
		//}
		
		reg.getWeaponMap().forEach((k , weapon) -> spawnWeapons(2, (WeaponPrototype)weapon).forEach(item -> System.out.println(item.printSpecs())));
		reg.getProtectionMap().forEach((k , protection) -> spawnProtection(2, (ProtectionPrototype)protection).forEach(item -> System.out.println(item.printSpecs())));
	}
	
	public void restart()	{
		System.out.println("[START]: Demo Game Object Creation App - Prototype Pattern");
		//System.out.println("- [INFO]: Environment is set to \"" + env + "\" mode");
		
		RegistratorInterface reg = Registrator.getInstance();
		
		reg.clearRegistry();
		
		// Initialize the Registartor to watch over Prototype instances
		reg.init();
		
		//if(env == "Debug")	{
			//reg.getPrototypes().forEach((k , v) -> System.out.println("Type in Map --> " + v.getType()));
		//}
		//else	{
			reg.getPrototypes().forEach((k , v) -> System.out.println("[INFO]: Type: " + v.getType() + " ( " + v.getClass().getName() + " )"));
		//}
		
		reg.getWeaponMap().forEach((k , weapon) -> spawnWeapons(2, (WeaponPrototype)weapon).forEach(item -> System.out.println(item.printSpecs())));
		reg.getProtectionMap().forEach((k , protection) -> spawnProtection(2, (ProtectionPrototype)protection).forEach(item -> System.out.println(item.printSpecs())));
	}

}
