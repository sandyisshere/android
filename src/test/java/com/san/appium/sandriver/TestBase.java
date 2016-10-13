/**
 * 
 */
/**
 * @author Santhosh.Baby
 */
package com.san.appium.sandriver;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.appium.factory.ExtentManager;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBase extends SelBase {

	public ExtentReports extent = ExtentManager.getInstance();
	public ExtentTest test;
	public static DesiredCapabilities cap;
	// public AppiumServer appiumServer;
	public String Device = "";

	static String reportLocation = "D:\\data\\";
	static String imageLocation = "images/";

	@BeforeTest()
	@Parameters({ "port", "device", "platform_name", "platform_version", "mobilename", "apk" })
	public void setUp(String port, String device, String platform_name, String platform_version, String mobilename, String apk) throws MalformedURLException {
		File file = new File(apk);
		// extent.init(reportLocation + "ScreenshotReport.html", true,
		// DisplayOrder.BY_OLDEST_TO_LATEST, GridType.STANDARD);

		// extent.config().documentTitle("Sample ExtentReports report");

		// extent.config().reportHeadline("Test report for ParaBank login tests generated using <b>ExtentReports</b>");

		/*
		 * ServerArguments serverArguments = new ServerArguments();
		 * serverArguments.setArgument("--address", "127.0.0.1");
		 * serverArguments.setArgument("--chromedriver-port", 9516);
		 * serverArguments.setArgument("--bootstrap-port", 4725);
		 * serverArguments.setArgument("--no-reset", true);
		 * serverArguments.setArgument("--local-timezone", true);
		 * 
		 * AppiumServer appiumServer = new AppiumServer(serverArguments);
		 * 
		 * appiumServer.startServer();
		 */

		this.cap = new DesiredCapabilities();
		/*
		 * cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platform_name);
		 * cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,
		 * platform_version);
		 * cap.setCapability(MobileCapabilityType.DEVICE_NAME, mobilename);
		 * cap.setCapability(MobileCapabilityType.APP, file);
		 * cap.setCapability(MobileCapabilityType.UDID, device);
		 */cap.setCapability(MobileCapabilityType.APP_PACKAGE, "com.ril.ajio");
		cap.setCapability(MobileCapabilityType.APP_ACTIVITY, "SplashScreenActivity");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platform_name);
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platform_version);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		cap.setCapability(MobileCapabilityType.APP, file);

		Device = device;

		runProcess(true, "adb -s "+device+" shell pm clear com.ril.ajio");
		URL url = new URL("http://localhost:" + port + "/wd/hub");
		System.out.println(url.toString());
		this.driver = new AndroidDriver<MobileElement>(url, cap);
		System.out.println(this.driver.toString());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterTest
	public void teardown() {
		driver.quit();
		// appiumServer.stopServer();
	}

	@BeforeMethod
	public void startTest(Method method) throws Exception {
		String testName = method.getName();
		System.out.println("Executing test: " + testName);
		test = extent.startTest(testName);

	}

	@AfterMethod
	public void afterTest(Method method) throws Exception {
		String testName = method.getName();
		takeScreenShot();
		if (extent != null) {
			extent.endTest(test);
			extent.flush();
		}
	}

	public void reportFailure(String failureMessage){
		test.log(LogStatus.FAIL, failureMessage);
		takeScreenShot();
		Assert.fail(failureMessage);
	}
	public void takeScreenShot() {
		Date d = new Date();
		String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		String filePath = "D://data//" + "screenshots//" + screenshotFile;
		// store screenshot in that file
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(scrFile, new File(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.INFO, test.addScreenCapture(filePath));

	}

	
}
