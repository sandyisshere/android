package com.appium.pages;

import org.openqa.selenium.By;

public class PDPPage {

	public static By selectsize = By.xpath("//android.widget.LinearLayout[@resource-id='com.ril.ajio:id/size_buttons_layout']/android.widget.TextView[@index='1']");

	public static By addtobag = By.xpath("//android.widget.TextView[@text='ADD TO BAG']");
	public static By savetocloset = By.xpath("//com.ril.ajio:id/internal_textview[text()='SAVE TO CLOSET']");
	
	public static By promomessages = By.id("com.ril.ajio:id/potential_promotions");
	public static By shopalook = By.id("com.ril.ajio:id/custom_strikebehind_text");
	

}
