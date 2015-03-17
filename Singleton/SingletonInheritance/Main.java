package SingletonInheritance;

import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		
		LoggerSuper Test = StringLogger.getInstance();
		LoggerSuper TestTwo = DateLogger.getInstance();
		
		System.out.println("+++++ String Logger starts +++++");
		
		Test.Log();
		Test.Log();
		
		System.out.println("+++++ Now Date Logger +++++");
		
		TestTwo.Log();
		TestTwo.Log();
		
		System.out.println("===== Output from String Logger =====");
		
		LinkedList<?> StringHis = (LinkedList<?>) Test.GetLogHistory();
		
		// New Java8 default forEach method from collections that implement Iterable
		// Takes Lambda Expression as an argument
		
		StringHis.forEach(log -> System.out.println(log));
		
		System.out.println("===== Output from Date Logger =====");
		
		LinkedList<?> DateHis = (LinkedList<?>) TestTwo.GetLogHistory();
		
		// New Java8 default forEach method from collections that implement Iterable
		// Takes Lambda Expression as an argument
		
		DateHis.forEach(date -> System.out.println(date));

	}

}
