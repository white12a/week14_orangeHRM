package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
        homePage = new HomePage();
    }

    @Test(groups = {"sanity","smoke","regression"})
    public void verifyUserShouldLoginSuccessFully() throws InterruptedException {
//    Enter username
        loginPage.enterUserName("Admin");
//    Enter password
        loginPage.enterPassword("admin123");
//    Click on Login Button
        loginPage.clickOnLogInButton();
//    Verify "WelCome" Message
        homePage.verifyWelcomeText();
    }

    @Test(groups = {"smoke","regression"})
    public void verifyThatTheLogoDisplayOnHomePage() {
//    Login To The application
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLogInButton();
//    Verify Logo is Displayed
        homePage.verifyLogo();
    }

    @Test(groups = {"regression"})
    public void verifyUserShouldLogOutSuccessFully() {
//    Login To The application
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLogInButton();
//    Click on User Profile logo
        homePage.verifyProfileLogo();
//    Mouse hover on "Logout" and click
        homePage.mouseHoverToWelcomeAndClickOnLogOut();
//    Verify the text "Login Panel" is displayed
        homePage.verifyLogInPanelText("Login Panel");
    }
}