package colabupmtest.steps;

import colabupmtest.selenium.FileReaderManager;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import colabupmtest.pageobjects.ContestListPage;
import colabupmtest.pageobjects.ContestManagerPage;
import colabupmtest.pageobjects.ContestPage;
import colabupmtest.pageobjects.DeleteConfirmationPage;
import colabupmtest.pageobjects.EditContestPreferencesPage;
import colabupmtest.pageobjects.EditionContestPage;
import colabupmtest.pageobjects.MainPage;
import colabupmtest.selenium.TestContext;
import cucumber.api.java.en.Then;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import cucumber.api.java.en.And;

public class ContestSteps {
	
	private MainPage mainPage;
	private ContestManagerPage contestManagerPage;
	private ContestPage contestPage;
	private int initialNumberOfContest;
	private String nameOfLastContest;
	private EditionContestPage editionContestPage;
	private String newTitle;
	private String newQuestion;
	private String newDescription;
	private String newBackground;
	private String newKeyIssues;
	private String newJudgingCriteria;
	private String newPrizes;
	private String newResourcesForProposalAuthors;
	private String urlContest;
	private final ArrayList<String> ontologyWhat = new ArrayList<String>(
			Arrays.asList("Cualquier acción", "Proyecto", "Práctica"));

	private final ArrayList<String> ontologyWhere = new ArrayList<String>(Arrays.asList("Cualquier lugar",
			"Comunidad de Madrid", "Ciudad de Madrid", "Distrito de Madrid", "Otro lugar"));
	private final ArrayList<String> ontologyWho = new ArrayList<String>(Arrays.asList("Cualquier actor",
			"Administración pública", "Empresa privada", "Ciudadanos", "Otras entidades", "Universidades"));
	private final ArrayList<String> ontologyHow = new ArrayList<String>(Arrays.asList("Cualquier tipo de acción",
			"Acción política", "Acción económica", "Acción física", "Acción cultural", "Otro tipo de acción"));
	private int whatRandomOption;
	private int whereRandomOption;
	private int whoRandomOption;
	private int howRandomOption;
	private DeleteConfirmationPage deleteConfirmationPage;
	private ContestListPage contestListPage;
	private EditContestPreferencesPage editContestPreferencesPage;
	private int numberOfContestToShow;
	private ArrayList<String> selections;
	private String memberTeam;
	private TestContext testContext;


	public ContestSteps(TestContext testContext) {
		this.testContext = testContext;
		mainPage = testContext.getPageObjectManager().getMainPage();
	}

	@When("^go to Contest Manager section$")
	public void goToContestManager() {
		mainPage.goToContestManagerPage();
		contestManagerPage = testContext.getPageObjectManager().getContestManagerPage();
	}

	@And("^click on Create New Contest$")
	public void createNewContest() {
		initialNumberOfContest = contestManagerPage.numberOfContest();
		contestManagerPage.clickOnCreateNewContestButton();
	}

	@Then("^a new contest is created$")
	public void checkNewContestIsCreated() {
		contestManagerPage.goToContestManagerPage();
		Assert.assertEquals(initialNumberOfContest + 1, contestManagerPage.numberOfContest());
	}

	@And("^click on view contest button$")
	public void clickOnViewContest() {
		nameOfLastContest = contestManagerPage.getNameOfContest(contestManagerPage.numberOfContest() - 1);
		contestManagerPage.clickOnViewContest(contestManagerPage.numberOfContest() - 1);
		contestPage = this.testContext.getPageObjectManager().getContestPage();
	}

	@Then("^the contest is shown$")
	public void checkContestPageIsShown() {

		Assert.assertEquals(nameOfLastContest, contestPage.getNameContestShown());
	}

	@And("^click on the title of the contest which will be change$")
	public void goToEditContest() {
		nameOfLastContest = contestManagerPage.getNameOfContest(contestManagerPage.numberOfContest() - 1);
		contestManagerPage.clickOnContestToEdit(contestManagerPage.numberOfContest() - 1);
		editionContestPage = this.testContext.getPageObjectManager().getEditionContestPage();

	}


	@And("^set the new title$")
	public void writeNewTitleContest() {
		newTitle = "El nuevo titulo es " + new Timestamp(new Date().getTime());
		newTitle = newTitle.replaceAll(":", ".").replaceAll("-", ".");
		editionContestPage.changeTitle(newTitle);
	}

	@And("^set the new title with quotes$")
	public void writeNewTitleContestWithAccentMark() {
		newTitle = "El nuevo titulo es áÁéÉíÍóÓúÚñ" + new Timestamp(new Date().getTime());
		newTitle = newTitle.replaceAll(":", ".").replaceAll("-", ".");
		editionContestPage.changeTitle(newTitle);
	}

