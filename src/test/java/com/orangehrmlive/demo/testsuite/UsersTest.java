package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UsersTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    ViewSystemUsersPage viewSystemUsersPage;
    AddUserPage addUserPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
        homePage = new HomePage();
        viewSystemUsersPage = new ViewSystemUsersPage();
        addUserPage = new AddUserPage();

    }
    @Test(groups = {"sanity","smoke","regression"})
public void adminShouldAddUserSuccessFully(){
    //    Login to Application
    loginPage.enterUserName("Admin");
    loginPage.enterPassword("admin123");
    loginPage.clickOnLogInButton();
//    click On "Admin" Tab
        homePage.clickOnAdmin();
//    Verify "System Users" Text
        viewSystemUsersPage.verifySystemUserText();
//    click On "Add" button
       addUserPage.clickOnAddButton();
//    Verify "Add User" Text
        addUserPage.verifyAddUserText("Add User");
//    Select User Role "Admin"
addUserPage.selectUserRoleByValue("1");
//    enter Employee Name "Ananya Dash"
        addUserPage.enterEmployeeName("Ananya Dash");
//    enter Username
        addUserPage.enterUserName("chiku");
//    Select status "Disable"
addUserPage.selectStatus();
//    enter psaaword
        addUserPage.enterPassword("Abc@123!");
//    enter Confirm Password
        addUserPage.enterConfirmPassword("Abc@123!");
//    click On "Save" Button
        addUserPage.clickOnSaveButton();
//    verify message "Successfully Saved"
//addUserPage.verifyTextOfSuccessfullySaved();
}
    @Test(groups = {"smoke","regression"})
public void searchTheUserCreatedAndVerifyIt(){
    //    Login to Application
    loginPage.enterUserName("Admin");
    loginPage.enterPassword("admin123");
    loginPage.clickOnLogInButton();
//    click On "Admin" Tab
        homePage.clickOnAdmin();
//    Verify "System Users" Text
        viewSystemUsersPage.verifySystemUserText();
//    Enter Username
viewSystemUsersPage.enterSearchUserName("Nidhi");
//    Select User Role
viewSystemUsersPage.selectSearchUserRole("Admin");
// select employee name
        viewSystemUsersPage.enterSearchEmployeeName("Ananya Dash");
//    Select Satatus
        viewSystemUsersPage.selectSearchStatus("Disabled");
//    Click on "Search" Button
        viewSystemUsersPage.clickOnSearchButton();
//    Verify the User should be in Result list.
viewSystemUsersPage.verifyListOfResult("Nidhi");
}
    @Test(groups = {"regression"})
public void verifyThatAdminShouldDeleteTheUserSuccessFully() {

//    Login to Application
    loginPage.enterUserName("Admin");
    loginPage.enterPassword("admin123");
    loginPage.clickOnLogInButton();
//    click On "Admin" Tab
        homePage.clickOnAdmin();
//    Verify "System Users" Text
        viewSystemUsersPage.verifySystemUserText();
//    Enter Username
        viewSystemUsersPage.enterSearchUserName("chiku");
//    Select User Role
        viewSystemUsersPage.selectSearchUserRole("Admin");
        // select employee name
        viewSystemUsersPage.enterSearchEmployeeName("Ananya Dash");
//    Select Satatus
        viewSystemUsersPage.selectSearchStatus("Disabled");
//    Click on "Search" Button
        viewSystemUsersPage.clickOnSearchButton();
//    Verify the User should be in Result list.
        viewSystemUsersPage.verifyListOfResult("chiku");
//    Click on Check box
        viewSystemUsersPage.clickOnCheckBox();
//    Click on Delete Button
viewSystemUsersPage.clickOnDeleteButton();
//    Popup will display
//    Click on Ok Button on Popup
        viewSystemUsersPage.clickOnOkButton();
//    verify message "Successfully Deleted"
}
    @Test(groups = {"regression"})
public void searchTheDeletedUserAndVerifyTheMessageNoRecordFound() {

//    Login to Application
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLogInButton();
//    click On "Admin" Tab
        homePage.clickOnAdmin();
//    Verify "System Users" Text
        viewSystemUsersPage.verifySystemUserText();
//    Enter Username
        viewSystemUsersPage.enterSearchUserName("gayatrimaa");
//    Select User Role
        viewSystemUsersPage.selectSearchUserRole("Admin");
//    Select Satatus
        viewSystemUsersPage.selectSearchStatus("Disabled");
//    Click on "Search" Button
        viewSystemUsersPage.clickOnSearchButton();
//    verify message "No Records Found"
viewSystemUsersPage.verifyNoRecordFoundText();
}
}
