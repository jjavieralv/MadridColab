package colabupmtest.steps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import colabupmtest.pageobjects.ContestListPage;
import colabupmtest.pageobjects.ContestPage;
import colabupmtest.pageobjects.DiscussionPage;
import colabupmtest.pageobjects.ProposalDetailsPage;
import colabupmtest.pageobjects.SubscriptionsPage;
import colabupmtest.selenium.TestContext;

public class SubscriptionSteps {


	private ContestListPage contestListPage;
	private ContestPage contestPage;
	private ProposalDetailsPage proposalDetails;
	private SubscriptionsPage subscriptionsPage;
	private DiscussionPage discussionPage;
	private String contestName;
	private TestContext testContext;
	
	public SubscriptionSteps(TestContext testContext){
		this.testContext = testContext;
		this.contestListPage = testContext.getPageObjectManager().getContestListPage();
	}
	@When("^he subscribe to a proposal$")
	public void he_subscribe_to_a_proposal() throws Throwable {
		proposalDetails = testContext.getPageObjectManager().getProposalDetailsPage();
		proposalDetails.clickOnSubscribe();
	    
	}

	@Then("^the button change to unsubscribe in proposal details$")
	public void the_button_change_to_unsubscribe_in_proposal_details() throws Throwable {
		Assert.assertTrue(proposalDetails.unsubscribeButtonIsDisplay());
	}
	
	@Then("^the button change to unsubscribe in contest details$")
	public void the_button_change_to_unsubscribe_in_contest_details() throws Throwable {
		Assert.assertTrue(this.contestPage.unsubscribeButtonIsDisplay());
	}


	@When("^click on unsubscribe in a proposal$")
	public void click_on_unsubscribe_in_a_proposal() throws Throwable {
	  proposalDetails.clickOnUnsubscribe();
	}

	@Then("^the button change to subscribe in proposal details$")
	public void the_button_change_to_subscribe_in_proposal_details() throws Throwable {
	    Assert.assertTrue(proposalDetails.subscribeButtonIsDisplay());
	}
	@Then("^the button change to subscribe in contest details$")
	public void the_button_change_to_subscribe_in_contest_details() throws Throwable {
	    Assert.assertTrue(contestPage.subscribeButtonIsDisplay());
	}

	@When("^he subscribe to a contest$")
	public void he_subscribe_to_a_contest() throws Throwable {
		contestName = contestListPage.getNameOfrandomContestWithProposals();
	    contestListPage.clickOnContestByName(contestName);
	    contestPage = this.testContext.getPageObjectManager().getContestPage();
		contestPage.clickOnSubscribeButton();
	}

	@When("^click on unsubscribe in a contest$")
	public void click_on_unsubscribe_in_a_contest() throws Throwable {
	    contestPage.clickOnUnsubscribeButton();
	}

	@When("^someone write a comment in the proposal$")
	public void someone_write_a_comment_in_the_proposal() throws Throwable {
	    proposalDetails.clickOnCommentTab();
	    proposalDetails.writeComment("Comentario");
	    proposalDetails.clickOnAddComment();
	}

	@Then("^the subscribe user receive a \"([^\"]*)\" notification$")
	public void the_subscribe_user_receive_a_notification(String typeOfNotification) throws Throwable {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
	    if(typeOfNotification.equals("new comment in proposal")) {
	    	this.proposalDetails.goToSubscriptions();
	    	subscriptionsPage = this.testContext.getPageObjectManager().getSubscriptionPage();
	    	Assert.assertTrue(subscriptionsPage.newCommentInProposalMessage(dateFormat.format(date)));
	    }
	    else if (typeOfNotification.equals("new comment in contest")) {
	    	this.discussionPage.goToSubscriptions();
	    	subscriptionsPage = this.testContext.getPageObjectManager().getSubscriptionPage();
	    	Assert.assertTrue(subscriptionsPage.newCommentInContestMessage(dateFormat.format(date)));
	    }
	   
	}

	@When("^someone write a comment in the contest$")
	public void someone_write_a_comment_in_the_contest() throws Throwable {
	    contestPage.clickOnDiscuss();
	    discussionPage= this.testContext.getPageObjectManager().getDiscussionPage();
	    discussionPage.writeComment("comment");
	    discussionPage.clickOnAddComment();
	}

	

	@When("^go to manage subscribed activities$")
	public void go_to_manage_suscribed_activities() throws Throwable {
	    this.contestPage.goToSubscriptions();
	    subscriptionsPage = this.testContext.getPageObjectManager().getSubscriptionPage();
	    subscriptionsPage.clickOnManageSubscriptions();
	}

	@When("^select all$")
	public void select_all() throws Throwable {
	    subscriptionsPage.clickOnSelectAllSubscriptions();
	}

	@When("^click on delete selected$")
	public void click_on_delete_selected() throws Throwable {
	    subscriptionsPage.clickOnDeleteSelected();
	}

	@Then("^the user is unsubscribe$")
	public void the_user_is_unsuscribe() throws Throwable {
	   this.subscriptionsPage.goToContest();
	   contestListPage = this.testContext.getPageObjectManager().getContestListPage();
	   contestListPage.clickOnContestByName(contestName);
	   contestPage = this.testContext.getPageObjectManager().getContestPage();
	   Assert.assertTrue(contestPage.subscribeButtonIsDisplay());
	}

}
