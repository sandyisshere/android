package com.appium.pages;

import org.openqa.selenium.By;

public class MyBag {
	
	public static By customername = By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.TextView[@resource-id='com.ril.ajio:id/address_customer_name'][@index='0']");
	public static By address = By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.TextView[@resource-id='android:id/text1'][@index='0']");
	public static By payment = By.id("com.ril.ajio:id/proceed");
	public static By confirmorder = By.id("com.ril.ajio:id/confirm_order");
	public static By codpayment = By.xpath("//android.widget.TextView[@text='Cash On Delivery']");
	public static By expand = By.id("com.ril.ajio:id/expand");
	public static By pincodebox = By.id("com.ril.ajio:id/pincode_box");
	public static By pincodecheck = By.id("com.ril.ajio:id/pincode_check");
	public static By pincodecheckmessage = By.id("com.ril.ajio:id/deivery_days");
	
	
	
	
	
	
	
	
	
}
