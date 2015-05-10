package com.testcases;

import org.testng.annotations.Test;

import com.utility.FunctionalLibrary;

public class VerfiyEmailRemainder {
	
	
	@Test
	public void verifyingEmailRemainder() {
		
		FunctionalLibrary.initiazlize();
	
		FunctionalLibrary.goToUrl();
		
		FunctionalLibrary.chooseProduct("ALDO");
	
		FunctionalLibrary.enterEmailAddress("sahoobigdata@gmail.com");
		
		FunctionalLibrary.verifyEmailEntereted();
		
	}
	
}
