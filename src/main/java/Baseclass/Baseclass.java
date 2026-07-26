package Baseclass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.common.io.Files;

public class Baseclass {

	public static void Browserlaunch()
	{
		ChromeDriver driver = new ChromeDriver();
	}

	public static void geturl(String url) 
	{
		ChromeDriver chromeDriver = new ChromeDriver();
		chromeDriver.get(url);
	}

	public static void maximize() 
	{
		ChromeDriver.manage().window().maximize();
	}	

	public static void implicitywait() 
	{
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));	
	}
	public static void MouseHover(WebElement Element)
	{
		Actions hover = new Actions(driver);

		hover.moveToElement(Element).perform();

	}
		
	public static void Scrolldown(WebElement Element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("argument[0].scrollintoview()",Element);
	}

	public static void WindowsHandling(int ind)
	{
		Set<String> windowHandle = driver.getWindowHandles();

		List<String> window = new ArrayList<String>(windowHandle);

		driver.switchTo().window(window.get(ind ));	
	}

	public static void screenshot(WebElement table) throws IOException
	{

	TakesScreenshot screenshot = (TakesScreenshot)driver;	

	File img = screenshot.getScreenshotAs(OutputType.FILE);

	File imagepath = new File("C:\\Users\\Admin\\eclipse-workspace\\Worryproject\\img"+table+"M.png");

	Files.copy((File) table,imagepath);

	}
	
	
	
}
