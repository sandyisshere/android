package com.san.test;

import org.testng.annotations.Test;

import com.san.pages.ButtonsPage;
import com.san.pages.ComponentListPage;
import com.san.pages.LandingPage;
import com.san.utility.AbstractTest;

public class FirstButtonTest extends AbstractTest {

	@Test
	public void clickFirstButton() {
		LandingPage.clickNavUICatalog();
		ComponentListPage.clickButtons();
		ButtonsPage.clickFirstButton();
		ButtonsPage.clickNavUICatalog();
	}
}