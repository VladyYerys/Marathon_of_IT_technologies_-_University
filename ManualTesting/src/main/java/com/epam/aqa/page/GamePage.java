package com.epam.aqa.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.*;

public class GamePage extends BasePage {

    @FindBy(xpath = "//h1[@class='page__title']")
    private WebElement gameTitleText;

    @FindBy(xpath = "//a[@class='game-field__overlay--link link secondary-link'][contains(text(),'Play with robot')]")
    private WebElement playWithRobotLinkButton;

    public GamePage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void verifyThatTextTitle(String text) {
        waitVisibilityOfElementFluent(gameTitleText);
        assertThat(gameTitleText.getText()).isEqualTo(text);
    }

    @Step
    public void clickOnGameWithRobot() {
        clickOnButton(playWithRobotLinkButton);
        waitForPageLoadComplete(5);
    }


}
