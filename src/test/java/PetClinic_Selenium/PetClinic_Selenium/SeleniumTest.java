package PetClinic_Selenium.PetClinic_Selenium;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest extends TestCase
{
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
    public void testGoogle(){
    	// Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
        WebDriver driver = new FirefoxDriver();

        // And now use this to visit webpage
        driver.get("http://54.172.164.220:8080/petclinic");
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
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("petclinic");
            }
        });

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().toLowerCase().startsWith("petclinic"));
        //Close the browser
        driver.close();
    }
}
