
import com.practice_learning.utils.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ReportManagementStepsPage {

    private WebDriver driver;
    private ElementUtils elementUtils;

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

    @FindBy(id = "exportPdfButton")
    private WebElement exportPdfButton;

    public ReportManagementStepsPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToReportsDashboard() {
        driver.get("http://localhost/reports-dashboard");
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

    public void clickDownloadButton() {
        try {
            elementUtils.clickElement(downloadReportButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyReportGenerated() {
        // Implement the verification logic here
        // Example: Assert that a success message is displayed
    }

    public void verifyReportInList(String reportName) {
        try {
            // Implement the logic to check if the report is in the list
            String actualReportName = elementUtils.getElementText(reportList); // Adjust as needed
            Assert.assertEquals(actualReportName, reportName, "Report name does not match!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchReport(String reportName) {
        try {
            // Implement search logic here
            // Example: Use a search input field to find the report
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickDeleteReport(String reportName) {
        try {
            // Implement delete logic here based on report name
            // Example: Find the delete button for the specific report and click it
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyReportRemoved(String reportName) {
        try {
            // Implement removal verification logic here
            // Example: Assert that the report is no longer in the report list
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickExportToPdf() {
        try {
            elementUtils.clickElement(exportPdfButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyPdfDownloaded() {
        // Implement the logic to verify the PDF download
        // Example: Check if the file exists in the download directory
    }
}