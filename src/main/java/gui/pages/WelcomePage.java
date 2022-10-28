package gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

import static data.UiConstants.WELCOME_URL;

public class WelcomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//div[@role='main']//span[text()='Welcome to Facebook, Johan']")
    private ExtendedWebElement welcomeInscription;

    @FindBy(xpath = "//div[@aria-label='Account Controls and Settings']/span//div[@role]")
    private ExtendedWebElement accountMenu;

    @FindBy(xpath = "//span[text()='Log Out']")
    private ExtendedWebElement logOutButton;


    public WelcomePage(WebDriver driver) {
        super(driver);
        setPageURL(WELCOME_URL);
    }

    public  void openAccountMenu(){
        accountMenu.click();
    }

    public  void clickLogout(){
        logOutButton.click();
    }
}
