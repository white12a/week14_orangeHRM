package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

// System Users Text, Username Field, User Roll dropDown,
//         Employee Name Field,
//         Status Drop Down, Search Button, Reset Button, Add Button and Delete Button locators and
//         it's actions
public class ViewSystemUsersPage extends Utility {
    public ViewSystemUsersPage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//div[@id='systemUser-information']")
    WebElement systemUsersText;

    public void verifySystemUserText() {
        String actualText = getTextFromElement(systemUsersText);
        String finalText = actualText.substring(0, 12);
        String expectedText = "System Users";
        Assert.assertEquals(finalText, expectedText);
    }

    @FindBy(xpath = "//input[@id='searchSystemUser_userName']")
    WebElement searchUsername;
    @FindBy(xpath = "//select[@id='searchSystemUser_userType']")
    WebElement searchUserRole;
    @FindBy(xpath = "//input[@id='searchSystemUser_employeeName_empName']")
    WebElement searchEmployeeName;
    @FindBy(xpath = "//option[contains(text(),'Admin')]")
    WebElement searchAdmin;
    @FindBy(xpath = "//select[@id='searchSystemUser_status']")
    WebElement searchStatus;
    @FindBy(xpath = "//input[@id='resetBtn']")
    WebElement reset;
    @FindBy(xpath = "//input[@id='searchBtn']")
    WebElement searchButton;
    @FindBy(xpath = "//tbody/tr[1]/td[2]")
    List<WebElement> resultList;


    public void enterSearchUserName(String username) {
        sendTextToElement(searchUsername, username);
    }

    public void selectSearchUserRole(String value) {
        selectByVisibleTextFromDropDown(searchUserRole,value);
    }


    public void enterSearchEmployeeName(String ename) {
        sendTextToElement(searchEmployeeName, ename);
    }
public void clickOnResetButton(){
        clickOnElement(reset);
}
    public void selectSearchStatus(String text) {
        selectByVisibleTextFromDropDown(searchStatus, text);
    }

    public void clickOnSearchButton() {
        clickOnElement(searchButton);
    }

    public void verifyListOfResult(String name) {
        for (WebElement userNamelist : resultList) {
            if (userNamelist.getText().equalsIgnoreCase(name)) {
                Assert.assertTrue(true, "Username is in Result List");
            } else {
                Assert.fail();
            }
        }
    }
    @FindBy(xpath = "//tr[@class='odd']/td[1]")
    WebElement checkBox;
    public void clickOnCheckBox(){
        clickOnElement(checkBox);
    }
    @FindBy(xpath = "//input[@id='btnDelete']")
    WebElement delete;

    public void clickOnDeleteButton(){
        clickOnElement(delete);
    }

    @FindBy(xpath = "//input[@id='dialogDeleteBtn']")
    WebElement okButton;
    public void clickOnOkButton(){
        clickOnElement(okButton);
    }

    @FindBy (xpath = "//td[contains(text(),'No Records Found')]")
    WebElement noRecordFound;

    public void verifyNoRecordFoundText(){
        String actualText = getTextFromElement(noRecordFound);
        String expectedText = "No Records Found";
        Assert.assertEquals(actualText,expectedText);
    }
}