package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day2 {

	@Test(groups = {"smoke"})
	public void Ploan() {
		System.out.println("Good");
	}
	
	@BeforeTest
	public void Prerequisite() {
		System.out.println("I will execute first");
	}
	
	
	
		
}
