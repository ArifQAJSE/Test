package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import driver.Browser;

public abstract class BaseElement {
	private By locator;

	public BaseElement(By locator) {
		this.locator = locator;
	}

	public void click() {
		getElement().click();
	}

	public String getText() {
		return getElement().getText();
	}

	protected WebElement getElement() {
		return Browser.getDriver().findElement(locator);
	}

	public boolean isDisplayed() {
		return getElement().isDisplayed();
	}

	public void scrollUntilEelementIsVisiable() {

        new Actions(Browser.getDriver())
                .scrollToElement(getElement())
                .perform();
	}
}
