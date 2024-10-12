package pages;

import org.openqa.selenium.By;

public class homePage {
  
  // Variables
  public static String[][] subscriptionPriceWithCurrency = {{"2 BHD", "3 BHD", "6 BHD"}, {"15 SAR", "25 SAR", "60 SAR"}, {"1.2 KWD", "2.5 KWD", "4.8 KWD"}};
  
  public static String[] subscriptionTypes = {"lite", "classic", "premium"};
  public static String[] countries = {"bh", "sa", "kw"};

  
  // Selectors
  public static By countryName = By.id("country-name");
 

	

}
