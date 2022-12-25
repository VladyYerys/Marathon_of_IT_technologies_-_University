package com.epam.ticTacToeTests;

import com.epam.BaseTest;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest {

    private static final String USER_EMAIL = "testUser@marathon.com";
    private static final String USER_PASSWORD = "testUser@marathon.com";
    private static final String TEXT_BORDER_COLOR_WITH_TEXT = "#313253";
    private static final String TEXT_BORDER_COLOR_WITHOUT_TEXT = "#d22626";

    @Test
    public void signInTest(){
        getBasePage().openBasePageUrl();
        getBasePage().openSignInPage();
        getSignInPage().waitForEmailIsVisible();
        getSignInPage().emailInputFieldFill("");
        getSignInPage().passwordInputFieldFill("");
        getSignInPage().emailInputFieldClick();
        getSignInPage().verifyEmailBorderColor(TEXT_BORDER_COLOR_WITHOUT_TEXT);
        getSignInPage().verifyPasswordBorderBorderColor(TEXT_BORDER_COLOR_WITHOUT_TEXT);
        getSignInPage().emailInputFieldFill(USER_EMAIL);
        getSignInPage().verifyEmailBorderColor(TEXT_BORDER_COLOR_WITH_TEXT);
        getSignInPage().passwordInputFieldFill(USER_PASSWORD);
        getSignInPage().verifyPasswordBorderColor(TEXT_BORDER_COLOR_WITH_TEXT);
    }
}
