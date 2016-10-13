/**
 * 
 */
/**
 * @author Santhosh.Baby
 */
package com.san.appium.sandriver;

import io.appium.java_client.android.AndroidDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitEvent {

	private int DEFAULT_TIMEOUT_SEC = 30;
	private int DEFAULT_POLL_SEC = 1;

	private AndroidDriver driver = null;
	private By locator = null;
	private int timeOutInSeconds;
	private int pollIntervalInSeconds;
	private String text = null;
	private WebElement element = null;

	public WaitEvent(AndroidDriver driver, int duration_in_sec,
			int poll_interval_in_sec) {
		this.driver = driver;
		this.timeOutInSeconds = duration_in_sec;
		this.pollIntervalInSeconds = poll_interval_in_sec;
	}

	public WaitEvent(AndroidDriver driver) {
		this.driver = driver;
		this.timeOutInSeconds = DEFAULT_TIMEOUT_SEC;
		this.pollIntervalInSeconds = DEFAULT_POLL_SEC;
	}

	public WaitEvent(AndroidDriver driver, int duration_in_sec) {
		this.driver = driver;
		this.timeOutInSeconds = duration_in_sec;
		this.pollIntervalInSeconds = DEFAULT_POLL_SEC;
	}

	public void setTimeOut(int duration_in_sec) {
		this.timeOutInSeconds = duration_in_sec;
	}

	public void setPollingInterval(int poll_interval_in_sec) {
		this.pollIntervalInSeconds = poll_interval_in_sec;
	}

	public void changeDriver(AndroidDriver driver) {
		this.driver = driver;
	}

	public WebElement waitForElement(By locat) throws Exception {
		this.locator = locat;
		this.timeOutInSeconds = DEFAULT_TIMEOUT_SEC;
		return waitForElement(locat, timeOutInSeconds);
	}

	public WebElement waitForElement(By locat, int durationSecs)
			throws Exception {
		try {
			this.locator = locat;
			this.timeOutInSeconds = durationSecs;

			WebDriverWait wait = new WebDriverWait(driver,
					this.timeOutInSeconds);
			try {
				wait.until(ExpectedConditions.elementToBeClickable(locator));
				WebElement elem = driver.findElement(locator);

				return elem;
			} catch (StaleElementReferenceException ste) {
				Thread.sleep(3000);
				wait.until(ExpectedConditions.elementToBeClickable(locator));
				WebElement elem = driver.findElement(locator);

				return elem;

			}
		} catch (TimeoutException te) {
			return null;
		}
	}

}
