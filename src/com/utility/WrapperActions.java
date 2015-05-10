package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class WrapperActions {

	static WebDriver driver = null;
	static FileInputStream fileInputStream = null;
	static Properties properties = null;

	public static void initiazlize() {
		try {
			fileInputStream = new FileInputStream(new File(System.getProperty("user.dir")+ "\\src\\GlobalVaraibles.properties"));
			properties = new Properties();
			properties.load(fileInputStream);
		} catch (Exception e) {
			System.out.println("Error in loading proeprties file");
			e.printStackTrace();
		}
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public static WebElement findElement(String xpath) {

		WebElement element = null;

		try {
			element = driver.findElement(By.xpath(xpath));
		} catch (ElementNotVisibleException enve) {
			enve.printStackTrace();
			element=null;
		} catch(NoSuchElementException nse) {
			nse.printStackTrace();
			element =null;			
		}catch(Exception e) {
			element = null;
		}
		return element;
	}

	public static boolean click(String xpath) {
		WebElement element = findElement(xpath);
		if (element == null) {
			return false;
		} else {
			element.click();
			return true;
		}
	}

	public static boolean inputText(String xpath, String text) {
		WebElement element = findElement(xpath);
		if (element == null) {
			System.out.println("Input Text box not available");
			return false;
		} else {
			findElement(xpath).clear();
			findElement(xpath).sendKeys(text);
			return true;
		}
	}

	public static boolean chooseDropDown(String xpath, String value) {
		WebElement element = findElement(xpath);
		if (element == null) {
			System.out.println("Input Text box not available");
			return false;
		} else {
		Select select = new Select(findElement(xpath));

		select.selectByValue(value);
		return true;
		}
	}

	public static String getTextAtLocation(String xpath) {
		WebElement element = findElement(xpath);
		String text=null;
		if(element==null) {
			System.out.println("No text at that locaiton");
			text= null;
		}else {
			text= element.getText();
		}return text;
	}
	
}
