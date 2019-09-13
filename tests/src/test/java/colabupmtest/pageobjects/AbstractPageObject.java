package colabupmtest.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPageObject {

	protected WebDriver driver;
	protected JavascriptExecutor js;
	protected Logger logger;

	@FindBy(css = ".navbar-nav.ml-auto")
	private WebElement navBar;
	private WebElement loginButton;
	@FindBy(name = "username")
	private WebElement inputUserName;
	@FindBy(name = "password")
	private WebElement inputPassword;
	@FindBy(id = "user-dropdown")
	private WebElement userIcon;
	@FindBy(xpath = "//a[@href='/logout']")
	private WebElement closeSessionLink;
	@FindBy(css = ".navbar-brand")
	protected WebElement logoWeb;
	@FindBy(css = ".nav-link")
	protected WebElement firstNavLink;
	@FindBy(linkText = "Contest manager")
	private WebElement contestManagerLink;

	@FindBy(xpath = "//a[@href='/contests']")
	private WebElement linkToContests;
	@FindBy(xpath = "//a[@href='/']")
	private WebElement linkToHome;
	@FindBy(xpath = "//a[@href='/page/about']")
	private WebElement linkToAbout;

	@FindBy(xpath = "//a[@href='/register?redirect=/']")
	private WebElement registerLink;
	@FindBy(xpath = "//a[contains(@href,'/members/profile/') and (contains(text(),'profile') or contains(text(),'perfil'))]")
	private WebElement profileLink;
	@FindBy(id = "signInForm_form")
	private WebElement signInForm;

	@FindBy(xpath = "//a[@href='/members']")
	private WebElement linkToCommunity;
	@FindBy(xpath = "//li[@class='nav-item cb-nav-item-gray cb-nav-item-sm dropdown cb-dropdown-inverse cb-nav-item-icon']")
	private List<WebElement> languageButton;

	@FindBy(xpath = "//a[contains(@href,'subscriptions')]")
	private WebElement subscriptionsLink;
	@FindBy(id = "loginPopupTopSubmit")
	private WebElement submitButton;

	public AbstractPageObject(WebDriver driver2) {
		this.driver = driver2;
	}

	public void changeTab() {
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(tabs2.size() - 1));

	}

	public void scrollToElement(WebElement element) {

		js = (JavascriptExecutor) driver;

		// This will scroll the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	protected String getContentHtml(WebElement element) {
		String contentHtml;
		contentHtml = element.getAttribute("innerHTML");
		return contentHtml;
	}

	public WebDriver getDriver() {
		return this.driver;

	}

	public void scrollToTopPage() {

		js = (JavascriptExecutor) driver;

		// This will scroll the page till the element is found
		js.executeScript("window.scrollTo(0, 0)");
	}

	public void clickEnter() {
		loginButton = navBar.findElements(By.tagName("li")).get(1);
		this.loginButton.click();

	}

	private void insertCredentials(String user, String password) {
		inputUserName.sendKeys(user);
		inputPassword.sendKeys(password);

	}

	@SuppressWarnings("finally")
	public boolean checkUserLogedIn() {
		boolean result = false;
		try {
			if (this.userIcon.isDisplayed()) {
				result = true;
			}

		} catch (NoSuchElementException ex) {
			result = false;
		} finally {
			return result;
		}
	}

	public void insertValidUserAndPassword(String user, String password) {
		insertCredentials(user, password);
	}

	public void clickSubmmit() {
		this.submitButton.click();

	}

	public void closeSession() {
		this.userIcon.click();
		this.closeSessionLink.click();

	}

	public void insertInvalidUserAndPassword(String user, String password) {
		insertCredentials(user, password);
		this.clickSubmmit();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("signInForm_form"))));
	}
	
	public ContestManagerPage goToContestManagerPage() {
		this.userIcon.click();
		this.contestManagerLink.click();
		return new ContestManagerPage(this.driver);
	}

	public ContestListPage goToContest() {
		linkToContests.click();
		return new ContestListPage(driver);
	}

	public void goToMainPage() {
		linkToHome.click();

	}

	public AboutPage goToAbout() {
		this.linkToAbout.click();
		return new AboutPage(this.driver);
	}

	public void goToRegistrationPage() {
		registerLink.click();
	}

	public void goToProfilePage() {
		this.userIcon.click();
		this.profileLink.click();
	}
	public boolean formToDoLoginIsShown() {
		boolean displayed = false;
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(this.signInForm));
		if (this.signInForm.isDisplayed()) {
			displayed = true;
		}
		return displayed;
	}

	public String getNavBarAboutText() {
		return this.linkToAbout.getText();
	}

	public String getNavBarContestsText() {
		return this.linkToContests.getText();
	}

	public String getNavBarCommunityText() {
		return this.linkToCommunity.getText();
	}

	public void clickOnLanguage() {
		this.languageButton.get(1).click();
	}

	public void selectLanguage(String languageValue) {
		driver.findElement(By.xpath(
				"//li[@class='nav-item cb-nav-item-gray cb-nav-item-sm dropdown cb-dropdown-inverse cb-nav-item-icon show']/ul/form/li/div/label/input[@value='"
						+ languageValue + "']"))
				.click();

	}

	public CommunityPage goToCommunity() {
		this.linkToCommunity.click();
		return new CommunityPage(this.driver);
	}

	public SubscriptionsPage goToSubscriptions() {
		this.userIcon.click();
		this.subscriptionsLink.click();
		return new SubscriptionsPage(this.driver);

	}

}
