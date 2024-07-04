package pages;

import org.openqa.selenium.By;
import elements.Links;
import waits.ExplicitWait;
import elements.Element;

public class HomePage {

	private final Element FeaturedAndRecommendedBanner = new Element(By.xpath("//div[contains(@id,'home_maincap')]"));
	private final Links PrivacyPolicy = new Links(By.xpath("//div[@id='footer_text']//a[contains(text(),'Privacy Policy')]"));
	
	private final Element homepage = new Element(By.xpath("//h1[contains(text(),'Unparalleled Growth and Excellence of')]"));

	public boolean FeaturedAndRecommendedBannerIsDisplayed() {
		return FeaturedAndRecommendedBanner.isDisplayed();
	}
	
	
	public boolean homePageIsDisplayed() {
		ExplicitWait.presenceOfElementLocated(homepage.getLocator());	
		return homepage.isDisplayed();
	}

	public void clickOnPrivacyPolicy() {
		PrivacyPolicy.click();
	}

	public void scrollDownToPrivacyPolicy() {
		PrivacyPolicy.scrollUntilEelementIsVisiable();
	}
}
