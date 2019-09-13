package colabupmtest.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class DeleteConfirmationPage extends AbstractPageObject {
	@FindBy(id = "contestOverviewBody")
	private WebElement tableContestsToDelete;
	@FindBy(id = "submitButton")
	private WebElement submitButton;
	public DeleteConfirmationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}

	public void confirmDeleteContest() {
		tableContestsToDelete.findElement(By.tagName("tr")).findElement(By.tagName("td")).click();
		this.submitButton.click();
	}
	

}
