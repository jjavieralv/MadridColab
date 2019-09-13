package colabupmtest.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class CommunityPage extends AbstractPageObject {
	@FindBy(xpath = "//a[contains(@href,'discussion')]")
	private WebElement discussionTab;
	@FindBy(xpath = "//a[@href='/discussion/threads/create']")
	private WebElement createNewDiscussionButton;
	@FindBy(id = "threadCategoryId")
	private WebElement selectCategoryId;
	@FindBy(id = "threadTitle")
	private WebElement titleInput;
	@FindBy(tagName = "iframe")
	private WebElement messageInputIframe;
	@FindBy(id = "addThreadButton")
	private WebElement addButton;
	

	public CommunityPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}

	public void clickOnDiscussionTab() {
		discussionTab.click();
	}

	public void clickOnCreateNewDiscussion() {
		createNewDiscussionButton.click();
	}

	public void selectDiscussionCategory(String category) {
		Select select = new Select(selectCategoryId);
		select.selectByVisibleText(category);

	}

	public void writeNewTitle(String title) {
		this.titleInput.clear();
		this.titleInput.sendKeys(title);
	}

	public void writeMessage(String message) {
		driver.switchTo().frame(messageInputIframe).findElement(By.tagName("body")).sendKeys(message);
		driver.switchTo().defaultContent();
		
	}

	public void clickOnAdd() {
this.addButton.click();		
	}

	public boolean existDiscussion(String newTitle) {
		
		return driver.findElement(By.linkText(newTitle)).isDisplayed();
	}

	public void clickOnDiscussionTypeSection(String discussionType) {
		driver.findElement(By.linkText(discussionType)).click();
		
	}

	public void clickOnDiscussionLink() {
		this.discussionTab.click();
		
	}

}
