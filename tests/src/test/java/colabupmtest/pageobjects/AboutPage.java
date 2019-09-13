package colabupmtest.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.WebElement;

public class AboutPage extends AbstractPageObject{
@FindBy(css=".l-Content__sidebar.l-Content__sidebar--small.c-SideMenu.c-SideMenu--styled")
WebElement sectionsContent;
@FindBy(xpath="//div[@class='l-Content__main']/div")
WebElement mainContent;

@FindBy(xpath="//a[@href='/web/guest/about']")
WebElement linkToAbout;
@FindBy(xpath="//a[@href='/page/origen']")
WebElement linkToOrigin;
@FindBy(xpath="//a[@href='/page/Como-funciona']")
WebElement linkToHowTo;
@FindBy(linkText = "Retos y Áreas de trabajo")
WebElement linkToContestsAndWorkspaces;
@FindBy(xpath="//a[@href='/page/Participa']")
WebElement linkToTakePart;
@FindBy(xpath="//a[@href='/page/preguntas-frecuentes']")
WebElement linkToFrequentQuestions;
@FindBy(xpath="//a[@href='/page/personas']")
WebElement linkToPeople;
@FindBy(xpath="//a[@href='/page/equipo']")
WebElement linkToTeam;
@FindBy(xpath="//a[@href='/page/Colaboradores']")
WebElement linkToCollaborators;
@FindBy(xpath="//a[@href='/page/feedback']")
WebElement linkToContact;



	public AboutPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}

	public ArrayList<String> getSections() {
		List<WebElement> sections = driver.findElements(By.xpath("//main/div/div/div/ul/li/a"));
		ArrayList<String>sectionNames = new ArrayList<String>();
		for(int i=0;i<sections.size();i++) {
			sectionNames.add(sections.get(i).getText());
			System.out.println(sectionNames.get(i));
		}
		return sectionNames;
	}

	public ArrayList<String> getSectionsInHowTo() {
		List<WebElement> sections = driver.findElements(By.xpath("//main/div/div/div/ul/li/ul/li/a"));
		ArrayList<String>sectionNames = new ArrayList<String>();
		for(int i=0;i<sections.size();i++) {
			sectionNames.add(sections.get(i).getText());
			System.out.println(sectionNames.get(i));
		}
		return sectionNames;
	}

	
	public String getAboutContentHtml() {
		
		return this.getContentHtml(this.mainContent);
		
	}

	public String getOriginContentHtml() {
		this.linkToOrigin.click();
		return this.getContentHtml(this.mainContent);
	}

	public String getContactContentHtml() {
		this.linkToContact.click();
		return this.getContentHtml(this.mainContent);
	}

	public String getCollaboratorsContentHtml() {
		this.linkToCollaborators.click();
		return this.getContentHtml(this.mainContent);
	}

	public String getTeamContentHtml() {
		this.linkToTeam.click();
		return this.getContentHtml(this.mainContent);
	}

	public String getPeopleContentHtml() {
		this.linkToPeople.click();
		return this.getContentHtml(this.mainContent);
	}

	public String getFrequentQuestionsContentHtml() {
		this.linkToFrequentQuestions.click();
		return this.getContentHtml(this.mainContent);
	}

	public String getTakePartContentHtml() {
		this.linkToTakePart.click();
		return this.getContentHtml(this.mainContent);
	}

	public String getContestAndWorkspacesContentHtml() {
		this.linkToContestsAndWorkspaces.click();
		return this.getContentHtml(this.mainContent);
	}

}
