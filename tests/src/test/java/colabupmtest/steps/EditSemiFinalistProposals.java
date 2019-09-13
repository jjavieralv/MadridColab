package colabupmtest.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import colabupmtest.pageobjects.ContestPage;
import colabupmtest.pageobjects.MainPage;
import colabupmtest.pageobjects.ProposalDetailsPage;
import colabupmtest.selenium.TestContext;

public class EditSemiFinalistProposals {

	private MainPage mainPage;

	private ContestPage contestPage;

	private ProposalDetailsPage proposalDetailsPage;


	private TestContext testContext;

	public EditSemiFinalistProposals(TestContext testContext){
		this.testContext = testContext;
		contestPage = this.testContext.getPageObjectManager().getContestPage();
	
	}
	
	
	@Given("^a contest which is in proposal revision phase$")
	public void a_member_into_a_contest_which_is_in_proposal_revision_phase() throws Exception {
		String contestPhase = contestPage.getCurrentPhase();
		if (!contestPhase.contains("Revisión de propuestas")) {
			throw new Exception();
		}
	}

	@When("^a member access to the contest$")
	public void the_member_try_to_create_a_new_proposal() {
		contestPage.clickEnter();
		contestPage.insertValidUserAndPassword("member", "odemlo13");
		contestPage.clickSubmmit();
		
	}

	@Then("^the button to create new proposals is disabled$")
	public void the_button_to_create_new_proposals_is_disabled() throws Throwable {
	  Assert.assertTrue(!contestPage.checkIfCreateNewProposalButtonIsDisplay());
	}

	@Given("^a semi-finalist proposal in proposal revision phase$")
	public void a_semi_finalist_proposal_in_proposal_revision_phase() throws Throwable {
		
		contestPage.clickOnProposalByName("Titulo");
			
	}

	@When("^the author enter in the proposal page$")
	public void the_author_enter_in_the_proposal_page() throws Throwable {
		contestPage.clickEnter();
		contestPage.insertValidUserAndPassword("member","odemlo13");
		contestPage.clickSubmmit();
		proposalDetailsPage = this.testContext.getPageObjectManager().getProposalDetailsPage();
	   
	}

	@Then("^the author can edit the proposal$")
	public void the_author_can_edit_the_proposal() throws Throwable {
	    Assert.assertTrue(this.proposalDetailsPage.editButtonIsDisplay());
	}
	
	private void login(String userName, String password) {
		mainPage.clickEnter();
		mainPage.insertValidUserAndPassword(userName, password);
		mainPage.clickSubmmit();
	}



}
