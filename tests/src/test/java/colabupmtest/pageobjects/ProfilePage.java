package colabupmtest.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends AbstractPageObject{
	@FindBy(xpath="//div[@style='flex: 0 0 auto']/h2")
	WebElement nameAndLastName;
	@FindBy(xpath="//table[@class='colab members profileTable']/tbody/tr")
	List<WebElement> profileTable;
	@FindBy(xpath="//a[contains(@href,'/edit')]")
	WebElement linkToProfileEditionPage;
	@FindBy(xpath="//*[@class='noty_message']/span")
	WebElement alertMessage;
	

	public ProfilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}

	public String getEmail() {
		System.out.println(profileTable.get(3).findElements(By.tagName("td")).get(1).getText());
		return profileTable.get(3).findElements(By.tagName("td")).get(1).getText();
		
	}

	public String getCountry() {
		System.out.println(profileTable.get(2).findElements(By.tagName("td")).get(1).getText());
		return profileTable.get(2).findElements(By.tagName("td")).get(1).getText();
	}

	public String getAlertMessage() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(alertMessage));
		return this.alertMessage.getText();
	}

	public void  goToProfileEditionPage() {
		this.linkToProfileEditionPage.click();
	}

	public String getNameWithLastName() {
		return this.nameAndLastName.getText();
	}

}
