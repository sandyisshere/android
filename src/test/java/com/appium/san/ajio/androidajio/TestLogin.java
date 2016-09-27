package com.appium.san.ajio.androidajio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appium.pages.CartPage;
import com.appium.pages.ClosetPage;
import com.appium.pages.CommonPages;
import com.appium.pages.MyBag;
import com.appium.pages.PDPPage;
import com.appium.pages.SearchPage;
import com.appium.san.ajio.androidajio.components.Components;
import com.san.appium.sandriver.TestBase;

public class TestLogin extends TestBase {

	// @Test
	public void testmethodLogin() throws Exception {
		System.out.println("test");
		Components comp = new Components(driver);
		comp.navigatetologin();
		comp.login();
		
	}

	@BeforeMethod
	public void initbefore() {
		// driver.resetApp();

		//driver.closeApp();
		//driver.launchApp();
	}

	//@Test
	public void Verify_user_can_sign_into_the_app_with_an_existing_account() throws Exception {
		Components comp = new Components(driver);
		comp.navigatetologin();
		comp.login();
		if(comp.assertlogin()){
        insertscreenshot();
		}

	}

	String addrs;

	// @Test
	public void Verify_Add_New_Delivery_Address() throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String addrs = dateFormat.format(date).toString().replaceAll("/", "").replaceAll(":", "").replaceAll(" ", "");
		System.out.println(addrs);
		Components comp = new Components(driver);
		comp.navigatetologin();
		comp.login();
		comp.enterAdresss("560034", "Santhosh", "baby", addrs, "jakkasrandra", "landmark1", "koramngala", "9611437246");
		comp.AssertenteredAdress(addrs);
		date = new Date();
		addrs = dateFormat.format(date).toString().replaceAll("/", "").replaceAll(":", "").replaceAll(" ", "");
System.out.println(addrs);
		comp.editAddress(addrs);
	}
	 
	 
	// @Test
	 public void Verify_PDP_screen_adding_product() throws Exception
	 {
		 Components comp = new Components(driver);
			//comp.navigatetologin();
			//comp.login();
			comp.addproduct("Shirt");
			
	 }

	 //@Test(dependsOnMethods = { "Verify_PDP_screen_adding_product" })
	 public void Add_Remove_feature_in_cart() throws Exception
	 {
		 Components comp = new Components(driver);
		 click(CommonPages.navigateup);
			comp.deletecart();
			if (!driver.findElement(CartPage.emptycart).isDisplayed()) {
				Assert.fail("Cart not empty");
			}

	 }
	// @Test(dependsOnMethods = { "Add_Remove_feature_in_cart" }) 
	 public void Verify_when_no_items_in_cart_closet() throws Exception {

		 click(CommonPages.carttab);
		 if (!driver.findElement(CartPage.emptycart).isDisplayed()) {
				Assert.fail("Cart not empty");
			}
		 click(CommonPages.closetab);

		 if (!driver.findElement(ClosetPage.closestempty).isDisplayed()) {
				Assert.fail("Closet not empty");
			}
	}

	 //@Test
	 public void place_order() throws Exception
	 {
		 Components comp = new Components(driver);			
			comp.addproduct("Shirt");
			click(CommonPages.navigateup);
			click(CommonPages.carttab);
			click(CartPage.proceedshipping);
			click(MyBag.payment);
			click(MyBag.codpayment);
	 }

	// @Test
	 public void Verify_my_account_screen() throws Exception{
		 Components comp = new Components(driver);
		 click(CommonPages.accounttab);
		 comp.verifymyaccounttab("ORDERS");
		 comp.verifymyaccounttab("CREDITS");
		 comp.verifymyaccounttab("ADDRESS BOOK");
		 comp.verifymyaccounttab("FAQ");
		 comp.verifymyaccounttab("RETURNS");
		 comp.verifymyaccounttab("CONTACT US");
		 
	 }
	 
	// @Test
	 public  void Verify_Home_screen_contents_navigation_to_other_screens() throws Exception {
		 Components comp = new Components(driver);
		 comp.verifyhomepagenavigation("MEN");
		 comp.verifyhomepagenavigation("ETHNIC");
		 comp.verifyhomepagenavigation("WESTERN");



	}
	 //@Test
	 public  void Verify_offer_tag_appears_in_PLP() throws Exception {

		 Components comp = new Components(driver);
		 comp.navigatetocollection("MEN");
		 if (!driver.findElement(SearchPage.promoimage).isDisplayed()) {
			Assert.fail("Promo image  not displayed");
		}
	}
	 
	 //@Test
	 public void Verify_promo_msgs_in_PDP() throws Exception{
		 
		 Components comp = new Components(driver);
		 comp.navigatetocollection("MEN");
		 click(SearchPage.product);
		 if (!driver.findElement(PDPPage.promomessages).isDisplayed()) {
			Assert.fail("No promo message");
		}
	 }

	@Test
	 public  void Verify_pincode_check_in_PDP_and_cart() throws Exception {
		Components comp = new Components(driver);			
		comp.addproduct("Shirt");
		click(CommonPages.navigateup);
		click(CommonPages.carttab);
		click(MyBag.expand);
		setValue(MyBag.pincodebox,"560034");
		click(MyBag.pincodecheck);
		if (!driver.findElement(MyBag.pincodecheckmessage).getText().toLowerCase().contains("order")) {
			Assert.fail("Pincode check message not avaliable");
		}
		
	}
	 
	 //@Test
	 public void Verify_user_can_see_shop_the_look_capsule_on_PDP() throws Exception {
		 Components comp = new Components(driver);
		 click(CommonPages.hometab);
		 comp.navigatetocollection("MEN");			
			click(SearchPage.product);
			driver.scrollTo("SHOP THE LOOK");
			if (!driver.findElement(PDPPage.shopalook).isDisplayed()) {
				Assert.fail("No shop a look message");
			}
			
	}
	 
	 
}
