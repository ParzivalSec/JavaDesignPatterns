package UnitTestsSingleton;

import SingletonInheritance.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class SingletonInheritanceTests {

	@Test
	public void datelogger_is_child_from_loggersuper()	{
		LoggerSuper One = DateLogger.getInstance();
		assertEquals("DateLogger is not childclass from LoggerSuper" , One.getClass().getSuperclass() , LoggerSuper.class);	
	}
	
	@Test
	public void stringlogger_is_child_from_loggersuper()	{
		LoggerSuper Two = StringLogger.getInstance();
		assertEquals("StringLogger is not childclass from LoggerSuper" , Two.getClass().getSuperclass() , LoggerSuper.class);	
	}
	
	@Test
	public void superclass_can_have_more_singleton_childs()	{
		LoggerSuper One = DateLogger.getInstance();
		LoggerSuper Two = StringLogger.getInstance();
		assertNotEquals("DateLogger is same as StringLogger" , One.getClass() , Two.getClass());	
	}
	
	@Test
	public void superclass_can_inherite_to_more_subclasses()	{
		LoggerSuper One = DateLogger.getInstance();
		LoggerSuper Two = StringLogger.getInstance();
		assertEquals("StringLogger and DateLogger are not both childs from LoggerSuper" , One.getClass().getSuperclass() , Two.getClass().getSuperclass());	
	}
}
