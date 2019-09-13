package colabupmtest.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import colabupmtest.enums.Context;
import colabupmtest.pageobjects.ContestPage;
import colabupmtest.pageobjects.MainPage;
import colabupmtest.pageobjects.ProposalDetailsPage;
import colabupmtest.selenium.TestContext;
import colabupmtest.utils.ContestManagerUtils;

public class SemiFinalistSelection {

	private MainPage mainPage;
	private ContestPage contestPage;
	private ProposalDetailsPage proposalDetailsPage;
	private TestContext testContext;
	private ProposalDetailsPage proposalDetails;
	private ContestManagerUtils cmUtils;

	public SemiFinalistSelection(TestContext testContext, ContestManagerUtils cmUtils) {
		this.testContext = testContext;
		this.cmUtils = cmUtils;
	}
	
	
	
	@Given("^a proposal in a contest in phase SemiFinalist selection$")
	public void a_proposal_in_a_contest_in_phase_SemiFinalist_selection() throws Throwable {
		cmUtils.createContestAndLaunch();
		cmUtils.createNewProposal("Titulo");
		cmUtils.login("solmedo", "odemlo13", testContext.getPageObjectManager().getProposalDetailsPage());
		cmUtils.updateSchedule("semi-finalist");
		cmUtils.goToContest((String)this.testContext.getScenarioContext().getContext(Context.CONTEST_NAME));
		contestPage = this.testContext.getPageObjectManager().getContestPage();
		contestPage.waitUntilProposalIsViewInSemiFinalistPhase("Titulo");
	}

	@When("^a fellow decide not advance the proposal$")
	public void a_fellow_decide_not_advance_the_proposal() throws Throwable {
		cmUtils.login("fellow", "odemlo13", contestPage);
		contestPage.clickOnProposalByName("Titulo");
		proposalDetailsPage = this.testContext.getPageObjectManager().getProposalDetailsPage();
		proposalDetailsPage.clickOnScreeningTab();
		int[] valuesNegation = { 1, 2, 4 };
		int randomValue = (int) (Math.random() * 2);
		proposalDetailsPage.selectDecision(valuesNegation[randomValue]);
		proposalDetailsPage.saveDecission();
		proposalDetailsPage.goToMainPage();
		mainPage = this.testContext.getPageObjectManager().getMainPage();
		mainPage.closeSession();
	}

	@Then("^the proposal is not visible in the Proposal Revision phase$")
	public void the_proposal_is_not_visible_in_the_Proposal_Revision_phase() throws Throwable {
		mainPage = this.testContext.getPageObjectManager().getMainPage();
		cmUtils.login("solmedo", "odemlo13", mainPage);
		cmUtils.updateSchedule("proposalRevision");
		cmUtils.goToContest((String)this.testContext.getScenarioContext().getContext(Context.CONTEST_NAME));
		
		Assert.assertFalse(contestPage.checkIfProposalIsShowInProposalRevisionPhase("Titulo"));
	}

	@When("^a fellow decide advance the proposal$")
	public void a_fellow_decide_advance_the_proposal() throws Throwable {
	
		cmUtils.login("fellow", "odemlo13", contestPage);
		contestPage.clickOnProposalByName("Titulo");
		proposalDetailsPage = this.testContext.getPageObjectManager().getProposalDetailsPage();
		proposalDetailsPage.clickOnScreeningTab();
		proposalDetailsPage.selectDecision(3);
	}

	@When("^select the judge$")
	public void select_the_judge() throws Throwable {
		proposalDetailsPage.selectJudge();
		proposalDetailsPage.saveDecission();

	}

