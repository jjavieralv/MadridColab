package colabupmtest.steps;

import org.junit.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import colabupmtest.pageobjects.ContestManagerPage;
import colabupmtest.pageobjects.EditionContestPage;
import colabupmtest.selenium.TestContext;

public class ProposalTemplateSteps {

	private int numTemplatesBeforeCreate;
	private int numTemplatesBeforeDelete;
	private ContestManagerPage contestManagerPage;
	private EditionContestPage editionContestPage;
	private String contestName;
	private String templateName;
	private String selectedTemplateName;
	private TestContext testContext;

	public ProposalTemplateSteps(TestContext testContext) {
		this.testContext = testContext;
		this.contestManagerPage = this.testContext.getPageObjectManager().getContestManagerPage();
	}
	
	@When ("^click on proposal template tab$")
	public void clickOnProposalTemplateTab() {
		this.contestManagerPage.goToProposalTemplates();
		
	}
	@When("^click on CREATE new template$")
	public void click_on_CREATE_new_template() throws Throwable {
		numTemplatesBeforeCreate=this.contestManagerPage.getNumTemplates();
		contestManagerPage.clickOnCreateNewTemplate();
	}

	@Then("^a new template is created$")
	public void a_new_template_is_created() throws Throwable {
		System.out.println((this.numTemplatesBeforeCreate+1)+","+this.contestManagerPage.getNumTemplates());
		Assert.assertTrue((this.numTemplatesBeforeCreate+1)== this.contestManagerPage.getNumTemplates());
	}

	@When("^select a existing template as \"([^\"]*)\"$")
	public void select_a_existing_template_as(String templateName) throws Throwable {
	
	  contestManagerPage.selectTemplate(templateName);
	  selectedTemplateName = contestManagerPage.getSelectedTemplateName();
	}

	@When("^change the name of the template to \"([^\"]*)\"$")
	public void change_the_name_of_the_template_to(String templateName) throws Throwable {
		this.templateName = templateName; 
		contestManagerPage.changeProposalTemplateName(templateName);
	}

	@When("^click on save template$")
	public void click_on_save_template() {
		contestManagerPage.clickOnSaveTemplate();
	}

	@Then("^the new name is \"([^\"]*)\"$")
	public void the_new_name_is(String templateName){
	    Assert.assertTrue(this.contestManagerPage.checkIfNameExistInTemplateOptions(templateName));
	}

	@When("^click on add section button$")
	public void click_on_add_section_button() {
	  contestManagerPage.clickOnAddSection();
	}

	@When("^select Text section in section type of new section$")
	public void select_Text_section_in_section_type_of_new_section() throws Throwable {
	   contestManagerPage.selectTextTypeInSectionType();
	}

	@When("^fill the field Title of new section with \"([^\"]*)\"$")
	public void fill_the_field_Title_of_new_section_with(String nameTitle) throws Throwable {
		  this.contestManagerPage.fillTitleField(nameTitle);
	}

	@When("^fill the field character limit with (\\d+)$")
	public void fill_the_field_character_limit_with(int characterLimit) throws Throwable {
	   this.contestManagerPage.fillLimitCharacterField(Integer.toString(characterLimit));
	}

	@When("^fill the field help text with \"([^\"]*)\"$")
	public void fill_the_field_help_text_with(String helpText) throws Throwable {
		  this.contestManagerPage.fillHelpField(helpText);

	}

	@When("^fill the field Default text with \"([^\"]*)\"$")
	public void fill_the_field_Default_text_with(String defaultText) throws Throwable {
		  this.contestManagerPage.fillDefaultTextField(defaultText);
	}

	@When("^link the proposal Example name Proposal Template to a contest$")
	public void link_the_proposal_Example_name_Proposal_Template_to_a_contest() throws Throwable {
	  this.contestManagerPage.goToContestsSection();
	  contestName = contestManagerPage.getNameOfContest(contestManagerPage.numberOfContest() - 1);
	this.contestManagerPage.clickOnContestToEdit(this.contestManagerPage.numberOfContest()-1);
	 editionContestPage =  this.testContext.getPageObjectManager().getEditionContestPage();
	 editionContestPage.selectProposalTemplate(selectedTemplateName);
	 editionContestPage.clickOnSaveChanges();

	 
	}

	@Then("^the proposal template for the contest include the new sections$")
	public void the_proposal_template_for_the_contest_include_the_new_sections() throws Throwable {
		editionContestPage.goToContestManagerPage();
		contestManagerPage = this.testContext.getPageObjectManager().getContestManagerPage();
		contestManagerPage.goToProposalTemplates();
		contestManagerPage.selectTemplate(selectedTemplateName);
		Assert.assertTrue(this.contestManagerPage.templateProposalHasLinkContest(contestName));
	}

	@When("^click on DELETE template$")
	public void click_on_DELETE_template() throws Throwable {
		numTemplatesBeforeDelete = this.contestManagerPage.getNumTemplates();
	    this.contestManagerPage.clickOnDelete();
	}

	@Then("^the template is deleted$")
	public void the_template_is_deleted() throws Throwable {
		Assert.assertTrue((numTemplatesBeforeDelete-1)==this.contestManagerPage.getNumTemplates());
	}


}
