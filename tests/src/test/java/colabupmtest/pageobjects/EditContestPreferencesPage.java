package colabupmtest.pageobjects;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class EditContestPreferencesPage extends AbstractPageObject {
	@FindBy(id = "feedSize")
	private WebElement feedSize;
	@FindBy(id = "selectedContests")
	private WebElement selectedContests;
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	private WebElement saveButton;
	@FindBy(xpath = "//a[@href='/']")
	private WebElement linkToHome;

	public EditContestPreferencesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}

	public int getFeedSize() {
		return Integer.parseInt(feedSize.getAttribute("value"));
	}

	public ArrayList<String> selectContestToShow() {
		ArrayList<String> selections = new ArrayList<String>();
		String aux = "";
		Select select = new Select(this.selectedContests);
		select.deselectAll();

		select.selectByIndex(select.getOptions().size() - 1);
		aux = select.getOptions().get(select.getOptions().size() - 1).getText();
		selections.add(aux.split("] ")[1]);
		select.selectByIndex(select.getOptions().size() - 2);
		aux = select.getOptions().get(select.getOptions().size() - 2).getText();
		selections.add(aux.split("] ")[1]);
		return selections;
	}

	public void clickOnSaveButton() {
		this.saveButton.click();

	}

	public MainPage clickOnReturnToHomeButton() {
		this.linkToHome.click();
		return new MainPage(this.driver);
	}

}
