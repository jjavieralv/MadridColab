package colabupmtest.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import colabupmtest.enums.Context;
import colabupmtest.enums.DriverType;
import colabupmtest.pageobjects.AbstractPageObject;
import colabupmtest.pageobjects.ContestListPage;
import colabupmtest.pageobjects.ContestManagerPage;
import colabupmtest.pageobjects.ContestPage;
import colabupmtest.pageobjects.CreateProposalPage;
import colabupmtest.pageobjects.EditionContestPage;
import colabupmtest.pageobjects.MainPage;
import colabupmtest.pageobjects.ProposalDetailsPage;
import colabupmtest.selenium.PageObjectManager;
import colabupmtest.selenium.ScenarioContext;
import colabupmtest.selenium.TestContext;

public class ContestManagerUtils {
	private TestContext testContext;
	private MainPage mainPage;
	private ContestManagerPage contestManagerPage;
	private SimpleDateFormat format;
	private Calendar now;
	private String nameSchedule;
	private EditionContestPage editionContestPage;
	private String nameContest;
	private ContestPage contestPage;
	private CreateProposalPage createProposalPage;
	private ProposalDetailsPage proposalDetailsPage;
	private ContestListPage contestListPage;

	public ContestManagerUtils (TestContext testContext) {
		this.testContext = testContext;
	}
	
	public void createContestAndLaunch() {
		mainPage = this.testContext.getPageObjectManager().getMainPage();
		mainPage.loadMainPage();
		this.login("solmedo", "odemlo13", mainPage);
		mainPage.goToContestManagerPage();
		contestManagerPage = this.testContext.getPageObjectManager().getContestManagerPage();
		contestManagerPage.gotoScheduleTemplate();
		contestManagerPage.createScheduleTemplate();
		format = new SimpleDateFormat("MM/dd/yyy HH:mm");
		now = Calendar.getInstance();
		nameSchedule = "pruebaSchedule" + new Timestamp(new Date().getTime()).toString().replaceAll("\\.", "")
				.replaceAll(":", "").replaceAll("-", "").replaceAll(" ", "");
		this.testContext.getScenarioContext().setContext(Context.SCHEDULE_NAME, nameSchedule);
		contestManagerPage.initSecheduleTemplate(nameSchedule, now);
		contestManagerPage.goToContestsSection();
		contestManagerPage.clickOnCreateNewContestButton();
		contestManagerPage.editNewContest();
		editionContestPage = this.testContext.getPageObjectManager().getEditionContestPage();
		nameContest = "Prueba semifinalista" + new Timestamp(new Date().getTime()).toString().replaceAll("\\.", "")
				.replaceAll(":", "").replaceAll("-", "").replaceAll(" ", "");
		this.testContext.getScenarioContext().setContext(Context.CONTEST_NAME, nameContest);
		editionContestPage.changeTitle(nameContest);
		editionContestPage.selectScheduleTemplateByName(nameSchedule);
		editionContestPage.clickOnSaveChanges();
		editionContestPage.goToTeamSelectionPage();
		editionContestPage.addFellow("fellow");
		editionContestPage.addJudge("judge");
		editionContestPage.clickOnSaveTeamButton();
		editionContestPage.goToContestManagerPage();
		contestManagerPage = this.testContext.getPageObjectManager().getContestManagerPage();
		contestManagerPage.selectContestByName(nameContest);
		contestManagerPage.selectLaunchContestOption();
		contestManagerPage.clickOnSubmitButton();
		contestManagerPage.goToMainPage();
	}
	
	public void createNewProposal(String titulo) {
		mainPage = this.testContext.getPageObjectManager().getMainPage();
		mainPage.closeSession();
		this.login("member", "odemlo13", mainPage);

		this.goToContest(nameContest);
		contestPage = this.testContext.getPageObjectManager().getContestPage();
		contestPage.clickOnCreateNewProposal();
		createProposalPage = this.testContext.getPageObjectManager().getCreteProposalPage();
		createProposalPage.fillMandatoryFields(titulo, "Pitch");
		createProposalPage.clickOnSaveAndPublish();
		createProposalPage.acceptContestRules();
		this.proposalDetailsPage = testContext.getPageObjectManager().getProposalDetailsPage();
		proposalDetailsPage.goToMainPage();
		this.mainPage = this.testContext.getPageObjectManager().getMainPage();
		mainPage.closeSession();
	}
	
	public void updateSchedule(String phase) {

		mainPage.goToContestManagerPage();
		contestManagerPage = this.testContext.getPageObjectManager().getContestManagerPage();
		contestManagerPage.gotoScheduleTemplate();
		contestManagerPage.selectScheduleByName(nameSchedule);
		now = Calendar.getInstance();
		String dateString;
		System.out.println(now.getTime().getSeconds());
		if (50 <= now.getTime().getSeconds() && now.getTime().getSeconds() <= 59) {
			now.add(Calendar.MINUTE, 3);
		} else {
			now.add(Calendar.MINUTE, 2);
		}

		dateString = format.format(now.getTime());
		if(phase.equals("semi-finalist")) {
		contestManagerPage.changeScheduleSemiFinalistSelection(dateString);
		}
		else if (phase.equals("proposalRevision")) {
			contestManagerPage.changeScheduleProposalRevisionSelection(dateString);
		}
		else if (phase.equals("Ganadores Proximamente")) {
			contestManagerPage.changeScheduleCompleted(dateString);
		}
		else if (phase.equals("Voting Phase")) {
			contestManagerPage.changeScheduleVotingSelection(dateString);
		}
		contestManagerPage.saveSchedule();
		contestManagerPage.goToMainPage();
		
		//end update schedule
		mainPage = testContext.getPageObjectManager().getMainPage();
		mainPage.closeSession();
		//this.goToContest(nameContest);


	}
	public void login(String userName, String password, AbstractPageObject page) {
		page.clickEnter();
		page.insertValidUserAndPassword(userName, password);
		page.clickSubmmit();
	}

	public void goToContest(String nameContest) {
		mainPage.goToContest();
		contestListPage = this.testContext.getPageObjectManager().getContestListPage();
		contestListPage.clickOnContestByName(nameContest);
		//contestPage = this.testContext.getPageObjectManager().getContestPage();
	}

}
