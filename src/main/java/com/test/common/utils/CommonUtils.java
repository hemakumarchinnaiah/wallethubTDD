package com.test.common.utils;


import java.io.File;
import java.io.IOException;
import java.lang.annotation.Target;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import page.objects.HomePageObjects;

public class CommonUtils {

	public void SendKeys(WebDriver driver, WebElement ele, String value) {

		try {
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOf(ele));
			ele.getText();
			ele.sendKeys(value);
		}
		catch(WebDriverException e) {
			Assert.assertTrue(false, "Unable to send keys "+ele);
		}
	}

	public void ClickButton(WebDriver driver, WebElement ele) {

		try {
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOf(ele));
			ele.getText();
			ele.click();
		}
		catch(NoSuchElementException element) {
			Assert.assertTrue(false, "Unable to locate the element"+element);
		} 
		catch(WebDriverException e) {
			Assert.assertTrue(false, "Unable to click the button "+ele); 
		}
	}

	

}
