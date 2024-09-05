package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Day1 {

	@Test
	public void Abc(){
		System.out.println("hello");
	}
	
	@AfterTest
	public void LastExecution()
	{
		System.out.println("I will execute last");
	}
	
	@Test
	public void Demo() 
	{
		System.out.println("Hello There");
	}
	
	@AfterSuite
	public void Afsuite() {
		System.out.println("I am number 1 from last");
	}
	
	@Test
	public void Secondtest() {
		System.out.println("Bye");
	}
	
	
	
	
}