	@And("^save description$")
	public void saveDescription() {
		editionContestPage.clickOnSaveChanges();
	}

	@Then("^the title is changed$")
	public void checkIfTitleContestIsChanged() {
		editionContestPage.goToContestManagerPage();
		contestManagerPage = this.testContext.getPageObjectManager().getContestManagerPage();
		

			Assert.assertEquals(newTitle, contestManagerPage.getNameOfContest(contestManagerPage.numberOfContest() - 1) );

	}

	@And("^set the new question$")
	public void writeNewQuestionContest() {
		newQuestion = "La nueva pregunta es " + new Timestamp(new Date().getTime());
		newQuestion = newQuestion.replaceAll(":", ".").replaceAll("-", ".");
		editionContestPage.changeQuestion(newQuestion);
	}

	@Then("^the contest question is changed$")
	public void checkIfQuestionContestIsChanged() {
		editionContestPage.goToContestManagerPage();
		contestManagerPage = this.testContext.getPageObjectManager().getContestManagerPage();
		contestManagerPage.clickOnViewContest(contestManagerPage.numberOfContest() - 1);
		contestPage = this.testContext.getPageObjectManager().getContestPage();
		contestPage.changeTab();
		Assert.assertEquals(newQuestion, contestPage.getQuestionContest());
	}

	@And("^set the new description$")
	public void writeNewDescriptionContest() {

		newDescription = "La nueva descripción es " + new Timestamp(new Date().getTime());
		newDescription = newDescription.replaceAll(":", ".").replaceAll("-", ".");
		editionContestPage.changeDescription(newDescription);
	}

	@Then("^the contest description is changed$")
	public void checkIfDescriptionContestIsChanged() {
		editionContestPage.goToContestManagerPage();
		contestManagerPage = this.testContext.getPageObjectManager().getContestManagerPage();
		contestManagerPage.clickOnViewContest(contestManagerPage.numberOfContest() - 1);
		contestPage = this.testContext.getPageObjectManager().getContestPage();
		contestPage.changeTab();
		Assert.assertTrue(contestPage.getDescriptionContest().contains(newDescription));
	}

	@And("^go to Resources Page$")
	public void goToResourcesPageMenu() {
		editionContestPage.goToResourcesPage();
	}

	@And("^click on create Resources Page$")
	public void clickOnCreateResourcePageButton() {
		editionContestPage.clickOnCreateResourcePageButton();

	}

	@And("^fill the fields$")
	public void fillResourcesPageFields() {
		this.newBackground = "El nuevo background de las pages resources es " + new Timestamp(new Date().getTime());
		this.newKeyIssues = "Las nuevas key issues background de las pages resources es "
				+ new Timestamp(new Date().getTime());
		this.newJudgingCriteria = "El Judging Criteria de las pages resources es "
				+ new Timestamp(new Date().getTime());
		this.newPrizes = "Los nuevos prizes de las pages resources es " + new Timestamp(new Date().getTime());
		this.newResourcesForProposalAuthors = "Los nuevos resources for proposal authors de las pages resources es "
				+ new Timestamp(new Date().getTime());
		editionContestPage.fillResourcesPageFields(this.newBackground, this.newKeyIssues, this.newJudgingCriteria,
				this.newPrizes, this.newResourcesForProposalAuthors);
	}

	@And("^click on save resources$")
	public void clickOnSaveResourcesButton() {
		editionContestPage.clickOnSaveResourcesButton();

	}

	@Then("^the contest has a link to resources page$")
	public void checkResourcesPageLinkInContest() {
		editionContestPage.goToContestManagerPage();
		contestManagerPage = this.testContext.getPageObjectManager().getContestManagerPage();
		contestManagerPage.clickOnViewContest(contestManagerPage.numberOfContest() - 1);
		contestPage = this.testContext.getPageObjectManager().getContestPage();
		contestPage.changeTab();
		Assert.assertTrue(contestPage.readMoreIsVisible());
	}

	@And("^the resources is shown$")
	public void getResourcesViewParagraphs() {
		contestPage.goToViewResources();
		List<String> parrafos = contestPage.getResourcesParagraphs();
		Assert.assertEquals(newBackground, parrafos.get(0));
		Assert.assertEquals(newKeyIssues, parrafos.get(1));
		Assert.assertEquals(newJudgingCriteria, parrafos.get(2));
		Assert.assertEquals(newPrizes, parrafos.get(3));
		Assert.assertEquals(newResourcesForProposalAuthors, parrafos.get(4));
	}

