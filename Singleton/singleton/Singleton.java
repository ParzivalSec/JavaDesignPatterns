/** Singleton Test Class **/
/** Author: Lukas Vogl <lukas@codebrewer.net> **/

/* Simple Singleton CLass 
 * - Private static reference on itself
 * - private constructor to prevent initialization
 * - public static getInstance() method to return and create Singleton instance
 * - But this method is not thread save because one can call it and then another one who could receive
 *   the singleton before it was initialized for the other one
 *   For that we would need either a SYNCHRONIZED part or a double checked initialization method (which is 
 *   better considering the performance with multiple threads)  
 */

package singleton;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.LinkedList;

public class Singleton	{
	// First initialize Singleton instance with null
	
	// Static initialization 
	// private static Singleton Instance = new Singleton();
	
	/**
	This static reference prevents the singleton also
	from deletion by the garbage collector because
	the reference count never drops to 0
	Could only be eligible for GC if instance
	is set to null again
	**/
	
	private static Singleton Instance = null;
	
	// LinkedList for feature history
	
	private LinkedList<Entry> history = new LinkedList<Entry>();
		
	// Don't let them initiate you
	
	protected Singleton() {};
	
	// Return the instance of the singleton 
	// Lazy initialization
	// BUT: is not thread save (with this implementation)
	
	public static Singleton getInstance()	{
		// if no Singleton exists create it 'on the fly'
		
		if(Instance == null)	{
			Instance = new Singleton();
		}
		return Instance;		
	};	
	
	/* Better than synchronizing the first if block
	 * because now only the first few threads while
	 * instance equals null will be synchronized
	 * all other won't pass the first if and so 
	 * they will not reach the sync block
	 * 
	 * public static Singleton getInstance()	{
	 * 	if(Singleton.instance == null)	{
	 * 		
	 * 		synchronized(Singleton.class)	{
	 * 			if(Singleton.instance == null)	{
	 * 				Singleton.instance = new Singleton();
	 * 			}
	 * 		}
	 * 	}
	 *  return Singleton.instance;
	 * };
	 */
	
	public void log(Date date, String user, String time)	{
		Entry CurrEntry = new Entry(date, user, time);
		history.add(CurrEntry);
		
		writeToFile();
	};
	
	public void writeToFile()	{
		try	{
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("./HelpFul/log.txt", true)));
			// Write the last logged data to file
				
			out.println(history.getLast().getDate().toString() + ": " + history.getLast().getUser() + " at " + history.getLast().getTime());
			out.close();
		}catch (IOException e) {
		    // Error will be handled here
		}	
	};
	
	// Returns history list for testing purposes
	
	public LinkedList<Entry> getHistory()	{
		return this.history;
	};
	
	// Only needed for UnitTesting here - i need to clear the list for size testing
	
	public void clearList()	{
		history.clear();
	}
}