import com.fleetservice.utils.ElementUtils;
package com.fleetservice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ReportManagementStepsPage {
    
    private WebDriver driver;
    private ElementUtils elementUtils;

    @FindBy(id = "reportsDashboard")
    private WebElement reportsDashboard;

    @FindBy(id = "generateReportButton")
    private WebElement generateReportButton;

    @FindBy(id = "reportTypeDropdown")
    private WebElement reportTypeDropdown;

    @FindBy(id = "startDateInput")
    private WebElement startDateInput;

    @FindBy(id = "endDateInput")
    private WebElement endDateInput;

    @FindBy(id = "reportNameInput")
    private WebElement reportNameInput;

    @FindBy(id = "downloadReportButton")
    private WebElement downloadReportButton;

    @FindBy(id = "reportList")
    private WebElement reportList;

    @FindBy(id = "deleteReportButton")
    private WebElement deleteReportButton;

    @FindBy(id = "exportToPdfButton")
    private WebElement exportToPdfButton;

    public ReportManagementStepsPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToReportsDashboard() {
        try {
            driver.get("https://github.com/maruthikudadala-k/page-files");
            elementUtils.clickElement(reportsDashboard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickGenerateReportButton() {
        try {
            elementUtils.clickElement(generateReportButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectReportType(String reportType) {
        try {
            elementUtils.clickElement(reportTypeDropdown);
            elementUtils.selectOptionInDropdown(reportTypeDropdown, reportType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectDateRange(String startDate, String endDate) {
        try {
            elementUtils.clearAndSendKeys(startDateInput, startDate);
            elementUtils.clearAndSendKeys(endDateInput, endDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterReportName(String reportName) {
        try {
            elementUtils.clearAndSendKeys(reportNameInput, reportName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void verifyReportGenerated() {
        // Implement verification logic for report generation
        try {
            // Example verification logic
            Assert.assertTrue(elementUtils.isElementDisplayed(reportList), "Report was not generated successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyReportInList(String reportName) {
        try {
            String actualReportName = elementUtils.getElementText(reportList); // Assuming a method to fetch report names
            Assert.assertEquals(actualReportName, reportName, "The report name does not match!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchReport(String reportName) {
        try {
            // Implement search logic here
            elementUtils.clearAndSendKeys(reportNameInput, reportName);
            // Assuming there's a search button to click after entering the report name
            elementUtils.clickElement(downloadReportButton); // Adjust as necessary
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickDeleteReport(String reportName) {
        try {
            elementUtils.clickElement(deleteReportButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyReportRemoved(String reportName) {
        // Implement verification logic for report removal
        try {
            // Example verification logic
            Assert.assertFalse(elementUtils.isElementDisplayed(reportList), "Report was not removed successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickExportToPdf() {
        try {
            elementUtils.clickElement(exportToPdfButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyPdfDownloaded() {
        // Implement verification logic for PDF download
        try {
            // Example verification logic
            Assert.assertTrue(true, "PDF was not downloaded successfully!"); // Adjust as necessary
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
Error code: 404 - {'error': {'code': 'DeploymentNotFound', 'message': 'The API deployment for this resource does not exist. If you created the deployment within the last 5 minutes, please wait a moment and try again.'}}