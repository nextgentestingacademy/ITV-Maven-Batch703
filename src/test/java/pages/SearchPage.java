package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
	WebDriver driver;
	
	
	//page specific locators
	By edtSearch = By.xpath("(//input[contains(@class,'placeholder')])[2]");
	By lnkMovies = By.xpath("//span[text()='Movies']");
	By lnkSearchResult = By.xpath("//h5[@class='dds-tracking-tight dds-text-lg dds-font-semibold dds-overflow-hidden dds-whitespace-normal dds-line-clamp-2 dds-text-primary dds-leading-normal dds-my-0']");
	
	
	//page specific methods
	public void clickMovies() {
		driver.findElement(lnkMovies).click();
	}
	
	public void enterTextToSearch(String text) {
		driver.findElement(edtSearch).sendKeys(text);;
	}
	
	public String getSearchResult() {
		return driver.findElement(lnkSearchResult).getText();
	}
	
}
