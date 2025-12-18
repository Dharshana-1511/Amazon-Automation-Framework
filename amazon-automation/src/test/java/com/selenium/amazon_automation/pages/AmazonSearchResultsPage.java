package com.selenium.amazon_automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonSearchResultsPage {

		 WebDriver driver;
		 WebDriverWait wait;

		 By firstResult = By.xpath("(//a[h2[contains(@class,'a-size-medium')]])[1]");

		 public AmazonSearchResultsPage(WebDriver driver, WebDriverWait wait)
		 {
		 this.driver = driver;
		 this.wait = wait;
         }

     public void clickFirstResult() 
     {
    	    String parentWindow = driver.getWindowHandle();

     WebElement result = wait.until(ExpectedConditions.elementToBeClickable(firstResult));
     result.click();
     // 🔁 SWITCH TO NEW TAB
     for (String window : driver.getWindowHandles()) {
         if (!window.equals(parentWindow)) {
             driver.switchTo().window(window);
             break;
	 }
     }
     }
}
