package pom;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomSearchResult {

	WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	TakesScreenshot ss = (TakesScreenshot) driver;

	public PomSearchResult(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	Search
	@FindBy(xpath = "//input[@placeholder='What do you want to learn?' ]")
	WebElement search;
	@FindBy(xpath = "//button[@class='nostyle search-button']//div")
	WebElement searchButton;

//	checkbox
	@FindBy(xpath = "//input[@id='cds-react-aria-17']")
	WebElement lang;
	@FindBy(xpath = "//span[text()='Beginner']")
	WebElement level;

//	search Result based on filter
	@FindBy(xpath = "//h3[@class='cds-CommonCard-title css-6ecy9b']")
	List<WebElement> courseTitles;
	@FindBy(xpath = "//p[@class='css-2xargn']")
	List<WebElement> courseRatings;
	@FindBy(xpath = "//p[contains(text(),'Months')]")
	List<WebElement> courseDetails;

//	Languages count
	@FindBy(xpath = "//div[@data-testid='search-filter-group-Language']")
	WebElement language;
	@FindBy(xpath = "//button[@data-track-component='expand_filter_items_button_language']")
	WebElement languageButton;

//	Level count
	@FindBy(xpath = "//div[@data-testid='search-filter-group-Level']")
	WebElement levelCount;
	@FindBy(xpath = "//div[@data-testid='search-filter-group-Level']//div[contains(@class,'css-nsxeb5')]")
	List<WebElement> levelList;

	public void clickSearchButton() {
		search.click();
		search.sendKeys("Web Development Courses");
		searchButton.click();
	}

	public void checkbox() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", lang);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click()", level);
		Thread.sleep(2000);
	}

	public void helperLoop(List<WebElement> courseTitlesAndDetails, int val) {
		int count = val;
		for (WebElement el : courseTitlesAndDetails) {
			if (count >= 2) {
				break;
			}
			System.out.println(el.getText());
			count++;
		}
	}

	public void helperLoopRating(List<WebElement> courseTitles, int val) {
		int count = val;
		for (WebElement el : courseTitles) {
			if (count >= 2) {
				break;
			}
			System.out.println(el.getText() + " Stars");
			count++;
		}
	}

	public void getSearchResult() throws InterruptedException {
		System.out.println("Title of First 2 Courses:");
		helperLoop(courseTitles, 0);
		System.out.println("Ratings of First 2 Courses:");
		helperLoopRating(courseRatings, 0);
		System.out.println("Details of First 2 Courses:");
		helperLoop(courseDetails, 0);
		Thread.sleep(3000);
	}

	public void getLanguages() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", languageButton);
		Thread.sleep(3000);
		System.out.println("Languages Available :");
		try {
			List<WebElement> languagesList = driver.findElements(By.xpath("//div[@aria-label='Select Language options']//div[contains(@class,'css-zweepb')]"));
			for (WebElement e : languagesList) {
				System.out.println(e.getText());
			}
			driver.findElement(By.xpath("//button[contains(@class,'cds-button-disableElevation cds-button-ghost css-1s96oj')]//span[@class='cds-button-label']")).click();
		} catch (Exception e) {

			try {
				List<WebElement> languagesList = driver.findElements(By.xpath(
						"//div[@data-testid='search-filter-group-Language']//div[contains(@class,'css-nsxeb5')]"));
				for (WebElement el : languagesList) {
					System.out.println(el.getText());
				}
			} catch (Exception el) {

			}

		}

		Thread.sleep(3000);

	}

	public void getLevel() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("Available Levels :");
		for (WebElement e : levelList) {
			System.out.println(e.getText());
		}
	}
	
	
	public void takeScreenshot(String name) throws IOException {
		  ss = (TakesScreenshot) driver;
		  File source= ss.getScreenshotAs(OutputType.FILE);
		  File target = new File("C:\\Users\\2317322\\Selenium_Project\\HackathonProject\\HackathonProject\\Screenshots\\"+name+".png");
		  FileHandler.copy(source, target);
	}

}
