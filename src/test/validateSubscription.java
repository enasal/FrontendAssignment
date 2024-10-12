package test;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import pages.homePage;

public class validateSubscription {
	WebDriver driver; 
	
	@BeforeClass
	public void openBrowser()
	{
	driver= new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://subscribe.stctv.com/sa-en");

	}
	
	@Test(description="validate subscription type, price and currency for each available countries")
	public void validateSubscriptionDetails() {		
	for (int i = 0; i < homePage.countries.length; i++) {
		driver.findElement(homePage.countryName).click();
		
		driver.findElement(By.id(homePage.countries[i])).click();
		
		String currentUrl = driver.getCurrentUrl();
		
		Assert.assertTrue(currentUrl.contains("https://subscribe.stctv.com/" + homePage.countries[i] + "-en"), "Text not found in the element!");
		
		for(int j = 0; j < homePage.subscriptionPriceWithCurrency[i].length; j++) {
			String subscriptionType  = driver.findElement(By.id("name-"+ homePage.subscriptionTypes[j])).getText();
			
			Assert.assertTrue(subscriptionType.equals(homePage.subscriptionTypes[j].toUpperCase()), "Text not found in the element!");
			
			String displayedSubscriptionPrice  = driver.findElement(By.id("currency-"+ homePage.subscriptionTypes[j])).getText();
			
			Assert.assertTrue(displayedSubscriptionPrice.contains(homePage.subscriptionPriceWithCurrency[i][j].toUpperCase()), "Text not found in the element!");
		 }
	   }

	 }

	@AfterClass
	public void afterClass()
	{
		driver.quit();
	}

}
