package ParkCharge.Regression;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
}
