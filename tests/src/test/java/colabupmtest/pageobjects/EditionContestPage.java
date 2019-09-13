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

public class EditionContestPage extends AbstractPageObject {

	@FindBy(id = "title")
	private WebElement title;
	@FindBy(id = "saveChangesButton")
	private WebElement saveChangesButton;
	@FindBy(id = "question")
	private WebElement questionInput;
	@FindBy(css = ".cke_wysiwyg_frame.cke_reset")
	private WebElement descriptionInputIframe;
	@FindBy(linkText = "Resources Page")
	private WebElement resourcesPageLink;
	@FindBy(name = "enable")
	private WebElement createNewResourcePageButton;
	@FindBy(xpath = "//iframe[@title='Editor de texto enriquecido, sections0.content']")
	private WebElement iFrameBackground;
	@FindBy(xpath = "//iframe[@title='Editor de texto enriquecido, sections1.content']")
	private WebElement iFrameKeyIssues;
	@FindBy(xpath = "//iframe[@title='Editor de texto enriquecido, sections2.content']")
	private WebElement iFrameJudgingCriteria;
	@FindBy(xpath = "//iframe[@title='Editor de texto enriquecido, sections3.content']")
	private WebElement iFramePrizes;
	@FindBy(xpath = "//iframe[@title='Editor de texto enriquecido, sections4.content']")
	private WebElement iFrameResourcesForProposalAuthors;
	@FindBy(linkText = "Ontology")
	private WebElement ontologyLink;
	@FindBy(linkText = "Team")
	private WebElement teamLink;
	@FindBy(id = "space_trigger_103")
	private WebElement whatLinkDeployOptions;
	@FindBy(id = "space_trigger_104")
	private WebElement whereLinkDeployOptions;
	@FindBy(id = "space_trigger_102")
	private WebElement whoLinkDeployOptions;
	@FindBy(id = "space_trigger_105")
	private WebElement howLinkDeployOptions;
	
	
	@FindBy(id = "userSelectorInputIAFellows")
	private WebElement userSelectorInputIAFellows;
	@FindBy(id = "userSelectorInputFellows")
	private WebElement userSelectorInputFellows;
	@FindBy(id = "userSelectorInputAdvisors")
	private WebElement userSelectorInputAdvisors;
	@FindBy(id = "userSelectorInputJudges")
	private WebElement userSelectorInputJudges;
	
	@FindBy(id = "ui-id-1")
	private WebElement autoCompleteIAFellows;
	@FindBy(id = "ui-id-2")
	private WebElement autoCompleteAdvisors;
	@FindBy(id = "ui-id-3")
	private WebElement autoCompleteFellows;
	@FindBy(id = "ui-id-4")
	private WebElement autoCompleteJudges;
	@FindBy(id = "previewContestButton")
	private WebElement previewContestButton;
	
	@FindBy(id = "userListIAFellows")
	private WebElement listOfIAFellows;
	@FindBy(id = "userListFellows")
	private WebElement listFellows;
	@FindBy(id = "userListAdvisors")
	private WebElement listAdvisors;
	@FindBy(id = "userListJudges")
	private WebElement listJudges;
	@FindBy(id = "proposalTemplateId")
	private WebElement templatesSelect;
	@FindBy(id="scheduleTemplateId")
	private WebElement scheduleSelect;
	@FindBy(id="contestDescriptionBean.errors")
	private WebElement saveContestErrorMessage;
	
