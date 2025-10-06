import com.fleetservice.utils.ElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginStepsPage {

    private WebDriver driver;
    private ElementUtils elementUtils;

    public LoginStepsPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username") // Unique locator for username field
    private WebElement usernameField;

    @FindBy(id = "password") // Unique locator for password field
    private WebElement passwordField;

    @FindBy(id = "loginButton") // Unique locator for login button
    private WebElement loginButton;

    @FindBy(id = "dashboard") // Unique locator for dashboard
    private WebElement dashboard;

    @FindBy(id = "errorMessage") // Unique locator for error message
    private WebElement errorMessage;






    @Given("user is on the login page")
    public void userIsOnLoginPage() {
        // Implementation to navigate to the login page
    }

    @When("user enters username {string}")
    public void userEntersUsername(String username) {

    @When("user enters password {string}")
    public void userEntersPassword(String password) {

    @When("user clicks on login button")
    public void userClicksLoginButton() {

    @Then("user should see the dashboard")
    public void userShouldSeeDashboard() {

    @Then("user should see error message {string}")
    public void userShouldSeeErrorMessage(String message) {
}