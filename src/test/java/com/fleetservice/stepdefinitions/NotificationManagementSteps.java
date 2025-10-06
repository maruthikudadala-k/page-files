// File: NotificationManagementSteps.java
// Place in: src/test/java/com/fleetservice/stepdefinitions/

package com.fleetservice.stepdefinitions;

import com.fleetservice.pages.NotificationManagementStepsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class NotificationManagementSteps {
    
    private WebDriver driver;
    private NotificationManagementStepsPage notificationPage;

    @Given("user is on the notifications page")
    public void userIsOnNotificationsPage() {
        notificationPage = new NotificationManagementStepsPage(driver);
        notificationPage.navigateToNotificationsPage();
    }

    @When("user clicks on mark all as read button")
    public void userClicksMarkAllAsReadButton() {
        notificationPage.clickMarkAllAsReadButton();
    }

    @When("user filters notifications by {string}")
    public void userFiltersNotificationsBy(String filterType) {
        notificationPage.selectNotificationFilter(filterType);
    }

    @When("user clicks on notification {string}")
    public void userClicksOnNotification(String notificationTitle) {
        notificationPage.clickNotification(notificationTitle);
    }

    @Then("notification details should be displayed")
    public void notificationDetailsShouldBeDisplayed() {
        notificationPage.verifyNotificationDetailsDisplayed();
    }

    @When("user deletes notification {string}")
    public void userDeletesNotification(String notificationTitle) {
        notificationPage.deleteNotification(notificationTitle);
    }

    @Then("notification {string} should be removed")
    public void notificationShouldBeRemoved(String notificationTitle) {
        notificationPage.verifyNotificationRemoved(notificationTitle);
    }

    @When("user enables notification alerts")
    public void userEnablesNotificationAlerts() {
        notificationPage.toggleNotificationAlerts(true);
    }

    @When("user disables notification alerts")
    public void userDisablesNotificationAlerts() {
        notificationPage.toggleNotificationAlerts(false);
    }

    @Then("notification alert status should be {string}")
    public void notificationAlertStatusShouldBe(String status) {
        notificationPage.verifyAlertStatus(status);
    }

    @When("user searches for notification containing {string}")
    public void userSearchesForNotificationContaining(String keyword) {
        notificationPage.searchNotification(keyword);
    }

    @Then("notifications matching {string} should be displayed")
    public void notificationsMatchingShouldBeDisplayed(String keyword) {
        notificationPage.verifySearchResults(keyword);
    }

    @When("user sorts notifications by {string}")
    public void userSortsNotificationsBy(String sortOption) {
        notificationPage.sortNotifications(sortOption);
    }

    @Then("notifications should be sorted by {string}")
    public void notificationsShouldBeSortedBy(String sortOption) {
        notificationPage.verifySortOrder(sortOption);
    }
}