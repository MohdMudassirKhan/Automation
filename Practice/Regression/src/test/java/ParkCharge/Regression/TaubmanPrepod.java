package ParkCharge.Regression;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;

public class TaubmanPrepod extends TestBase {
	//browser value can be chrome, firefox.
	String browser = "chrome";
	//give application name with environment for easy identification.
	String application = "TaubmanPreprod";
	
  @Test
  public void launch() throws InterruptedException {
	  driver.findElement(By.xpath(obj.getProperty("LoginEmail"))).sendKeys(getData(1,3,0));
	  driver.findElement(By.xpath(obj.getProperty("LoginPassword"))).sendKeys(getData(1,3,1));
	  driver.findElement(By.xpath(obj.getProperty("LoginButton"))).click();
	  driver.findElement(By.xpath(obj.getProperty("Logout"))).click();
	  Thread.sleep(3000);
  }
  
  @BeforeSuite
  public void beforeSuite() throws IOException {
	  init(browser, application);
	  driver.get(config.getProperty("Url"));
  }

  @AfterSuite
  public void afterSuite() {
	  driver.close();
  }

}
