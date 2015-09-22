package PetClinic_Selenium.PetClinic_Selenium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class InternetExplorerTest extends TestCase
{
	public static String browser = "ie";
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public InternetExplorerTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( InternetExplorerTest.class );
    }

    /**
     * Rigourous Test :-)
     */    
    public void testTitle(){
    	SeleniumTestMethods.testTitle(browser);
    }
    
    public void testWelcomeHeader(){
    	SeleniumTestMethods.testWelcomeHeader(browser);
    }
    
    public void testMenuHome(){
    	SeleniumTestMethods.testMenuHome(browser);
    }
    
    public void testMenuFind(){
    	SeleniumTestMethods.testMenuFind(browser);
    }
    
    public void testMenuVets(){
    	SeleniumTestMethods.testMenuVets(browser);
    }
    
    public void testMenuError(){
    	SeleniumTestMethods.testMenuError(browser);
    }
}
