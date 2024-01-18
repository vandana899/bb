package bbvv;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.awt.Desktop.Action;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class maven {
public static String van="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
ExtentReports extent;
ExtentHtmlReporter htmlReporter;
ExtentTest test;
WebDriver driver;
@BeforeTest
public void bt() {
	WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
	driver.get(van);
	driver.manage().window().maximize();
	
	 extent=new ExtentReports();
 htmlReporter=new ExtentHtmlReporter("extent.html");
	extent.attachReporter(htmlReporter);
	
}
@Test
public void login() throws InterruptedException {
	System.out.println("orangehrm is opened");
	test=extent.createTest("this is my first test");
	
	Thread.sleep(4000);
	WebElement user= driver.findElement(By.name("username"));
    if(user.isEnabled()) {
    	user.sendKeys("Admin");
    	test.pass("entered username");
    
    }
    Thread.sleep(4000);
    WebElement pass= driver.findElement(By.name("password"));
    Thread.sleep(4000);
    if(pass.isEnabled()) {
    	pass.sendKeys("admin123");
    	test.pass("entered password");
    	
    }
    Thread.sleep(4000);
    driver.findElement(By.xpath("//*[@type='submit']")).click();
    test.pass("submitted");
    Thread.sleep(4000);
    driver.findElement(By.linkText("Admin")).click();
    test.pass("clicked on admin");
    Thread.sleep(4000);
}
//@Test
//public void tc() {
//	List<WebElement> ele=  driver.findElements(By.tagName("a"));
//	System.out.println(ele.size());
//	for(int i=0;i<ele.size();i++) {
//		System.out.println(ele.get(i).getText());
//		System.out.println(ele.get(i).getAttribute("href"));
//	}
	

@Test(enabled=false)
public void tc3() {
	List<WebElement> bb=driver.findElements(By.xpath("//*[@class='oxd-table-card']"));
	System.out.println(bb.size());
	Actions act2=new Actions(driver);
	WebElement hh= driver.findElements(By.xpath("//*[@class='oxd-table-card']")).get(1);
	act2.click(hh).build().perform();
}   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    WebElement ele=driver.findElement(By.xpath("//*[@class='oxd-select-text oxd-select-text--active']//div"));
//    Select s=new Select(ele);
//    s.selectByIndex(1);
//   String beforelogin= driver.getTitle();
//   Thread.sleep(4000);
//       driver.findElement(By.xpath("//*[@type='submit']")).click();
//    Thread.sleep(4000);

//       String afterlogin=driver.getTitle();
       //assertions:- comparing expected result and actual result
//       Thread.sleep(4000);
//   Assert.assertEquals(beforelogin, afterlogin);
//   System.out.println("same");
  
  
  
  
  

@AfterTest
public void at() {
	driver.close();
	extent.flush();
}
}

