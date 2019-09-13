package colabupmtest.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProposalDetailsPage extends AbstractPageObject {
	@FindBy(linkText = "Admin")
	private WebElement linkToAdmin;
	@FindBy(xpath = "//form[@id='deleteProposalForm']/button")
	private WebElement deleteProposalButton;
	@FindBy(xpath = "//div[@class='cb-d-flex-between-center flex-column flex-sm-row mt-4']/div/button")
	private WebElement supportAndRetractButton;
	@FindBy(id = "radio-approve")
	private WebElement radioApprove;
	@FindBy(id = "radio-deny")
	private WebElement radioDeny;
	@FindBy(xpath = "//button[contains(text(),'Send')]")
	private WebElement sendButton;
	@FindBy(css = ".btn.btn-primary.dropdown-toggle.js-EnhancedLink")
	private WebElement requestMembershipButton;
	@FindBy(xpath = "//form[@id='requestMembershipForm']/button")
	private WebElement sendMembershipButton;
	@FindBy(xpath = "//ul[@class='nav nav-tabs flex-column flex-md-row']/li[2]/a")
	private WebElement linkToContributors;
	@FindBy(className = "d-lg-block")
	private WebElement proposalCreatorName;
	@FindBy(xpath = "//h1/a")
	private WebElement titleProposal;
	@FindBy(xpath = "//div[@class='cb-d-flex-between-center flex-column flex-sm-row mt-4']/div/span")
	private WebElement numOfFollowers;
	@FindBy(xpath = "//table[@class='contributors'][2]/tbody/tr/td/a")
	private List<WebElement> nameOfFollowers;
	@FindBy(xpath = "//a[contains(@href,'COMMENTS')]")
	private WebElement commentsTabLink;
	private CommentComponent commentComponent;
	@FindBy(xpath = "//a[contains(@href,'SCREENING')]")
	private WebElement linkToScreeningTab;
	@FindBy(id = "fellowScreeningAction")
	private WebElement selectFellowDecision;
	@FindBy(id = "selectedJudges1")
	private WebElement judgeCheckBox;
	@FindBy(id = "saveProposalScreeningDecision")
	private WebElement saveDecission;
	@FindBy(xpath = "//a[contains(@href,'ADVANCING')]")
	private WebElement linkToAdvancingTab;
	@FindBy(id = "advanceDecision")
	private WebElement selectAdvanceDecision;
	@FindBy(id = "fellowRatingForm")
	private WebElement fellowRatingForm;

	@FindBy(id = "advanceComment")
	private WebElement advanceComment;

	@FindBy(xpath = "//a[contains(@href,'edit')]")
	private WebElement editButton;
	@FindBy(xpath = "//button[contains(@data-url,'subscribeProposal')]/img[contains(@src,'subscribe')]")
	private WebElement subscribeButton;

	@FindBy(xpath = "//button[contains(@data-url,'subscribeProposal')]/img[contains(@src,'unsubscribe')]")
	private WebElement unsubscribeButton;
	@FindBy(xpath = "//form[contains(@action,'/vote')]/button")
	private WebElement voteButton;
	@FindBy(xpath="//span[@class='c-Count']/span")
	private WebElement voteCount;
	@FindBy(xpath="//h4[contains(text(),'Gracias por votar')]")
	private WebElement voteNotifyMessage;
	@FindBy(xpath="//h4[contains(text(),'Gracias por votar')]/../button")
	private WebElement closeMessageButton;
	@FindBy(id = "rating4")
	private WebElement noveltyMaxScore;
	@FindBy(id = "rating9")
	private WebElement feasibilityMaxScore;
	@FindBy(id = "rating14")
	private WebElement impactMaxScore;
	@FindBy(id = "rating24")
	private WebElement presentationMaxScore;
	@FindBy(id = "saveProposalJudging")
	private WebElement saveProposalJudgingButton;
	@FindBy(id = "shouldAdvanceProposal")
	private WebElement advanceProposalSelect;
	@FindBy(id = "comment")
	private WebElement commentTextArea;
	@FindBy(css=".c-Badge--big.badge-2")
	private WebElement finalistRibbon;
	@FindBy(css=".c-Badge--big.badge-3")
	private WebElement semiFinalistRibbon;
	@FindBy(name="ribbon")
	private WebElement ribbonSelector;
	@FindBy(css=".btn.cb-btn-admin.ml-2")
	private WebElement saveRibbon;

	@FindBy(css=".nav-item.text-md-center")
	private List<WebElement> proposalsTabLinks;
	@FindBy(css = ".c-Badge__text--big")
	private WebElement ribbonText;
	
	public ProposalDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}

	public void goToAdminSection() {
		this.linkToAdmin.click();

	}

	public void clickOnDeleteProposal() {
		this.deleteProposalButton.click();
		driver.switchTo().alert().accept();

	}

	public void clickOnRetractSupportProposal() {
		this.supportAndRetractButton.click();

	}

	public void clickOnSupportProposal() {
		this.supportAndRetractButton.click();

	}

	public void denyRequest() {
		this.radioDeny.click();
		this.sendButton.click();

	}

	public void approveRequest() {
		this.radioApprove.click();
		this.sendButton.click();

	}

	public boolean requestMembershipButtonIsEnabled() {
		boolean isDisplayed = false;
		try {

			isDisplayed = requestMembershipButton.isDisplayed();
		} catch (NoSuchElementException ex) {
			isDisplayed = false;
		}
		return isDisplayed;
	}

	public void clickOnRequestMembership() {
		requestMembershipButton.click();

	}

	public void clickOnSendMemberShipRequest() {
		sendMembershipButton.click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='noty_message']/span"))));
		driver.navigate().refresh();
	}

	public void goToContributorsSection() {
		linkToContributors.click();
	}

	public String getProposalCreator() {
		return proposalCreatorName.getText().split(" ")[1];
	}

	public String getOptionalSectionInPosition(int i) {
		int position = (i + i * 2);
		return driver.findElements(By.xpath("//div[@class='l-Content__main c-UserContent']/p")).get(position - 1)
				.getText();
	}

	public String getPitchProposal() {
		return driver.findElements(By.xpath("//div[@class='l-Content__main c-UserContent']/p")).get(0).getText();
	}

	public String getTitleProposal() {
		return this.titleProposal.getText().replaceAll("\n", "");
	}

	public int getNumberOfMemberSupports() {
		return Integer.parseInt(numOfFollowers.getText());
	}

	public boolean isNameAppearsInContributors(String user) {
		boolean isContributor = false;
		int i = 0;
		while (i < this.nameOfFollowers.size() && !isContributor) {
			if (this.nameOfFollowers.get(i).getText().equals(user)) {
				isContributor = true;
			}
			i++;
		}
		return isContributor;
	}

	public void clickOnCommentTab() {
		commentsTabLink.click();
		commentComponent = new CommentComponent(this.driver);

	}

	public void writeComment(String comment) {
		commentComponent.writeComment(comment);

	}

	public void clickOnAddComment() {
		commentComponent.clickOnAddComponent();

	}

	public boolean checkIfSignInFormDisplay() {
		return commentComponent.checkIfSignInFormDisplay();
	}

	public boolean commentInputIsDisplay() {
		return commentComponent.commentInputIsDisplay();
	}

	public String getAlertMessage() {
		return commentComponent.getAlertMessage();
	}

	public void clickOnDeleteLink() {
		this.commentComponent.clickOnDeleteLink();
	}

	public int getComments() {
		return this.commentComponent.getCountCommentsValue();
	}

	public boolean checkIfCommentExist(String comment) {
		return this.commentComponent.checkIfCommentExist(comment);
	}

	public String getAutorNameOfLastComment() {
		return this.commentComponent.getAutorNameOfLastComment();
	}

	public void clickOnEditLink() {
		this.commentComponent.clickOnEditLink();
	}

	public void clickOnAllDeleteLink() {
		this.commentComponent.clickOnAllDeleteLink();
	}

	public void clickOnSaveButton() {
		this.commentComponent.clickOnSaveButton();
	}

	public void clickOnScreeningTab() {
		this.linkToScreeningTab.click();

	}

	public void selectDecision(int value) {
		Select select = new Select(selectFellowDecision);
		select.selectByValue(Integer.toString(value));

	}

	public void selectJudge() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(this.judgeCheckBox));
		this.judgeCheckBox.click();
	}

	public void saveDecission() {
		this.saveDecission.click();
	}

	public void clickOnAdvancingTab() {
		this.linkToAdvancingTab.click();
	}

	public void selectAdvanceDecission(int value) {
		Select select = new Select(selectAdvanceDecision);
		select.selectByValue(Integer.toString(value));
	}

	public void submitAdvancing() {
		this.fellowRatingForm.submit();

	}

	public void writeFellowCommentBeforeAdvance(String comment) {
		WebDriverWait wait = new WebDriverWait(driver, 5);

		wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOf(this.advanceComment),
				ExpectedConditions.attributeContains(By.id("comment-container"), "style", "display: block;")));
		
		this.advanceComment.clear();
		this.advanceComment.sendKeys(comment);
	}

	public boolean editButtonIsDisplay() {
		boolean display = false;
		try {
			display = this.editButton.isDisplayed();
		} catch (NoSuchElementException ex) {
			display = false;
			logger.info("Elemento no encontrado");
		} finally {
			return display;
		}
	}

	public void clickOnSubscribe() {
		this.subscribeButton.click();
	}

	public boolean unsubscribeButtonIsDisplay() {
		boolean isDisplay = false;
		try {
			isDisplay = this.unsubscribeButton.isDisplayed();
		} catch (NoSuchElementException ex) {
			isDisplay = false;
		}
		return isDisplay;

	}

	public void clickOnUnsubscribe() {
		this.unsubscribeButton.click();
	}

	public boolean subscribeButtonIsDisplay() {
		boolean isDisplay = false;
		try {
			isDisplay = this.subscribeButton.isDisplayed();
		} catch (NoSuchElementException ex) {
			isDisplay = false;
		}
		return isDisplay;
	}

	public void voteProposal() {
		this.voteButton.click();
	}
	
	public void removeVote() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".modal-backdrop.fade"))));
		this.voteButton.click();
	}

	public String getButtonVoteText() {
		return this.voteButton.getText();
	}

	public int getNumVotes() {
		return Integer.parseInt(voteCount.getText());
	}

	public boolean checkIfVoteNotifyIsVisible() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(this.voteNotifyMessage));
		return this.voteNotifyMessage.isDisplayed();
	}
	
	public void selectMaxScoreRatings() {
		this.noveltyMaxScore.click();
		this.feasibilityMaxScore.click();
		this.impactMaxScore.click();
		this.presentationMaxScore.click();

	}

	public void advanceProposal() {
		Select select = new Select(this.advanceProposalSelect);
		select.selectByValue("true");

	}

	public void saveProposalJudging() {
		this.saveProposalJudgingButton.click();

	}

	public void writeJudgingComment(String comment) {
		WebDriverWait wait = new WebDriverWait(driver, 5);

		wait.until(ExpectedConditions.visibilityOf(commentTextArea));
		this.commentTextArea.clear();
		this.commentTextArea.sendKeys(comment);
	}
	public boolean checkVisibilityOfAdvanceProposalSelect() {
	boolean visible = false;
	try {
		visible = advanceProposalSelect.isDisplayed();
	} catch (NoSuchElementException ex) {
		visible = false;
	} finally {
		return visible;
	}
}

	public void closeMessage() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(this.closeMessageButton));
		this.closeMessageButton.click();
	}

	public boolean checkFinalistRibbonIsShown() {
		return this.finalistRibbon.isDisplayed();
	}

	public boolean checkSemiFinalistRibbonIsShown() {
		return this.semiFinalistRibbon.isDisplayed();
	}

	public void updateRibbon(int ribbonValue) {
		Select ribbonSelect = new Select (this.ribbonSelector);
		ribbonSelect.selectByValue(Integer.toString(ribbonValue));
		this.saveRibbon.click();
	}

	public void clickOnDescriptionTab() {
		proposalsTabLinks.get(0).click();	
	}

	public boolean checkIfRibbonShown(int ribbonType) {
	return	driver.findElement(By.cssSelector(".c-Badge--big.badge-"+ribbonType)).isDisplayed();
	}

	public String getTextRibbon() {
		return this.ribbonText.getText();
	}

}
