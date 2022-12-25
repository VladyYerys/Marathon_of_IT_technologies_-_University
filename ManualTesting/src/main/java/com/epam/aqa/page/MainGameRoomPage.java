package com.epam.aqa.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MainGameRoomPage extends BasePage{


    @FindBy(xpath = "//div[@class='game-table__wrapper']")
    private WebElement tableWrapper;

    @FindBy(xpath = "//app-game-cell[@class='cell']")
    private List<WebElement> cellOfTable;

    @FindBy(xpath = "//div[@class='game-overlay__wrapper']")
    private String gameResultOverlay;

    @FindBy(xpath = "//div[@class='game-overlay__wrapper']")
    private WebElement gameResultOverlay1;

    public MainGameRoomPage(WebDriver driver) {
        super(driver);
    }


    @Step
    private void playWithRobot() throws InterruptedException {
        int[] array = new Random().ints(0, 9).distinct().limit(9).toArray();
            for (int i = 0; i<cellOfTable.size(); i++) {
                clickOnButton(cellOfTable.get(array[i]));
                Thread.sleep(1000);
                Boolean isPresent = driver.findElements(By.xpath("//div[@class='game-overlay__wrapper']")).size() > 0;
                if(isPresent){
                    break;
                }
            }
    }

    @Step
    public void verifyWinLoseDrawPlayAgainAppear() throws InterruptedException {
        playWithRobot();
        assertThat(gameResultOverlay1.isDisplayed()).isTrue();
        waitForPageLoadComplete(5);
    }
}
