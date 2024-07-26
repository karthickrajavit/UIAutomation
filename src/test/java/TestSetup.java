import org.UIAutomation.Pages.LoginPage;
import org.UIAutomation.Pages.RegisterUserPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestSetup extends BaseTest {


    RegisterUserPage registerUserPage;
    LoginPage loginPage;

//    @BeforeTest
//    public void setup(){
//        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
//        driver.get("https://www.automationexercise.com/");
//    }

    @Test
    public void doBasicTest(){
        registerUserPage = new RegisterUserPage(driver);
        registerUserPage.clickOnButton(registerUserPage.getSingUpLink());
        registerUserPage.fillField(registerUserPage.getSignUpName(),"Karthick");
        registerUserPage.fillField(registerUserPage.getSignUpEmailAddress(),"Karthick@email.com");
        registerUserPage.clickOnButton(registerUserPage.getSignUpSubmit());
    }

    @Test
    public void testLogin(){
        loginPage = new LoginPage(driver);
        loginPage.clickOnButton(loginPage.getSingUpLink());
        loginPage.fillField(loginPage.getLoginEmailAddress(),"Karthick@email.com");
        loginPage.fillField(loginPage.getLoginPassword(),"Karthick");
        loginPage.clickOnButton(loginPage.getLoginSubmit());
        Assert.assertTrue(loginPage.getErrorMessage().getText().contains("email or password is incorrect"));
    }

}
