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
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommentComponent extends AbstractPageObject {
	@FindBy(xpath = "//div[@class='alert alert-danger']/i")
	WebElement alertMessage;
	@FindBy(xpath = "//span[@class='c-Count__number']")
	WebElement countValue;
	@FindBy(xpath = "//form[@id='addCommentForm']/button")
	WebElement addCommentButton;
	@FindBy(tagName = "iframe")
	WebElement commentInputIFrame;
	@FindBy(id = "signInForm_form")
	WebElement signInForm;
	@FindBy(xpath = "//div[@class='c-Comment__actions']/button[1]")
	WebElement editLink;
	@FindBy(xpath = "//div[@class='c-Comment__actions']/button[2]")
	WebElement deleteLink;
	@FindBy(xpath = "//td[@class='c-Comment__commentor']/a[2]")
	List<WebElement> commentorName;
	@FindBy(xpath = "//table[@id='commentsTable']/tbody/tr/td[2]/div/p")
	List<WebElement> comments;
	@FindBy(xpath = "//form[contains(@action,'editComment?commentId=')]/div[@class='text-center']/button")
	WebElement savebutton;

	public CommentComponent(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}

	public boolean commentInputIsDisplay() {
		boolean display = false;
		try {
			display = driver.switchTo().frame(commentInputIFrame).findElement(By.tagName("body")).isDisplayed();
			driver.switchTo().defaultContent();
		} catch (NoSuchElementException ex) {
			display = false;
		}
		return display;
	}

	public String getAlertMessage() {
		return this.alertMessage.getText();
	}

	public void clickOnDeleteLink() {
		this.deleteLink.click();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
	}

	public boolean checkIfCommentExist(String comment) {
		boolean isPresent = false;
		for (int i = 0; i < this.comments.size(); i++) {
			if (comments.get(i).getText().equals(comment)) {
				isPresent = true;
			}

		}
		return isPresent;
	}

	public int getCountCommentsValue() {
		return Integer.parseInt(this.countValue.getText());
	}

	public void clickOnAddComponent() {
		this.addCommentButton.click();
	}

	public void writeComment(String comment) {
		WebElement aux = driver.switchTo().frame(this.commentInputIFrame)
				.findElement(By.cssSelector(".cke_editable.cke_editable_themed.cke_contents_ltr.cke_show_borders"));
		aux.clear();
		aux.sendKeys(comment);
		driver.switchTo().defaultContent();

	}

	public boolean checkIfSignInFormDisplay() {
		boolean display = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(this.signInForm));
			display = this.signInForm.isDisplayed();
		} catch (NoSuchElementException ex) {
			display = false;
		}
		return display;
	}

	public String getAutorNameOfLastComment() {
		return this.commentorName.get(commentorName.size() - 1).getText();
	}

	public void clickOnEditLink() {
		this.editLink.click();
	}

	public void clickOnAllDeleteLink() {
		List<WebElement> aux = driver.findElements(By.xpath("//div[@class='c-Comment__actions']/button[2]"));
		for (int i = 0; i < aux.size(); i++) {
			aux.get(i).click();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}

	public void clickOnSaveButton() {
		this.savebutton.click();
	}

}
