package com.testcases;

import org.testng.annotations.Test;

import com.utility.FunctionalLibrary;

public class VerifyShoesForAMonth {
	
	@Test
	public void verifyShoesForAMonth() {
		
		FunctionalLibrary.initiazlize();
		
		FunctionalLibrary.goToUrl();
	
		FunctionalLibrary.moveToAMonth("January");
		
		FunctionalLibrary.displayShoesForTheMonthDetails();
		
		FunctionalLibrary.quitBrower();
	}

}
