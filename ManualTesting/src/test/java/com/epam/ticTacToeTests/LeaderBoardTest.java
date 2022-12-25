package com.epam.ticTacToeTests;

import com.epam.BaseTest;

import org.testng.annotations.Test;

public class LeaderBoardTest extends BaseTest {

    private static final String WELCOME_TO_TIC_TAC_TOE_TITLE_TEXT = "Welcome to Tic Tac Toe";
    private static final String TEST_USER_NAME = "Jan_2012";
    private static final String TEST_USER_SCOPE = "345";
    private static final String TEST_USER_WIN = "123";
    private static final String TEST_USER_DRAW = "56";
    private static final String TEST_USER_ROBOT_WON = "123";

    @Test
    public void leaderBoardSimpleTest(){
        getBasePage().openBasePageUrl();
        getGamePage().verifyThatTextTitle(WELCOME_TO_TIC_TAC_TOE_TITLE_TEXT);
        getBasePage().openLeaderBoardPage();
        getLeaderBoardPage().waitForElementRatingTitleTextVisible();
        getLeaderBoardPage().verifyUserNameInLeaderBoard(TEST_USER_NAME);
        getLeaderBoardPage().verifyUserScorePointsInLeaderBoard(TEST_USER_SCOPE);
        getLeaderBoardPage().verifyUserWonInLeaderBoard(TEST_USER_WIN);
        getLeaderBoardPage().verifyUserDrawInLeaderBoard(TEST_USER_DRAW);
        getLeaderBoardPage().verifyUserRobotWonInLeaderBoard(TEST_USER_ROBOT_WON);
    }
}
