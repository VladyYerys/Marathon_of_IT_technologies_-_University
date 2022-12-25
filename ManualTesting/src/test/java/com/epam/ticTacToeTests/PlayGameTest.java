package com.epam.ticTacToeTests;

import com.epam.BaseTest;
import org.testng.annotations.Test;


public class PlayGameTest extends BaseTest {

    private static final String WELCOME_TO_TIC_TAC_TOE_TITLE_TEXT = "Welcome to Tic Tac Toe";

    @Test
    public void playGameWithRobotTest() throws InterruptedException {
        getBasePage().openBasePageUrl();
        getGamePage().verifyThatTextTitle(WELCOME_TO_TIC_TAC_TOE_TITLE_TEXT);
        getBasePage().openPlayGamePage();
        getMainGameRoomPage().openPlayGamePage();
        getGamePage().clickOnGameWithRobot();
        getMainGameRoomPage().verifyWinLoseDrawPlayAgainAppear();

    }

}
