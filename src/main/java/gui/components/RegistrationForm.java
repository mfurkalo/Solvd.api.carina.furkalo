package gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RegistrationForm extends AbstractUIObject {

    @FindBy(xpath = "//input[@placeholder='First name']")
    private ExtendedWebElement firstNameField;

    @FindBy(xpath = "//input[@name='lastname']")
    private ExtendedWebElement lastNameField;

    @FindBy(xpath = "//input[@name='reg_email__']")
    private ExtendedWebElement loginField;

    @FindBy(xpath = "//input[@name='reg_email_confirmation__']")
    private ExtendedWebElement loginReenterField;

    @FindBy(xpath = "//input[@name='reg_passwd__']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//button[@name='websubmit']")
    private ExtendedWebElement signUpButton;

    public void insertFirstName(String name) {
        firstNameField.type(name);
    }

    public void insertLastName(String name) {
        lastNameField.type(name);
    }

    public void insertLogin(String login) {
        loginField.type(login);
    }

    public void reenterLogin(String login) {
        loginReenterField.type(login);
    }

    public void insertPassword(String pass) {
        passwordField.type(pass);
    }

    public void clickSignUp() {
        signUpButton.click();
    }

    public RegistrationForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public RegistrationForm(WebDriver driver) {
        super(driver);
    }
}
