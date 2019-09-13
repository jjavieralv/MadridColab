package colabupmtest.pageobjects;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContestManagerPage extends AbstractPageObject {
	@FindBy(xpath = "//button[@data-url='/admin/contest/manager/createContest']")
	private WebElement createNewContestButton;
	@FindBy(id = "contestOverviewBody")
	private WebElement listOfContest;

	@FindBy(linkText = "VIEW")
	private List<WebElement> listOfViews;

	@FindBy(id = "selectedMassAction")
	private WebElement selectMassAction;
	@FindBy(id = "submitButton")
	private WebElement submitButton;
	@FindBy(xpath = "//a[@href='/admin/contest/manager/tab/PROPOSAL_TEMPLATES']")
	private WebElement linkToProposalTemplates;
	@FindBy(id = "changeElementSelect")
	private WebElement templatesSelect;
	@FindBy(id = "templateName")
	private WebElement templateNameInput;
	@FindBy(id = "addSectionButton")
	private WebElement addSectionButton;
	@FindBy(linkText = "CREATE new template")
	private WebElement createTemplateButton;
	@FindBy(linkText = "SAVE template")
	private WebElement saveTemplateButton;
	@FindBy(linkText = "DELETE template")
	private WebElement deleteTemplateButton;
	@FindBy(xpath = "//tbody/tr/td[2]")
	private List<WebElement> contestsLinkedNames;
	@FindBy(id = "sections2.type")
	private WebElement sectionTypeSelect;
	@FindBy(id = "sections2.title")
	private WebElement sectionTitleInput;
	@FindBy(id = "sections2.characterLimit")
	private WebElement sectionLimitInput;
	@FindBy(id = "sections2.helpText")
	private WebElement sectionHelpTextInput;
	@FindBy(id = "sections2.defaultText")
	private WebElement sectionDefaultTextInput;
	@FindBy(xpath = "//a[@href='/admin/contest/manager']")
	private WebElement linkToContestSection;
	@FindBy(xpath = "//*[@class='noty_message']/span")
	WebElement alertMessage;
	@FindBy(xpath = "//a[@href='/admin/contest/manager/tab/SCHEDULES']")
	private WebElement scheduleTemplateLink;
	@FindBy(xpath = "//div[@class='text-right cb-btn-spacer']/a[3]")
	private WebElement buttonNewSchedule;
	
	@FindBy(id="schedulePhases0.phaseStartDate")
	private WebElement firstPhaseDate;
	@FindBy(id="scheduleName")
	private WebElement scheduleName;
	@FindBy(xpath="//div[@class='floatRight']/a")
	private WebElement addContestPhaseButton;
	@FindBy(id="schedulePhases1.contestPhaseTypeId")
	private List<WebElement> secondPhaseType;
	@FindBy(id="schedulePhases1.phaseStartDate")
	private List<WebElement> secondPhaseDate;
	@FindBy(id="schedulePhases2.contestPhaseTypeId")
	private WebElement thirdPhaseType;
	@FindBy(id="schedulePhases2.phaseStartDate")
	private WebElement thirdPhaseDate;
	@FindBy(id="schedulePhases3.contestPhaseTypeId")
	private WebElement fourthPhaseType;
	@FindBy(id="schedulePhases3.phaseStartDate")
	private WebElement fourthPhaseDate;
	@FindBy(id="schedulePhases4.contestPhaseTypeId")
	private WebElement fifthPhaseType;
	@FindBy(id="schedulePhases4.phaseStartDate")
	private WebElement fifthPhaseDate;
	@FindBy(id="schedulePhases5.contestPhaseTypeId")
	private WebElement sixthPhaseType;
	@FindBy(id="schedulePhases5.phaseStartDate")
	private WebElement sixthPhaseDate;
	
	@FindBy(xpath="//div[@class='alert alert-info']/a")
	private WebElement linkToEditNewContest;
	@FindBy(id="changeContestScheduleSelect")
	private WebElement scheduleSelect;
	@FindBy(xpath = "//div[@class='text-right cb-btn-spacer']/a[1]")
	private WebElement saveScheduleButton;

	public ContestManagerPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}

	public void clickOnCreateNewContestButton() {
		createNewContestButton.click();
	}

	public int numberOfContest() {
		return listOfContest.findElements(By.tagName("tr")).size();
	}

	public ContestPage clickOnViewContest(int positionContest) {

		listOfContest.findElements(By.tagName("tr")).get(positionContest).findElements(By.tagName("td")).get(13)
				.findElement(By.tagName("a")).sendKeys(Keys.ENTER);
		this.changeTab();
		return new ContestPage(this.driver);
	}

	public String getNameOfContest(int position) {
		return listOfContest.findElements(By.tagName("tr")).get(position).findElements(By.tagName("td")).get(2)
				.getText();
	}
	public String getUrlOfContest(int position){
		return listOfContest.findElements(By.tagName("tr")).get(position).findElements(By.tagName("td")).get(13).findElement(By.tagName("a")).getAttribute("href");

	}

	public EditionContestPage clickOnContestToEdit(int positionContest) {
		listOfContest.findElements(By.tagName("tr")).get(positionContest).findElements(By.tagName("td")).get(2).click();
		return new EditionContestPage(this.driver);
	}

	public void selectContest(int positionContest) {
		listOfContest.findElements(By.tagName("tr")).get(positionContest).findElements(By.tagName("td")).get(0).click();

	}

	public void selectPublicContestOption() {
		Select select = new Select(this.selectMassAction);
		select.selectByValue("PUBLIC");
	}

	public void clickOnSubmitButton() {
		this.submitButton.click();

	}

	public void selectDeleteContestOption() {
		Select select = new Select(this.selectMassAction);
		select.selectByValue("DELETE_WITH_PHASES");

	}

	public void clickOnDelete() {
		this.deleteTemplateButton.click();
		driver.switchTo().alert().accept();
	}

	public boolean templateProposalHasLinkContest(String contestName) {
		boolean exist = false;
		int i = 0;
		while (i < this.contestsLinkedNames.size() && !exist) {
			if (this.contestsLinkedNames.get(i).getText().equals(contestName)) {
				exist = true;
			}
			i++;
		}
		return true;

	}

	public void goToProposalTemplates() {
		this.linkToProposalTemplates.click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(
				ExpectedConditions.textToBePresentInElementValue(this.templateNameInput, "Plantilla Áreas de Trabajo"));

	}

	public int getNumTemplates() {
		Select select = new Select(this.templatesSelect);
		return select.getOptions().size();
	}

	public void clickOnCreateNewTemplate() {
		this.createTemplateButton.click();

	}

	public void selectTemplate(String templateName) {
		Select select = new Select(this.templatesSelect);
		select.selectByVisibleText(templateName);

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.textToBePresentInElementValue(this.templateNameInput, templateName));

	}

	public void changeProposalTemplateName(String templateName) {
		this.templateNameInput.clear();
		this.templateNameInput.sendKeys(templateName);

	}

	public void clickOnSaveTemplate() {
		this.scrollToTopPage();
		this.saveTemplateButton.click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(alertMessage));
	}

	public boolean checkIfNameExistInTemplateOptions(String templateName) {

		Select select = new Select(this.templatesSelect);
		boolean exist = false;
		int i = 0;
		while (i < select.getOptions().size() && !exist) {
			if (select.getOptions().get(i).getText().equals(templateName)) {
				exist = true;
			}
			i++;
		}
		return exist;
	}

	public void selectTextTypeInSectionType() {
		Select select = new Select(this.sectionTypeSelect);
		select.selectByIndex(1);
	}

	public void fillTitleField(String nameTitle) {
		this.sectionTitleInput.clear();
		this.sectionTitleInput.sendKeys(nameTitle);

	}

	public void fillLimitCharacterField(String limit) {
		this.sectionLimitInput.clear();
		this.sectionLimitInput.sendKeys(limit);

	}

	public void fillHelpField(String helpText) {
		this.sectionHelpTextInput.clear();
		this.sectionHelpTextInput.sendKeys(helpText);

	}

	public void fillDefaultTextField(String defaultText) {
		this.sectionDefaultTextInput.clear();
		this.sectionDefaultTextInput.sendKeys(defaultText);

	}

	public void goToContestsSection() {
		this.linkToContestSection.click();

	}

	public void clickOnAddSection() {
		this.addSectionButton.click();

	}

	public String getSelectedTemplateName() {
		Select select = new Select(this.templatesSelect);
		return select.getFirstSelectedOption().getText();
	}

	public void selectLaunchContestOption() {
		Select select = new Select(this.selectMassAction);
		select.selectByValue("LAUNCH");

	}

	public void gotoScheduleTemplate() {
		this.scheduleTemplateLink.click();

	}

	public void createScheduleTemplate() {
		this.buttonNewSchedule.click();

	}

	public void initSecheduleTemplate(String nameSchedule, Calendar now) {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		this.scheduleName.clear();
		this.scheduleName.sendKeys(nameSchedule);
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		String stringDate = format.format(now.getTime());
		this.firstPhaseDate.clear();
		this.firstPhaseDate.sendKeys(stringDate);
		
		this.addContestPhaseButton.click();
		Select select = new Select(secondPhaseType.get(this.secondPhaseType.size()-1));
		select.selectByValue("16");
		now.add(Calendar.HOUR, 1);
		stringDate = format.format(now.getTime());
		secondPhaseDate.get(secondPhaseDate.size()-1).clear();
		secondPhaseDate.get(secondPhaseDate.size()-1).sendKeys(stringDate);
		
		this.addContestPhaseButton.click();
		select = new Select(thirdPhaseType);
		select.selectByValue("18");
		now.add(Calendar.HOUR, 2);
		stringDate = format.format(now.getTime());
		thirdPhaseDate.clear();
		thirdPhaseDate.sendKeys(stringDate);
		
		this.addContestPhaseButton.click();
		select = new Select(fourthPhaseType);
		select.selectByValue("11");
		now.add(Calendar.HOUR, 3);
		stringDate = format.format(now.getTime());
		fourthPhaseDate.clear();
		fourthPhaseDate.sendKeys(stringDate);
		
		this.addContestPhaseButton.click();
		select = new Select(fifthPhaseType);
		select.selectByValue("20");
		now.add(Calendar.HOUR, 4);
		stringDate = format.format(now.getTime());
		fifthPhaseDate.clear();
		fifthPhaseDate.sendKeys(stringDate);
		
		this.addContestPhaseButton.click();
		select = new Select(sixthPhaseType);
		select.selectByValue("14");
		now.add(Calendar.HOUR, 5);
		stringDate = format.format(now.getTime());
		sixthPhaseDate.clear();
		sixthPhaseDate.sendKeys(stringDate);
		
		this.saveSchedule();
	}

	public EditionContestPage editNewContest() {
		this.linkToEditNewContest.click();
		return new EditionContestPage(this.driver);
	}

	public void selectContestByName(String nameContest) {
		
		WebElement child = this.driver.findElement(By.linkText(nameContest));
		WebElement checkBox = child.findElement(By.xpath("../../td[1]/input[1]"));
		checkBox.click();
	}

	public void selectScheduleByName(String nameSchedule) {
		

		Select select = new Select(this.scheduleSelect);
		select.selectByVisibleText(nameSchedule);
		
	}

	public void changeScheduleSemiFinalistSelection(String dateString) {
		this.secondPhaseDate.get(this.secondPhaseDate.size()-1).clear();
		this.secondPhaseDate.get(this.secondPhaseDate.size()-1).sendKeys(dateString);
		
	}

	public void saveSchedule() {
		super.scrollToTopPage();
		this.saveScheduleButton.click();
		
	}

	public void changeScheduleProposalRevisionSelection(String dateString) {
		thirdPhaseDate.clear();
		thirdPhaseDate.sendKeys(dateString);
		
	}


	public void changeScheduleFinalistSelection(String dateString) {
		this.fourthPhaseDate.clear();
		this.fourthPhaseDate.sendKeys(dateString);
		
	}

	public void changeScheduleVotingSelection(String dateString) {
		this.fifthPhaseDate.clear();
		this.fifthPhaseDate.sendKeys(dateString);
		
	}

	public String getStateOfContest(int contestPosition) {
		return listOfContest.findElements(By.tagName("tr")).get(contestPosition).findElements(By.tagName("td")).get(3)
				.getText();
	}

	public void selectShowRibbons() {
		Select select = new Select(this.selectMassAction);
		select.selectByValue("SHOW_RIBBONS");
		
	}

	public void changeScheduleCompleted(String dateString) {
		this.sixthPhaseDate.clear();
		this.sixthPhaseDate.sendKeys(dateString);		
	}


}
