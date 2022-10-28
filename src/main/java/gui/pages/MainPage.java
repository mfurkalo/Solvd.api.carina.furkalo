package gui.pages;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import gui.components.RegistrationForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class MainPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//input[@id='email']")
    private ExtendedWebElement loginField;

    @FindBy(xpath = "//input[@id='pass']")
    private ExtendedWebElement passField;

    @FindBy(xpath = "//button[@name='login']")
    private ExtendedWebElement logInButton;

    @FindBy(xpath = "//a[text()='Forgot password?']")
    private ExtendedWebElement forgotPassLink;

    @FindBy(xpath = "//a[@data-testid='open-registration-form-button']")
    private ExtendedWebElement createNewButton;

    @FindBy(xpath = "//a[text()='Create a Page']")
    private ExtendedWebElement createPageLink;

    @FindBy(xpath = "//a[text()='Forgot password?']")
    private ExtendedWebElement passwordError;

    @FindBy(xpath = "//div[contains(text(),'isn’t connected')]")
    private ExtendedWebElement loginError;

    @FindBy(xpath = "//a[@data-testid='open-registration-form-button']")
    private ExtendedWebElement createNewAccountButton;

    @FindBy(xpath = "//span[text()='Johan Putin']")
    private ExtendedWebElement userName;

    public MainPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(loginField);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public void insertLogin(String login) {
        loginField.type(login);
    }

    public void insertPassword(String pass) {
        passField.type(pass);
    }

    public void clickLoginButton() {
        logInButton.click();
    }

    public boolean passwordError() {
        return passwordError.isElementPresent();
    }

    public boolean loginError() {
        return loginError.isElementPresent();
    }

    public RegistrationForm clickCreateNewAccount() {
        createNewAccountButton.click();
        return new RegistrationForm(driver);
    }

    public boolean userNamePresent() {
        this.pause(5);
        return userName.isElementPresent();
    }
}
