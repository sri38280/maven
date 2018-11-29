package maven.maven;
//@ Sujana Sonkavelly
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class smoke {
	public static WebDriver driver;
	
	@BeforeMethod
	public void launchbrowser()
	{
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
			
	}
	@Test (priority=1)
	public void verifylaunchapplication(){
		driver.get("http://www.gcrit.com/build3/");
		String title = driver.getTitle();
		Assert.assertEquals("GCR Shop", title);
		
	}
	@Test (priority=2)
	public void verifyelements(){
		driver.get("http://www.gcrit.com/build3/");
		Assert.assertEquals(true,driver.findElement(By.linkText("login")).isDisplayed());
		Assert.assertEquals(true,driver.findElement(By.linkText("create an account")).isDisplayed());
	}

	@Test (priority=3)
	public void userRegistration() throws InterruptedException{
		driver.get("http://www.gcrit.com/build3/create_account.php");
		driver.findElement(By.name("gender")).click();
		driver.findElement(By.name("firstname")).sendKeys("abcd");
		driver.findElement(By.name("lastname")).sendKeys("xyz");
		driver.findElement(By.name("dob")).sendKeys("10/10/1980");
		driver.findElement(By.name("email_address")).sendKeys("hyderabada948@gmail.com");
		driver.findElement(By.name("street_address")).sendKeys("andhra bank lane");
		driver.findElement(By.name("postcode")).sendKeys("500038");
		driver.findElement(By.name("city")).sendKeys("Hyderabad");
		driver.findElement(By.name("state")).sendKeys("telengana");
		
		Select dropdown = new Select (driver.findElement(By.name("country")));
		dropdown.selectByVisibleText("India");
		driver.findElement(By.name("telephone")).sendKeys("9878987898");
		driver.findElement(By.name("password")).sendKeys("abcd123");
		driver.findElement(By.name("confirmation")).sendKeys("abcd123");
		
		driver.findElement(By.id("tdb4")).click();
		Thread.sleep(4000);
		
		Assert.assertEquals("Your Account Has Been Created!" , driver.findElement(By.tagName("h1")).getText());
		
	}
	
	@Test(priority=4)
	public void login()
	{
		driver.get("http://www.gcrit.com/build3/login.php");
		
		driver.findElement(By.name("email_address")).sendKeys("hyderabad98@gmail.com");
		driver.findElement(By.name("password")).sendKeys("abcd123");
		driver.findElement(By.id("tdb5")).click();
		Assert.assertEquals(true, driver.findElement(By.linkText("Log Off")).isDisplayed());
		
	}
	@AfterMethod
	public void closebrowser(){
		driver.close();
	}
	
	}
