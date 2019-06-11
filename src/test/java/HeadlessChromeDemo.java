import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import junit.framework.Assert;
import junit.framework.TestCase;

public class HeadlessChromeDemoIT extends TestCase
{
    public static void main(String args[])
    {
        test();
    }
    public static void test()
    {
        System.setProperty("ebdriver.chrome.driver","/usr/bin/chromedriver");
        
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("chrome.switches","--disable-extensions");
        options.addArguments("chrome.switches","--no-sandbox");
        
        WebDriver driver = new ChromeDriver(options);
      
        
        driver.get("https:google.com");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Google");     
        driver.close();
        driver.quit();
        
    }
}
