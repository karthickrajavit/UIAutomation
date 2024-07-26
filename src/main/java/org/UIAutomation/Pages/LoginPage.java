package org.UIAutomation.Pages;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Getter
@Setter
public class LoginPage {
    WebDriver driver;

    @FindBy(xpath = "//a[text()=' Signup / Login']" )
    WebElement singUpLink;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    WebElement loginPassword;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement loginEmailAddress;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    WebElement loginSubmit;

    @FindBy(xpath = "//p[contains(text(),'email')]")
    WebElement errorMessage;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void clickOnButton(WebElement webElement){
        webElement.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    public void fillField(WebElement webElement, String text){
        webElement.sendKeys(text);
    }

}