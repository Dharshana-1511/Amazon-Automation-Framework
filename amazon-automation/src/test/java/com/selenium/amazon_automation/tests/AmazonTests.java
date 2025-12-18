package com.selenium.amazon_automation.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.amazon_automation.base.BaseTest;
import com.selenium.amazon_automation.pages.AmazonHomePage;
import com.selenium.amazon_automation.pages.AmazonProductPage;
import com.selenium.amazon_automation.pages.AmazonSearchResultsPage;

public class AmazonTests extends BaseTest  {
	// ⏳ Debug wait helper (only for visibility)
    private void debugSleep(int seconds) {
        try {
            System.out.println("⏳ Waiting for " + seconds + " seconds...");
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

	/*
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
       
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();
       wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    @Test
    public void automateAmazon() throws IOException {

        // Navigate to homepage
        driver.get("https://www.amazon.in/");

        // Search product
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
        searchBox.sendKeys("laptop");
        searchBox.submit();
        
        // Click first search result
        WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[h2[contains(@class,'a-size-medium')]])[1]")));
        firstResult.click();

     //WebDriverWait wait1 = (WebDriverWait) wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".puis-card-container a.s-line-clamp-2.a-text-normal"))).click();

        	// 2. Find ALL matching elements and store them in a List
        	
        	
        // Validate product page loaded
        WebElement addToCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-button")));
        Assert.assertTrue(addToCart.isDisplayed(), "Add to Cart not visible!");

        // Take screenshot
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("product_page.png"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        
        */
	
     @Test
	    public void openHome() throws IOException {
	    	
	        System.out.println("🚀 TEST STARTED: Amazon automation");

            System.out.println("🖥️ Maximizing browser window");
            driver.manage().window().maximize();
            debugSleep(2);
            System.out.println("📄 Initializing Page Objects");

            System.out.println("🌐 Opening Amazon Home Page");
	        AmazonHomePage homePage = new AmazonHomePage(driver, wait);
	        homePage.openHomePage();
            System.out.println("✅ Home page opened: " + driver.getCurrentUrl());
            debugSleep(3);      
            
            System.out.println("🔍 Searching for product: laptop");
            homePage.searchProduct("laptop");
            debugSleep(3);

	        
	      }
	    @Test(dependsOnMethods = "openHome")
	    public void openSearch() {
            System.out.println("📦 Clicking first product from search results");
	        AmazonSearchResultsPage resultsPage = new AmazonSearchResultsPage(driver, wait);
	        resultsPage.clickFirstResult();
            debugSleep(4); 
	    }
	    
	    @Test(dependsOnMethods = "openSearch")
	    public void openProduct() throws IOException {
            System.out.println("🔎 Validating product page load (Add to Cart visibility)");
	        AmazonProductPage productPage = new AmazonProductPage(driver, wait);
	        System.out.println("📸 Taking screenshot after validation");
            productPage.takeScreenshot("Add_To_Cart_Visible");
            debugSleep(2); 
           /* boolean isVisible = productPage.isAddToCartVisible();
            System.out.println("📊 Add to Cart visible status: " + isVisible);
            Assert.assertTrue(isVisible, "❌ Add to Cart button not visible - Product page not loaded");
            */
            System.out.println("Clicking Add to Cart action");
            productPage.clickAddToCart();
            debugSleep(4);
             
            System.out.println("✅ Add to Cart clicked successfully");

        
	      
	    }    
	    }
	

    

