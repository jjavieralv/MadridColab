package colabupmtest.steps;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import colabupmtest.pageobjects.MainPage;
import colabupmtest.selenium.TestContext;

public class ThemeSteps {

	private MainPage mainPage;
	private String pathLogo;
	private String primaryColorCss;
	private String pathCss;
	private String name;
	private String navBarAboutText;
	private String navBarContestsText;
	private String navBarCommunityText;
	private TestContext testContext;
	
	public ThemeSteps(TestContext testContext) {
		this.testContext = testContext;
		this.mainPage = this.testContext.getPageObjectManager().getMainPage();
	}
	@Given("^a \"([^\"]*)\" in the platform main page$")
	public void goToColabPage(String typeUser) {
		mainPage.loadMainPage();
	}

	@When("^check the platform name$")
	public void getNameOrg() {
		this.name = mainPage.getTitle();
	}

	@Then("^the name is \"([^\"]*)\"$")
	public void checkNameOrg(String name) {

		Assert.assertEquals(name, this.name);
	}

	@When("^check the path of the logo image$")
	public void getPathLogo() {

		pathLogo = mainPage.getPathLogo();

	}

	@Then("^is the path of the theme \"([^\"]*)\"$")
	public void checkPathLogo(String theme) {
		String camelCaseName = WordUtils.capitalizeFully(theme, '_').replaceAll("_", "");
		String themeName = StringUtils.uncapitalize(camelCaseName);
		themeName = mainPage.getDriver().getCurrentUrl() + "images/" + themeName + "-logo.png";

		Assert.assertEquals(themeName, pathLogo);
	}

	@When("^check the primary color$")
	public void getPrimaryColor() {
		primaryColorCss = mainPage.getPrimaryColorCss();
		String[] numbers = primaryColorCss.replace("rgba(", "").replace(")", "").split(",");
		int r = Integer.parseInt(numbers[0].trim());
		int g = Integer.parseInt(numbers[1].trim());
		int b = Integer.parseInt(numbers[2].trim());
		System.out.println("r: " + r + "g: " + g + "b: " + b);
		primaryColorCss = "#" +String.format("%02d", Integer.parseInt(Integer.toHexString(r))) + Integer.toHexString(g) + Integer.toHexString(b);
		
	}

	@Then("^is \"([^\"]*)\"$")
	public void checkPrimaryColor(String colorKey) {

		Assert.assertEquals(colorKey, primaryColorCss);
	}

	@When("^check the stylesheets$")
	public void getCss() {
		String[] url = mainPage.getPathCss().split("/");
		url[5] = url[5].replaceAll("-([^<]*).css", "").replaceFirst("-", "");
		pathCss = "";
		for (int i = 0; i < url.length - 1; i++) {
			pathCss = pathCss + url[i] + "/";

		}
		pathCss = pathCss + url[url.length - 1] + ".css";

	}

	@When("^check the language by default$")
	public void check_the_language_by_default() throws Throwable {
		this.navBarAboutText = mainPage.getNavBarAboutText();
		this.navBarContestsText = mainPage.getNavBarContestsText();
		this.navBarCommunityText = mainPage.getNavBarCommunityText();
	}

	@Then("^is spanish$")
	public void is_spanish() throws Throwable {
		Assert.assertTrue(this.navBarAboutText.equals("Acerca de"));
		Assert.assertTrue(this.navBarContestsText.equals("Retos"));
		Assert.assertTrue(this.navBarCommunityText.equals("Comunidad"));
	}

	@When("^change the language to english$")
	public void change_the_language_to_english() throws Throwable {
		mainPage.clickOnLanguage();
		mainPage.selectLanguage("en");
	}

	@When("^check the language$")
	public void check_the_language() throws Throwable {
		this.navBarAboutText = mainPage.getNavBarAboutText();
		this.navBarContestsText = mainPage.getNavBarContestsText();
		this.navBarCommunityText = mainPage.getNavBarCommunityText();
	}

	@Then("^the language change to english rightly$")
	public void the_language_change_to_english_rightly() throws Throwable {
		Assert.assertTrue(this.navBarAboutText.equals("About"));
		Assert.assertTrue(this.navBarContestsText.equals("Contests"));
		Assert.assertTrue(this.navBarCommunityText.equals("Community"));
	}

	@When("^change the language to spanish$")
	public void change_the_language_to_spanish() throws Throwable {
		mainPage.clickOnLanguage();
		mainPage.selectLanguage("es");
	}

	@Then("^the language change to spanish rightly$")
	public void the_language_change_to_spanish_rightly() throws Throwable {
		Assert.assertTrue(this.navBarAboutText.equals("Acerca de"));
		Assert.assertTrue(this.navBarContestsText.equals("Retos"));
		Assert.assertTrue(this.navBarCommunityText.equals("Comunidad"));
	}


	@Then("^are the stylesheets related to the theme \"([^\"]*)\"$")
	public void checkCss(String theme) {
		String camelCaseName = WordUtils.capitalizeFully(theme, '_').replaceAll("_", "");
		String themeName = StringUtils.uncapitalize(camelCaseName);
		themeName = mainPage.getDriver().getCurrentUrl() + "css/themes/" + themeName + ".css";
		System.out.println("-------------------------------" + pathCss);
		System.out.println("-------------------------------" + themeName);
		Assert.assertEquals(this.pathCss, themeName);
	}



}
