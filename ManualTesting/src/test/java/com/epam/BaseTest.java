package com.epam;

import com.epam.aqa.manager.PageFactoryManager;
import com.epam.aqa.page.*;
import com.epam.listener.AllureListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.*;


@Listeners({AllureListener.class})
public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setUp(ITestContext iTestContext){
        //WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

    protected BasePage getBasePage(){
        return new BasePage(getDriver());
    }

    protected DonatePage getDonatePage(){
        return new DonatePage(getDriver());
    }

    protected GamePage getGamePage(){
        return new GamePage(getDriver());
    }

    protected LeaderBoardPage getLeaderBoardPage(){
        return new LeaderBoardPage(getDriver());
    }

    protected MainGameRoomPage getMainGameRoomPage(){
        return new MainGameRoomPage(getDriver());
    }

    protected SaveYourScorePopUp getSaveYourScorePopUp(){
        return new SaveYourScorePopUp(getDriver());
    }

    protected SignInPage getSignInPage(){
        return new SignInPage(getDriver());
    }

    protected SignUpPage getSignUpPage(){
        return new SignUpPage(getDriver());
    }


    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
