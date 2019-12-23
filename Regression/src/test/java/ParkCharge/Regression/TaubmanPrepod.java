package ParkCharge.Regression;

import org.testng.annotations.Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TaubmanPrepod extends TestBase {
	//browser value can be chrome, firefox.
	String browser = "chrome";
	//give application name with environment for easy identification.
	String application = "TaubmanPreprod";
	
  @Test
  public void modify() throws InterruptedException {
	  //modify flow test
	  //Login Page
	  driver.findElement(By.xpath(obj.getProperty("LoginEmail"))).sendKeys(getData(1,1,1));
	  driver.findElement(By.xpath(obj.getProperty("LoginPassword"))).sendKeys(getData(1,2,1));
	  driver.findElement(By.xpath(obj.getProperty("LoginButton"))).click();
	  Thread.sleep(2000);
	  //Welcome Back Page
	  driver.findElement(By.xpath(obj.getProperty("ModifyAccount"))).click();
	  Thread.sleep(2000);
	  //Your Information Page
	  driver.findElement(By.xpath(obj.getProperty("FirstName"))).sendKeys(Keys.chord(Keys.CONTROL, "a"),getData(1,3,1));	
	  driver.findElement(By.xpath(obj.getProperty("LastName"))).sendKeys(Keys.chord(Keys.CONTROL, "a"),getData(1,4,1));
	  driver.findElement(By.xpath(obj.getProperty("AddressOne"))).sendKeys(Keys.chord(Keys.CONTROL, "a"),getData(1,5,1));	  
	  driver.findElement(By.xpath(obj.getProperty("AddressTwo"))).sendKeys(Keys.chord(Keys.CONTROL, "a"),getData(1,6,1));	
	  driver.findElement(By.xpath(obj.getProperty("State"))).sendKeys(Keys.chord(Keys.CONTROL, "a"),getData(1,7,1));	
	  driver.findElement(By.xpath(obj.getProperty("YIP_NextStep"))).click();
	  Thread.sleep(2000);
	  //Vehicle Details Page
	  driver.findElement(By.xpath(obj.getProperty("DeleteFirst"))).click();
	  driver.findElement(By.xpath(obj.getProperty("LicensePlate"))).sendKeys(getData(1,8,1));	
	  driver.findElement(By.xpath(obj.getProperty("ConfirmLicensePlate"))).sendKeys(getData(1,9,1));
	  driver.findElement(By.xpath(obj.getProperty("VehicleColor"))).sendKeys(getData(1,10,1));
	  driver.findElement(By.xpath(obj.getProperty("AddVehicle"))).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(obj.getProperty("VDP_NextStep"))).click();
	  Thread.sleep(2000);
	  //Payment Details Page
	  driver.findElement(By.xpath(obj.getProperty("PDP_NextStep"))).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(obj.getProperty("UpdateCardDetailsCheckBox"))).click();
	  driver.findElement(By.xpath(obj.getProperty("CardNumber"))).sendKeys(getData(1,11,1));
	  driver.findElement(By.xpath(obj.getProperty("CardName"))).sendKeys(getData(1,12,1));	  
	  Select selectOne = new Select(driver.findElement(By.xpath(obj.getProperty("ExpiryMonth"))));
	  selectOne.selectByVisibleText(getData(1,13,1));
	  Select selectTwo = new Select(driver.findElement(By.xpath(obj.getProperty("ExpiryYear"))));
	  selectTwo.selectByVisibleText(getData(1,14,1));	  
	  driver.findElement(By.xpath(obj.getProperty("Cvv"))).sendKeys(getData(1,15,1));
	  driver.findElement(By.xpath(obj.getProperty("PDP_NextStep"))).click();
	  Thread.sleep(2000);
	  //Complete Modify Details Page
	  driver.findElement(By.xpath(obj.getProperty("UpdateButton"))).click();
	  //Modification Complete Page
	  //WebDriverWait wait=new WebDriverWait(driver,20);
	  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj.getProperty("ModificationDoneButton"))));
	  ///Thread.sleep(2000);
	  ///driver.findElement(By.xpath(obj.getProperty("ModificationDoneButton"))).click();
	  //Thread.sleep(2000);
	  //Welcome Back Page
	  //driver.findElement(By.xpath(obj.getProperty("Logout"))).click();
	  Thread.sleep(2000);
  } 
  
  @Test
  public void signUp() throws InterruptedException {
	  //Sign up flow test
	  //Sign up Page
	  driver.findElement(By.xpath(obj.getProperty("SignUpButton"))).click();
	  driver.findElement(By.xpath(obj.getProperty("SignUp_FirstName"))).sendKeys(getData(0,1,1));
	  driver.findElement(By.xpath(obj.getProperty("SignUp_LastName"))).sendKeys(getData(0,2,1));
	  driver.findElement(By.xpath(obj.getProperty("SignUp_Email"))).sendKeys(getData(0,3,1));
	  driver.findElement(By.xpath(obj.getProperty("SignUp_Password"))).sendKeys(getData(0,4,1));
	  driver.findElement(By.xpath(obj.getProperty("SignUp_ConfirmPassword"))).sendKeys(getData(0,5,1));
	  driver.findElement(By.xpath(obj.getProperty("SignUp_SignUp"))).click();
	  Thread.sleep(2000);
	  String Custmail = getData(0,3,1);
	  String code = MailCheckMailinator(config.getProperty("MailinatorUrl"),Custmail);
	  Thread.sleep(2000);
	  //Email Verification Page
	  driver.findElement(By.xpath(obj.getProperty("VerificationCode"))).sendKeys(code);	  
	  driver.findElement(By.xpath(obj.getProperty("ConfirmAccountButton"))).click();
	  Thread.sleep(2000);
	  //Your Information Page
	  driver.findElement(By.xpath(obj.getProperty("AddressOne"))).sendKeys(getData(0,6,1));	  
	  driver.findElement(By.xpath(obj.getProperty("AddressTwo"))).sendKeys(getData(0,7,1));	
	  driver.findElement(By.xpath(obj.getProperty("State"))).sendKeys(getData(0,8,1));	
	  driver.findElement(By.xpath(obj.getProperty("ZipCode"))).sendKeys(getData(0,9,1));	
	  driver.findElement(By.xpath(obj.getProperty("MobileNumber"))).sendKeys(getData(0,10,1));	
	  driver.findElement(By.xpath(obj.getProperty("ConfirmTermsCondition"))).click();
	  driver.findElement(By.xpath(obj.getProperty("AcceptMarketingInfo"))).click();
	  driver.findElement(By.xpath(obj.getProperty("YIP_NextStep"))).click();
	  Thread.sleep(2000);
	  //Vehicle Details Page
	  driver.findElement(By.xpath(obj.getProperty("LicensePlate"))).sendKeys(getData(0,11,1));	
	  driver.findElement(By.xpath(obj.getProperty("ConfirmLicensePlate"))).sendKeys(getData(0,12,1));
	  driver.findElement(By.xpath(obj.getProperty("VehicleColor"))).sendKeys(getData(0,13,1));
	  driver.findElement(By.xpath(obj.getProperty("AddVehicle"))).click();
	  Thread.sleep(2000);	  
	  driver.findElement(By.xpath(obj.getProperty("VDP_NextStep"))).click();
	  Thread.sleep(2000);
	  //Payment Details Page
	  driver.findElement(By.xpath(obj.getProperty("PDP_NextStep"))).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(obj.getProperty("CardNumber"))).sendKeys(getData(0,14,1));
	  driver.findElement(By.xpath(obj.getProperty("CardName"))).sendKeys(getData(0,15,1));	  
	  Select selectOne = new Select(driver.findElement(By.xpath(obj.getProperty("ExpiryMonth"))));
	  selectOne.selectByVisibleText(getData(0,16,1));
	  Select selectTwo = new Select(driver.findElement(By.xpath(obj.getProperty("ExpiryYear"))));
	  selectTwo.selectByVisibleText(getData(0,17,1));	  
	  driver.findElement(By.xpath(obj.getProperty("Cvv"))).sendKeys(getData(0,18,1));
	  driver.findElement(By.xpath(obj.getProperty("PDP_NextStep"))).click();
	  Thread.sleep(2000);
	  //Finished Page
	  driver.findElement(By.xpath(obj.getProperty("CompleteRegistrationButton"))).click();
	  //Account Confirmation Page
	  WebDriverWait wait=new WebDriverWait(driver,20);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj.getProperty("SignUpDoneButton"))));
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(obj.getProperty("SignUpDoneButton"))).click();
	  Thread.sleep(3000);
  } 
  
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  init(browser, application);
	  driver.get(config.getProperty("Url"));
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
