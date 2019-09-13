package colabupmtest.steps;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import colabupmtest.pageobjects.ContestListPage;
import colabupmtest.pageobjects.ContestPage;
import colabupmtest.pageobjects.CreateProposalPage;
import colabupmtest.pageobjects.MainPage;
import colabupmtest.pageobjects.ProposalDetailsPage;
import colabupmtest.selenium.TestContext;

public class ProposalsSteps {

	private MainPage mainPage;
	private ContestListPage contestListPage;
	private ContestPage contestPage;
	private CreateProposalPage createProposalPage;
	private ArrayList<String> optionalSections;
	private String teamName;
	private ProposalDetailsPage proposalDetailsPage;
	private String titulo;
	private String pitch;
	private int numOfSupports;
	private TestContext testContext;

	public ProposalsSteps(TestContext testContext) {
		this.testContext = testContext;
		this.mainPage = this.testContext.getPageObjectManager().getMainPage();
	}

	@And("^go to contests section$")
	public void goToContestSection() {
		this.mainPage.goToContest();
	}

	@When("^enter in a contest where the proposal creation is not still open as \"([^\"]*)\"$")
	public void enter_in_a_contest_where_the_proposal_creation_is_not_still_open(String contestName) throws Throwable {
		contestListPage = this.testContext.getPageObjectManager().getContestListPage();
		contestListPage.clickOnContestByName(contestName);
		contestPage = this.testContext.getPageObjectManager().getContestPage();
	}

	@Then("^the button to create proposal is not shown$")
	public void the_button_to_create_proposal_is_not_shown() throws Throwable {
		Assert.assertTrue(!contestPage.createProposalButtonIsEnabled());
	}

	@When("^enter in a contest where the proposal creation is open as \"([^\"]*)\"$")
	public void enter_in_acontest_where_the_proposal_creation_is_open(String contestName) throws Throwable {
		contestListPage = this.testContext.getPageObjectManager().getContestListPage();
		contestListPage.clickOnContestByName(contestName);
		contestPage = this.testContext.getPageObjectManager().getContestPage();
	}

	@Then("^the button to create proposal is shown$")
	public void the_button_to_create_proposal_is_shown() throws Throwable {
		Assert.assertTrue(contestPage.createProposalButtonIsEnabled());
	}

	@When("^click on the button to create a new proposal$")
	public void click_on_the_button_to_create_a_new_proposal() throws Throwable {
		contestPage.clickOnCreateNewProposal();
	}

	@Then("^a form to do login appears$")
	public void a_form_to_do_login_appears() throws Throwable {
		Assert.assertTrue(contestPage.formToDoLoginIsShown());
	}


	@When("^fill mandatory fields$")
	public void fill_mandatory_fields() throws Throwable {
		createProposalPage = this.testContext.getPageObjectManager().getCreteProposalPage();
		this.titulo = "Titulo " + new Timestamp(new Date().getTime()).toString().replaceAll(" ", "")
				.replaceAll("\\.", "").replaceAll(":", "");
		this.pitch = "Pitch " + new Timestamp(new Date().getTime()).toString().replaceAll(" ", "").replaceAll("\\.", "")
				.replaceAll(":", "");
		createProposalPage.fillMandatoryFields(this.titulo, this.pitch);

	}

	@When("^fill the field Team Name$")
	public void fill_the_field_Team_Name() throws Throwable {
		teamName = new Timestamp(new Date().getTime()).toString().replaceAll(" ", "");
		createProposalPage.fillTeamName(teamName);
	}

	@When("^fill optional sections$")
	public void fill_optional_sections() throws Throwable {
		optionalSections = new ArrayList<String>();
		this.optionalSections.add("Optional Section 1: " + new Timestamp(new Date().getTime()).toString());
		this.optionalSections.add("Optional Section 2: " + new Timestamp(new Date().getTime()).toString());
		createProposalPage.fillOptionalSections(this.optionalSections);
	}

	@When("^click on save and PUBLISH changes button$")
	public void click_on_save_and_PUBLISH_changes_button() throws Throwable {
		createProposalPage.clickOnSaveAndPublish();
	}

	@When("^accept the Contest Rules$")
	public void acceptTheContestRules() {
		 createProposalPage.acceptContestRules();
		 proposalDetailsPage = this.testContext.getPageObjectManager().getProposalDetailsPage();
	}

