package com.san.test;

import org.testng.annotations.Test;

import com.san.pages.LoginPage;
import com.san.pages.HomePage;
import com.san.pages.LandingPage;
import com.san.utility.AbstractTest;

public class FirstButtonTest extends AbstractTest {

	@Test
	public void validatelogin() {
		LoginPage.login();
	}
}