package colabupmtest.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LightBoxLoginPage extends AbstractPageObject {
	@FindBy(id = "loginModal")
	private WebElement loginModal;
	@FindBy(css = ".alert.alert-danger")
	private WebElement messageError;
	@FindBy(name = "remember-me")
	private WebElement rememberMe;
	public LightBoxLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}

	public Boolean isErrorMessageDisplayed() {
		return loginModal.findElement(By.cssSelector(".alert.alert-danger")).isDisplayed();
	}

	public String getErrorMessageText() {

		return this.messageError.getText();
	}

}
