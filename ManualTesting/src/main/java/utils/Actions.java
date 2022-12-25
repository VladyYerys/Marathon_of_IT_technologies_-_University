package utils;

import org.openqa.selenium.WebElement;

public class Actions {

    protected String getTextFromXpath(WebElement xpath){
        return xpath.getText();
    }
    protected void clickOnButton(WebElement xpath){
        xpath.click();
    }

    protected void fillField(WebElement xpath, String text){
        xpath.sendKeys(text);
    }

    protected String getCssAttribute(WebElement xpath, String cssValue){
        return xpath.getCssValue(cssValue);
    }

    protected void clearField(WebElement xpath){
        xpath.clear();
    }
}
