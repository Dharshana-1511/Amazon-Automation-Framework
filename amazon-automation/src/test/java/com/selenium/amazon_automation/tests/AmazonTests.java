package com.selenium.amazon_automation.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.amazon_automation.base.BaseTest;
import com.selenium.amazon_automation.pages.AmazonHomePage;
import com.selenium.amazon_automation.pages.AmazonProductPage;
import com.selenium.amazon_automation.pages.AmazonSearchResultsPage;

public class AmazonTests extends BaseTest  {
	//  Debug wait helper (only for visibility)
    private void debugSleep(int seconds) {
        try {
            System.out.println(" Waiting for " + seconds + " seconds...");
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
	
     @Test
	    public void openHome() throws IOException {
	    	
	        System.out.println("TEST STARTED: Amazon automation");

            System.out.println("Maximizing browser window");
            driver.manage().window().maximize();
            debugSleep(2);
            System.out.println("Initializing Page Objects");

            System.out.println("Opening Amazon Home Page");
	        AmazonHomePage homePage = new AmazonHomePage(driver, wait);
	        homePage.openHomePage();
            System.out.println("Home page opened: " + driver.getCurrentUrl());
            debugSleep(3);      
            
            System.out.println("Searching for product: laptop");
            homePage.searchProduct("laptop");
            debugSleep(3);

	        
	      }
	    @Test(dependsOnMethods = "openHome")
	    public void openSearch() {
            System.out.println("Clicking first product from search results");
	        AmazonSearchResultsPage resultsPage = new AmazonSearchResultsPage(driver, wait);
	        resultsPage.clickFirstResult();
            debugSleep(4); 
	    }
	    
	    @Test(dependsOnMethods = "openSearch")
	    public void openProduct() throws IOException {
            System.out.println("Validating product page load (Add to Cart visibility)");
	        AmazonProductPage productPage = new AmazonProductPage(driver, wait);
	        System.out.println("Taking screenshot after validation");
            productPage.takeScreenshot("Add_To_Cart_Visible");
            debugSleep(2); 
           
            System.out.println("Clicking Add to Cart action");
            productPage.clickAddToCart();
            debugSleep(4);
             
            System.out.println("Add to Cart clicked successfully");

        
	      
	    }    
	    }
	

    

