

package com.fleetservice.stepdefinitions;

import com.fleetservice.pages.ReportManagementStepsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class ReportManagementSteps {
    
    private WebDriver driver;
    private ReportManagementStepsPage reportPage;

    @Given("user is on the reports dashboard")
    public void userIsOnReportsDashboard() {
        reportPage = new ReportManagementStepsPage(driver);
        reportPage.navigateToReportsDashboard();
    }

    @When("user clicks on generate report button")
    public void userClicksGenerateReportButton() {
        reportPage.clickGenerateReportButton();
    }

    @When("user selects report type {string}")
    public void userSelectsReportType(String reportType) {
        reportPage.selectReportType(reportType);
    }

    @When("user selects date range from {string} to {string}")
    public void userSelectsDateRange(String startDate, String endDate) {
        reportPage.selectDateRange(startDate, endDate);
    }

    @When("user enters report name {string}")
    public void userEntersReportName(String reportName) {
        reportPage.enterReportName(reportName);
    }

    @When("user clicks on download report button")
    public void userClicksDownloadReportButton() {
        reportPage.clickDownloadButton();
    }

    @Then("report should be generated successfully")
    public void reportShouldBeGeneratedSuccessfully() {
        reportPage.verifyReportGenerated();
    }

    @Then("user should see report {string} in the list")
    public void userShouldSeeReportInList(String reportName) {
        reportPage.verifyReportInList(reportName);
    }

    @When("user searches for report {string}")
    public void userSearchesForReport(String reportName) {
        reportPage.searchReport(reportName);
    }

    @When("user clicks on delete button for report {string}")
    public void userClicksDeleteButtonForReport(String reportName) {
        reportPage.clickDeleteReport(reportName);
    }

    @Then("report {string} should be removed from the list")
    public void reportShouldBeRemovedFromList(String reportName) {
        reportPage.verifyReportRemoved(reportName);
    }

    @When("user clicks on export to PDF button")
    public void userClicksExportToPdfButton() {
        reportPage.clickExportToPdf();
    }

    @Then("PDF file should be downloaded successfully")
    public void pdfFileShouldBeDownloaded() {
        reportPage.verifyPdfDownloaded();
    }
}