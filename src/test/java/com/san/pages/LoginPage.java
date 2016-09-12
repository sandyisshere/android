package com.san.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;





import com.san.utility.AbstractTest;


public class LoginPage extends AbstractTest {

	// Objects
	@AndroidFindBy(id = "com.ril.ajio:id/txt_email")
	private static WebElement emailid;
	@AndroidFindBy(id = "com.ril.ajio:id/txt_password")
	private static WebElement password;
	@AndroidFindBy(id = "com.ril.ajio:id/login_button")
	private static WebElement signin;

	// Methods
	
	public static void login() {
		
		emailid.sendKeys("santhosh.baby@ril.com");
		driver.hideKeyboard();
		password.sendKeys("test@321");
		driver.hideKeyboard();
		signin.click();
		
		PageFactory.initElements(new AppiumFieldDecorator(driver),
				new HomePage());
	}

}
