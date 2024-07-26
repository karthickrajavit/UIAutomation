package org.UIAutomation.Pages;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

@Getter
@Setter
public class RegisterUserPage {
    WebDriver driver;

    By singUpLink = By.xpath("//a[text()=' Signup / Login']");
    By signUpName = By.xpath("//input[@data-qa='signup-name']");
    By signUpEmailAddress = By.xpath("//input[@data-qa='signup-email']");
    By signUpSubmit = By.xpath("//button[@data-qa='signup-button']");
    By titleSignUp = By.xpath("//input[@id='id_gender1']");

    public RegisterUserPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnButton(By webElement){
        driver.findElement(webElement).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    public void fillField(By webElement, String text){
        driver.findElement(webElement).sendKeys(text);
    }

}
