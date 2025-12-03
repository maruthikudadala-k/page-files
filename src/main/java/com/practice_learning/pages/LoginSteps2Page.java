import com.practice_learning.utils.ElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;

public class LoginSteps2Page {

    private WebDriver driver;
    private ElementUtils elementUtils;

    @FindBy(id = "usernameField") // Unique locator for username input
    private WebElement usernameField;

    @FindBy(id = "passwordField") // Unique locator for password input
    private WebElement passwordField;

    @FindBy(id = "loginButton") // Unique locator for login button
    private WebElement loginButton;

    @FindBy(id = "dashboardPage") // Unique locator for dashboard page
    private WebElement dashboardPage;

    @FindBy(id = "errorMessage") // Unique locator for error message
    private WebElement errorMessage;

    @FindBy(id = "forgotPasswordLink") // Unique locator for forgot password link
    private WebElement forgotPasswordLink;

    @FindBy(id = "passwordResetPage") // Unique locator for password reset page
    private WebElement passwordResetPage;

    @FindBy(id = "rememberMeCheckbox") // Unique locator for remember me checkbox
    private WebElement rememberMeCheckbox;

    @FindBy(id = "submitButton") // Unique locator for submit button
    private WebElement submitButton;

    @FindBy(id = "passwordResetEmail") // Unique locator for password reset email input
    private WebElement passwordResetEmail;

    public LoginSteps2Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.elementUtils = new ElementUtils(driver);
    }











}