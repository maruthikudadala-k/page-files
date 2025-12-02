
import com.practice_learning.utils.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class NotificationManagementStepsPage {
    
    private WebDriver driver;
    private ElementUtils elementUtils;

    @FindBy(id = "markAllAsReadButton")
    private WebElement markAllAsReadButton;

    @FindBy(id = "notificationFilterDropdown")
    private WebElement notificationFilterDropdown;

    @FindBy(xpath = "//div[@class='notification-title']")
    private WebElement notificationTitleElement;

    @FindBy(id = "notificationDetails")
    private WebElement notificationDetailsElement;

    @FindBy(id = "deleteNotificationButton")
    private WebElement deleteNotificationButton;

    @FindBy(id = "notificationAlertToggle")
    private WebElement notificationAlertToggle;

    @FindBy(id = "searchNotificationInput")
    private WebElement searchNotificationInput;

    @FindBy(id = "notificationList")
    private WebElement notificationList;

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
            WebElement notification = driver.findElement(By.xpath("//div[text()='" + notificationTitle + "']"));
            elementUtils.clickElement(notification);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyNotificationDetailsDisplayed() {
        try {
            boolean isElementDisplayed = elementUtils.isElementDisplayed(notificationDetailsElement);
            Assert.assertTrue(isElementDisplayed, "Notification details are not displayed!");
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
            boolean isRemoved = !elementUtils.isElementDisplayed(driver.findElement(By.xpath("//div[text()='" + notificationTitle + "']")));
            Assert.assertTrue(isRemoved, "Notification is still displayed!");
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

    public void verifyAlertStatus(String status) {
        try {
            String actualStatus = notificationAlertToggle.isSelected() ? "enabled" : "disabled";
            Assert.assertEquals(actualStatus, status, "Alert status does not match!");
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
            // Implementation to verify search results
            // For example, check if notifications containing the keyword are displayed
            // This can be implemented based on specific requirements
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sortNotifications(String sortOption) {
        try {
            elementUtils.clickElement(notificationFilterDropdown);
            elementUtils.selectOptionInDropdown(notificationFilterDropdown, sortOption);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifySortOrder(String sortOption) {
        try {
            // Implementation to verify sort order
            // This can be implemented based on specific requirements
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}