	@And("^go to Ontologies$")
	public void goToOntologyMenu() {

		editionContestPage.goToOntology();

	}

	@And("^change ontologies$")
	public void changeOntologies() {
		whatRandomOption = (int) (Math.random() * 2);
		whereRandomOption = (int) (Math.random() * 4);
		whoRandomOption = (int) (Math.random() * 5);
		howRandomOption = (int) (Math.random() * 5);

		editionContestPage.changeOntologies(this.ontologyWhat.get(whatRandomOption),
				this.ontologyWhere.get(whereRandomOption), this.ontologyWho.get(whoRandomOption),
				this.ontologyHow.get(howRandomOption));
	}

	@And("^click on save ontologies$")
	public void clickOnSaveOntologyButton() {
		editionContestPage.clickOnSaveOntologyButton();
	}

	@Then("^the contest show selected ontologies$")
	public void checkOntologiesInContest() {
		editionContestPage.goToContestManagerPage();
		contestManagerPage = this.testContext.getPageObjectManager().getContestManagerPage();
		contestManagerPage.clickOnViewContest(contestManagerPage.numberOfContest() - 1);
		contestPage = this.testContext.getPageObjectManager().getContestPage();
		contestPage.changeTab();
		Assert.assertTrue(contestPage.checkThatOntologyWhatExist(ontologyWhat.get(whatRandomOption)));
		Assert.assertTrue(contestPage.checkThatOntologyWhereExist(ontologyWhere.get(whereRandomOption)));
		Assert.assertTrue(contestPage.checkThatOntologyWhoExist(ontologyWho.get(whoRandomOption)));
		Assert.assertTrue(contestPage.checkThatOntologyHowExist(ontologyHow.get(howRandomOption)));
	}

	@And("^select a contest$")
	public void selectContest() {
		nameOfLastContest = contestManagerPage.getNameOfContest(contestManagerPage.numberOfContest() - 1);
		urlContest = contestManagerPage.getUrlOfContest(contestManagerPage.numberOfContest() - 1);
		this.initialNumberOfContest = contestManagerPage.numberOfContest();
		contestManagerPage.selectContest(contestManagerPage.numberOfContest() - 1);
	}

	@And("^select Public not private option$")
	public void selectPublicContestOption() {
		contestManagerPage.selectPublicContestOption();
	}

	@And("^click on submit$")
	public void clickOnSubmit() {
		contestManagerPage.clickOnSubmitButton();
	}

	@Then("^the contest is shown in contest section whith grid view$")
	public void checkIfContestIsPublic() {
		contestManagerPage.closeSession();
		contestManagerPage.goToContest();
		contestListPage = this.testContext.getPageObjectManager().getContestListPage();
		contestListPage.viewAllContests();


		System.out.println(urlContest);
		Assert.assertTrue(contestListPage.checkIfContestVisible(this.urlContest.replaceAll(FileReaderManager.getInstance().getConfigReader().getWebUrl(),"")));
	}

	@And("^in outline view$")
	public void checkIfContestIsVisibleInAttributeMode() {
		contestListPage.changeToViewAttributes();
		Assert.assertTrue(contestListPage.checkIfContestVisible(this.urlContest.replaceAll(FileReaderManager.getInstance().getConfigReader().getWebUrl(),"")));

	}

	@And("^in list view$")
	public void checkIfContestIsVisibleInListMode() {
		contestListPage.changeToViewList();
		Assert.assertTrue(contestListPage.checkIfContestVisible(this.urlContest.replaceAll(FileReaderManager.getInstance().getConfigReader().getWebUrl(),"")));
	}

	@And("^select delete contests including phases option$")
	public void selectDeleteContestOption() {
		contestManagerPage.selectDeleteContestOption();
	}

	@And("^confirm deletion$")
	public void confirmDeleteContest() {
		deleteConfirmationPage = this.testContext.getPageObjectManager().getDeleteConfirmationPage();
		deleteConfirmationPage.confirmDeleteContest();
	}

	@Then("^the contest is deleted$")
	public void checkContestIsDeleted() {
		Assert.assertEquals(this.initialNumberOfContest - 1, contestManagerPage.numberOfContest());
		Assert.assertFalse(this.nameOfLastContest
				.equals(contestManagerPage.getNameOfContest(contestManagerPage.numberOfContest() - 1)));
	}

