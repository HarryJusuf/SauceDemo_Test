package Temp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Login {

    @Test
    public void StandardUser_Positive() {

        WebDriver driver;
        String baseURL = "https://www.saucedemo.com";

        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        String username = "standard_user";
        String passwd = "secret_sauce";

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseURL);

        String getTitle = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(getTitle,"Swag Labs");
        driver.findElement(By.id("user-name")).sendKeys(username);
        Assert.assertEquals(username,"standard_user");
        driver.findElement(By.id("password")).sendKeys(passwd);
        Assert.assertEquals(passwd,"secret_sauce");
        driver.findElement(By.id("login-button")).click();
        //driver.findElement(By.xpath("//button[@type='submit']")).click();

        String getHeader = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div")).getText();
        Assert.assertEquals(getHeader, "Swag Labs");

        driver.close();
    }

    @Test
    public void StandardUser_WrongPasswd_Negative(){

        WebDriver driver;
        String baseURL = "https://www.saucedemo.com";

        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        String username = "standard_user";
        String passwd = "wrong password";

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseURL);

        String getTitle = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(getTitle,"Swag Labs");
        driver.findElement(By.id("user-name")).sendKeys(username);
        Assert.assertEquals(username,"standard_user");
        driver.findElement(By.id("password")).sendKeys(passwd);
        Assert.assertEquals(passwd,"wrong password");
        driver.findElement(By.id("login-button")).click();
        //driver.findElement(By.xpath("//button[@type='submit']")).click();

        //String getHeader = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div")).getText();

        String getErrorMsg = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        //System.out.println(getErrorMsg);
        Assert.assertEquals(getErrorMsg
                , "Epic sadface: Username and password do not match any user in this service");

        driver.close();





    }



}
