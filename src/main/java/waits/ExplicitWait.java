package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.Browser;
import utility.DataReader;

public class ExplicitWait {
	private final static int time = DataReader.getIntValue("explicitWaitTimeInSeconds","config");

	public static void presenceOfElementLocated(By Locator) {
		WebDriverWait wait = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(time));
		wait.until(ExpectedConditions.presenceOfElementLocated(Locator));
	}

	public static void elementToBeClickable(By Locator) {
		WebDriverWait wait = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(Locator));
	}

}
