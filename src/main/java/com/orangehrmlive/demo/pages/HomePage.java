package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

//Store OrangeHRM logo, Admin, PIM, Leave,Dashboard, Welcome Text
//        locatores
//        and create appropriate methods for it
public class HomePage extends Utility {
    public HomePage(){
        PageFactory.initElements(driver,this);
    }
@FindBy(xpath = "//a[@id='welcome']")
    WebElement WelcomeText;

public void verifyWelcomeText(){
  String actualText = getTextFromElement(WelcomeText);
  String finalText = actualText.substring(0,7);
  String expectedText = "Welcome";
    Assert.assertEquals(finalText,expectedText);

}
@FindBy(xpath = "//img[@alt='OrangeHRM']")
    WebElement Logo;

public void verifyLogo(){
    verifyLogoVisible(Logo);
    }

    @FindBy (xpath = "//a[@id='welcome']")
    WebElement profileLogo;
    public void verifyProfileLogo(){
        verifyLogoVisible(profileLogo);
    }
@FindBy(xpath = "//a[contains(text(),'Logout')]")
    WebElement logOut;
    public void mouseHoverToWelcomeAndClickOnLogOut(){
        clickOnElement(profileLogo);
        clickOnElement(logOut);
    }

    @FindBy(xpath = "//div[@id='logInPanelHeading']")
    WebElement logInPanel;

    public void verifyLogInPanelText(String text){
       if(logInPanel.getText().equalsIgnoreCase(text)){
           Assert.assertTrue(true);
       }else{
           Assert.fail();
       }
    }
    @FindBy (xpath = "//b[contains(text(),'Admin')]")
    WebElement Admin;

    public void clickOnAdmin(){
        clickOnElement(Admin);
    }
}
