package pom;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PomCampus {

	WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	TakesScreenshot ss;
	
	
	public PomCampus(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);	
	}
	
	@FindBy(xpath = "//a[text()='For Enterprise']") WebElement enterprise;
	@FindBy(xpath = "//a[text()='For Campus']") WebElement campus;
	
//	Fill form
	@FindBy(id = "FirstName") WebElement firstName;
	@FindBy(id = "LastName") WebElement lastName;
	@FindBy(id = "Email") WebElement Email;
	@FindBy(id = "Phone") WebElement phoneNo;
	@FindBy(id = "Institution_Type__c") WebElement institute;
	@FindBy(id = "Company") WebElement Company;
	@FindBy(id = "Title") WebElement jobRole;
	@FindBy(id = "Department") WebElement department;
	@FindBy(id = "What_the_lead_asked_for_on_the_website__c") WebElement description;
	@FindBy(id = "Self_reported_employees_to_buy_for__c") WebElement numberOfEmp;
	@FindBy(id = "Country") WebElement countryName;
	@FindBy(id = "State") WebElement StateName;
	@FindBy(xpath = "//button[text()='Submit']") WebElement submitButton;
	@FindBy(id = "ValidMsgEmail")WebElement errorMsg;
	
	public void getCampus() throws InterruptedException {
		enterprise.click();
		Thread.sleep(3000);
		campus.click();
		Thread.sleep(3000);
	}
	
	public void fillForm(String fname,String lname,String email,String phone,String instituteType,String collegeName,String title, String dept, String reason,String country,String state) {
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		Email.sendKeys(email);
		phoneNo.sendKeys(phone);
		
		Select select = new Select(institute);
		select.selectByValue(instituteType);
		Company.sendKeys(collegeName);
		Select select2 = new Select(jobRole);
		select2.selectByValue(title);
		Select select3 = new Select(department);
		select3.selectByValue(dept);
		
		Select select4 = new Select(description);
		select4.selectByValue(reason);

//		Select select5 = new Select(numberOfEmp);
//		select5.selectByValue(no);

		Select select6 = new Select(countryName);
		select6.selectByVisibleText(country);

		Select select7 = new Select(StateName);
		select7.selectByValue(state);
		
		submitButton.click();
		String msg = errorMsg.getText();
		System.out.println(msg);
	}
	
	public void takeScreenshot(String name) throws IOException {
		  ss = (TakesScreenshot) driver;
		  File source= ss.getScreenshotAs(OutputType.FILE);
		  File target = new File("C:\\Users\\2317322\\Selenium_Project\\HackathonProject\\HackathonProject\\Screenshots\\"+name+".png");
		  FileHandler.copy(source, target);
	}
	
	
}
