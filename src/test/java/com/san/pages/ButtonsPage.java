package com.san.pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.san.utility.AbstractPage;



public class ButtonsPage extends AbstractPage{

	//Objects

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIATableCell[1]")

	private static WebElement firstButton;

	@FindBy(name="UICatalog")

	private static WebElement navUICatalog;

	//Methods

	public static void clickFirstButton(){

	firstButton.click();

	}

	public static void clickNavUICatalog(){

	navUICatalog.click();

	//ComponentListPage

	PageFactory.initElements(new AppiumFieldDecorator(driver),new ComponentListPage());

	}

	}
