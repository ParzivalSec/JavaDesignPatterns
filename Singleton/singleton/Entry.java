/** Singleton Test Class **/
/** Author: Lukas Vogl <lukas@codebrewer.net> **/

package singleton;

import java.util.Date;

public class Entry {
	
	private String user;
	private Date date;
	private String time;
	
	// Object to pass to the log history
	public Entry(Date date, String user, String time)	{
		this.user = user;
		this.date = date;
		this.time = time;
	}
	
	public String getUser()	{
		return this.user;
	};
	
	public String getTime()	{
		return this.time;
	};
	
	public Date getDate()	{
		return this.date;
	};
	
	public void setUser(String user){
		this.user = user;
	};
	
	public void setTime(String time){
		this.time = time;
	};
	
	public void setDate(Date date){
		this.date = date;
	};
}
