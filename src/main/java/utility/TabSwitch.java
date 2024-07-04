package utility;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import driver.Browser;

public class TabSwitch {

	private static final WebDriver driver = Browser.getDriver();
	private static String originalTabHandle;

	public static void switchToCurrentTab() {
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		int numberOfTabs = tabs.size();

		if (numberOfTabs > 0) {
			driver.switchTo().window(tabs.get(numberOfTabs - 1));
		} else {
			throw new IllegalStateException("No tabs available to switch to.");
		}
	}

    public static void switchBackToOriginalTab() {
        if (originalTabHandle != null) {
            driver.switchTo().window(originalTabHandle);
        } else {
            throw new IllegalStateException("Original tab handle is not set.");
        }
    }

	public static void switchToSpecificTab(int tabNumber) {
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		int numberOfTabs = tabs.size();

		if (tabNumber < 0 || tabNumber >= numberOfTabs) {
			throw new IllegalArgumentException("Invalid tab number: " + tabNumber);
		}

		driver.switchTo().window(tabs.get(tabNumber));
	}

    public static void setOriginalTabHandle() {
        originalTabHandle = driver.getWindowHandle();
    }
}
