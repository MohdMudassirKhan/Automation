package Appium.MobileAuto;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.Keys;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class Testing extends TestBase {
  @Test
  public void demoFail() throws InterruptedException {	  
	
	  driver.findElementByAccessibilityId("Search message").click(); 
	  driver.findElementById("com.google.android.apps.messaging:id/search_src_text").sendKeys(getData(0,1,1)); 
      /* MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Search messages");
	  el2.click();
	  MobileElement el3 = (MobileElement) driver.findElementById("com.google.android.apps.messaging:id/search_src_text");
	  el3.sendKeys("Demo"); */
	  Thread.sleep(2000);
  }
  
  @Test
  public void demoPass() throws InterruptedException {	  
	
	  driver.findElementByAccessibilityId("Search messages").click(); 
	  driver.findElementById("com.google.android.apps.messaging:id/search_src_text").sendKeys(getData(0,1,1)); 
      /* MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Search messages");
	  el2.click();
	  MobileElement el3 = (MobileElement) driver.findElementById("com.google.android.apps.messaging:id/search_src_text");
	  el3.sendKeys("Demo"); */
	  Thread.sleep(2000);
  }
  
  @BeforeSuite
  public void beforeSuite() {
	  setCapability();
  }
  @BeforeMethod
  public void beforeMethod() throws InterruptedException, IOException {
	  initAndroid();
  }

  @AfterMethod
  public void afterMethod(ITestResult result) throws IOException {
	  if (ITestResult.FAILURE==result.getStatus()) {
		  screenshot(result);
	  }
	  driver.quit();
  }
  }