	public EditionContestPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}

	public void changeTitle(String newTitle) {
		title.clear();
		title.sendKeys(newTitle);
	}

	public void clickOnSaveChanges() {
		saveChangesButton.click();
	}

	public void changeQuestion(String newQuestion) {
		questionInput.clear();
		questionInput.sendKeys(newQuestion);

	}

	public void changeDescription(String newDescription) {
		WebElement descriptionInput = driver.switchTo().frame(descriptionInputIframe)
				.findElement(By.cssSelector(".cke_editable.cke_editable_themed.cke_contents_ltr.cke_show_borders"));
		descriptionInput.clear();
		descriptionInput.sendKeys(newDescription);
		driver.switchTo().defaultContent();

	}

	public void goToResourcesPage() {
		resourcesPageLink.click();

	}

	public void clickOnCreateResourcePageButton() {
		createNewResourcePageButton.click();

	}

	public void fillResourcesPageFields(String newBackground, String newKeyIssues, String newJudgingCriteria,
			String newPrizes, String newResourcesForProposalAuthors) {

		WebElement auxInput = driver.switchTo().frame(iFrameBackground)
				.findElement(By.cssSelector(".cke_editable.cke_editable_themed.cke_contents_ltr.cke_show_borders"));
		auxInput.clear();
		auxInput.sendKeys(newBackground);
		driver.switchTo().defaultContent();
		auxInput = driver.switchTo().frame(iFrameKeyIssues)
				.findElement(By.cssSelector(".cke_editable.cke_editable_themed.cke_contents_ltr.cke_show_borders"));
		auxInput.clear();
		auxInput.sendKeys(newKeyIssues);
		driver.switchTo().defaultContent();
		auxInput = driver.switchTo().frame(iFrameJudgingCriteria)
				.findElement(By.cssSelector(".cke_editable.cke_editable_themed.cke_contents_ltr.cke_show_borders"));
		auxInput.clear();
		auxInput.sendKeys(newJudgingCriteria);
		driver.switchTo().defaultContent();
		auxInput = driver.switchTo().frame(iFramePrizes)
				.findElement(By.cssSelector(".cke_editable.cke_editable_themed.cke_contents_ltr.cke_show_borders"));
		auxInput.clear();
		auxInput.sendKeys(newPrizes);
		driver.switchTo().defaultContent();
		auxInput = driver.switchTo().frame(iFrameResourcesForProposalAuthors)
				.findElement(By.cssSelector(".cke_editable.cke_editable_themed.cke_contents_ltr.cke_show_borders"));
		auxInput.clear();
		auxInput.sendKeys(newResourcesForProposalAuthors);

		driver.switchTo().defaultContent();
	}

	public void clickOnSaveResourcesButton() {
		this.clickOnSaveChanges();

	}

	public void goToOntology() {
		ontologyLink.click();

	}

	public void changeOntologies(String what, String where, String who, String how) {
		WebDriverWait wait = new WebDriverWait(driver, 5);

		whatLinkDeployOptions.click();
		WebElement aux = driver.findElement(By.name(what));
		wait.until(ExpectedConditions.visibilityOf(aux));
		aux.click();
		whatLinkDeployOptions.click();
		whereLinkDeployOptions.click();

		aux = driver.findElement(By.name(where));
		wait.until(ExpectedConditions.visibilityOf(aux));
		aux.click();
		whereLinkDeployOptions.click();
		whoLinkDeployOptions.click();
		aux = driver.findElement(By.name(who));
		wait.until(ExpectedConditions.visibilityOf(aux));
		aux.click();
		whoLinkDeployOptions.click();
		howLinkDeployOptions.click();
		aux = driver.findElement(By.name(how));
		wait.until(ExpectedConditions.visibilityOf(aux));
		aux.click();

	}

	public void clickOnSaveOntologyButton() {
		this.clickOnSaveChanges();

	}

	public void goToTeamSelectionPage() {
		this.teamLink.click();
		
	}

	public void clickOnSaveTeamButton() {
		this.clickOnSaveChanges();
		
	}

	public void addMemberTeam(String member) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		this.userSelectorInputIAFellows.sendKeys(member);
		wait.until(ExpectedConditions.visibilityOf(this.autoCompleteIAFellows));
		this.autoCompleteIAFellows.findElements(By.tagName("li")).get(0).click();
		
		this.userSelectorInputAdvisors.sendKeys(member);
		wait.until(ExpectedConditions.visibilityOf(this.autoCompleteAdvisors));
		this.autoCompleteAdvisors.findElements(By.tagName("li")).get(0).click();
		
		this.userSelectorInputFellows.sendKeys(member);
		wait.until(ExpectedConditions.visibilityOf(this.autoCompleteFellows));
		this.autoCompleteFellows.findElements(By.tagName("li")).get(0).click();
		
		this.userSelectorInputJudges.sendKeys(member);
		wait.until(ExpectedConditions.visibilityOf(this.autoCompleteJudges));
		this.autoCompleteJudges.findElements(By.tagName("li")).get(0).click();
	}

	public ContestPage clickOnPreviewContest() {
		this.previewContestButton.click();
		this.changeTab();
		return new ContestPage(driver);
	}

	public void deleteMemberTeam() {
		this.listOfIAFellows.findElements(By.tagName("li")).get(0).click();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		
		this.listAdvisors.findElements(By.tagName("li")).get(0).click();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		
		this.listFellows.findElements(By.tagName("li")).get(0).click();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		
		this.listJudges.findElements(By.tagName("li")).get(0).click();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		
	}

	public void selectProposalTemplate(String templateName) {
		Select select = new Select(this.templatesSelect);
		select.selectByVisibleText(templateName);
	}

	public void selectScheduleTemplateByName(String scheduleName) {
		Select select = new Select(this.scheduleSelect);
		select.selectByVisibleText(scheduleName);
	}

	public void addFellow(String fellowName) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		this.userSelectorInputFellows.sendKeys(fellowName);
		wait.until(ExpectedConditions.visibilityOf(this.autoCompleteFellows));
		this.autoCompleteFellows.findElements(By.tagName("li")).get(0).click();
		
	}

	public void addJudge(String judgeName) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		this.userSelectorInputJudges.sendKeys(judgeName);
		wait.until(ExpectedConditions.visibilityOf(this.autoCompleteJudges));
		this.autoCompleteJudges.findElements(By.tagName("li")).get(0).click();
	}

	public String getSaveContestErrror() {
		return this.saveContestErrorMessage.getText();
	}
		
	}


