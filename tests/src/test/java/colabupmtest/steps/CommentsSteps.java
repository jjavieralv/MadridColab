package colabupmtest.steps;

import java.sql.Timestamp;
import java.util.Date;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import colabupmtest.pageobjects.CommunityPage;
import colabupmtest.pageobjects.ContestListPage;
import colabupmtest.pageobjects.ContestPage;
import colabupmtest.pageobjects.DiscussionPage;
import colabupmtest.pageobjects.MainPage;
import colabupmtest.pageobjects.ProposalDetailsPage;
import colabupmtest.selenium.TestContext;

public class CommentsSteps {
	
	private MainPage mainPage;
	private ContestListPage contestPageList;
	private ContestPage contestPage;
	private DiscussionPage discussionPage;
	private int numComments;;
	private String contestName;
	private String proposalName;
	private ProposalDetailsPage proposalDetailsPage;
	private String comment;
	private CommunityPage communityPage;
	private String newTitle;
	private TestContext testContext;

	public CommentsSteps(TestContext testContext) {		
		this.testContext = testContext;
		contestPageList = testContext.getPageObjectManager().getContestListPage();
		
	}
	@Given("^go to the contest details of \"([^\"]*)\"$")
	public void go_to_the_contest_details_of(String contestName) throws Throwable {
	
		 contestPageList.clickOnContestByName(contestName);
		 contestPage =   testContext.getPageObjectManager().getContestPage();
	}

	@When("^click on Discuss Button$")
	public void click_on_Discuss_Button() throws Throwable {
		contestPage.clickOnDiscuss();
		discussionPage = testContext.getPageObjectManager().getDiscussionPage();
	}

	@Then("^the comment section opens$")
	public void the_comment_section_opens() throws Throwable {

		if (discussionPage != null) {
			Assert.assertTrue(discussionPage.commentInputIsDisplay());
		} else if (proposalDetailsPage != null) {
			Assert.assertTrue(this.proposalDetailsPage.commentInputIsDisplay());
		} else {
			throw new Exception();
		}
	}

	@Then("^the advise message appear with the text \"([^\"]*)\"$")
	public void the_advise_message_appear_with_the_text(String message) throws Throwable {

		if (discussionPage != null) {
			Assert.assertTrue(message.equals(discussionPage.getAlertMessage()));
		} else if (proposalDetailsPage != null) {
			Assert.assertTrue(message.equals(proposalDetailsPage.getAlertMessage()));
		} else {
			throw new Exception();
		}

	}

	@Given("^go to any proposal details$")
	public void go_to_any_proposal_details() throws Throwable {


		contestName = contestPageList.getNameOfrandomContestWithProposals();
		System.out.println(contestName);
		contestPageList.clickOnContestByName(contestName);
		contestPage = testContext.getPageObjectManager().getContestPage();
		proposalName = contestPage.getNameOfRandomProposal();
		contestPage.clickOnProposalByName(proposalName);
		proposalDetailsPage = testContext.getPageObjectManager().getProposalDetailsPage();
	}

	@When("^click on comments tab$")
	public void click_on_comments_tab() throws Throwable {
		proposalDetailsPage.clickOnCommentTab();
	}

	@When("^Write a comment as \"([^\"]*)\"$")
	public void write_a_comment_as(String comment) throws Throwable {
		this.comment = comment + new Timestamp(new Date().getTime());
		if (discussionPage != null) {
			discussionPage.writeComment(this.comment);
		} else if (proposalDetailsPage != null) {
			proposalDetailsPage.writeComment(this.comment);
		} else {
			throw new Exception();
		}
	}

	@When("^click on add comment button$")
	public void click_on_add_comment_button() throws Throwable {

		if (discussionPage != null) {
			numComments = discussionPage.getComments();
			discussionPage.clickOnAddComment();
		} else if (proposalDetailsPage != null) {
			proposalDetailsPage.getComments();
			proposalDetailsPage.clickOnAddComment();
		} else {
			throw new Exception();
		}
	}

	@Then("^a signin form opens$")
	public void a_signin_form_opens() throws Throwable {

		if (discussionPage != null) {
			Assert.assertTrue(discussionPage.checkIfSignInFormDisplay());
		} else if (proposalDetailsPage != null) {
			Assert.assertTrue(proposalDetailsPage.checkIfSignInFormDisplay());
		} else {
			throw new Exception();
		}

	}

	

	@When("^click on delete comment link$")
	public void click_on_delete_comment_link() throws Throwable {

		if (discussionPage != null) {

			numComments = discussionPage.getComments();
			this.discussionPage.clickOnDeleteLink();
		} else if (proposalDetailsPage != null) {
			numComments = proposalDetailsPage.getComments();
			this.proposalDetailsPage.clickOnDeleteLink();
		} else {
			throw new Exception();
		}
	}

