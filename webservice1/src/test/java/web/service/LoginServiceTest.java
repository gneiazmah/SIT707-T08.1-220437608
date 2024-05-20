package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginServiceTest {

    private void sleep(long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLoginPageLoad() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("file:///C:/Users/hp/Desktop/SIT-707/Task 8/webservice1/src/main/resources/webapp/login.html");
        sleep(5);

        String title = driver.getTitle();
        Assert.assertEquals("Login Page", title);

        driver.close();
    }

    @Test
    public void testLoginSuccess() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("file:///C:/Users/hp/Desktop/SIT-707/Task 8/webservice1/src/main/resources/webapp/login.html");
        sleep(5);

        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys("validUser");

        ele = driver.findElement(By.id("password"));
        ele.clear();
        ele.sendKeys("validPass");

        ele = driver.findElement(By.id("dob"));
        ele.clear();
        ele.sendKeys("2000-01-01");

        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();
        sleep(5);

        String title = driver.getTitle();
        Assert.assertEquals("success", title);

        driver.close();
    }

    @Test
    public void testLoginWithInvalidPassword() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("file:///C:/Users/hp/Desktop/SIT-707/Task 8/webservice1/src/main/resources/webapp/login.html");
        sleep(5);

        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys("validUser");

        ele = driver.findElement(By.id("password"));
        ele.clear();
        ele.sendKeys("invalidPass");

        ele = driver.findElement(By.id("dob"));
        ele.clear();
        ele.sendKeys("2000-01-01");

        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();
        sleep(5);

        String title = driver.getTitle();
        Assert.assertEquals("fail", title);

        driver.close();
    }

    @Test
    public void testLoginWithInvalidUsername() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("file:///C:/Users/hp/Desktop/SIT-707/Task 8/webservice1/src/main/resources/webapp/login.html");
        sleep(5);

        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys("invalidUser");

        ele = driver.findElement(By.id("password"));
        ele.clear();
        ele.sendKeys("validPass");

        ele = driver.findElement(By.id("dob"));
        ele.clear();
        ele.sendKeys("2000-01-01");

        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();
        sleep(5);

        String title = driver.getTitle();
        Assert.assertEquals("fail", title);

        driver.close();
    }

    @Test
    public void testLoginWithEmptyFields() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("file:///C:/Users/hp/Desktop/SIT-707/Task 8/webservice1/src/main/resources/webapp/login.html");
        sleep(5);

        WebElement ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();
        sleep(5);

        // The error message id should be checked against actual HTML implementation
        WebElement errorMessage = driver.findElement(By.id("error-message"));
        Assert.assertEquals("Fields cannot be empty", errorMessage.getText());

        driver.close();
    }
}
