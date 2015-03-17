package SingletonInheritance;

import java.util.Date;
import java.util.LinkedList;

public class DateLogger extends LoggerSuper {

	private static DateLogger instance = null;
	private LinkedList<Date> History = new LinkedList<Date>();
	
	// Prevent SingletonTwo from initialization
	private DateLogger()	{};
	
	// Returns (creates) instance of DateLogger
	public static DateLogger getInstance()	{
		if(DateLogger.instance == null)	{
			DateLogger.instance = new DateLogger();
		}
		
		return DateLogger.instance;
	}
	
	public void Log() {
		System.out.println("Logged a new date");
		History.add(new Date());
	}

	public Object GetLogHistory() {
		return History;
	}
}