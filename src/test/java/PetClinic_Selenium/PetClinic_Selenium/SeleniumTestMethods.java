package PetClinic_Selenium.PetClinic_Selenium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumTestMethods extends TestCase{
	public static String seleniumHubAddress = "52.2.229.225";
	public static String testSiteAddress = "54.172.164.220";
	//public static String testSiteAddress = "localhost";
	public static String address = "http://"+testSiteAddress+":8080/petclinic";
	
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    /*public FirefoxTest( String testName )
    {
        super( testName );
    }*/

    /**
     * @return the suite of tests being tested
     */
    /*public static Test suite()
    {
        return new TestSuite( FirefoxTest.class );
    }*/

    /**
     * Rigourous Test :-)
     */    
    public static void testTitle(String browser){
    	// Create a new instance of the browser driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
    	//System.out.println(address);
        //WebDriver driver = new FirefoxDriver();
    	//DesiredCapabilities capability = DesiredCapabilities.firefox();
    	//capability.setCapability("jenkins.label", "windows && firefox");
    	DesiredCapabilities capability = setupCapability(browser);
    	
    	setSystemProperties(browser);
    	
    	WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL("http://"+seleniumHubAddress+":4444/wd/hub"), capability);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // And now use this to visit webpage
        //driver.get(address);
		driver.get(address);
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
    
    public static void testWelcomeHeader(String browser){
    	//WebDriver driver = new FirefoxDriver();
    	//DesiredCapabilities capability = DesiredCapabilities.firefox();
    	//capability.setCapability("jenkins.label", "windows && firefox");
    	DesiredCapabilities capability = setupCapability(browser);
    	
    	WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL("http://"+seleniumHubAddress+":4444/wd/hub"), capability);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get(address);
    	//String header = driver.findElement(By.tagName("css=h2")).getText();
    	String header = driver.findElement(By.cssSelector("h2")).getText();
    	
    	Assert.assertTrue(header.toLowerCase().startsWith("welcome"));
    	
    	driver.close();
    }
    
    public static void testMenuHome(String browser){
    	//WebDriver driver = new FirefoxDriver();
    	//DesiredCapabilities capability = DesiredCapabilities.firefox();
    	//capability.setCapability("jenkins.label", "windows && firefox");
    	DesiredCapabilities capability = setupCapability(browser);
    	
    	WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL("http://"+seleniumHubAddress+":4444/wd/hub"), capability);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get(address);
    	
    	
    	WebElement homeItem = driver.findElement(By.linkText("Home"));
    	String url = homeItem.getAttribute("href");
    	System.out.println("Home URL: "+url);
    	//Assert.assertTrue(url.startsWith(address+"/"));
    	List<String> urlSplit = Arrays.asList(url.split(":"));
    	System.out.println("Split URL: " + urlSplit.get(2));
    	Assert.assertTrue(urlSplit.get(2).toLowerCase().startsWith("8080/petclinic/"));
    	driver.close();
    }
    
    public static void testMenuFind(String browser){
    	//WebDriver driver = new FirefoxDriver();
    	//DesiredCapabilities capability = DesiredCapabilities.firefox();
    	//capability.setCapability("jenkins.label", "windows && firefox");
    	DesiredCapabilities capability = setupCapability(browser);
    	
    	WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL("http://"+seleniumHubAddress+":4444/wd/hub"), capability);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get(address);
    	
    	
    	WebElement homeItem = driver.findElement(By.linkText("Find owners"));
    	String url = homeItem.getAttribute("href");
    	System.out.println("Home URL: "+url);
    	//Assert.assertTrue(url.startsWith(address+"/owners/find.html"));
    	List<String> urlSplit = Arrays.asList(url.split(":"));
    	System.out.println("Split URL: " + urlSplit.get(2));
    	Assert.assertTrue(urlSplit.get(2).toLowerCase().startsWith("8080/petclinic/owners/find.html"));
    	driver.close();
    }
    
    public static void testMenuVets(String browser){
    	//WebDriver driver = new FirefoxDriver();
    	//DesiredCapabilities capability = DesiredCapabilities.firefox();
    	//capability.setCapability("jenkins.label", "windows && firefox");
    	DesiredCapabilities capability = setupCapability(browser);
    	
    	WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL("http://"+seleniumHubAddress+":4444/wd/hub"), capability);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get(address);
    	
    	
    	WebElement homeItem = driver.findElement(By.linkText("Veterinarians"));
    	String url = homeItem.getAttribute("href");
    	System.out.println("Home URL: "+url);
    	//Assert.assertTrue(url.startsWith(address+"/vets.html"));
    	List<String> urlSplit = Arrays.asList(url.split(":"));
    	System.out.println("Split URL: " + urlSplit.get(2));
    	Assert.assertTrue(urlSplit.get(2).toLowerCase().startsWith("8080/petclinic/vets.html"));
    	driver.close();
    }
    
    public static void testMenuError(String browser){
    	//WebDriver driver = new FirefoxDriver();
    	//DesiredCapabilities capability = DesiredCapabilities.firefox();
    	//capability.setCapability("jenkins.label", "windows && firefox");
    	DesiredCapabilities capability = setupCapability(browser);
    	
    	WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL("http://"+seleniumHubAddress+":4444/wd/hub"), capability);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get(address);
    	
    	
    	WebElement homeItem = driver.findElement(By.linkText("Error"));
    	String url = homeItem.getAttribute("href");
    	System.out.println("Home URL: "+url);
    	//Assert.assertTrue(url.startsWith(address+"/oups.html"));
    	List<String> urlSplit = Arrays.asList(url.split(":"));
    	System.out.println("Split URL: " + urlSplit.get(2));
    	Assert.assertTrue(urlSplit.get(2).toLowerCase().startsWith("8080/petclinic/oups.html"));
    	driver.close();
    }
    
    private static DesiredCapabilities setupCapability(String browser){
    	DesiredCapabilities capability = null;
    	if(browser.equals("firefox")){
    		capability = DesiredCapabilities.firefox();
    		capability.setCapability("jenkins.label", "windows && firefox");
    	}
    	else if(browser.equals("ie")){
    		capability = DesiredCapabilities.internetExplorer();
    		capability.setCapability("jenkins.label", "windows && internet explorer");
    	}
    	return capability;
    }
    
    private static void setSystemProperties(String browser){
    	File file = new File("C:/IEWebdriver/IEDriverServer.exe");
    	System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
    }
}
