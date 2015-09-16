package PetClinic_Selenium.PetClinic_Selenium;

import org.openqa.selenium.WebDriver;

public final class ClinicNavigation {
	static String ipAddress = "54.172.164.220";
	public static String address = "http://"+ipAddress+":8080/petclinic";
	
	public static void goToMainPage(WebDriver driver){
		driver.get(address);
	}
}
