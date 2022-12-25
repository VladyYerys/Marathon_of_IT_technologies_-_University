package com.epam.aqa.page;

import com.beust.ah.A;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class BasePage extends Actions {

    @FindBy(xpath = "//a[@class='sign-menu__link'][contains(text(),'Sign In')]")
    private WebElement signInLinkButton;

    @FindBy(xpath = "//a[@class='sign-menu__link'][contains(text(),'Sign Up')]")
    private WebElement signUpLinkButton;

    @FindBy(xpath = "//a[@class='leader-board__link']")
    private WebElement leaderBoardLinkButton;

    @FindBy(xpath = "//a[@class='play__link']")
    private WebElement playLinkButton;

    @FindBy(xpath = "//img[@alt='facebook']")
    private WebElement facebookLinkButton;

    @FindBy(xpath = "//img[@alt='instagram']")
    private WebElement instagramLinkButton;

    @FindBy(css = "a.donate__link")
    private WebElement donateCssLinkButton;

    @FindBy(xpath = "//a[@class='donate__link link primary-link']")
    private WebElement donateLinkButton;

    @FindBy(xpath = "//a[@class='report__link link secondary-link']")
    private WebElement reportAnErrorButton;

    private static final String baseURL = "http://marathon-2022-static.s3-website-eu-west-1.amazonaws.com/";

    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step
    public void waitForPageLoadComplete(long timeToWait) {
        new WebDriverWait(driver, Duration.ofSeconds(timeToWait)).until(webDriver -> {
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            return Objects.equals("complete", js.executeScript("return document.readyState"));
        });
    }

    @Step
    public void waitVisibilityOfElement(long timeToWait, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(timeToWait))
                .until(webDriver -> ExpectedConditions.visibilityOf(element));
    }

    @Step
    public void waitVisibilityOfElementFluent(WebElement element) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofSeconds(5L))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    @Step
    public void scrollToElement(WebElement element) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
    }


    @Step
    public void openBasePageUrl() {
        driver.get(baseURL);
        waitForPageLoadComplete(5);
    }

    @Step
    public void openLeaderBoardPage() {
        clickOnButton(leaderBoardLinkButton);
        waitForPageLoadComplete(5);
    }

    @Step
    public void openPlayGamePage() {
        clickOnButton(playLinkButton);
        waitForPageLoadComplete(5);
    }

    @Step
    public void openSignInPage() {
        clickOnButton(signInLinkButton);
        waitForPageLoadComplete(5);
    }

    @Step
    public void openDonatePage() throws InterruptedException {
        clickOnButton(donateCssLinkButton);
        Thread.sleep(5000);
        waitForPageLoadComplete(10);
    }

    @Step
    public void switchToSecondTab(){
        driver.switchTo().window(getOpenTabs().get(1));
    }

    @Step
    public void closeSecondTabAndSwitchToDefault(){
        driver.close();
        driver.switchTo().window(getOpenTabs().get(0));
    }

    private List<String> getOpenTabs(){
       return new ArrayList<String> (driver.getWindowHandles());
    }
}
