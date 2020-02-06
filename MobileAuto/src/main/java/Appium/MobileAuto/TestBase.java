package Appium.MobileAuto;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;

import io.appium.java_client.android.AndroidDriver;

public class TestBase 
{	
	 //1.apk taken - not making sense if we are running multiple test cases
	 //2.browser run 3.remote machine url
	 static AndroidDriver driver;
	 static DesiredCapabilities capabilities = new DesiredCapabilities();
	 static XSSFWorkbook wb;
	 static XSSFSheet sheet;
	 static String path = System.getProperty("user.dir");
	    	    
	 public static void setCapability() {
		
		 capabilities.setCapability("deviceName", "emulator-5554");
		 capabilities.setCapability("platformName", "Android");
		 capabilities.setCapability("appPackage", "com.google.android.apps.messaging");
		 capabilities.setCapability("appActivity", ".ui.ConversationListActivity");
	 }
	 
	 public static void initAndroid() throws MalformedURLException, InterruptedException, IOException {
	 
		 String excelPath = path + "\\Data\\TestData.xlsx";
		 File src = new File(excelPath);
		 FileInputStream fis = new FileInputStream(src);
 	     wb = new XSSFWorkbook(fis);
 	     
		 driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 }
	 
	 public String getData(int sheetnumber, int row, int column) {
	    	//Count sheet number, row and column from 0.	
	    	sheet = wb.getSheetAt(sheetnumber);
	    	String data = sheet.getRow(row).getCell(column).getStringCellValue();
	    	return data;
	 }
	    
	 public int getRowCount(int sheetIndex) {
	    	int row = wb.getSheetAt(sheetIndex).getLastRowNum();
	    	row = row + 1;
	    	return row;
	 }
	 
	 public void screenshot(ITestResult result) { 	
	    	try {
	    		BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	    		new File(path+"\\target\\Screenshots\\").mkdir();
	    		ImageIO.write(image, "jpg", new File(path + "\\target\\Screenshots\\"+result.getName()+".jpg"));
	    		System.out.println("Screenshot taken is "+path+"\\target\\Screenshots\\"+result.getName()+".jpg");     
	    	}
	    	catch( Exception e ) {
	    		System.out.println("Exception while taking screenshot "+e.getMessage());
	    	}
	    	 
	    	/* Screenshot without taskbar and header, mainly focussed in application area only
	    	try 
	    	{
	    		TakesScreenshot ts=(TakesScreenshot)driver;
	    		File source=ts.getScreenshotAs(OutputType.FILE);
	    		FileUtils.copyFile(source, new File(path+"\\Screenshots\\"+result.getName()+".png"));     
	    		System.out.println("Screenshot taken at"+path+"\\Screenshots\\"+result.getName()+".png");
	    	} 
	    	catch (Exception e)
	    	{
	    		System.out.println("Exception while taking screenshot "+e.getMessage());
	    	}
	    	*/   
	 }
	 
}

/* static AndroidDriver driver;
	 public static void initAndroid() throws MalformedURLException, InterruptedException {
	 
	 //File classpathRoot = new File(System.getProperty("user.dir"));
	 //File appDir = new File(classpathRoot, "/Apps/Amazon");
	 //File app = new File(appDir, "amazon.apk");
	 
	 DesiredCapabilities capabilities = new DesiredCapabilities();
	 //capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
	 capabilities.setCapability("deviceName", "emulator-5554");
	 //capabilities.setCapability("platformVersion", "9.0");
	 capabilities.setCapability("platformName", "Android");
	 //capabilities.setCapability("app", app.getAbsolutePath());
	 capabilities.setCapability("appPackage", "com.google.android.apps.messaging");
	 capabilities.setCapability("appActivity", ".ui.ConversationListActivity");
	 
	 driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	 driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	 
	 MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Search messages");
	 el2.click();
	 MobileElement el3 = (MobileElement) driver.findElementById("com.google.android.apps.messaging:id/search_src_text");
	 el3.sendKeys("Demo");
	 Thread.sleep(2000);
	 //driver.quit();
 * 
 * 
 */



