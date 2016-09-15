package com.appium.san.ajio.androidajio;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appium.san.ajio.androidajio.components.Components;
import com.san.appium.sandriver.TestBase;

public class TestLogin extends TestBase{

	@Test
	public void testmethodLogin() throws Exception
	{
		System.out.println("test");
		Components comp = new Components(driver);
		comp.navigatetologin();
		comp.login();
	}
	
}
