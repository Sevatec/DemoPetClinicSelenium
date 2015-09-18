package PetClinic_Selenium.PetClinic_Selenium;

import java.net.MalformedURLException;
import java.net.URL;
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

import com.thoughtworks.selenium.DefaultSelenium;


public class SeleniumTest extends TestCase
{
	public static String ipAddress = "54.172.164.220";
	public static String address = "http://"+ipAddress+":8080/petclinic";
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SeleniumTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SeleniumTest.class );
    }

    /**
     * Rigourous Test :-)
     */    
    public void testTitle(){
    	// Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
    	System.out.println(address);
        //WebDriver driver = new FirefoxDriver();
    	DesiredCapabilities capability = DesiredCapabilities.firefox();
    	capability.setCapability("jenkins.label", "windows && firefox");

    	WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL("http://"+ipAddress+":4444/wd/hub"), capability);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // And now use this to visit webpage
        //driver.get(address);
        ClinicNavigation.goToMainPage(driver);
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Find the text input element by its name
        //WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        //element.sendKeys("Wine!");

        // Now submit the form. WebDriver will find the form for us from the element
        //element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());
        
        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        /*(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("petclinic");
            }
        });*/

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().toLowerCase().startsWith("petclinic"));
        //Close the browser
        driver.close();
    }
    
    public void testWelcomeHeader(){
    	//WebDriver driver = new FirefoxDriver();
    	DesiredCapabilities capability = DesiredCapabilities.firefox();
    	capability.setCapability("jenkins.label", "windows && firefox");

    	WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL("http://"+ipAddress+":4444/wd/hub"), capability);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	ClinicNavigation.goToMainPage(driver);
    	//String header = driver.findElement(By.tagName("css=h2")).getText();
    	String header = driver.findElement(By.cssSelector("h2")).getText();
    	
    	Assert.assertTrue(header.toLowerCase().startsWith("welcome"));
    	
    	driver.close();
    }
    
    public void testMenuHome(){
    	//WebDriver driver = new FirefoxDriver();
    	DesiredCapabilities capability = DesiredCapabilities.firefox();
    	capability.setCapability("jenkins.label", "windows && firefox");

    	WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL("http://"+ipAddress+":4444/wd/hub"), capability);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	ClinicNavigation.goToMainPage(driver);
    	
    	
    	WebElement homeItem = driver.findElement(By.linkText("Home"));
    	String url = homeItem.getAttribute("href");
    	System.out.println("Home URL: "+url);
    	Assert.assertTrue(url.startsWith(address+"/"));
    	driver.close();
    }
    
    public void testMenuFind(){
    	//WebDriver driver = new FirefoxDriver();
    	DesiredCapabilities capability = DesiredCapabilities.firefox();
    	capability.setCapability("jenkins.label", "windows && firefox");

    	WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL("http://"+ipAddress+":4444/wd/hub"), capability);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	ClinicNavigation.goToMainPage(driver);
    	
    	
    	WebElement homeItem = driver.findElement(By.linkText("Find owners"));
    	String url = homeItem.getAttribute("href");
    	System.out.println("Home URL: "+url);
    	Assert.assertTrue(url.startsWith(address+"/owners/find.html"));
    	driver.close();
    }
    
    public void testMenuVets(){
    	//WebDriver driver = new FirefoxDriver();
    	DesiredCapabilities capability = DesiredCapabilities.firefox();
    	capability.setCapability("jenkins.label", "windows && firefox");

    	WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL("http://"+ipAddress+":4444/wd/hub"), capability);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	ClinicNavigation.goToMainPage(driver);
    	
    	
    	WebElement homeItem = driver.findElement(By.linkText("Veterinarians"));
    	String url = homeItem.getAttribute("href");
    	System.out.println("Home URL: "+url);
    	Assert.assertTrue(url.startsWith(address+"/vets.html"));
    	driver.close();
    }
    
    public void testMenuError(){
    	//WebDriver driver = new FirefoxDriver();
    	DesiredCapabilities capability = DesiredCapabilities.firefox();
    	capability.setCapability("jenkins.label", "windows && firefox");

    	WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL("http://"+ipAddress+":4444/wd/hub"), capability);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	ClinicNavigation.goToMainPage(driver);
    	
    	
    	WebElement homeItem = driver.findElement(By.linkText("Error"));
    	String url = homeItem.getAttribute("href");
    	System.out.println("Home URL: "+url);
    	Assert.assertTrue(url.startsWith(address+"/oups.html"));
    	driver.close();
    }
}
