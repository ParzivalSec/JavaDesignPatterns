/** Singleton Test Class **/
/** Author: Lukas Vogl <lukas@codebrewer.net> **/

package singleton;

import java.util.Date;

public class Main	{
	
	public static void main(String[] args)	{
		// Demo Routine - Testing in UnitTests
		
		Singleton one = null, two = null;
		
		// Get first singleton and log
		System.out.println("+++ Getting singleton... +++");
		one = Singleton.getInstance();
		System.out.println("=== Got First singleton: " + one + " ===");
		System.out.println("=== LOG Singleton One ===");
		one.log(new Date(), "TestFeatureOne", "12:04");
		
		// Get second singleton and log
		System.out.println("+++ Getting singleton... +++");
		two = Singleton.getInstance();
		System.out.println("=== Got Second singleton: " + two + " ===");
		System.out.println("=== LOG Singleton Two ===");
		two.log(new Date(), "FeatureCall2", "12:08");
		
	}
}