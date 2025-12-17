package com.selenium.amazon_automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonHomePage {
	        WebDriver driver;
	        WebDriverWait wait;

	        By searchBox = By.id("twotabsearchtextbox");

	        public AmazonHomePage(WebDriver driver, WebDriverWait wait) {
	            this.driver = driver;
	            this.wait = wait;
	        }

	        public void openHomePage() {
	            driver.get("https://www.amazon.in/");
	            wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
	        }

	        public void searchProduct(String productName) {
	   WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
	            search.sendKeys(productName);
	            search.submit();
	}

}
