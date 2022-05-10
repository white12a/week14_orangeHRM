package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

//User Role Drop Down, Employee Name, Username, Status Drop Down,
//        Password, Confirm Password,
//        Save and Cancle Button Locators and it's actions
public class AddUserPage extends Utility {
    public AddUserPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//h1[@id='UserHeading']")
    WebElement addUserText;
    public void verifyAddUserText(String expectedText){
        if(addUserText.getText().equalsIgnoreCase(expectedText)){
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }
    }
    @FindBy (xpath = "//input[@id='btnAdd']")
    WebElement addButton;
    public void clickOnAddButton(){
        clickOnElement(addButton);
    }

    @FindBy(xpath = "//select[@id='systemUser_userType']")
    WebElement userRole;
    public void selectUserRoleByValue(String Value){
        selectByValueFromDropDown(userRole,Value);
    }
    @FindBy (xpath = "//input[@id='systemUser_employeeName_empName']")
    WebElement employeeName;
    public void enterEmployeeName(String eName){
        sendTextToElement(employeeName,eName);
    }

    @FindBy(xpath = "//input[@id='systemUser_userName']")
    WebElement Username;
    public void enterUserName(String username){
        sendTextToElement(Username,username);
    }

    @FindBy(xpath = "//select[@id='systemUser_status']")
    WebElement status;
    public void selectStatus(){
        selectByVisibleTextFromDropDown(status,"Disabled");
    }

    @FindBy(xpath = "//input[@id='systemUser_password']")
    WebElement password;
    public void enterPassword(String Password){
        sendTextToElement(password,Password);
    }

    @FindBy(xpath = "//input[@id='systemUser_confirmPassword']")
    WebElement confirmPassword;
    public void enterConfirmPassword(String ConfirmPassword){
        sendTextToElement(confirmPassword,ConfirmPassword);
    }

    @FindBy (xpath = "//form[@name='frmSystemUser']/fieldset/p/input[1]")
    WebElement saveButton;
    public void clickOnSaveButton(){
        clickOnElement(saveButton);
    }

    @FindBy(css = "div:nth-child(2) div.box.noHeader:nth-child(1) div.inner form:nth-child(1) > script:nth-child(3)")
    WebElement successfullySavedText;

    public void verifyTextOfSuccessfullySaved(){
        String actualText = successfullySavedText.getText();
        String expectedText = "Successfully Saved";
        Assert.assertEquals(actualText,expectedText);
    }

}
