package RegistrationFormTest;

import java.awt.AWTException;
import java.util.List;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class RegForm {

	public static void main(String[] args) throws AWTException, InterruptedException {
		// WebDriver object instantiation 	
		WebDriver driver = new ChromeDriver();
		// Implementing implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id = 'name']")).sendKeys("Alok Tiwari");
		driver.findElement(By.xpath("//input[@id = 'email']")).sendKeys("test@yopmail.com");
		driver.findElement(By.xpath("//input[@id = 'gender']")).click();
		driver.findElement(By.xpath("//input[@id = 'mobile']")).sendKeys("5588990077");
		driver.findElement(By.xpath("//input[@id = 'dob']")).sendKeys("10/06/1994");
		driver.findElement(By.xpath("//input[@id = 'subjects']")).sendKeys("Mathematics");
		driver.findElement(By.xpath("//input[@id = 'hobbies']")).click();
		
		//uploading a picture
		WebElement uploadFile = driver.findElement(By.xpath("//input[@type='file']"));
		
		Actions ac = new Actions(driver);
		ac.click(uploadFile).perform();
		
		Robot rb = new Robot();
		// Wait for 2 seconds to ensure the file dialog is open
		rb.delay(2000);
		// Copy the file path to the clipboard
		StringSelection ss = new StringSelection("C:\\Users\\alokz\\OneDrive\\Desktop\\bull");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		rb.delay(1000);
		// Simulate pressing CTRL + V to paste the copied file path
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		// Simulate pressing ENTER to confirm the file selections
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);
		
		List<WebElement> uploadedPath= driver.findElements(By.cssSelector("input#picture"));
		
		if(uploadedPath.size()>0) {
		System.out.println("File Uploaded successfully");

		
		driver.findElement(By.xpath("//textarea[@placeholder='Currend Address']")).sendKeys("Test address");
		Select dd1 = new Select (driver.findElement(By.id("state")));
		dd1.selectByVisibleText("Uttar Pradesh");
		Select dd2 = new Select (driver.findElement(By.id("city")));
		dd2.selectByVisibleText("Agra");
		
//		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
	}

}}
