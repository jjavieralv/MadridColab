package colabupmtest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class DiscussionPage extends AbstractPageObject {
	private CommentComponent commentComponent;

	public DiscussionPage(WebDriver driver) {
		super(driver);
		commentComponent = new CommentComponent(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);

	}

	public boolean commentInputIsDisplay() {
		return commentComponent.commentInputIsDisplay();
	}

	public String getAlertMessage() {
		return commentComponent.getAlertMessage();
	}

	public void clickOnDeleteLink() {
		commentComponent.clickOnDeleteLink();

	}

	public boolean checkIfCommentExist(String comment) {
		return commentComponent.checkIfCommentExist(comment);
	}

	public int getComments() {
		return commentComponent.getCountCommentsValue();
	}

	public void writeComment(String comment) {
		this.commentComponent.writeComment(comment);
	}

	public void clickOnAddComment() {
this.commentComponent.clickOnAddComponent();		
	}

	public boolean checkIfSignInFormDisplay() {
		return commentComponent.checkIfSignInFormDisplay();
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

	

}