	@And("^click on edit contest preferences$")
	public void clickOnEditContestPreferences() {
		mainPage.clickOnEditContestPreferencesButton();
		editContestPreferencesPage = this.testContext.getPageObjectManager().getEditContestPreferencesPage();
	}

	@And("^select the contest which will be shown$")
	public void selectContestToShowInMainPage() {
		numberOfContestToShow = editContestPreferencesPage.getFeedSize();
		selections = editContestPreferencesPage.selectContestToShow();
	}

	@And("^click on save button$")
	public void clickOnSave() {
		editContestPreferencesPage.clickOnSaveButton();
	}

	@And("^go to main page$")
	public void returnToMainPage() {
		editContestPreferencesPage.clickOnReturnToHomeButton();
		mainPage = this.testContext.getPageObjectManager().getMainPage();
	}

	@Then("^the selected contests is being shown in the main page$")
	public void checkIfContestsAreVisibleInMainPage() {

		Assert.assertEquals(this.selections.size(), mainPage.getNumberOfContestsShown());
		ArrayList<String> shownContestsTitles = mainPage.getNameOfShownContests();

		System.out.println(this.selections.get(0));
		System.out.println(this.selections.get(1));
		System.out.println(shownContestsTitles.get(1));
		System.out.println(shownContestsTitles.get(0));
		Assert.assertTrue(this.selections.get(0).equals(shownContestsTitles.get(0))
				|| this.selections.get(0).equals(shownContestsTitles.get(1)));
		Assert.assertTrue(this.selections.get(1).equals(shownContestsTitles.get(0))
				|| this.selections.get(1).equals(shownContestsTitles.get(1)));

	}

	@And("^go to team$")
	public void goToTeamSelection() {
		editionContestPage.goToTeamSelectionPage();
	}

	@And("^add members team$")
	public void addMemberTeam() {
		memberTeam = "member";
		editionContestPage.addMemberTeam("member");

	}

	@And("^click on save team$")
	public void clickOnSaveTeam() {
		editionContestPage.clickOnSaveTeamButton();
	}

	@Then("^the team members are shown in the contest page$")
	public void checkIfTeamIsShownInContestPage() {
		editionContestPage.clickOnPreviewContest();
		contestPage = this.testContext.getPageObjectManager().getContestPage();
		Assert.assertTrue(contestPage.checkIfTeamIsShownInContestPage("Member Member", "Member Member", "Member Member",
				"Member Member"));
	}

	@And("^delete members team$")
	public void deleteMemberTeam() {
		editionContestPage.deleteMemberTeam();
	}

	@Then("^the team members are not shown in the contest page$")
	public void checkTeamNotShownInContestPage() {
		editionContestPage.clickOnPreviewContest();
		contestPage = this.testContext.getPageObjectManager().getContestPage();
		Assert.assertEquals(0, contestPage.getSizeTeam());
	}

	@When("^set a title with (\\d+) characters length$")
	public void introduce_un_titulo_con_caracteres(int maxLength) throws Throwable {
		newTitle = "El nuevo titulo es " + new Timestamp(new Date().getTime());
		newTitle = newTitle.replaceAll(":", ".").replaceAll("-", ".");
		maxLength = maxLength - newTitle.length();
		for (int i = 0; i < maxLength; i++) {
			newTitle = newTitle.concat("a");
		}
		editionContestPage.changeTitle(newTitle);
	}

	@Then("^appear the next error \"([^\"]*)\"$")
	public void aparece_un_error_con_el_siguiente_texto(String error) throws Throwable {
		Assert.assertEquals(editionContestPage.getSaveContestErrror(), error);
	}

	@When("^set a question with (\\d+) characters length$")
	public void introduce_una_pregunta_con_caracteres(int maxLength) throws Throwable {
		newQuestion = "La nueva pregunta es " + new Timestamp(new Date().getTime());
		newQuestion = newQuestion.replaceAll(":", ".").replaceAll("-", ".");
		maxLength = maxLength - newQuestion.length();
		for (int i = 0; i < maxLength; i++) {
			newQuestion = newQuestion.concat("a");
		}
		editionContestPage.changeQuestion(newQuestion);
	}

	@When("^set a description with (\\d+) characters length$")
	public void introduce_una_descripci_n_con_caracteres(int maxLength) throws Throwable {
		newDescription = "La nueva descripcion es " + new Timestamp(new Date().getTime());
		newDescription = newDescription.replaceAll(":", ".").replaceAll("-", ".");
		maxLength = maxLength - newDescription.length();
		for (int i = 0; i < maxLength; i++) {
			newDescription = newDescription.concat("a");

		}
		editionContestPage.changeDescription(newDescription);
	}



}
