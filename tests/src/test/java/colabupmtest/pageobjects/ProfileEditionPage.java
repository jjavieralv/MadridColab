package colabupmtest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class ProfileEditionPage extends AbstractPageObject {
	@FindBy(id = "firstName")
	WebElement firstName;
	@FindBy(id = "lastName")
	WebElement lastName;
	@FindBy(id = "countryCode")
	WebElement countryCodeSelector;
	@FindBy(id = "email")
	WebElement emailField;
	@FindBy(id = "currentPassword")
	WebElement currentPasswordField;
	@FindBy(id = "password")
	WebElement passwordField;
	@FindBy(id = "retypePassword")
	WebElement retypePasswordField;
	@FindBy(id = "userBean.errors")
	WebElement errorMessage;
	@FindBy(xpath = "//a[contains (@onclick,'#updateUserProfileForm')]")
	WebElement saveButton;

	public ProfileEditionPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}

	public void fillCurrentPasswordField(String password) {
		this.currentPasswordField.clear();
		this.currentPasswordField.sendKeys(password);
	}

	public String getMessageError() {
		return this.errorMessage.getText();
	}

	public void fillRetypePasswordField(String password) {
		this.retypePasswordField.clear();
		this.retypePasswordField.sendKeys(password);

	}

	public void fillNewEmailField(String email) {
		this.emailField.clear();
		this.emailField.sendKeys(email);

	}

	public void clickOnSave() {
		this.saveButton.click();
	}

	public void fillNewPasswordField(String newPassword) {
		this.passwordField.clear();
		this.passwordField.sendKeys(newPassword);

	}

	public ProfilePage changeCountry(String newCountry) {
		Select select = new Select(this.countryCodeSelector);

		select.selectByValue(newCountry);
		this.clickOnSave();
		return new ProfilePage(this.driver);
	}

	public ProfilePage changeFirstName(String newName) {
		this.firstName.clear();
		this.firstName.sendKeys(newName);
		this.clickOnSave();
		return new ProfilePage(this.driver);
	}

	public ProfilePage changeLastName(String newLastName) {
		this.lastName.clear();
		this.lastName.sendKeys(newLastName);
		this.clickOnSave();
		return new ProfilePage(this.driver);
	}

}
