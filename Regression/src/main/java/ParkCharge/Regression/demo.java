package ParkCharge.Regression;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class demo {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/* driver.get("https://qa.idisciple.org/feed");
		driver.findElement(By.xpath("//*[text()='Sign in']")).click();
		driver.findElement(By.xpath("//*[@id='UserName']")).sendKeys("sarangjaltare@givingcompany.com");
		driver.findElement(By.xpath("//*[@id='signin']")).click();
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='nav navbar-nav d-xl-flex d-lg-flex d-md-flex d-sm-none d-none']/li[2]/a/span[2]")));
		//Thread.sleep(2000);
		//WebElement element = driver.findElement(By.xpath("//*[@class='header-centered']/nav/ul/li[2]/a"));
		//JavascriptExecutor executor = (JavascriptExecutor)driver;
		//executor.executeScript("arguments[0].click();", element);
		driver.findElement(By.xpath("//*[@class='dropdown-toggle']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='dropdown-toggle']")).click();
		driver.findElement(By.xpath("//*[text()=' Sign Out']")).click();
		//Actions hover = new Actions(driver);
		//hover.moveToElement(element).build().perform();
		//hover.clickAndHold().build().perform();
		//hover.release().build().perform();
		//Robot bot = new Robot();
		//int mask = InputEvent.BUTTON1_MASK;
		//bot.mouseMove(100, 100);           
		//bot.mousePress(mask);     
		//bot.mouseRelease(mask); */
		String windowHandle = driver.getWindowHandle();

		WebDriver handle = new ChromeDriver();

		
		handle.get("https://www.mailinator.com/");
		handle.findElement(By.xpath("//*[@placeholder='Enter Public Mailinator Inbox']")).sendKeys("testcasesignup1");
		handle.findElement(By.xpath("//*[@id='go-to-public']")).click();
		handle.findElement(By.xpath("//*[contains(text(),'Your verification code')]")).click();
    	Thread.sleep(3000);
    	handle.switchTo().frame("msg_body");
    	String codeLine = handle.findElement(By.xpath("//*[contains(text(),'Your verification code')]")).getText();
    	System.out.println("codeLine "+codeLine);
    	String[] arrSplit = codeLine.split(" ");
    	System.out.println("array "+arrSplit);
    	String code = arrSplit[4].substring(0, arrSplit[4].length() - 1);
    	
    	System.out.println("Code "+code);
    	
    	handle.close();
	    // change focus back to old tab
	    driver.switchTo().window(windowHandle);
	    driver.get("https://www.mailinator.com/");
		  

	}

}
