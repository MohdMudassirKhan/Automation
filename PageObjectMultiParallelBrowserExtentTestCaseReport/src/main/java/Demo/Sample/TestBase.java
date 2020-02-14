package Demo.Sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase 
{
	static Properties config = new Properties();
	static WebDriver driver = null;
    static XSSFWorkbook wb;
    static XSSFSheet sheet;
    static String path = System.getProperty("user.dir");
    
    public void init(String application) throws IOException {	
    	//configuration file loading
		FileInputStream configfile = new FileInputStream(path+"\\configs\\"+application+".properties");
		config.load(configfile);
		//test data excel file initialization
		String excelPath = path + config.getProperty("TestDataExcelPath");
	    File src = new File(excelPath);
	    FileInputStream fis = new FileInputStream(src);
	    wb = new XSSFWorkbook(fis);
		
    	//if (browser.equals("chrome")) {
    		System.setProperty("webdriver.chrome.driver", path + "\\resources\\chromedriver.exe");
    		driver = new ChromeDriver();
    		driver.manage().window().maximize();
    		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	//}
    	/*else if (browser.equals("firefox")) {
    		System.setProperty("webdriver.gecko.driver", path + "\\resources\\geckodriver.exe");  		
    		driver = new FirefoxDriver();
    		driver.manage().window().maximize();
    		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	}*/
    	
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
    
    public String MailCheckMailinator(String url, String Custmail) throws InterruptedException {  
		String windowHandle = driver.getWindowHandle();
		WebDriver handle = new ChromeDriver();
		handle.manage().window().maximize();
		handle.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			handle.get(url);
			handle.findElement(By.xpath("//*[@placeholder='Enter Public Mailinator Inbox']")).sendKeys(Custmail);
			handle.findElement(By.xpath("//*[@id='go-to-public']")).click();
			Thread.sleep(5000);
			handle.findElement(By.xpath("//*[contains(text(),'Your verification code')]")).click();
			handle.switchTo().frame("msg_body");
		} catch (Exception e) {
			System.out.println("Mail element given exception, Failure in Mailinator.");
			handle.close();
			e.printStackTrace();
		}
		String codeLine = handle.findElement(By.xpath("//*[contains(text(),'Your verification code')]")).getText();
		String[] arrSplit = codeLine.split(" ");
		String code = arrSplit[4].substring(0, arrSplit[4].length() - 1);
		Thread.sleep(2000);
		handle.close();
	    driver.switchTo().window(windowHandle);
    	return code;
    }
    
    //public void screenshot(ITestResult result) { 	
    	// Screenshot with taskbar and header, basically full screen
    	/*try {
    		BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
    		new File(path+"\\target\\Screenshots\\").mkdir();
    		ImageIO.write(image, "jpg", new File(path + "\\target\\Screenshots\\"+result.getName()+".jpg"));
    		System.out.println("Screenshot taken is "+path+"\\target\\Screenshots\\"+result.getName()+".jpg");    
    	}
    	catch( Exception e ) {
    		System.out.println("Exception while taking screenshot "+e.getMessage());
    	}*/
    	 
    	// Screenshot without taskbar and header, mainly focussed in application area only
    /*	try 
    	{
    		TakesScreenshot ts=(TakesScreenshot)driver;
    		new File(path+"\\target\\Screenshots\\").mkdir();
    		File source=ts.getScreenshotAs(OutputType.FILE);
    		FileUtils.copyFile(source, new File(path+"\\target\\Screenshots\\"+result.getName()+".png"));     
    		System.out.println("Screenshot taken at"+path+"\\target\\Screenshots\\"+result.getName()+".png");
    	} 
    	catch (Exception e)
    	{
    		System.out.println("Exception while taking screenshot "+e.getMessage());
    	}
    	   
    } */
    
    public void upload(WebElement uploadElement, String filename) throws InterruptedException {  
    	uploadElement.sendKeys(path+"\\InputFiles\\"+filename);
    }

	public WebDriver getDriver() {
		return driver;
	}
}
