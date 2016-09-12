package com.san.pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.san.utility.AbstractPage;

public class LandingPage extends AbstractPage {

	// public static AppiumDriver driver=null;

	// Objects

	@FindBy(name = "UICatalog")
	private static WebElement navUICatalog;

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[2]/UIAStaticText[1]")
	private WebElement textReadMe;

	// Methods

	public static void clickNavUICatalog() {

		navUICatalog.click();

		// Return ComponentListPage

		PageFactory.initElements(new AppiumFieldDecorator(driver), new HomePage());

	}

}
