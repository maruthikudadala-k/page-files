
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

    @FindBy(id = "markAllAsReadButton")
    private WebElement markAllAsReadButton;

    @FindBy(id = "notificationFilterDropdown")
    private WebElement notificationFilterDropdown;

    @FindBy(xpath = "//div[@class='notification-title']")
    private WebElement notificationTitleElement;

    @FindBy(id = "notificationDetails")
    private WebElement notificationDetails;

    @FindBy(xpath = "//button[contains(text(),'Delete')]")
    private WebElement deleteNotificationButton;

    @FindBy(id = "notificationAlertToggle")
    private WebElement notificationAlertToggle;

    @FindBy(id = "searchNotificationInput")
    private WebElement searchNotificationInput;

    @FindBy(id = "sortNotificationsDropdown")
    private WebElement sortNotificationsDropdown;

    public NotificationManagementStepsPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToNotificationsPage() {
        try {
            driver.get("https://github.com/maruthikudadala-k/page-files");
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
            WebElement notificationElement = driver.findElement(By.xpath("//div[text()='" + notificationTitle + "']"));
            elementUtils.clickElement(notificationElement);
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
            WebElement notificationElement = driver.findElement(By.xpath("//div[text()='" + notificationTitle + "']//following-sibling::button[contains(text(),'Delete')]"));
            elementUtils.clickElement(notificationElement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyNotificationRemoved(String notificationTitle) {
        try {
            Assert.assertFalse(driver.getPageSource().contains(notificationTitle), "Notification is still present!");
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
            Assert.assertEquals(actualStatus, status, "Notification alert status does not match!");
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
            Assert.assertTrue(driver.getPageSource().contains(keyword), "Search results do not match the keyword!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sortNotifications(String sortOption) {
        try {
            elementUtils.clickElement(sortNotificationsDropdown);
            elementUtils.selectOptionInDropdown(sortNotificationsDropdown, sortOption);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifySortOrder(String sortOption) {
        // Implement verification logic for sorted notifications
        // This could involve checking the order of notifications based on the sort option
        // For example, if sorting by date, check if the notifications are in the correct order
        // This is a placeholder for actual implementation
        try {
            // Logic to verify the sort order
            // Example: Assert.assertTrue(isSortedByDate(), "Notifications are not sorted by date!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}