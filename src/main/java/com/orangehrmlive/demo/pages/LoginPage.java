package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//- Store usename, password, Login Button and LOGIN Panel text Locators
//        and create appropriate methods for it
public class LoginPage extends Utility {
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//input[@id='txtUsername'])[1]")
    WebElement username;

    public void enterUserName(String uName){
        sendTextToElement(username,uName);}

        @FindBy(xpath = "(//input[@id='txtPassword'])[1]")
                WebElement password;

    public void enterPassword(String Pswrd){
       sendTextToElement(password,Pswrd);}

@FindBy(xpath = "//input[@id='btnLogin']")
    WebElement logInButton;

    public void clickOnLogInButton(){
        clickOnElement(logInButton);}

    }

