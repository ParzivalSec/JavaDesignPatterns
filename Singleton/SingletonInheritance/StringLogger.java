package SingletonInheritance;

import java.util.LinkedList;
import java.util.UUID;

public class StringLogger extends LoggerSuper {

	private static StringLogger instance = null;
	private LinkedList<String> History = new LinkedList<String>();
	
	// Prevent SingletonTwo from initialization
	private StringLogger()	{};
	
	// Returns (creates) instance of SingletonTwo
	public static StringLogger getInstance()	{
		if(StringLogger.instance == null)	{
			StringLogger.instance = new StringLogger();
		}
		
		return StringLogger.instance;
	}
	
	public void Log() {
		System.out.println("Logged a new String");
		History.add(UUID.randomUUID().toString());
	}

	public Object GetLogHistory() {
		return History;
	}
}
