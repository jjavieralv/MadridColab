package colabupmtest.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import colabupmtest.enums.Context;
import colabupmtest.pageobjects.ContestListPage;
import colabupmtest.pageobjects.ContestManagerPage;
import colabupmtest.pageobjects.ContestPage;
import colabupmtest.pageobjects.MainPage;
import colabupmtest.pageobjects.ProposalDetailsPage;
import colabupmtest.selenium.TestContext;
import colabupmtest.utils.ContestManagerUtils;

public class ResultsSteps {
	private TestContext testContext;
	private ContestPage contestPage;
	private ContestListPage contestListPage;
	private ContestManagerUtils utils;
	private MainPage mainPage;
	private ContestManagerPage contestManagerPage;
	private ProposalDetailsPage proposalDetails;

	public ResultsSteps(TestContext testContext, ContestManagerUtils utils) {
		this.testContext = testContext;
		this.utils = utils;
		contestPage = testContext.getPageObjectManager().getContestPage();
	}

	@When("^the contest change to \"([^\"]*)\"$")
	public void waitUntilContestChange(String phase) {
		utils.login("solmedo", "odemlo13", contestPage);
		utils.updateSchedule(phase);
		utils.goToContest((String) this.testContext.getScenarioContext().getContext(Context.CONTEST_NAME));
		contestPage = this.testContext.getPageObjectManager().getContestPage();
		contestPage.waitUntilContestEnd();


	}

	@And("^show ribbons$")
	public void showRibbons() {
		utils.login("solmedo", "odemlo13", contestPage);
		contestPage.goToContestManagerPage();
		contestManagerPage = this.testContext.getPageObjectManager().getContestManagerPage();
		contestManagerPage
				.selectContestByName((String) this.testContext.getScenarioContext().getContext(Context.CONTEST_NAME));
		contestManagerPage.selectShowRibbons();
		contestManagerPage.clickOnSubmitButton();
		contestManagerPage.goToMainPage();
		mainPage = testContext.getPageObjectManager().getMainPage();
		mainPage.closeSession();
	}

	@Then("^the proposal has the finalist ribbon$")
	public void checkFinalistRibbon() {
		utils.goToContest((String) this.testContext.getScenarioContext().getContext(Context.CONTEST_NAME));
		contestPage = this.testContext.getPageObjectManager().getContestPage();
		contestPage.clickOnProposalByName("Titulo");
		proposalDetails = this.testContext.getPageObjectManager().getProposalDetailsPage();
		Assert.assertTrue(proposalDetails.checkFinalistRibbonIsShown());

	}

	@Then("^the proposal has the semi-finalist ribbon$")
	public void checkSemiFinalistRibbon() {
		utils.goToContest((String) this.testContext.getScenarioContext().getContext(Context.CONTEST_NAME));
		contestPage = this.testContext.getPageObjectManager().getContestPage();
		contestPage.clickOnProposalByName("Titulo");
		proposalDetails = this.testContext.getPageObjectManager().getProposalDetailsPage();
		Assert.assertTrue(proposalDetails.checkSemiFinalistRibbonIsShown());
	}

	@And("^go to any proposal of contest in \"([^\"]*)\" phase$")
	public void goToContestInPhase(String phase) {
		boolean found = false;
		do {
		contestListPage = this.testContext.getPageObjectManager().getContestListPage();
		contestListPage.clickOnContestByName(contestListPage.getNameOfrandomContestWithProposals(phase));
		contestPage = this.testContext.getPageObjectManager().getContestPage();
		String nameProposal = contestPage.getNameOfFinalistProposal();
		if (nameProposal!=null) {
		contestPage.clickOnProposalByName(nameProposal);
		found = true;
		}
		else {
			contestPage.goToContest();
		}
		}while(!found);
	}

	@And("^select \"([^\"]*)\" ribbon$")
	public void setRibbonByType(String typeRibbon) {
		proposalDetails = this.testContext.getPageObjectManager().getProposalDetailsPage();


		if(typeRibbon.equals("Popular choice")){
			this.proposalDetails.updateRibbon(2);
		}
		else if (typeRibbon.equals("Judges choice")){
			this.proposalDetails.updateRibbon(4);
		}
		else if (typeRibbon.equals("Popular & Judges choice")){
			this.proposalDetails.updateRibbon(5);
		}
	}

	@Then("^the \"([^\"]*)\" ribbon is shown in proposal details$")
	public void checkRibbonIsShown(String typeRibbon) {
		proposalDetails.clickOnDescriptionTab();
		switch (typeRibbon) {
		case "Popular choice":
			Assert.assertTrue(proposalDetails.checkIfRibbonShown(1));
			Assert.assertEquals(proposalDetails.getTextRibbon(), "Popular Choice");
			break;
		case "Judges choice":
			Assert.assertTrue(proposalDetails.checkIfRibbonShown(1));
			Assert.assertEquals(proposalDetails.getTextRibbon(), "Judges' choicce");
			break;
		case "Popular & Judges choice":
			Assert.assertTrue(proposalDetails.checkIfRibbonShown(1));
			Assert.assertEquals(proposalDetails.getTextRibbon(), "Judges' & Popular Choice");
			break;
		}

	}

	@And("^wait until phase change to voting phase$")
	public void waitUntilContestChangeToVotingPhase() {
		utils.login("solmedo", "odemlo13", contestPage);
		utils.updateSchedule("Voting Phase");
		utils.goToContest((String) this.testContext.getScenarioContext().getContext(Context.CONTEST_NAME));
		contestPage = this.testContext.getPageObjectManager().getContestPage();
		contestPage.waitUntilContestInVotingPhase();

	}

}
