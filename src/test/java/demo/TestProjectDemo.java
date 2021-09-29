package demo;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

import io.testproject.sdk.DriverBuilder;
import io.testproject.sdk.drivers.web.ChromeDriver;

public class TestProjectDemo {
	public static void main(final String[] args) throws Exception {
		ChromeDriver driver = new DriverBuilder<ChromeDriver>(new ChromeOptions())
				  .withRemoteAddress(new URL("http://localhost:8585"))
				  .withToken("g6taEsND3mjc0mkIhjAWSwjuE3Eevte0CuyQDEc0GkY1")
				  .build(ChromeDriver.class);
		
    //    ChromeDriver driver = new ChromeDriver(new ChromeOptions());

        driver.navigate().to("https://example.testproject.io/web/");

        driver.findElement(By.cssSelector("#name")).sendKeys("John Smith");
        driver.findElement(By.cssSelector("#password")).sendKeys("12345");
        driver.findElement(By.cssSelector("#login")).click();

        boolean passed = driver.findElement(By.cssSelector("#logout")).isDisplayed();
        if (passed) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

        driver.quit();
    }
}
