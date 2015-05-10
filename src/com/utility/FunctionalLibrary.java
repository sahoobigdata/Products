package com.utility;

import org.testng.Assert;

public class FunctionalLibrary extends WrapperActions {

	public static void goToUrl() {
		driver.get(properties.getProperty("Url"));
		System.out.println("Title of Page is : " + driver.getTitle());
	}

	public static void chooseProduct(String productName) {
		WrapperActions.chooseDropDown(ObjectRepository.BRANDNAME, productName);
		WrapperActions.click(ObjectRepository.SEARCHBUTTON);
	}

	public static void moveToDefinition() {
		WrapperActions.click(ObjectRepository.DEFINITION);
	}

	public static void enterEmailAddress(String emailAddress) {

		WrapperActions.inputText("//*[@id='remind_email_input']", emailAddress);

		WrapperActions.click("//*[@id='remind_email_form']/div/input[2]");
	}

	public static boolean verifyEmailEntereted() {
		String text = getTextAtLocation("//*[@id='flash']/div");
		try {
			Assert.assertTrue(text
					.contains("Thanks! We will notify you of our new shoes at this email: "));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void moveToAMonth(String month) {
		WrapperActions.click("//*[contains(text(),'" + month + "')]");
	}

	public static void displayShoesForTheMonthDetails() {

		try {

			for (int i = 1; i <= 5; i++) {
				String brandName = getTextAtLocation("html/body/ul/li[" + i
						+ "]/div/table/tbody/tr[1]/td[2]/a");
				String nameOfShoe = getTextAtLocation("html/body/ul/li[" + i
						+ "]/div/table/tbody/tr[2]/td[2]");
				String priceOfShoe = getTextAtLocation("html/body/ul/li[" + i
						+ "]/div/table/tbody/tr[3]/td[2]");

				System.out.println("Brand Name of Shoe : " + brandName
						+ " Name of a Shoe : " + nameOfShoe + " Price of Shoe : "
						+ priceOfShoe);

			}

		} catch (Exception e) {

		}

	}

	public static void quitBrower() {
		driver.quit();
		
	}

}
