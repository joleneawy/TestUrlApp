package com.jomighty.testurl.test.features.accesspage;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import com.jomighty.testurl.test.steps.AccessSteps;

import java.util.Properties;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WhenUserAccessPage {
	
	@Managed(uniqueSession = true)
    public WebDriver webdriver;
	
	@Steps
    AccessSteps step;
	
	public static Properties props;

    @BeforeClass
    public static void setUp() throws Exception {
        props = new Properties();
        props.load(WhenUserAccessPage.class.getClassLoader().getResourceAsStream("setup.properties"));
    }
    
    @Test
    public void a_when_http_redirect_https_testcase_1() {
    	step.access(props.getProperty("testMainUrl"));
    	step.should_see_https(props.getProperty("testMainMatch"));
    }
    
    @Test
    public void a_when_http_redirect_https_testcase_2() {
    	step.access(props.getProperty("testWSUrl"));
    	step.should_see_https(props.getProperty("testMainMatch"));
    }
    
    @Test
    public void a_when_http_redirect_https_testcase_3() {
    	step.access(props.getProperty("testHttpsUrl"));
    	step.should_see_https(props.getProperty("testMainMatch"));
    }

    @Test
    public void a_when_http_redirect_https_testcase_4() {
    	step.access(props.getProperty("testWPSUrl"));
    	step.should_see_https(props.getProperty("testMainMatch"));
    }
    
    @Test
    public void a_when_http_redirect_https_testcase_5() {
    	step.access(props.getProperty("testWPSHttpsUrl"));
    	step.should_see_https(props.getProperty("testMainMatch"));
    }
    
    @Test
    public void b_when_http_map_redirect_https_testcase_1() {
    	step.access(props.getProperty("testMapUrl"));
    	step.should_see_https(props.getProperty("testMapMatch"));
    }
    
    @Test
    public void b_when_https_map_redirect_https_testcase_2() {
    	step.access(props.getProperty("testMapHttpsUrl"));
    	step.should_see_https(props.getProperty("testMapMatch"));
    }
    
    @Test
    public void c_when_mobile_http_redirect_https_testcase_1() {
    	step.accessAndValidateMobile(props.getProperty("testMobileUrl"),props.getProperty("testMobileMatch"));
    }
    
    @Test
    public void c_when_mobile_https_redirect_https_testcase_2() {
    	step.accessAndValidateMobile(props.getProperty("testMobileHttpsUrl"),props.getProperty("testMobileMatch"));
    }
    
    @Test
    public void d_when_test_subdir_testcase_1() {
    	step.access(props.getProperty("testSubDirPfp"));
    	step.should_see_https(props.getProperty("testSubDirPfpMatch"));
    }
    
    @Test
    public void d_when_test_subdir_testcase_2() {
    	step.access(props.getProperty("testSubDirEae"));
    	step.should_see_https(props.getProperty("testSubDirEaeMatch"));
    }

    @Test
    public void d_when_test_subdir_testcase_3() {
    	step.access(props.getProperty("testSubDirPforum"));
    	step.should_see_https(props.getProperty("testSubDirPforumMatch"));
    }
    
    @Test
    public void d_when_test_subdir_testcase_4() {
    	step.access(props.getProperty("testSubDirCalendar"));
    	step.should_see_https(props.getProperty("testSubDirCalendarMatch"));
    }
    
    @Test
    public void d_when_test_subdir_testcase_5() {
    	step.access(props.getProperty("testSubDirFinancialAssistance"));
    	step.should_see_https(props.getProperty("testSubDirFinancialAssistanceMatch"));
    }
    
    @Test
    public void d_when_test_subdir_testcase_6() {
    	step.access(props.getProperty("testSubDirJae"));
    	step.should_see_https(props.getProperty("testSubDirJaeMatch"));
    }
    
    @Test
    public void d_when_test_subdir_testcase_7() {
    	step.access(props.getProperty("testSubDirAbe"));
    	step.should_see_https(props.getProperty("testSubDirAbeMatch"));
    }
    
    @Test
    public void e_when_google_search_redirection_testcase_1() {
    	step.googleSearch(props.getProperty("testGoogleSearchKeyword"), props.getProperty("testGoogleSearchMatchUrl"), props.getProperty("testGoogleSearchMatchHttpsUrl"));
    }
    
    @Test
    public void f_when_google_mobile_search_redirection_testcase_1() {
    	step.googleMobileSearch(props.getProperty("testGoogleSearchKeyword"), props.getProperty("testGoogleSearchMatchUrl"), props.getProperty("testGoogleMobileSearchMatchHttpsUrl"));
    }
}
