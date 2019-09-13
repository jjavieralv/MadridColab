package colabupmtest.pageobjects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SubscriptionsPage extends AbstractPageObject {

	@FindBy(xpath="//tr[@class='colabRow']")
	List<WebElement> subscriptionRaws;
	@FindBy(xpath="//a[contains(@href,'/subscriptions/manage')]")
	WebElement manageLink;
	@FindBy(xpath="//a[@onclick='selectAllSubscriptions()']")
	private WebElement selectAllButton;
	@FindBy(xpath="//a[ contains(@onclick,'#removeSubscriptionsForm')]")
	private WebElement deleteSelectedButton;

	public SubscriptionsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}

	public boolean newCommentInProposalMessage(String date) {
		boolean exist = false;
		Iterator<WebElement> it = this.subscriptionRaws.iterator();
		WebElement newSubscriptionActivity;
		String messageActivity;
		long milisecsDate;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date dateActivity ;
		while (!exist && it.hasNext()) {
			newSubscriptionActivity=it.next();
			messageActivity = newSubscriptionActivity.findElements(By.tagName("td")).get(0).getText();
			milisecsDate = Long.parseLong(newSubscriptionActivity.findElements(By.tagName("td")).get(1).findElement(By.tagName("span")).getAttribute("data-millis"));
			dateActivity = new Date(milisecsDate);
			if(date.equals(dateFormat.format(dateActivity)) && messageActivity.contains(" agregó un comentario a la propuesta ")) {
				exist=true;
			}
		}
		return exist;
		
	}
		
	
	public boolean newCommentInContestMessage(String date) {
		boolean exist = false;
		Iterator<WebElement> it = this.subscriptionRaws.iterator();
		WebElement newSubscriptionActivity;
		String messageActivity;
		long milisecsDate;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date dateActivity ;
		while (!exist && it.hasNext()) {
			newSubscriptionActivity=it.next();
			messageActivity = newSubscriptionActivity.findElements(By.tagName("td")).get(0).getText();
			milisecsDate = Long.parseLong(newSubscriptionActivity.findElements(By.tagName("td")).get(1).findElement(By.tagName("span")).getAttribute("data-millis"));
			dateActivity = new Date(milisecsDate);
			if(date.equals(dateFormat.format(dateActivity)) && messageActivity.contains(" agregó un comentario al reto ")) {
				exist=true;
			}
		}
		return exist;
		
	}

	public void clickOnManageSubscriptions() {
this.manageLink.click();		
	}

	public void clickOnSelectAllSubscriptions() {
		this.selectAllButton.click();
	}

	public void clickOnDeleteSelected() {
this.deleteSelectedButton.click();		
	}

}
