import com.fleetservice.utils.ElementUtils;
package com.fleetservice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DriverManagementStepsPage {
    
    private WebDriver driver;
    private ElementUtils elementUtils;

    public DriverManagementStepsPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "addDriverButton")
    private WebElement addDriverButton;

    @FindBy(id = "driverNameInput")
    private WebElement driverNameInput;

    @FindBy(id = "licenseNumberInput")
    private WebElement licenseNumberInput;

    @FindBy(id = "phoneNumberInput")
    private WebElement phoneNumberInput;

    @FindBy(id = "saveDriverButton")
    private WebElement saveDriverButton;

    @FindBy(id = "driverList")
    private WebElement driverList;

    @FindBy(id = "vehicleDropdown")
    private WebElement vehicleDropdown;









}