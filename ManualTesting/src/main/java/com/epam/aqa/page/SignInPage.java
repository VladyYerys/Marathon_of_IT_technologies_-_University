package com.epam.aqa.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SignInPage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='Enter your email']")
    private WebElement emailInputField;

    @FindBy(xpath = "//input[@placeholder='Enter password']")
    private WebElement passwordInputField;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void waitForEmailIsVisible() {
        waitVisibilityOfElementFluent(emailInputField);
    }

    @Step
    public void emailInputFieldFill(String email) {
        fillField(emailInputField, email);
    }

    @Step
    public void passwordInputFieldFill(String password) {
        fillField(passwordInputField, password);
    }

    @Step
    public void emailInputFieldClear() {
        clearField(emailInputField);
    }

    @Step
    public void passwordInputFieldClear() {
        clearField(passwordInputField);
    }

    @Step
    public void emailInputFieldClick() {
        clickOnButton(emailInputField);
    }

    @Step
    public void passwordInputFieldClick() {
        clickOnButton(passwordInputField);
    }
    private String getEmailBorderColor() {
        return Color.fromString(getCssAttribute(emailInputField, "border").substring(9)).asHex();
    }

    @Step
    private String getEmailBorderBorderColor() {
        return Color.fromString(getCssAttribute(emailInputField, "border-color")).asHex();
    }

    @Step
    private String getPasswordBorderColor() {
        return Color.fromString(getCssAttribute(passwordInputField, "border").substring(9)).asHex();
    }

    @Step
    private String getPasswordBorderBorderColor() {
        return Color.fromString(getCssAttribute(passwordInputField, "border-color")).asHex();
    }

    @Step
    public void verifyEmailBorderColor(String text) {
        assertThat(getEmailBorderColor()).isEqualTo(text);
    }

    @Step
    public void verifyEmailBorderBorderColor(String text) {
        assertThat(getEmailBorderBorderColor()).isEqualTo(text);
    }

    @Step
    public void verifyPasswordBorderColor(String text) {
        assertThat(getEmailBorderColor()).isEqualTo(text);
    }

    @Step
    public void verifyPasswordBorderBorderColor(String text) {
        System.out.println(driver.getCurrentUrl());
        assertThat(getEmailBorderBorderColor()).isEqualTo(text);
    }
}
