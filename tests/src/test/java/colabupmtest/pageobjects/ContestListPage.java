package colabupmtest.pageobjects;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContestListPage extends AbstractPageObject {
	@FindBy(xpath = "//a[@href='/contests?viewType=GRID&filter=&showAllContests=true']")
	private WebElement buttonAllContests;
	@FindBy(xpath = "//a[@href='/contests?viewType=LIST&filter=&showAllContests=true']")
	private WebElement buttonToListMode;
	@FindBy(xpath = "//a[@href='/contests?viewType=OUTLINE&filter=&showAllContests=true']")
	private WebElement buttonToAttributeMode;
	@FindBy(xpath = "//div[@class='c-ContestBox']")
	private List<WebElement> visibleContests;
	private ArrayList<Integer> contestWithProposals = new ArrayList();
	@FindBy(xpath = "//div[@class='c-ContestBox__metaCount']/span[1]/strong")
	private List<WebElement> countCommentsValues;
	@FindBy(css = ".c-ContestBox__metaFlag")
	private List<WebElement> currentPhase;

	public ContestListPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}

	public void viewAllContests() {
		buttonAllContests.click();
	}

	public boolean checkIfContestVisible(String urlContest) {
		System.out.println(urlContest);
		String path = "//a[contains(@href,'"+urlContest+"')]";
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(path))));
		return driver.findElement(By.xpath(path)).isDisplayed();
	}

	public void changeToViewAttributes() {

		buttonToAttributeMode.click();
	}

	public void changeToViewList() {
		buttonToListMode.click();
	}

	public ContestPage clickOnContestByName(String contestName) {
		driver.findElement(By.linkText(contestName)).click();
		return new ContestPage(this.driver);
	}

	private void loadContestsWithProposals() {
		for (int i = 0; i < this.visibleContests.size(); i++) {
			if (Integer.parseInt(this.countCommentsValues.get(i).getText()) > 0) {
				this.contestWithProposals.add(i);
			}

		}
	}

	public String getNameOfrandomContestWithProposals() {
		this.loadContestsWithProposals();
		int i = (int) (Math.random() * this.contestWithProposals.size());
		System.out.println("Concurso posición:" + i);
		//return driver.findElement(By.xpath("//div[@class='c-ContestBox'][" + this.contestWithProposals.get(i) + "]/div/div/h3")).getText();
		return driver.findElements(By.xpath("//div[@class='c-ContestBox']/descendant::h3")).get(this.contestWithProposals.get(i)).getText();

	}

	public String getNameOfrandomContestWithProposals(String phase) {
		this.loadContestsWithProposals(phase);
		int i = (int) (Math.random() * this.contestWithProposals.size());
		return driver.findElement(By.xpath("//div[@class='c-ContestBox'][" + this.contestWithProposals.get(i) + "]/div/div/h3")).getText();

	}

	private void loadContestsWithProposals(String phase) {
		for (int i = 0; i < this.visibleContests.size(); i++) {
			if ((Integer.parseInt(this.countCommentsValues.get(i).getText()) > 0) && this.currentPhase.get(i).getText().equals(phase)) {
				this.contestWithProposals.add(i+1);
//				System.out.println("//div[@class='c-ContestBox'][" + this.contestWithProposals.get(this.contestWithProposals.size()-1)+ "]/div/div/h3");
			}

		}		
	}

	

}
