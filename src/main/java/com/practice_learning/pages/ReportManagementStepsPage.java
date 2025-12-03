
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
        try {
            Assert.assertTrue(elementUtils.isElementDisplayed(reportList), "Report was not generated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyReportInList(String reportName) {
        try {
            String actualReportName = elementUtils.getElementText(reportList); 
            Assert.assertEquals(actualReportName, reportName, "The report name does not match!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchReport(String reportName) {
        try {
            WebElement searchInput = driver.findElement(By.id("searchInput"));
            elementUtils.clearAndSendKeys(searchInput, reportName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickDeleteReport(String reportName) {
        try {
            WebElement deleteButton = driver.findElement(By.xpath("//div[text()='" + reportName + "']/following-sibling::button[@class='delete']"));
            elementUtils.clickElement(deleteButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyReportRemoved(String reportName) {
        try {
            Assert.assertFalse(elementUtils.isElementDisplayed(reportList), "The report was not removed from the list.");
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
        try {
            // Implement a condition to check if the PDF is downloaded
            Assert.assertTrue(/* condition to check if PDF is downloaded */, "PDF was not downloaded successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}