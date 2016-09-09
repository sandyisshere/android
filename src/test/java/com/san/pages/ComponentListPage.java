package com.san.pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.san.utility.AbstractPage;

public class ComponentListPage extends AbstractPage {

	@FindBy(name = "Buttons")
	private static WebElement comButtons;

	// All the Components

	public static void clickButtons() {

		comButtons.click();

		// ButtonsPage

		PageFactory.initElements(new AppiumFieldDecorator(driver), new ButtonsPage());

	}

}