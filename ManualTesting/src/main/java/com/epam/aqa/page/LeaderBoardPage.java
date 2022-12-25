package com.epam.aqa.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class LeaderBoardPage extends BasePage {

    @FindBy(xpath = "//h2[@class='your-rating__title']")
    private WebElement yourRatingTitleText;

    @FindBy(xpath = "//*[@class='your-rating__wrapper']//div[@class='points__wrapper']/span")
    private WebElement yourRatingUserNameText;

    @FindBy(xpath = "//*[@class='your-rating__wrapper']//div[@class='points__wrapper']//div[@class='points']/span")
    private WebElement yourRatingUserScorePointsText;

    @FindBy(xpath = "//div[@class='your-rating__wrapper']//p[1][@class='score__item resize__item trophy']")
    private WebElement yourRatingUsersYouWonText;

    @FindBy(xpath = "//div[@class='your-rating__wrapper']//p[2][@class='score__item resize__item handshake']")
    private WebElement yourRatingUsersDrawText;

    @FindBy(xpath = "//div[@class='your-rating__wrapper']//p[3][@class='score__item resize__item trophy']")
    private WebElement yourRatingUsersRobotWonText;

    public LeaderBoardPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void waitForElementRatingTitleTextVisible() {
        waitVisibilityOfElementFluent(yourRatingTitleText);
    }

    @Step
    public void verifyUserNameInLeaderBoard(String text) {
        assertThat(yourRatingUserNameText.getText()).isEqualTo(text);
    }

    @Step
    public void verifyUserScorePointsInLeaderBoard(String text) {
        assertThat(yourRatingUserScorePointsText.getText()).isEqualTo(text);
    }

    @Step
    public void verifyUserWonInLeaderBoard(String text) {
        assertThat(yourRatingUsersYouWonText.getText()).contains(text);
    }

    @Step
    public void verifyUserDrawInLeaderBoard(String text) {
        assertThat(yourRatingUsersDrawText.getText()).contains(text);
    }

    @Step
    public void verifyUserRobotWonInLeaderBoard(String text) {
        assertThat(yourRatingUsersRobotWonText.getText()).contains(text);
    }
}
