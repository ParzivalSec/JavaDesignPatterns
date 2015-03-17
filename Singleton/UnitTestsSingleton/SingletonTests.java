/** Singleton Test Class **/
/** Author: Lukas Vogl <lukas@codebrewer.net> **/

package UnitTestsSingleton;

import java.util.Date;

import singleton.Singleton;

import org.junit.Test;

import static org.junit.Assert.*;

public class SingletonTests {
	
	@Test
	public void can_initialize_singleton_class()	{
		Singleton one = Singleton.getInstance();
		assertNotNull("Singleton is null" , one);
	}
	
	@Test
	public void singleton_is_always_the_same()	{
		Singleton one = Singleton.getInstance();
		Singleton two = Singleton.getInstance();
		assertEquals("Instance of singleton one doesn't match instance two", one , two);
	}
	
	@Test
	public void save_logged_entries_in_LinkedList()	{
		Singleton.getInstance().clearList();
		Singleton one = Singleton.getInstance();
		one.log(new Date(), "Test", "12:12:12");
		assertEquals("LinkedList has no entry" , 1 , one.getHistory().size());
	}
	
	@Test
	// Test needed adaption due to not deletion of singleton after last test - not touchable for garbage collector
	public void get_proper_values_from_entry()	{
		Singleton.getInstance().clearList();
		Singleton one = Singleton.getInstance();
		one.log(new Date(), "Test", "12:12:12");
		assertEquals("Username is wrong" , "Test" , one.getHistory().getLast().getUser());
		assertEquals("Time is wrong" , "12:12:12" , one.getHistory().getLast().getTime());
		assertEquals("Date is no Date" , Date.class , one.getHistory().getLast().getDate().getClass());
	}
}
