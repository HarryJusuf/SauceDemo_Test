package SQATugasW6.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class login {

    WebDriver driver;
    String baseURL = "https://www.saucedemo.com";

    @Given("SauceDemo Login Page")
    public void SauceDemo_Login_Page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseURL);

    }

    @When("Input Username")
    public void inputUsername() {
        String username = "standard_user";

        driver.findElement(By.id("user-name")).sendKeys(username);
        Assert.assertEquals(username,"standard_user");
    }

    @And("Input Password")
    public void inputPassword() {
        String passwd = "secret_sauce";

        driver.findElement(By.id("password")).sendKeys(passwd);
        Assert.assertEquals(passwd,"secret_sauce");
    }

    @And("click Login Button")
    public void clickLoginButton() {
        driver.findElement(By.id("login-button")).click();

    }

    @Then("User in Main Content Page")
    public void userInMainContentPage() {
        String getHeader = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div")).getText();
        Assert.assertEquals(getHeader, "Swag Labs");

        driver.close();
    }

    @And("input Invalid Password")
    public void inputInvalidPassword() {
        String passwd = "wrong password";

        driver.findElement(By.id("password")).sendKeys(passwd);
        Assert.assertEquals(passwd,"wrong password");
    }

    @Then("shown error login message")
    public void shownErrorLoginMessage() {
        String getErrorMsg = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        //System.out.println(getErrorMsg);
        Assert.assertEquals(getErrorMsg, "Epic sadface: Username and password do not match any user in this service");

        driver.close();
    }

    @When("Input Locked Username")
    public void inputLockedUsername() {
        String username = "locked_out_user";

        driver.findElement(By.id("user-name")).sendKeys(username);
        Assert.assertEquals(username,"locked_out_user");
    }


    @Then("shown locked user message")
    public void shownLockedUserMessage() {
        String getErrorMsg = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        //System.out.println(getErrorMsg);
        Assert.assertEquals(getErrorMsg, "Epic sadface: Sorry, this user has been locked out.");

        driver.close();
    }


    @When("Input Unknown Username")
    public void inputUnknownUsername() {
        String username = "Unknown";

        driver.findElement(By.id("user-name")).sendKeys(username);
        Assert.assertEquals(username,"Unknown");
    }
}
