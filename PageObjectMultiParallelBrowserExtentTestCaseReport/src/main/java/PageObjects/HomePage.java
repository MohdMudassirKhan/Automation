package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private static WebElement element = null;    

    public static WebElement firstName(WebDriver driver){
    	element = driver.findElement(By.xpath("//*[@name='firstname']"));
    	return element;
    }
 
    public static WebElement lastName(WebDriver driver){
    	element = driver.findElement(By.xpath("//*[@name='lastname']"));
    	return element;
    }
    
    public static WebElement month(WebDriver driver){
    	element = driver.findElement(By.id("month"));
    	return element;
    }
 
    public static WebElement customGender(WebDriver driver){
    	element = driver.findElement(By.xpath("//*[text()='Custom']"));
    	return element;
    }
    
    public static WebElement logIn(WebDriver driver){
    	element = driver.findElement(By.cssSelector("input[value='Log I']"));
    	return element;
    }
}
