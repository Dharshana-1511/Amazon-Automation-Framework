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

   
    
    private By addToCartBtn = By.xpath("(//input[@id='add-to-cart-button'])[last()]");
    
    private By productTitle = By.id("productTitle");


    public AmazonProductPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public void waitForProductPage() {
        ensureProductTab();
        wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle));
    }

    //  switch to product tab
    private void ensureProductTab() {
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
    }
    public void clickAddToCart() {

        ensureProductTab();

        //  Confirm product page loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle));

        WebElement addToCart = wait.until(
                ExpectedConditions.presenceOfElementLocated(addToCartBtn)
        );

        //  Scroll into view
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", addToCart
        );
        
        // Optional highlight (debug)
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].style.border='3px solid red'", addToCart
        );
        // Amazon-safe JS click (DO NOT wait for clickable)
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", addToCart
        );
    }

    // Screenshot
    public void takeScreenshot(String fileName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File("Product screenshots/" + fileName + ".png");
        FileUtils.copyFile(src, dest);
    }
	}
	        
	 