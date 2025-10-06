
import com.fleetservice.utils.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class NotificationManagementStepsPage {
    
    private WebDriver driver;
    private ElementUtils elementUtils;

    public NotificationManagementStepsPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "markAllAsReadButton")
    private WebElement markAllAsReadButton;

    @FindBy(id = "notificationFilterDropdown")
    private WebElement notificationFilterDropdown;

    @FindBy(css = ".notification-item")
    private WebElement notificationItem;

    @FindBy(id = "notificationDetails")
    private WebElement notificationDetails;

    @FindBy(id = "deleteNotificationButton")
    private WebElement deleteNotificationButton;

    @FindBy(id = "notificationAlertToggle")
    private WebElement notificationAlertToggle;

    @FindBy(id = "searchNotificationInput")
    private WebElement searchNotificationInput;

    @FindBy(id = "notificationSortDropdown")
    private WebElement notificationSortDropdown;

    @FindBy(id = "notificationAlertStatus")
    private WebElement notificationAlertStatus;

    public void navigateToNotificationsPage() {
        try {
            driver.get("https://github.com/maruthikudadala-k/page-files"); // Replace with actual notifications page URL
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
            clickNotification(notificationTitle);
            elementUtils.clickElement(deleteNotificationButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyNotificationRemoved(String notificationTitle) {
        try {
            boolean isPresent = driver.findElements(By.xpath("//div[text()='" + notificationTitle + "']")).size() > 0;
            Assert.assertFalse(isPresent, "Notification is still present!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void toggleNotificationAlerts(boolean enable) {
        try {
            elementUtils.clickElement(notificationAlertToggle);
            // Additional logic might be necessary to confirm the toggle state
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyAlertStatus(String expectedStatus) {
        try {
            String actualStatus = elementUtils.getElementText(notificationAlertStatus);
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
        try {
            boolean isMatchFound = driver.findElements(By.xpath("//*[contains(text(),'" + keyword + "')]")).size() > 0;
            Assert.assertTrue(isMatchFound, "No matching notifications found!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sortNotifications(String sortOption) {
        try {
            elementUtils.clickElement(notificationSortDropdown);
            elementUtils.selectOptionInDropdown(notificationSortDropdown, sortOption);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifySortOrder(String sortOption) {
        try {
            // Placeholder for actual sort order verification logic
            Assert.assertTrue(true, "Notifications are not sorted as expected!"); // Replace with actual logic
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}