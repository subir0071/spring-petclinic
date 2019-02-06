package com.test.selenium;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class ExampleIT {
	private WebDriver driver;

	@Test
	public void f() {
		
		String chromeDriverpath = "D:\\Software\\chromedriver_win32\\chromedriver.exe";
		WebDriver driver;

		System.setProperty("webdriver.chrome.driver", chromeDriverpath);

		// create a new instance of the Firefox driver
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Open the page we want to open
		driver.get("http://localhost:8020/petclinic/");

		//Defining Expected Title
		String expectedTitle = "PetClinic :: a Spring Framework demonstration";
		//Getting the actual Title
		String actualTitle = null;
		actualTitle=driver.getTitle();
		Assert.assertTrue(actualTitle.contains(expectedTitle));
		driver.quit();
		/*driver.get("http://demo.guru99.com/test/guru99home/");
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Demo Guru99 Page"));*/
	}

	/*@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
*/
}
