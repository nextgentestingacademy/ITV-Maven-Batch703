package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.SearchPage;

public class DistrictTest {
	private static HomePage home;
	private static SearchPage search;
	private static WebDriver driver;

	@BeforeMethod()
	public static void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.district.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		home = new HomePage();
		search = new SearchPage();
	}
	
	@Test
	public static void searchMovie() {
		home.clickSearch();//click on the Search image on the Home page
		search.clickMovies();//click on the Movies link on the Search page
		search.enterTextToSearch("Dhurandhar"); //enter Dhurandhar in the search box on the Search page
		Assert.assertTrue(search.getSearchResult().trim().contains("Dhurandhar"));
	}
	
	@AfterMethod()
	public static void tearDown() {
		driver.quit();
	}
}
