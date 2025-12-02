import com.practice_learning.utils.ElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginStepsPage {

    WebDriver driver;
    ElementUtils elementUtils;

    @FindBy(id = "usernameField") // Unique locator for username input
    private WebElement usernameField;

    @FindBy(id = "passwordField") // Unique locator for password input
    private WebElement passwordField;

    @FindBy(id = "loginButton") // Unique locator for login button
    private WebElement loginButton;

    @FindBy(id = "dashboard") // Unique locator for dashboard
    private WebElement dashboard;

    @FindBy(id = "errorMessage") // Unique locator for error message
    private WebElement errorMessageElement;

    public LoginStepsPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
        PageFactory.initElements(driver, this);
    }






    public void userIsOnLoginPage() {
        // Implementation to navigate to the login page
    }

    public void userEntersUsername(String username) {

    public void userEntersPassword(String password) {

    public void userClicksLoginButton() {

    public void userShouldSeeDashboard() {

    public void userShouldSeeErrorMessage(String message) {
}