	@Then("^assigned judge can evaluate the proposal$")
	public void assigned_judge_can_evaluate_the_proposal() throws Throwable {
		proposalDetailsPage.goToMainPage();
		mainPage = this.testContext.getPageObjectManager().getMainPage();
		mainPage.closeSession();
		cmUtils.login("judge", "odemlo13", mainPage);
		cmUtils.goToContest((String) this.testContext.getScenarioContext().getContext(Context.CONTEST_NAME));
		contestPage.clickOnProposalByName("Titulo");
		proposalDetails = this.testContext.getPageObjectManager().getProposalDetailsPage();
		Assert.assertTrue(proposalDetails.checkVisibilityOfAdvanceProposalSelect());
	}

	@Given("^a proposal which a judge decide that can be advance$")
	public void a_proposal_which_a_judge_decide_that_can_be_advance() throws Throwable {
		cmUtils.createContestAndLaunch();
		cmUtils.createNewProposal("Titulo");
		cmUtils.login("solmedo", "odemlo13", this.testContext.getPageObjectManager().getProposalDetailsPage());
		cmUtils.updateSchedule("semi-finalist");
		cmUtils.goToContest((String)this.testContext.getScenarioContext().getContext(Context.CONTEST_NAME));
		contestPage = this.testContext.getPageObjectManager().getContestPage();
		contestPage.waitUntilProposalIsViewInSemiFinalistPhase("Titulo");
		this.a_fellow_decide_advance_the_proposal();
		this.select_the_judge();
		this.proposalDetailsPage.goToMainPage();
		mainPage = this.testContext.getPageObjectManager().getMainPage();
		mainPage.closeSession();
		cmUtils.login("judge", "odemlo13", mainPage);
		cmUtils.goToContest((String) this.testContext.getScenarioContext().getContext(Context.CONTEST_NAME));
		contestPage = this.testContext.getPageObjectManager().getContestPage();
		contestPage.clickOnProposalByName("Titulo");
		proposalDetails = this.testContext.getPageObjectManager().getProposalDetailsPage();
		proposalDetails.selectMaxScoreRatings();
		proposalDetails.advanceProposal();
		proposalDetails.writeJudgingComment("Ok");
		proposalDetails.saveProposalJudging();
		proposalDetails.closeSession();
	
	}

	@When("^not advance the proposal$")
	public void not_advance_the_proposal() throws Throwable {
		proposalDetailsPage.selectAdvanceDecission(1);
		proposalDetailsPage.submitAdvancing();
		proposalDetailsPage.goToMainPage();
		mainPage = this.testContext.getPageObjectManager().getMainPage();
		mainPage.closeSession();
	}

	@When("^the fellow go to advance proposals selection section$")
	public void the_fellow_go_to_advance_proposals_selection_section() throws Throwable {
		cmUtils.login("fellow", "odemlo13", contestPage);
		cmUtils.goToContest((String) this.testContext.getScenarioContext().getContext(Context.CONTEST_NAME));
		contestPage.clickOnProposalByName("Titulo");
		proposalDetailsPage = this.testContext.getPageObjectManager().getProposalDetailsPage();
		proposalDetailsPage.clickOnAdvancingTab();

	}

	@When("^advance the proposal$")
	public void advance_the_proposal() throws Throwable {
		proposalDetailsPage.selectAdvanceDecission(2);
		proposalDetailsPage.writeFellowCommentBeforeAdvance("Avanza");
		proposalDetailsPage.submitAdvancing();
	}

	@Then("^the proposal is visible in the Proposal Revision Phase$")
	public void the_proposal_is_visible_in_the_Proposal_Revision_Phase() throws Throwable {
		proposalDetailsPage.goToMainPage();
		mainPage = this.testContext.getPageObjectManager().getMainPage();
		mainPage.closeSession();
		cmUtils.login("solmedo", "odemlo13", mainPage);
		cmUtils.updateSchedule("proposalRevision");
		cmUtils.goToContest((String) this.testContext.getScenarioContext().getContext(Context.CONTEST_NAME));
		Assert.assertTrue(contestPage.checkIfProposalIsShowInProposalRevisionPhase("Titulo"));
	}


}
