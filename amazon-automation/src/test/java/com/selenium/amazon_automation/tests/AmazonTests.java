package com.selenium.amazon_automation.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import com.selenium.amazon_automation.base.BaseTest;
import com.selenium.amazon_automation.pages.AmazonHomePage;
import com.selenium.amazon_automation.pages.AmazonProductPage;
import com.selenium.amazon_automation.pages.AmazonSearchResultsPage;

public class AmazonTests extends BaseTest  {

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
	    public void automateAmazon() throws IOException {

	        AmazonHomePage homePage = new AmazonHomePage(driver, wait);
	        AmazonSearchResultsPage resultsPage = new AmazonSearchResultsPage(driver, wait);
	        AmazonProductPage productPage = new AmazonProductPage(driver, wait);

	        homePage.openHomePage();
	        homePage.searchProduct("laptop");
	        resultsPage.clickFirstResult();

	        // ✅ Validation
	       Assert.assertTrue(
	                productPage.isAddToCartVisible(),
	                "Add to Cart button not visible - Product page not loaded"
	        );
	        
	      

	        // 📸 Screenshot after validation
	        productPage.takeScreenshot("Add_To_Cart_Visible");
	        
	    }
	    }

    

