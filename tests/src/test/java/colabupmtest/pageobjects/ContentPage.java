package colabupmtest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ContentPage extends AbstractPageObject {
	@FindBy(xpath="//main")
	WebElement mainContent;
	public ContentPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}
	public String getMainContentHtml() {
		return this.getContentHtml(mainContent);
	}

}
