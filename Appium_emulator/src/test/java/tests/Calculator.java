package tests;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Calculator {

    AndroidDriver driver;

    @SuppressWarnings("deprecation")
	@BeforeClass
    public void setup() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("Android");
        options.setUdid("00271662T000672");
        //options.setUdid("emulator-5554");
        options.setNoReset(true);
        
        options.setAppPackage("com.google.android.calculator");
        options.setAppActivity("com.android.calculator2.Calculator");

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                options);

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        driver.activateApp("com.google.android.calculator");
    }

    public void click(String contentDesc) {

        driver.findElement(
                AppiumBy.accessibilityId(contentDesc))
                .click();
    }

    public String getResult() {

        WebElement result = driver.findElement(
                By.id("com.google.android.calculator:id/result_final"));

        return result.getText().trim();
    }

    public void clearCalculator() {

        try {
            driver.findElement(
                    AppiumBy.accessibilityId("clear"))
                    .click();
        } catch (Exception e) {
            // ignore
        }
    }

    @Test(priority = 1)
    public void additionTest() {

        clearCalculator();

        click("7");
        click("4");
        click("plus");
        click("7");
        click("3");
        click("equals");

        String actual = getResult();

        System.out.println("Addition Result : " + actual);

        Assert.assertEquals(actual, "147");
    }

    @Test(priority = 2)
    public void subtractionTest() {

        clearCalculator();

        click("6");
        click("0");
        click("minus");
        click("4");
        click("equals");

        String actual = getResult();

        System.out.println("Subtraction Result : " + actual);

        Assert.assertEquals(actual, "56");
    }

    @Test(priority = 3)
    public void multiplicationTest() {

        clearCalculator();

        click("1");
        click("0");
        click("multiply");
        click("5");
        click("equals");

        String actual = getResult();

        System.out.println("Multiplication Result : " + actual);

        Assert.assertEquals(actual, "50");
    }

    @AfterClass
    public void tearDown() {

    	driver.navigate().back();
    	driver.navigate().back();

        if (driver != null) {
            driver.quit();
        }
    }
}