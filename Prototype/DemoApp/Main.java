package DemoApp;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import Prototype.*;
import Registrator.Registrator;
import Registrator.RegistratorInterface;
import FileWatcher.FileWatcher;

public class Main {

	public static void main(String[] args) {
		
		//String env = "Debug";
		String env = "Production";
		
		DemoApp demo = new DemoApp();
		
		demo.start();
		
		//System.out.println(one.printSpecs());
		
		if(env == "Debug")	{
			System.out.println("[INFO]: FileWatcher is disabled in Debug Mode");
		}
		else {
			TimerTask task = new FileWatcher(new File("./HelpFul/WeaponConfig.txt")	){
				protected void onChange(File file)	{
					System.out.println("File Changed: " + file.getName());
					demo.restart();
				}
			};
			
			TimerTask task2 = new FileWatcher(new File("./HelpFul/ProtectionConfig.txt")	){
				protected void onChange(File file)	{
					System.out.println("File Changed: " + file.getName());
					demo.restart();
				}
			};
			
			Timer timer = new Timer();
			Timer timer2 = new Timer();
			timer.schedule(task, new Date(), 1000);
			timer2.schedule(task2, new Date(), 1000);			
		}
	}

}
