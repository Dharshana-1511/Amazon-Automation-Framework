#Amazon Product Search Automation using Java Selenium 

#Objective
This project automates a basic e-commerce workflow on **Amazon** using **Selenium WebDriver with Java**.  
It demonstrates handling of dynamic web elements, use of explicit waits, and basic validation with screenshot capture.

#Automated Scenario
The following workflow is automated:

1. Navigate to the Amazon homepage  
2. Search for a product (example: **Laptop**)  
3. Click on the **first product** from the search results  
4. Validate that the **Product Details Page** is loaded  
   - Validation is done by checking the presence of the **“Add to Cart”** button  
5. Capture a **screenshot** of the Product Details Page

#Tech Stack
- Language: Java  
- Automation Tool:Selenium WebDriver  
- Build Tool:Maven  
- Browser:Google Chrome  
- Wait Strategy: Explicit Wait (`WebDriverWait`)  

#Project Structure
amazon-automation
├── src/test/java
│   ├── com.selenium.amazon_automation
│   ├── com.selenium.amazon_automation.base
│   │   └── BaseTest.java
│   ├── com.selenium.amazon_automation.pages
│   │   ├── AmazonHomePage.java
│   │   ├── AmazonProductPage.java
│   │   └── AmazonSearchResultsPage.java
│   └── com.selenium.amazon_automation.tests
│       └── AmazonTests.java
├── JRE System Library [JavaSE-17]
├── Maven Dependencies
├── TestNG
├── Product screenshots
│   └── Add_To_Cart_Visible.png
├── src
│   ├── main
│   └── test
├── target
├── test-output
├── pom.xml
└── testng.xml
