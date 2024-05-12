package IdentifyCourses;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pom.PomCampus;
import pom.PomSearchResult;


public class IdentifyCoursesTest {

	WebDriver driver;
	PomSearchResult searchObj;
	PomCampus campusObj;

	
	@BeforeClass
	@Parameters(value= {"browser"})
	void getUrl(String br) {
		if(br.equals("edge")) {
			driver = new EdgeDriver();
		}
		else if(br.equals("chrome")) {
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.coursera.org/");
		driver.manage().window().maximize();

	}

	
	@Test(priority=1)
	void search() throws InterruptedException, IOException
	{
		searchObj = new PomSearchResult(driver);
		Thread.sleep(3000);
		searchObj.takeScreenshot("search");
		searchObj.clickSearchButton();
		searchObj.checkbox();
		
	}
	
	@Test(priority=2)
	void searchResults() throws InterruptedException, IOException {
		searchObj.getSearchResult();
		Thread.sleep(3000);
		searchObj.takeScreenshot("searchResults");
		searchObj.checkbox();
	}
	
	
	@Test(priority = 3)
	void languages() throws InterruptedException, IOException {
		searchObj.takeScreenshot("Languages");
		searchObj.getLanguages();		
		Thread.sleep(3000);
		
	}
	
	@Test(priority = 4)
	void levels() throws InterruptedException, IOException {
		searchObj.getLevel();
		Thread.sleep(3000);
		searchObj.takeScreenshot("Levels");
		
	}
	
	@DataProvider(name="data")
	String[][] inputValues(){
		
		String[][] data = {
				{"Akash","Sharma","aaaaa",
				"97047434024","University/4 Year College",
				"KJ Somiaya","Student","Student Affairs",
				"Get in touch with sales",
				"India","Maharashtra"}
				
		};
		return data;
	}
	
	@Test(priority = 6)
	void campus() throws InterruptedException, IOException {
		driver.navigate().to("https://www.coursera.org/");
		campusObj = new PomCampus(driver);
		campusObj.getCampus();
		Thread.sleep(3000);
		searchObj.takeScreenshot("Campus");
	}
	
	@Test(priority = 7,dataProvider = "data")
	void formFill(String fname,String lname,String email,String phone,String instituteType,String collegeName,String title, String dept, String reason,String country,String state) throws IOException, InterruptedException {
		Thread.sleep(3000);
		campusObj.fillForm(fname, lname, email, phone, instituteType, collegeName, title, dept, reason, country, state);
		Thread.sleep(3000);
		searchObj.takeScreenshot("formFill");
	}
	
	@AfterClass
	void tearDown() {
		driver.quit();
	}
	
}
