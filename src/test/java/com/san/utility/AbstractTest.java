package com.san.utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.san.pages.LandingPage;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;

public class AbstractTest {

	public static IOSDriver driver;

	@BeforeClass
	public static void createEnvironment() throws Exception {

		// DesiredCapabilities

		startAppiumonMac();

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");

		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");

		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Srikanth Vejendla's iPhone");

		capabilities.setCapability("udid", "5e66e1067a0afea89be55a2d06322a98344023bb");

		capabilities.setCapability("app", "/Users/srikanthvejendla/Desktop/UiCatalog.app");

		// capabilities.setCapability("bundleId","com.example.apple-samplecode.UICatalog");

		try {

			driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		} catch (MalformedURLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		PageFactory.initElements(new AppiumFieldDecorator(driver), new LandingPage());

	}

	@AfterClass
	public static void tearEnvironment() throws Exception {
		driver.quit();
		stopAppium();

	}

	public static void startAppiumonMac() throws Exception {

		// node appium

		// node appium.js

		CommandLine command = new CommandLine("/Applications/Appium.app/Contents/Resources/node/bin/node");

		command.addArgument("/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js", false);

		command.addArgument("--address", false);

		command.addArgument("127.0.0.1");

		command.addArgument("--port", false);

		command.addArgument("4723");

		command.addArgument("--no-reset", false);

		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();

		DefaultExecutor executor = new DefaultExecutor();

		executor.setExitValue(1);

		executor.execute(command, resultHandler);

		Thread.sleep(3000);

	}

	public static void stopAppium() throws Exception {
		Runtime.getRuntime().exec("killall node");

	}

}
