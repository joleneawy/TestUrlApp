package com.jomighty.testurl.test.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@DefaultUrl("/")
public class HomePage extends PageObject{
	
	WebDriver driver;
	
	public void accessPage(String url) {
		try {
			getDriver().navigate().to(url);
			Thread.sleep(1000);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public void accessAndValidateMobilePage(String url, String match) {
		try {
			Map<String, String> mobileEmulation = new HashMap<String, String>();
			mobileEmulation.put("deviceName", "Nexus 5");
			//here creating the second map with key mobileEmulation
			Map<String, Object> chromeOptions = new HashMap<String, Object>();
			chromeOptions.put("mobileEmulation", mobileEmulation);
			
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			driver = new ChromeDriver(capabilities);
			driver.get(url);
			assertThat("Redirection should be at "+match+ ", but current url is "+driver.getCurrentUrl(), driver.getCurrentUrl().equalsIgnoreCase(match));
			driver.close();
			Thread.sleep(1000);
		}catch(Exception ex){
			driver.close();
			ex.printStackTrace();
		}finally{
			//driver.close();
		}
	}
	
	public void googleSearch(String keyword, String matchUrl, String matchHttps) {
		try {
			boolean isMatch = false;
			driver = new ChromeDriver();
			driver.get("http://www.google.com");

			WebElement element = driver.findElement(By.name("q"));
			element.sendKeys(keyword + "\n");
			
			Thread.sleep(1000);

			WebElement myDynamicElement = (new WebDriverWait(driver, 20))
					.until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));

			List<WebElement> findElements = driver.findElements(By.xpath("//*[@id='rso']//h3/a"));

			for (WebElement webElement : findElements) {
				if (webElement.getAttribute("href").equalsIgnoreCase(matchUrl)) {
					webElement.click();

					Thread.sleep(1000);
					assertThat("Redirection should be at "+matchHttps+", but current url is "+driver.getCurrentUrl(), driver.getCurrentUrl().equalsIgnoreCase(matchHttps));

					isMatch = true;
					//driver.close();
				}
			}

			if (!isMatch) {
				assertThat("Cannot find the link from google search", false);
			}
			
			driver.close();
		} catch (Exception ex) {
			driver.close();
			ex.printStackTrace();
		} finally {
			//driver.close();
		}

	}
	
	public void googleMobileSearch(String keyword, String matchUrl, String matchHttps) {
		try {
			boolean isMatch = false;
			Map<String, String> mobileEmulation = new HashMap<String, String>();
			mobileEmulation.put("deviceName", "Nexus 5");
			//here creating the second map with key mobileEmulation
			Map<String, Object> chromeOptions = new HashMap<String, Object>();
			chromeOptions.put("mobileEmulation", mobileEmulation);
			
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			
			driver = new ChromeDriver(capabilities);
			driver.get("http://www.google.com");

			WebElement element = driver.findElement(By.name("q"));
			element.sendKeys(keyword + "\n");

			WebElement myDynamicElement = (new WebDriverWait(driver, 20))
					.until(ExpectedConditions.presenceOfElementLocated(By.id("ires")));

			List<WebElement> findElements = driver.findElements(By.xpath("//*[@id='rso']//a"));

			for (WebElement webElement : findElements) {
				if (webElement.getAttribute("href").equalsIgnoreCase(matchUrl)) {
					webElement.click();

					Thread.sleep(1000);
					assertThat("Redirection should be at "+matchHttps+", but current url is "+driver.getCurrentUrl(), driver.getCurrentUrl().equalsIgnoreCase(matchHttps));

					isMatch = true;
					
				}
			}

			if (!isMatch) {
				assertThat("Cannot find the link from google search", false);
			}
			
			driver.close();
		} catch (Exception ex) {
			driver.close();
			ex.printStackTrace();
		} finally {
			//driver.close();
		}

	}

}
