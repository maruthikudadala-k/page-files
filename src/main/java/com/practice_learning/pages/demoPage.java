
import com.practice_learning.utils.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DemoPage {

    private WebDriver driver;
    private ElementUtils elementUtils;

    @FindBy(id = "markAllAsReadButton")
    private WebElement markAllAsReadButton;

    @FindBy(id = "notificationFilterDropdown")
    private WebElement notificationFilterDropdown;

    @FindBy(xpath = "//div[@class='notification-title']")
    private WebElement notificationTitleElement;

    @FindBy(id = "notificationDetails")
    private WebElement notificationDetails;

    @FindBy(id = "deleteNotificationButton")
    private WebElement deleteNotificationButton;

    @FindBy(id = "notificationAlertToggle")
    private WebElement notificationAlertToggle;

    @FindBy(id = "searchNotificationInput")
    private WebElement searchNotificationInput;

    @FindBy(id = "sortedNotifications")
    private WebElement sortedNotifications;

    public DemoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.elementUtils = new ElementUtils(driver);
    }

    public void navigateToNotificationsPage() {
        try {
            driver.get("http://localhost/notifications");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickMarkAllAsReadButton() {
        try {
            elementUtils.clickElement(markAllAsReadButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectNotificationFilter(String filterType) {
        try {
            elementUtils.clickElement(notificationFilterDropdown);
            elementUtils.selectOptionInDropdown(notificationFilterDropdown, filterType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickNotification(String notificationTitle) {
        try {
            WebElement notification = driver.findElement(By.xpath("//div[text()='" + notificationTitle + "']"));
            elementUtils.clickElement(notification);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyNotificationDetailsDisplayed() {
        try {
            Assert.assertTrue(elementUtils.isElementDisplayed(notificationDetails), "Notification details are not displayed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteNotification(String notificationTitle) {
        try {
            clickNotification(notificationTitle); // Click on the notification to delete
            elementUtils.clickElement(deleteNotificationButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyNotificationRemoved(String notificationTitle) {
        try {
            Assert.assertFalse(isNotificationDisplayed(notificationTitle), "Notification was not removed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isNotificationDisplayed(String notificationTitle) {
        try {
            WebElement notification = driver.findElement(By.xpath("//div[text()='" + notificationTitle + "']"));
            return elementUtils.isElementDisplayed(notification);
        } catch (NoSuchElementException e) {
            return false; // Notification is not displayed
        }
    }

    public void toggleNotificationAlerts(boolean enable) {
        try {
            elementUtils.clickElement(notificationAlertToggle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyAlertStatus(String expectedStatus) {
        try {
            String actualStatus = notificationAlertToggle.getAttribute("aria-checked"); // Assuming toggle uses aria-checked for status
            Assert.assertEquals(actualStatus, expectedStatus, "Notification alert status does not match!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchNotification(String keyword) {
        try {
            elementUtils.clearAndSendKeys(searchNotificationInput, keyword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifySearchResults(String keyword) {
        // Implementation for verifying search results can be added here
        // Example: Assert that the search results contain the keyword
    }

    public void sortNotifications(String sortOption) {
        try {
            elementUtils.clickElement(sortedNotifications);
            elementUtils.selectOptionInDropdown(sortedNotifications, sortOption);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifySortOrder(String sortOption) {
        // Implementation for verifying sort order can be added here
    }
}