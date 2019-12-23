package ParkCharge.Regression;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase 
{
	static Properties obj = new Properties();
	static Properties config = new Properties();
	static WebDriver driver = null;
    static XSSFWorkbook wb;
    static XSSFSheet sheet;
    
    public void init(String browser, String application) throws IOException {
    	//project path
    	String path = System.getProperty("user.dir");
    	//configuration file loading
		FileInputStream configfile = new FileInputStream(path+"\\configs\\"+application+".properties");
		config.load(configfile);
		//test data excel file initialization
		String excelPath = path + config.getProperty("TestDataExcelPath");
	    File src = new File(excelPath);
	    FileInputStream fis = new FileInputStream(src);
	    wb = new XSSFWorkbook(fis);
		//object file loading
		FileInputStream objfile = new FileInputStream(path+"\\objects\\"+application+"ObjectRepository.properties");
		obj.load(objfile);
		
    	if (browser.equals("chrome")) {
    		System.setProperty("webdriver.chrome.driver", path + "\\resources\\chromedriver.exe");
    		driver = new ChromeDriver();
    		driver.manage().window().maximize();
    		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	}
    	else if (browser.equals("firefox")) {
    		System.setProperty("webdriver.gecko.driver", path + "\\resources\\geckodriver.exe");  		
    		driver = new FirefoxDriver();
    		driver.manage().window().maximize();
    		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	}
    	
    }
     
    public String getData(int sheetnumber, int row, int column)
    {
    //Count sheet number, row and column from 0.	
    sheet = wb.getSheetAt(sheetnumber);
    String data = sheet.getRow(row).getCell(column).getStringCellValue();
    return data;
    }
     
    public int getRowCount(int sheetIndex)
    {
    int row = wb.getSheetAt(sheetIndex).getLastRowNum();
    row = row + 1;
    return row;
    }
    
    public String MailCheckMailinator(String url, String Custmail) throws InterruptedException {  
		String windowHandle = driver.getWindowHandle();
		WebDriver handle = new ChromeDriver();
		handle.manage().window().maximize();
		handle.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		handle.get(url);
		handle.findElement(By.xpath("//*[@placeholder='Enter Public Mailinator Inbox']")).sendKeys(Custmail);
		handle.findElement(By.xpath("//*[@id='go-to-public']")).click();
		Thread.sleep(5000);
		handle.findElement(By.xpath("//*[contains(text(),'Your verification code')]")).click();
		handle.switchTo().frame("msg_body");
    	String codeLine = handle.findElement(By.xpath("//*[contains(text(),'Your verification code')]")).getText();
    	String[] arrSplit = codeLine.split(" ");
    	String code = arrSplit[4].substring(0, arrSplit[4].length() - 1);
    	Thread.sleep(2000);
    	handle.close();
	    driver.switchTo().window(windowHandle);
    	return code;
    }
}