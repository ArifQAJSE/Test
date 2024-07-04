package test;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import driver.Browser;
import pages.HomePage;
import pages.PrivacyPolicyPage;
import utility.DataReader;
import utility.TabSwitch;

public class Task3 {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = Browser.initialize();
		driver.get(DataReader.getStringValue("url", "config"));
	}

	@Test
	public void TestPrivacyPolicy() {
		HomePage homepage = new HomePage();
		
		boolean isHomepageDisplayed = homepage.homePageIsDisplayed();
		
		if (isHomepageDisplayed) {
			System.out.println("Test Pass");
		}
		Assert.assertTrue(isHomepageDisplayed, "Home page is not displayed");

//		// Scroll Down to Privacy Policy and click on it
//		homepage.scrollDownToPrivacyPolicy();
//		homepage.clickOnPrivacyPolicy();
//
//		// Switch to the new created Privacy Policy Tab
//		TabSwitch.switchToCurrentTab();
//
//		// Privacy policy page Validation
//		PrivacyPolicyPage privacypolicypage = new PrivacyPolicyPage();
//		boolean isPrivacyPolicyPageNameDisplayed = privacypolicypage.PrivacyPolicyAgreementPageNameIsDisplayed();
//		Assert.assertTrue(isPrivacyPolicyPageNameDisplayed, "Privacy Policy Page is not Open in new Tab");
//
//		// Switch Language Lists validation
//		privacypolicypage.clickOnSwitchLanguage();
//		boolean isSwitchLanguageElementListDisplayed = privacypolicypage.switchLanguageElementListIsDisplayed();
//		Assert.assertTrue(isSwitchLanguageElementListDisplayed, "Switch Elements Language Lists is not displayed");
//
//		// CLose the list by Clicking on SwitchLanguage again
//		privacypolicypage.clickOnSwitchLanguage();
//
//		// Supported Languages Validation
//		List<String> supportedLanguagesList = DataReader.getStringList("supportedLanguages", "TestData");
//		List<String> actualLanguages = privacypolicypage.getActualSupportedLanguages();
//
//		// Compare the two lists using assertions in your test method
//		Assert.assertEquals(supportedLanguagesList, actualLanguages,
//				"Not all supported languages are present on the page");
//
//		// Privacy Policy Signed Year Validation
//		String expectedYear = DataReader.getStringValue("policyRevisionSignedYear", "TestData");
//		String actualYear = privacypolicypage.getRevisionSignYear();
//		Assert.assertEquals(actualYear, expectedYear, "Policy Revision Not Signed In 2023");

	}

	@AfterMethod
	public void teardown() {
		Browser.quitDriver();
	}
}
