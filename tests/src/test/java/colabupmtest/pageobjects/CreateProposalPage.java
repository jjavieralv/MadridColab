package colabupmtest.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateProposalPage extends AbstractPageObject {

	@FindBy(id = "saveChangesButton")
	private WebElement saveChangesButton;
	@FindBy(id = "proposalName")
	private WebElement proposalNameInput;
	@FindBy(id = "proposalPitchInput")
	private WebElement proposalPitchInput;
	@FindBy(id = "proposalTeam")
	private WebElement proposalTeam;
	@FindBy(xpath="//iframe")
	private List<WebElement> optionalSections;
	@FindBy(id="tosAccepted")
	private WebElement tosAcceptedButton;
	@FindBy(id="editForm")
	private WebElement editForm;

	
	public CreateProposalPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}

	public void clickOnSaveAndPublish() {
		this.saveChangesButton.click();
		
	}
	
	public int getNumberOfOptionalSections() {
		return optionalSections.size();
	}

	public void fillOptionalSections(ArrayList<String> sectionTexts) {
		WebElement auxInput;
		for(int i = 0; i<this.optionalSections.size()-1; i++) {
			auxInput = driver.switchTo().frame(optionalSections.get(i))
					.findElement(By.cssSelector(".cke_editable.cke_editable_themed.cke_contents_ltr.cke_show_borders"));
			auxInput.clear();
			auxInput.sendKeys(sectionTexts.get(i));
			driver.switchTo().defaultContent();
		}
	}

	public void fillMandatoryFields(String titulo, String pitch) {
		this.proposalNameInput.clear();
		this.proposalNameInput.sendKeys(titulo);
		this.proposalPitchInput.clear();
		this.proposalPitchInput.sendKeys(pitch);
	}

	public void fillTeamName(String teamName) {
		this.proposalTeam.clear();
		this.proposalTeam.sendKeys(teamName);
	}

	public void acceptContestRules() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		boolean tosIsVisible = false;
		try {
			this.tosAcceptedButton.isDisplayed();
			wait.until(ExpectedConditions.elementToBeClickable(tosAcceptedButton));
			tosIsVisible = true;
		}
		catch(org.openqa.selenium.NoSuchElementException ex) {
			wait.until(ExpectedConditions.visibilityOf(this.driver.findElement(By.id("js-Proposal__sidebar"))));
		}
		
		if(tosIsVisible) {
			tosAcceptedButton.click();
			
		}
		
	}


}
