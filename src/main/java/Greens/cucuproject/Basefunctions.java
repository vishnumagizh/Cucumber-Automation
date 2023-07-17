package Greens.cucuproject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Basefunctions {
	
public static WebDriver driver;
	

	// Launch browser
	public static WebDriver browserlauncher(String option) {

		if (option.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			
		} else if (option.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		return driver;
	}
	// launch url
		public static void gourl(String url) {

			driver.get(url);
			

		}
		// send keys
		public static void sendkeys(String text, WebElement ele) {
			ele.sendKeys(text);

		}

		// Dropdown index
		public static void dropindex(WebElement ele, int index) {
			Select sc = new Select(ele);
			sc.selectByIndex(index);

		}

		// Drop down text
		public static void droptext(WebElement ele, String text) {
			Select sc = new Select(ele);
			sc.selectByVisibleText(text);

		}

		// Dropdown value
		public static void dropvalue(WebElement ele, String text) {
			Select sc = new Select(ele);
			sc.selectByValue(text);
		}
		// implicit wait
		public static void implicitwait(int i) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(i));
		}
		// Explicit wait
				public static void explicitwait(By ele, String options) 
				{
					WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
					if(options.equalsIgnoreCase("visibility"))
					{
					WebElement until1 = wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
					String text1 = until1.getText();
					System.out.println("Visible element: "+text1);
					}
					else if(options.equalsIgnoreCase("invisibility"))
					{
						Boolean until2 = wait.until(ExpectedConditions.invisibilityOfElementLocated(ele));
						System.out.println(until2 + "It is invisible");
					}
					else if(options.equalsIgnoreCase("clickable"))
					{
						WebElement until3 = wait.until(ExpectedConditions.elementToBeClickable(ele));
						String text2 = until3.getText();
						System.out.println("Clickable element: "+text2);
					}
				}
				
				public static void explicitwait(By ele, String options,String text) 
				{
					WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
					 if(options.equalsIgnoreCase("texttobepresent"))
					{
						Boolean until4 = wait.until(ExpectedConditions.textToBePresentInElementLocated(ele,text));
						System.out.println(until4);	
					}

					

				}	
				// robot enter
				public static void robotenter() throws AWTException {
					Robot rc = new Robot();
					rc.keyPress(KeyEvent.VK_ENTER);
					rc.keyRelease(KeyEvent.VK_ENTER);

				}

		

}
