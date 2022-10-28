import com.qaprosoft.carina.core.foundation.IAbstractTest;
import gui.components.RegistrationForm;
import gui.pages.MainPage;
import gui.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static data.UiConstants.*;

public class UiTest implements IAbstractTest {
    MainPage mainPage = null;
    WelcomePage welcomePage = null;

    @BeforeMethod
    public void startDriver() {
        mainPage = new MainPage(getDriver());
    }

    @Test
    public void LogInPositive() {
        welcomePage = new WelcomePage(getDriver());
        SoftAssert softAssert = new SoftAssert();
        mainPage.open();
        softAssert.assertTrue(mainPage.isPageOpened(), "Home page is not opened");
        mainPage.insertLogin(LOGIN);
        mainPage.insertPassword(PASSWORD);
        mainPage.clickLoginButton();
        softAssert.assertTrue(welcomePage.isPageOpened(), "The welcome page should be opened");
        softAssert.assertAll();
    }

    @Test
    public void LogInIncorrectPassword() {
        mainPage.open();
        mainPage.insertLogin(LOGIN);
        mainPage.insertPassword(WRONG_PASSWORD);
        mainPage.clickLoginButton();
        Assert.assertTrue(mainPage.passwordError(), "Forgot password should be present");
    }

    @Test
    public void LogInIncorrectLogin() {
        mainPage.open();
        mainPage.insertLogin(WRONG_LOGIN);
        mainPage.insertPassword(PASSWORD);
        mainPage.clickLoginButton();
        Assert.assertTrue(mainPage.loginError(), "Login error message should be displayed");
    }

    @Test
    public void LogOutPositive() {
        welcomePage = new WelcomePage(getDriver());
        SoftAssert softAssert = new SoftAssert();
        mainPage.open();
        mainPage.insertLogin(LOGIN);
        mainPage.insertPassword(PASSWORD);
        mainPage.clickLoginButton();
        softAssert.assertTrue(welcomePage.isPageOpened(), "The welcome page should be opened");
        welcomePage.openAccountMenu();
        welcomePage.clickLogout();
        softAssert.assertTrue(welcomePage.isPageOpened(), "The welcome page should be opened");
        softAssert.assertAll();
    }

    @Test
    public void CreatingExistingUserPositive() {
        mainPage.open();
        RegistrationForm form = mainPage.clickCreateNewAccount();
        form.insertFirstName(NAME);
        form.insertLastName(L_NAME);
        form.insertLogin(LOGIN);
        form.reenterLogin(LOGIN);
        form.insertPassword(PASSWORD);
        form.clickSignUp();
        Assert.assertTrue(mainPage.userNamePresent(), "The user's name should be displayed");
    }
}
