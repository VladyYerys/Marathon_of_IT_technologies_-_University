package com.epam.aqa.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DonatePage extends BasePage {

    @FindBy(xpath = "//h1[@class='title']")
    private WebElement titleText;

    public DonatePage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void switchToTabAndVerifyUrl(String text) {
        switchToSecondTab();
        verifyDonateURLPage(text);
        closeSecondTabAndSwitchToDefault();
    }

    @Step
    private void verifyDonateURLPage(String text) {
        assertThat(this.driver.getCurrentUrl()).isEqualTo(text);
    }
}
