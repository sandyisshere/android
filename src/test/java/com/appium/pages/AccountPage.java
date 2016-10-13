/**
 * 
 */
/**
 * @author Santhosh.Baby
 */
package com.appium.pages;

import org.openqa.selenium.By;

public class AccountPage {

	public static By account_addressbook = By.xpath("//android.widget.TextView[@text='ADDRESS BOOK']");
	public static By addnewAdressblank = By.id("com.ril.ajio:id/add_new_address");
	public static By clicknewAdress = By.xpath("//android.widget.TextView[@text='Add a New Address']");
	public static By pincode = By.id("com.ril.ajio:id/pincode");
	public static By firstname = By.id("com.ril.ajio:id/first_name");
	public static By lastname = By.id("com.ril.ajio:id/last_name");
	public static By addressline1 = By.id("com.ril.ajio:id/address1");
	public static By addressline2 = By.id("com.ril.ajio:id/address2");
	public static By landmark = By.id("com.ril.ajio:id/land_mark");
	public static By townlocality = By.id("com.ril.ajio:id/town");
	public static By citydistrict = By.id("com.ril.ajio:id/city_district");
	public static By state = By.id("com.ril.ajio:id/state");
	public static By mobile = By.id("com.ril.ajio:id/mobile");
	public static By makethisaddressdeafault = By.id("com.ril.ajio:id/checkBox");
	public static By saveaddress = By.id("com.ril.ajio:id/save");
	public static By removeAdress = By.id("com.ril.ajio:id/remove");
	public static By  editAddress = By.id("com.ril.ajio:id/edit");
	public static By  accounttitilebar = By.id("com.ril.ajio:id/toolbar_title");		
}
