package com.san.appium.sandriver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelBase {

	public AndroidDriver<MobileElement> driver;
	public WaitEvent we = null;

	public SelBase() {

	}

	public void setValue(By locator, String val, int durationSecs) throws Exception {
		if (durationSecs > 0) {
			if (we == null)
				we = new WaitEvent(driver);

			we.waitForElement(locator, durationSecs);
		}
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(val);

		try {
			driver.hideKeyboard();
		} catch (Exception e) {
			System.out.println("faileeed to   perform hide keyword");
		}
	}

	public void setValue(By locator, String val) throws Exception {
		setValue(locator, val, 0);
	}

	public void click(By locator, int durationSecs) throws Exception {
		if (durationSecs > 0) {
			if (we == null)
				we = new WaitEvent(driver);

			we.waitForElement(locator, durationSecs);
		}

		driver.findElement(locator).click();
	}
	
	public WebElement webElement(By loc) throws Exception{
		
		return we.waitForElement(loc);
		
	}

	public void click(By locator) throws Exception {
		click(locator, 0);
	}

	private static final String[] WIN_RUNTIME = { "cmd.exe", "/C" };
	private static final String[] OS_LINUX_RUNTIME = { "/bin/bash", "-l", "-c" };

	private static <T> T[] concat(T[] first, T[] second) {
		T[] result = Arrays.copyOf(first, first.length + second.length);
		System.arraycopy(second, 0, result, first.length, second.length);
		return result;
	}

	public static List<String> runProcess(boolean isWin, String... command) {
		System.out.print("command to run: ");
		for (String s : command) {
			System.out.print(s);
		}
		System.out.print("\n");
		String[] allCommand = null;
		try {
			if (isWin) {
				allCommand = concat(WIN_RUNTIME, command);
			} else {
				allCommand = concat(OS_LINUX_RUNTIME, command);
			}
			ProcessBuilder pb = new ProcessBuilder(allCommand);
			pb.redirectErrorStream(true);
			Process p = pb.start();
			p.waitFor();
			BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String _temp = null;
			List<String> line = new ArrayList<String>();
			while ((_temp = in.readLine()) != null) {
				System.out.println("temp line: " + _temp);
				line.add(_temp);
			}
			System.out.println("result after command: " + line);
			return line;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
