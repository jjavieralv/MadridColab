package colabupmtest.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserRegistrationPage extends AbstractPageObject {
	@FindBy(id = "screenName")
	private WebElement screenName;
	@FindBy(id = "email")
	private WebElement email;
	@FindBy(id = "firstName")
	private WebElement firstName;
	@FindBy(id = "lastName")
	private WebElement lastName;
	@FindBy(id = "password")
	private WebElement password;
	@FindBy(id = "retypePassword")
	private WebElement retypePassword;
	@FindBy(id = "country")
	private WebElement country;
	@FindBy(tagName = "iframe")
	private WebElement shortBio;
	@FindBy(xpath = "//button[text() = 'CREAR una cuenta']")
	private WebElement createAccountButton;
	
	@FindBy(id = "email.errors")
	private WebElement emailErrors;
	@FindBy(id = "password.errors")
	private WebElement passwordErrors;
	@FindBy(id = "country.errors")
	private WebElement countryErrors;
	@FindBy(id = "createUserBean.errors")
	private WebElement createUserBeanErrors;
	@FindBy(id = "screenName.errors")
	private WebElement screeNameErrors;
	
	@FindBy(xpath = "//a[@href= '/page/Terms-of-use']")
	private WebElement termOfUseLink;
	@FindBy(xpath = "//a[@href= '/page/Community-philosophy-and-policies']")
	private WebElement philosophyAndPolicyLink;
	
	public UserRegistrationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}

	public void fillScreenName(String screenName) {
		this.screenName.clear();
		if(screenName.length()>40) {
		this.screenName.sendKeys(screenName.substring(17, 41));
		}
		else {
			this.screenName.sendKeys(screenName);
		}
	}

	public void clickOnCreateAccount() {
		this.createAccountButton.click();

	}

	public void fillRetypePassword(String password) {
		this.retypePassword.clear();
		this.retypePassword.sendKeys(password);
	}

	public void selectCountry(String country) {
		Select select = new Select(this.country);
		if(country.equals("Spain")) {
			select.selectByValue("ES");
		}

	}

	public void fillPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);

	}

	public void fillLastName(String lastName) {
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
	}

	public void fillFirstName(String firstName) {
		this.firstName.clear();
		this.firstName.sendKeys(firstName);

	}

	public void fillEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}

	public String getScreenNameErrorMessage() {
		
		return screeNameErrors.getText().replaceAll("\n", "");
	}

	public void clickOnUseTerms() {
		this.termOfUseLink.click();
		this.changeTab();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.urlContains("Terms")));
	}



	public void clickOnPhilosophyAndPolicy() {
		this.philosophyAndPolicyLink.click();
		this.changeTab();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.urlContains("Community")));

	}

	public void fillBio(String shortText) {
		WebElement auxInput = driver.switchTo().frame(this.shortBio).findElement(By.cssSelector(".cke_editable.cke_editable_themed.cke_contents_ltr.cke_show_borders"));
		auxInput.clear();
		auxInput.sendKeys(shortText);
		driver.switchTo().defaultContent();
	}

	public String getEmailMessageError() {
		return this.emailErrors.getText();
	}

	public String getPasswordMessageError() {
		return this.passwordErrors.getText();
	}

	public String getGeneralErrorMessage() {
		return this.createUserBeanErrors.getText();
	}

	public String getCountryMessageError() {
	return this.countryErrors.getText();
	}
}
