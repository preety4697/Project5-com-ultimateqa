package ultimateqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class UltimateqaTest {
    static String browser ="Chrome";
    static String baseurl = "https://courses.ultimateqa.com/";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        //Set up multi browser
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("FireFox")) {
            driver = new FirefoxDriver();
        }else {
            System.out.println("Wrong browser name");
        }
        //Open the url into the browser
        driver.get(baseurl);
        Thread.sleep(5000);

        //Maximise the browser
        driver.manage().window().maximize();

        //we give implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Get the title of the page
        String title = driver.getTitle();
        System.out.println(title);

        //Get the current url
        System.out.println("The current url : " + driver.getCurrentUrl());

        //Get the page source code
        System.out.println(driver.getPageSource());

        //Click on 'sign in' link
        WebElement signIn = driver.findElement(By.linkText("Sign In"));
        signIn.click();

        //print the current url
        System.out.println(driver.getCurrentUrl());

        //Enter the email to email field
        WebElement email = driver.findElement(By.id("user[email]"));
        email.sendKeys("hello");
        Thread.sleep(4000);

        //Enter the password to password field
        WebElement pass = driver.findElement(By.id("user[password]"));
        pass.sendKeys("hello123");
        Thread.sleep(4000);

        //Click login
        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();
        Thread.sleep(4000);

        //navigate to base
        driver.navigate().to(baseurl);
        Thread.sleep(4000);

        //navigate forward
        driver.navigate().forward();
        Thread.sleep(4000);

        //navigate back
        driver.navigate().back();
        Thread.sleep(4000);

        //refresh
        driver.navigate().refresh();
        Thread.sleep(4000);

        //Close the browser
        driver.quit();
    }
}
