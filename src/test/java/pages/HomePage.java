package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
	
	
	//page specific locators
	By imgSearch = By.xpath("//div[@class='dds-w-7 dds-h-7 dds-flex dds-items-center dds-cursor-pointer']//*[name()='svg']");
	By imgLocation = By.xpath("//div[@class='dds-w-8 dds-h-8 dds-flex dds-items-center dds-justify-center']//*[name()='svg']");

	
	//page specific methods
	public void clickSearch() {
		driver.findElement(imgSearch).click();
	}
	
	public void clickLocation() {
		driver.findElement(imgLocation).click();
	}
}
