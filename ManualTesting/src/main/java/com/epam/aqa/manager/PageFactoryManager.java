package com.epam.aqa.manager;

import com.epam.aqa.page.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryManager {

    private WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }



}
