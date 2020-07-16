package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class LoginPage extends BasePage {

	private WebDriver driver;
	ElementUtil elementUtil;

	// By Locators -- OR
	By emailId = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");

	// constructor of the page class:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	// page actions:
	public String getLoginPageTitle() {
		return elementUtil.doGetPageTitleWithIsTitle(10, Constants.LOGIN_PAGE_TITLE);
	}

	public boolean isSignUpLinkExist() {
		return elementUtil.doIsDisplayed(signUpLink);
	}

	public HomePage doLogin(String username, String pwd) {
		System.out.println("Login to app with--->" +username +":" + pwd);
		elementUtil.waitForElementToBeVisible(emailId, 10);
		elementUtil.doSendKeys(emailId, username);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);
		
		return new HomePage(driver);
	}

}