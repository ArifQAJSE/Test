package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import elements.Element;
import utility.ExtractLanguage;
import waits.ExplicitWait;

public class PrivacyPolicyPage {

	private static final Element PrivacyPolicyAgreementPageName = new Element(
			By.xpath("//div[@class='page_name']//div[@class='blockbg']"));
	private static final Element switchLanguage = new Element(By.id("language_pulldown"));
	private static final Element switchLanguageElementList = new Element(By.id("language_dropdown"));
	private static final Element supportedLanguages = new Element(By.id("languages"));
	private static final Element policyRevisionSigned = new Element(By.xpath("//i[contains(text(),'Revision Date:')]"));

	public boolean PrivacyPolicyAgreementPageNameIsDisplayed() {
		ExplicitWait.presenceOfElementLocated(PrivacyPolicyAgreementPageName.getLocator());
		return PrivacyPolicyAgreementPageName.isDisplayed();
	}

	public void clickOnSwitchLanguage() {
		ExplicitWait.elementToBeClickable(switchLanguage.getLocator());
		switchLanguage.click();
	}

	public boolean switchLanguageElementListIsDisplayed() {
		return switchLanguageElementList.isDisplayed();
	}

	public String getRevisionSignYear() {
		// Find the <i> element containing the revision date
		WebElement revisionDateElement = policyRevisionSigned.getElement();

		// Get the text from the element
		String revisionDateText = revisionDateElement.getText();

		// Extract the year from the text using regular expressions
		Pattern pattern = Pattern.compile("\\d{4}"); // Match a 4-digit year
		Matcher matcher = pattern.matcher(revisionDateText);

		// Check if a year is found and return it
		while (matcher.find()) {
			String year = matcher.group(); // Get the matched year
			return year;
		}

		return null; // Return null if the year is not found in the text
	}

	public List<String> getActualSupportedLanguages() {
		WebElement languagesDiv = supportedLanguages.getElement();
		List<WebElement> languageLinks = languagesDiv.findElements(By.tagName("a"));

		List<String> pageLanguages = new ArrayList<>();
		for (WebElement languageLink : languageLinks) {
			String href = languageLink.getAttribute("href");
			String language = ExtractLanguage.extractLanguageFromHref(href);
			if (language != null) {
				pageLanguages.add(language);
			}
		}
		return pageLanguages;
	}

}
