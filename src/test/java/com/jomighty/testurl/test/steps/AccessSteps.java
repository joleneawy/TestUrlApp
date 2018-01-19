package com.jomighty.testurl.test.steps;

import static org.hamcrest.MatcherAssert.*;

import org.apache.tools.ant.filters.LineContains.Contains;

import net.thucydides.core.annotations.Step;
import com.jomighty.testurl.test.pages.HomePage;

public class AccessSteps {
	
	HomePage homePage;
	
	@Step
    public void access(String url) {
		homePage.accessPage(url);
    }
	
	@Step
    public void should_see_https(String url) {
		assertThat("Redirection should be at "+url+ ", but current url is "+homePage.getDriver().getCurrentUrl(),homePage.getDriver().getCurrentUrl().contains(url));
	}

	@Step
    public void accessAndValidateMobile(String url, String match) {
		homePage.accessAndValidateMobilePage(url,match);
    }
	
	@Step
	public void googleSearch(String keyword, String matchUrl, String matchHttps){
		homePage.googleSearch(keyword, matchUrl, matchHttps);
	}
	
	@Step
	public void googleMobileSearch(String keyword, String matchUrl, String matchHttps){
		homePage.googleMobileSearch(keyword, matchUrl, matchHttps);
	}

}
