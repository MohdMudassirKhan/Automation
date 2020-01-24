package Demo.Sample;

import org.testng.annotations.Test;

import Demo.Sample.TestBase;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

	public class Automation extends TestBase {
		//browser value can be chrome, firefox.
		String browser = "chrome";
		//give application name with environment for easy identification.
		String application = "Demo";
		
	  @Test
	  public void ContactUs() throws InterruptedException {
		  //ContactUs flow test
		  Thread.sleep(7000);
		  driver.findElement(By.xpath(obj.getProperty("ContactUs"))).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath(obj.getProperty("Contact_FirstName"))).sendKeys(Keys.chord(Keys.CONTROL, "a"),getData(0,1,1));	
		  driver.findElement(By.xpath(obj.getProperty("Contact_Email"))).sendKeys(Keys.chord(Keys.CONTROL, "a"),getData(0,2,1));
		  driver.findElement(By.xpath(obj.getProperty("Contact_SkypeId"))).sendKeys(Keys.chord(Keys.CONTROL, "a"),getData(0,3,1));	  
		  driver.findElement(By.xpath(obj.getProperty("Contact_Subject"))).sendKeys(Keys.chord(Keys.CONTROL, "a"),getData(0,4,1));	
		  driver.findElement(By.xpath(obj.getProperty("Contact_Message"))).sendKeys(Keys.chord(Keys.CONTROL, "a"),getData(0,5,1));	
		  driver.findElement(By.xpath(obj.getProperty("Contact_Submit"))).click();
	  } 
	  
	   @Test
	  public void RequestProposal() throws InterruptedException {
		  //Request Proposal flow test
		  Thread.sleep(7000);
		  driver.findElement(By.xpath(obj.getProperty("RequestQuote"))).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath(obj.getProperty("RequestP_FirstName"))).sendKeys(Keys.chord(Keys.CONTROL, "a"),getData(1,1,1));	
		  driver.findElement(By.xpath(obj.getProperty("RequestP_CompanyName"))).sendKeys(Keys.chord(Keys.CONTROL, "a"),getData(1,2,1));
		  driver.findElement(By.xpath(obj.getProperty("RequestP_Email"))).sendKeys(Keys.chord(Keys.CONTROL, "a"),getData(1,3,1));	  
		  driver.findElement(By.xpath(obj.getProperty("RequestP_MobileNumber"))).sendKeys(Keys.chord(Keys.CONTROL, "a"),getData(1,4,1));	
		  driver.findElement(By.xpath(obj.getProperty("RequestP_SkypeId"))).sendKeys(Keys.chord(Keys.CONTROL, "a"),getData(1,5,1));	
		  driver.findElement(By.xpath(obj.getProperty("RequestP_SelectResources"))).click();
		  driver.findElement(By.xpath(obj.getProperty("RequestP_SelectedResource"))).click();	
		  driver.findElement(By.xpath(obj.getProperty("RequestP_SelectCategory"))).click();
		  driver.findElement(By.xpath(obj.getProperty("RequestP_SelectedCategory"))).click(); 
		  WebElement uploadElement = driver.findElement(By.xpath(obj.getProperty("RequestP_ChooseFile")));
		  String filename = "barcode.png";
	      upload(uploadElement,filename);
		  driver.findElement(By.xpath(obj.getProperty("RequestP_Message"))).sendKeys(Keys.chord(Keys.CONTROL, "a"),getData(1,6,1));	
		  Thread.sleep(3000);
	   } 
	  
	  @BeforeMethod
	  public void beforeMethod() throws IOException {
		  init(browser, application);
		  driver.get(config.getProperty("Url"));
	  }

	  @AfterMethod
	  public void afterMethod(ITestResult result) throws IOException {
		  if (ITestResult.FAILURE==result.getStatus()) {
			  screenshot(result);
		  }
		  driver.quit();
	  }
	  
	}