	@Then("^the new comment is deleted$")
	public void the_comment_is_deleted() throws Throwable {

		if (discussionPage != null) {
			Assert.assertTrue(!this.discussionPage.checkIfCommentExist(this.comment));
		} else if (proposalDetailsPage != null) {
			Assert.assertTrue(!this.proposalDetailsPage.checkIfCommentExist(this.comment));
		} else {
			throw new Exception();
		}
	}

	@Then("^the comment counter decrease in (\\d+)$")
	public void the_comment_counter_decrease_in_one(int x) throws Throwable {

		if (discussionPage != null) {
			Assert.assertTrue(this.numComments - x == discussionPage.getComments());
		} else if (proposalDetailsPage != null) {
			Assert.assertTrue(this.numComments - x == proposalDetailsPage.getComments());
		} else {
			throw new Exception();
		}
	}

	@Then("^comment counter increases in (\\d+)$")
	public void the_comment_counter_increase_in_one(int x) throws Throwable {

		if (discussionPage != null) {
			Assert.assertTrue(this.numComments + x == discussionPage.getComments());
		} else if (proposalDetailsPage != null) {
			Assert.assertTrue(this.numComments + x == proposalDetailsPage.getComments());
		} else {
			throw new Exception();
		}

	}

	@Then("^the autor name is \"([^\"]*)\"$")
	public void the_autor_name_is(String autorName) throws Throwable {
		if (discussionPage != null) {
			Assert.assertTrue(this.discussionPage.getAutorNameOfLastComment().equals(autorName));
		} else if (proposalDetailsPage != null) {
			Assert.assertTrue(this.proposalDetailsPage.getAutorNameOfLastComment().equals(autorName));
		} else {
			throw new Exception();
		}
	}

	@Then("^the comment is public$")
	public void the_comment_is_public() throws Throwable {
		if (discussionPage != null) {

		} else if (proposalDetailsPage != null) {

		} else {
			throw new Exception();
		}
	}

	@When("^click on edit link$")
	public void click_on_edit_link() throws Throwable {
		if (discussionPage != null) {
			discussionPage.clickOnEditLink();
		} else if (proposalDetailsPage != null) {
			proposalDetailsPage.clickOnEditLink();
		} else {
			throw new Exception();
		}
	}

	@Then("^the comment has changed$")
	public void the_comment_has_changed() throws Throwable {
		if (discussionPage != null) {
			Assert.assertTrue(discussionPage.checkIfCommentExist(comment));
		} else if (proposalDetailsPage != null) {
			Assert.assertTrue(proposalDetailsPage.checkIfCommentExist(comment));
		} else {
			throw new Exception();
		}
	}

	@And("^click on save$")
	public void click_on_save() throws Exception {
		if (discussionPage != null) {
			discussionPage.clickOnSaveButton();
		} else if (proposalDetailsPage != null) {
			proposalDetailsPage.clickOnSaveButton();
		} else {
			throw new Exception();
		}
	}
	
	@Given("^go to Community Section$")
	public void go_to_Community_Section() throws Throwable {
		this.mainPage = this.testContext.getPageObjectManager().getMainPage();
		mainPage.goToCommunity();
		communityPage = this.testContext.getPageObjectManager().getCommunityPage();
	}

	@Given("^click on discussion tab$")
	public void click_on_discussion_tab() throws Throwable {
		communityPage.clickOnDiscussionTab();
	}

	@When("^create new discussion$")
	public void create_new_discussion() throws Throwable {
		communityPage.clickOnCreateNewDiscussion();
	}

	@When("^select \"([^\"]*)\" as category$")
	public void select_as_category(String category) throws Throwable {
		communityPage.selectDiscussionCategory(category);
	}

	@When("^write a tittle$")
	public void write_a_tittle() throws Throwable {
		newTitle = "New Discussion" + new Timestamp(new Date().getTime()).toString().replaceAll("\\.", "")
				.replaceAll(":", "").replaceAll("-", "").replaceAll(" ", "");
		communityPage.writeNewTitle(newTitle);
	}

	@When("^write a comment$")
	public void write_a_comment() throws Throwable {
		communityPage.writeMessage("New Message");
	}

	@When("^click on add$")
	public void click_on_add() throws Throwable {
		communityPage.clickOnAdd();
	}

	@Then("^a discussion is created$")
	public void a_discussion_is_created() throws Throwable {
		communityPage.clickOnDiscussionLink();
		Assert.assertTrue(communityPage.existDiscussion(this.newTitle));
	}

	@Then("^is shown in \"([^\"]*)\" Section$")
	public void is_shown_in_Section(String discussionType) throws Throwable {
		this.communityPage.clickOnDiscussionTypeSection(discussionType);
		Assert.assertTrue(communityPage.existDiscussion(this.newTitle));
	}

	@After("@DeleteCommentAfterExecution")
	public void deleteAllComments() throws Exception {
		if (discussionPage != null) {
			discussionPage.clickOnAllDeleteLink();
		} else if (proposalDetailsPage != null) {
			proposalDetailsPage.clickOnAllDeleteLink();
		} else {
			throw new Exception();
		}
		
		
	}

}
