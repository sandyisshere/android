package com.appium.san.ajio.androidajio.components;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Keyboard;
import org.testng.Assert;

import com.appium.pages.AccountPage;
import com.appium.pages.CartPage;
import com.appium.pages.CommonPages;
import com.appium.pages.HomePage;
import com.appium.pages.LoginPage;
import com.appium.pages.PDPPage;
import com.appium.pages.SearchPage;
import com.san.appium.sandriver.TestBase;
import com.san.appium.sandriver.WaitEvent;

public class Components extends TestBase {

	public Components(AndroidDriver driver) throws Exception {
		System.out.println("uuuuuuuuuuuuu");
		this.driver = driver;
		// we = new WaitEvent(driver);

		// ui = new UIMapParser(utils.getConfig("ObjectRepository"));
	}

	public void navigatetologin() throws Exception {
		try {

			click(LoginPage.accounttab, 30);
			click(LoginPage.signin, 30);
		} catch (Exception e) {
			click(CommonPages.navigateup);
			click(LoginPage.accounttab, 30);
		}

	}

	public void login() throws Exception {
		setValue(By.id("com.ril.ajio:id/txt_email"), "santhosh.baby@ril.com");
		setValue(By.id("com.ril.ajio:id/txt_password"), "test@321");
		click(By.id("com.ril.ajio:id/login_button"));
		/*
		 * // driver.findElementByAndroidUIAutomator( //
		 * "new UiSelector().resourceId(\"com.ril.ajio:id/txt_email\")") //
		 * .sendKeys("santhosh.baby@ril.com");
		 * 
		 * driver.findElementByAndroidUIAutomator(
		 * "new UiSelector().resourceId(\"com.ril.ajio:id/txt_password\")")
		 * .sendKeys("test@321"); driver.hideKeyboard();
		 * 
		 * driver.findElementByAndroidUIAutomator(
		 * "new UiSelector().resourceId(\"com.ril.ajio:id/login_button\")")
		 * .click(); driver.hideKeyboard();
		 */}

	public Boolean assertlogin() throws Exception {
		WaitEvent we1 = new WaitEvent(driver, 40);
		String text = we1.waitForElement(By.id("com.ril.ajio:id/toolbar_title")).getText();
		System.out.println(text);
		if (text.equals("My Account")) {
			return true;
		} else {
			return false;
		}

	}

	public Boolean addressbook() throws Exception {

		click(AccountPage.account_addressbook);
		return false;

	}

	public Boolean clickNewAddress() throws Exception {
		try {
			click(AccountPage.clicknewAdress);

		} catch (Exception e) {
			click(AccountPage.addnewAdressblank);
		}

		return false;
	}

	public void enterAdresss(String... address) throws Exception {

		addressbook();
		clickNewAddress();
		setValue(AccountPage.pincode, address[0]);
		setValue(AccountPage.firstname, address[1]);
		setValue(AccountPage.lastname, address[2]);
		setValue(AccountPage.addressline1, address[3]);
		setValue(AccountPage.addressline2, address[4]);
		setValue(AccountPage.landmark, address[5]);
		driver.scrollTo("SAVE");
		setValue(AccountPage.townlocality, address[6]);
		// setValue(RegistrationPage.citydistrict, address[0]);
		// setValue(RegistrationPage.state, address[0]);
		setValue(AccountPage.mobile, address[7]);
		click(AccountPage.saveaddress);
		// setValue(RegistrationPage.pincode, address[0]);
	}

	public void AssertenteredAdress(String name) throws Exception {
		String text = webElement(By.xpath("//android.widget.TextView[contains(@text,'" + name + "')]")).getText();
		System.out.println(text);
		if (!text.contains(name)) {
			Assert.fail("Address addition fail");
		}
	}

	public void editAddress(String addrs) throws Exception {
		click(AccountPage.editAddress);

		setValue(AccountPage.addressline1, addrs);
		driver.scrollTo("SAVE");
		click(AccountPage.saveaddress);

		AssertenteredAdress(addrs);
	}

	public void removeAddress() {

	}

	public void navigatetocollection(String attr) throws Exception {
		click(By.xpath("//android.view.View[contains(@content-desc,'" + attr + "')]"));
	}

	public void navigatemyaccounttab(String attr) throws Exception {

		click(By.xpath("//android.widget.TextView[contains(@text,'" + attr + "')]"));
	}

	public void addproduct(String attr) throws Exception {
		try {
			deletecart();

		} catch (Exception e) {
			// TODO: handle exception
		}
		click(CommonPages.hometab);
		navigatetocollection("MEN");
		/*
		 * click(CommonPages.searchicon); setValue(CommonPages.searchicontext,
		 * attr);
		 * driver.findElement(CommonPages.searchicontext).sendKeys(Keys.ENTER);
		 */
		click(SearchPage.product);
		driver.scrollTo("SELECT SIZE");
		/*
		 * driver.findElement(PDPPage.selectsize).click(); List<MobileElement>
		 * findElements = driver.findElements(PDPPage.selectsize);
		 * findElements.get(0).click();
		 */click(PDPPage.selectsize);
		// click(PDPPage.selectsize);
		click(PDPPage.addtobag);

	}

	public void deletecart() throws Exception {
		
		click(CommonPages.carttab);
		click(CartPage.remove);
		click(CartPage.yes);
	  	
   
	}

	
	public void verifymyaccounttab(String val) throws Exception {

		navigatemyaccounttab(val);
		String text = driver.findElement(AccountPage.accounttitilebar).getText().toLowerCase();
		if (!text.contains(val.toLowerCase())) {
			click(CommonPages.navigateup);

			Assert.fail(val);
		}
		click(CommonPages.navigateup);

	}

	public void verifyhomepagenavigation(String val) throws Exception {

		navigatetocollection(val);
		String text = driver.findElement(CommonPages.landingpagetitle).getText().toLowerCase();
		System.out.println(text);
		if (!text.contains(val.toLowerCase())) {

			Assert.fail(val);
		}
		click(CommonPages.hometab);

	}

	public  void orderplacement() {

	}
}
