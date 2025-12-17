package com.selenium.amazon_automation.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AmazonProductPage {

	    WebDriver driver;
	    WebDriverWait wait;
	    private By addToCartBtn = By.id("add-to-cart-button");

	    public AmazonProductPage(WebDriver driver, WebDriverWait wait) {
	        this.driver = driver;
	        this.wait = wait;
	    }

	    // 🔽 Scroll to Add to Cart
	    public void scrollToAddToCart() {
	        WebElement addToCart = wait.until(
	                ExpectedConditions.presenceOfElementLocated(addToCartBtn)
	        );

	        ((JavascriptExecutor) driver)
	                .executeScript("arguments[0].scrollIntoView({block:'center'});", addToCart);
	    }

	    // ✅ Validate Product Page Loaded
	    public boolean isAddToCartVisible() {
	        try {
	            scrollToAddToCart();
	            wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartBtn));
	            return driver.findElement(addToCartBtn).isDisplayed();
	        } catch (TimeoutException e) {
	            return false;
	        }
	    }

	    // 📸 Screenshot
	    public void takeScreenshot(String fileName) throws IOException {
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File src = ts.getScreenshotAs(OutputType.FILE);
	        File dest = new File("screenshots/" + fileName + ".png");
	        FileUtils.copyFile(src, dest);
	    }
	}
	        
	 