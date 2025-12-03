
import com.practice_learning.utils.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class NotificationManagementStepsPage {

    private WebDriver driver;
    private ElementUtils elementUtils;

    @FindBy(id = "markAllAsReadButton")
    private WebElement markAllAsReadButton;

    @FindBy(id = "notificationFilterDropdown")
    private WebElement notificationFilterDropdown;

    @FindBy(id = "notificationDetails")
    private WebElement notificationDetailsElement;

    @FindBy(id = "deleteNotificationButton")
    private WebElement deleteNotificationButton;

    @FindBy(id = "notificationAlertToggle")
    private WebElement notificationAlertToggle;

    @FindBy(id = "searchNotificationInput")
    private WebElement searchNotificationInput;

    @FindBy(id = "sortedNotifications")
    private WebElement sortedNotificationsElement;

    public NotificationManagementStepsPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToNotificationsPage() {
        driver.get("http://localhost/notifications");
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
            WebElement notificationElement = driver.findElement(By.xpath("//div[contains(text(),'" + notificationTitle + "')]"));
            elementUtils.clickElement(notificationElement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyNotificationDetailsDisplayed() {
        try {
            Assert.assertTrue(elementUtils.isElementDisplayed(notificationDetailsElement), "Notification details are not displayed!");
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
            List<WebElement> notificationElements = driver.findElements(By.xpath("//div[contains(text(),'" + notificationTitle + "')]"));
            Assert.assertTrue(notificationElements.isEmpty(), "Notification is still displayed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void toggleNotificationAlerts(boolean enable) {
        try {
            elementUtils.clickElement(notificationAlertToggle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyAlertStatus(boolean expectedStatus) {
        try {
            String actualStatus = notificationAlertToggle.getAttribute("aria-checked");
            String expectedStatusString = expectedStatus ? "true" : "false";
            Assert.assertEquals(actualStatus, expectedStatusString, "Alert status does not match!");
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
            List<WebElement> searchResults = driver.findElements(By.xpath("//div[contains(text(),'" + keyword + "')]"));
            Assert.assertFalse(searchResults.isEmpty(), "No matching notifications found!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sortNotifications(String sortOption) {
        try {
            elementUtils.clickElement(sortedNotificationsElement);
            elementUtils.selectOptionInDropdown(sortedNotificationsElement, sortOption);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifySortOrder(String sortOption) {
        // Implement sort verification logic here
    }
}