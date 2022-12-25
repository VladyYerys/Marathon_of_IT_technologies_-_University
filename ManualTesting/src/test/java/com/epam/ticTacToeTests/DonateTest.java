package com.epam.ticTacToeTests;

import com.epam.BaseTest;
import org.testng.annotations.Test;

public class DonateTest extends BaseTest {

    private static final String URL_OF_DONATE_PAGE =
            "https://bank.gov.ua/en/news/all/natsionalniy-bank-vidkriv-rahunok-dlya-gumanitarnoyi-dopomogi-ukrayintsyam-postrajdalim-vid-rosiyskoyi-agresiyi";

    @Test(timeOut = 20)
    public void donateTest() throws InterruptedException {
        getBasePage().openBasePageUrl();
        getBasePage().openDonatePage();
     //   getDonatePage().switchToTabAndVerifyUrl(URL_OF_DONATE_PAGE);
    }
}
