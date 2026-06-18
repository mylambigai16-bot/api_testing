package appium_code;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class Using_emulator {

	public static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException {

		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android");
		options.setCapability("udid", "emulator-5554");
		options.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		options.setCapability("appPackage", "io.appium.android.apis");
		options.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		URL url = new URL("http://127.0.0.1:4723");
		driver = new AndroidDriver(url, options);
		WebElement Accessability1 = driver.findElement(By.id("android:id/text1"));
		Accessability1.click();
		WebElement NP = driver
				.findElement(By.xpath("//android.widget.TextView[@content-desc='Accessibility Node Provider']"));
		NP.click();
		driver.navigate().back();
		driver.navigate().back();

	}

}
