package Demo.Sample;

import org.testng.annotations.Test;

import PageObjects.HomePage;
import Utils.ExtentReports.ExtentTestManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

	public class Automation extends TestBase {
		//browser value can be chrome, firefox.
		//String browser = "chrome";
		//give application name with environment for easy identification.
	  String application = "Demo";
		
	  @Test (priority = 0,description = "Facebook homepage passing scenario for demo")
	  public void DemoPass(Method method) throws InterruptedException {
		  ExtentTestManager.startTest(method.getName(), "Facebook homepage passing scenario for demo");
		  Thread.sleep(2000);
		  HomePage.firstName(driver).sendKeys(getData(0, 1, 1));	
		  HomePage.lastName(driver).sendKeys(getData(0, 2, 1));
		  Select selection = new Select(HomePage.month(driver));
		  selection.selectByVisibleText(getData(0, 3, 1));
		  Thread.sleep(2000);
		  HomePage.customGender(driver).click();
	  } 
	  
	  @Test (priority = 1,description = "Facebook homepage failing scenario for demo")
	  public void DemoFail(Method method) throws InterruptedException {
		  ExtentTestManager.startTest(method.getName(), "Facebook homepage failing scenario for demo");
		  Thread.sleep(2000);
		  HomePage.firstName(driver).sendKeys(getData(0, 1, 1));	
		  HomePage.lastName(driver).sendKeys(getData(0, 2, 1));
		  Select selection = new Select(HomePage.month(driver));
		  selection.selectByVisibleText(getData(0, 3, 1));
		  Thread.sleep(2000);
		  HomePage.logIn(driver).click();
	   }
	  
	  @Parameters("browser")
	  @BeforeMethod
	  public void beforeMethod(String browser) throws IOException {
		  init(application,browser);
		  driver.get(config.getProperty("Url"));
	  }

	  @AfterMethod
	  public void afterMethod() throws IOException {
		/*  if (ITestResult.FAILURE==result.getStatus()) {
			  screenshot(result);
		  }*/
		  driver.quit();
	  }
	  
	}