	@Then("^the proposal is created with the provided information$")
	public void the_proposal_is_created_with_the_provided_information() throws Throwable {

		Assert.assertTrue(this.titulo.equals(proposalDetailsPage.getTitleProposal().trim()));
		Assert.assertTrue(this.pitch.equals(proposalDetailsPage.getPitchProposal().trim()));
		Assert.assertEquals(optionalSections.get(0), proposalDetailsPage.getOptionalSectionInPosition(1));
		Assert.assertEquals(optionalSections.get(1), proposalDetailsPage.getOptionalSectionInPosition(2));
	}

	@Then("^the name that appears in the proposal is that of the team$")
	public void the_name_that_appears_in_the_proposal_is_that_of_the_team() throws Throwable {
		Assert.assertTrue(this.teamName.equals(proposalDetailsPage.getProposalCreator()));
	}

	@Then("^the name that appears in the proposal is \"([^\"]*)\"$")
	public void the_name_that_appears_in_the_proposal_is(String name) throws Throwable {
		Assert.assertTrue(name.equals(proposalDetailsPage.getProposalCreator()));
	}

	@Given("^enter in a proposal details of a proposal created by member \"([^\"]*)\"$")
	public void enter_in_a_proposal_details_of_a_proposal_created_by_member(String proposalCreator) throws Throwable {
		contestPage.clickOnAProposalCreatedBy(proposalCreator);
		
	}

	@Given("^go to contributors section$")
	public void go_to_contributors_section() throws Throwable {
		proposalDetailsPage = this.testContext.getPageObjectManager().getProposalDetailsPage();
		proposalDetailsPage.goToContributorsSection();
	}

	@When("^click on Request Membership$")
	public void click_on_Request_Membership() throws Throwable {
		proposalDetailsPage.clickOnRequestMembership();
	}

	@When("^click on sent$")
	public void click_on_sent() throws Throwable {
		proposalDetailsPage.clickOnSendMemberShipRequest();
	}

	@Then("^the button Request Membership disappears$")
	public void the_button_Request_Membership_disappears() throws Throwable {
		Assert.assertTrue(!proposalDetailsPage.requestMembershipButtonIsEnabled());
	}

	@When("^approve the request$")
	public void approve_the_request() throws Throwable {
		proposalDetailsPage.approveRequest();
	}

	@Then("^Requesting user appears as member in the proposal$")
	public void requesting_user_appears_as_member_in_the_proposal() throws Throwable {
		throw new PendingException();
	}

	@When("^deny the request$")
	public void deny_the_request() throws Throwable {
		proposalDetailsPage.denyRequest();
	}


	@When("^click on Support proposal button$")
	public void click_on_Support_proposal_button() throws Throwable {
		numOfSupports = proposalDetailsPage.getNumberOfMemberSupports();
		proposalDetailsPage.clickOnSupportProposal();
	}

	@Then("^the user \"([^\"]*)\" is added to support proposal$")
	public void the_user_is_added_to_support_proposal(String user) throws Throwable {
		Assert.assertTrue(numOfSupports + 1 == proposalDetailsPage.getNumberOfMemberSupports());
		Assert.assertTrue(proposalDetailsPage.isNameAppearsInContributors(user));
	}

	@When("^click on Retract support$")
	public void click_on_Retract_support() throws Throwable {
		numOfSupports = proposalDetailsPage.getNumberOfMemberSupports();
		proposalDetailsPage.clickOnRetractSupportProposal();
	}

	@Then("^the user \"([^\"]*)\" is removed to support proposal$")
	public void the_user_is_removed_to_support_proposal(String user) throws Throwable {
		Assert.assertTrue(numOfSupports - 1 == proposalDetailsPage.getNumberOfMemberSupports());
		Assert.assertTrue(!proposalDetailsPage.isNameAppearsInContributors(user));
	}

	@Given("^go to admin section$")
	public void go_to_admin_section() throws Throwable {
		proposalDetailsPage = this.testContext.getPageObjectManager().getProposalDetailsPage();
		proposalDetailsPage.goToAdminSection();
	}

	@Given("^click on delete proposal$")
	public void click_on_delete_proposal() throws Throwable {
		this.titulo = proposalDetailsPage.getTitleProposal();
		proposalDetailsPage.clickOnDeleteProposal();
	}

	@Then("^the proposal is deleted$")
	public void the_proposal_is_deleted() throws Throwable {
		
		proposalDetailsPage.goToContest();
		this.contestListPage = this.testContext.getPageObjectManager().getContestListPage();
		 contestListPage.clickOnContestByName("Concurso 1");
		 this.contestPage =this.testContext.getPageObjectManager().getContestPage();
		Assert.assertTrue(!contestPage.isProposalInContest(titulo));
	}




}
