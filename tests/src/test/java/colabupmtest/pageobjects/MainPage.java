package colabupmtest.pageobjects;

import java.util.ArrayList;
import java.util.List;

import colabupmtest.selenium.FileReaderManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;

public class MainPage extends AbstractPageObject {



	@FindBy(xpath = "//link[@rel='stylesheet']")
	private WebElement cssPath;

	@FindBy(linkText = "Edit contestPreferences")
	private WebElement editContestPreferences;
	@FindBy(className = "c-ContestBox")
	private List<WebElement> contestsInMainPage;
	@FindBy(className = "c-ContestBox__title")
	private List<WebElement> titlesOfContestsInMainPage;

//	

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}

	

	public String getPathLogo() {
		return logoWeb.findElement(By.tagName("img")).getAttribute("src");

	}

	public String getPrimaryColorCss() {
		return this.firstNavLink.getCssValue("color");
	}

	public String getPathCss() {
		return this.cssPath.getAttribute("href");

	}

	
	public EditContestPreferencesPage clickOnEditContestPreferencesButton() {
		this.editContestPreferences.click();
		return new EditContestPreferencesPage(this.driver);
	}

	public int getNumberOfContestsShown() {
		return this.contestsInMainPage.size();
	}

	public ArrayList<String> getNameOfShownContests() {
		ArrayList<String> titles = new ArrayList<String>();
		titles.add(this.titlesOfContestsInMainPage.get(0).getText());
		titles.add(this.titlesOfContestsInMainPage.get(1).getText());
		return titles;
	}

	public String getTitle() {
		return this.driver.getTitle();
	}





	public void loadMainPage() {
		String url = FileReaderManager.getInstance().getConfigReader().getWebUrl() +  "/";
		this.driver.get(url);
		//this.driver.get("http://localhost:18082");
		//this.driver.get("http://pruebas.colab.upm.es/");
	}




	public void goToUrl(String url) {
this.driver.get(url);		
	}

}
