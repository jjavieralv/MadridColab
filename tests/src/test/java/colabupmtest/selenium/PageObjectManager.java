package colabupmtest.selenium;

import org.openqa.selenium.WebDriver;

import colabupmtest.pageobjects.AboutPage;
import colabupmtest.pageobjects.CommentComponent;
import colabupmtest.pageobjects.CommunityPage;
import colabupmtest.pageobjects.ContentPage;
import colabupmtest.pageobjects.ContestListPage;
import colabupmtest.pageobjects.ContestManagerPage;
import colabupmtest.pageobjects.ContestPage;
import colabupmtest.pageobjects.CreateProposalPage;
import colabupmtest.pageobjects.DeleteConfirmationPage;
import colabupmtest.pageobjects.DiscussionPage;
import colabupmtest.pageobjects.EditContestPreferencesPage;
import colabupmtest.pageobjects.EditionContestPage;
import colabupmtest.pageobjects.LightBoxLoginPage;
import colabupmtest.pageobjects.MainPage;
import colabupmtest.pageobjects.ProfileEditionPage;
import colabupmtest.pageobjects.ProfilePage;
import colabupmtest.pageobjects.ProposalDetailsPage;
import colabupmtest.pageobjects.SubscriptionsPage;
import colabupmtest.pageobjects.UploadImagePage;
import colabupmtest.pageobjects.UserRegistrationPage;

public class PageObjectManager {
	private WebDriver driver;
	private AboutPage aboutPage;
	private CommunityPage communityPage;
	private ContentPage contentPage;
	private ContestListPage contestListPage;
	private ContestManagerPage contestManagerPage;
	private ContestPage contestPage;
	private CreateProposalPage createProposalPage;
	private DeleteConfirmationPage deleteConfirmationPage;
	private DiscussionPage discussionPage;
	private EditContestPreferencesPage editContestPreferencesPage;
	private LightBoxLoginPage lightBoxLoginPage; // componente
	private CommentComponent commentComponent; // componente
	private MainPage mainPage;
	private ProfileEditionPage profileEditionPage;
	private ProfilePage profilePage;
	private ProposalDetailsPage proposalDetailsPage;
	private SubscriptionsPage subscriptionPage;
	private UserRegistrationPage userRegistrationPage;
	private EditionContestPage editionContestPage;
	private UploadImagePage uploadImagePage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public AboutPage getAboutPage() {
		return (aboutPage == null) ? new AboutPage(driver) : aboutPage;
	}

	public CommunityPage getCommunityPage() {
		return (communityPage == null) ? new CommunityPage(driver) : communityPage;
	}

	public ContentPage getContentPage() {
		return (contentPage == null) ? new ContentPage(driver) : contentPage;
	}

	public ContestListPage getContestListPage() {
		return (contestListPage == null) ? new ContestListPage(driver) : contestListPage;
	}

	public ContestManagerPage getContestManagerPage() {
		return (contestManagerPage == null) ? new ContestManagerPage(driver) : contestManagerPage;
	}

	public ContestPage getContestPage() {
		return (contestPage == null) ? new ContestPage(driver) : contestPage;
	}

	public CreateProposalPage getCreteProposalPage() {
		return (createProposalPage == null) ? new CreateProposalPage(driver) : createProposalPage;
	}

	public DeleteConfirmationPage getDeleteConfirmationPage() {
		return (deleteConfirmationPage == null) ? new DeleteConfirmationPage(driver) : deleteConfirmationPage;
	}

	public DiscussionPage getDiscussionPage() {
		return (discussionPage == null) ? new DiscussionPage(driver) : discussionPage;
	}

	public EditContestPreferencesPage getEditContestPreferencesPage() {
		return (editContestPreferencesPage == null) ? new EditContestPreferencesPage(driver)
				: editContestPreferencesPage;
	}

	public LightBoxLoginPage getLightBoxLoginPage() {
		return (lightBoxLoginPage == null) ? new LightBoxLoginPage(driver) : lightBoxLoginPage;
	}

	public CommentComponent getCommentComponent() {
		return (commentComponent == null) ? new CommentComponent(driver) : commentComponent;
	}

	public MainPage getMainPage() {
		return (mainPage == null) ? new MainPage(driver) : mainPage;
	}

	public ProfileEditionPage getProfileEditionPage() {
		return (profileEditionPage == null) ? new ProfileEditionPage(driver) : profileEditionPage;
	}

	public ProfilePage getProfilePage() {
		return (profilePage == null) ? new ProfilePage(driver) : profilePage;
	}

	public ProposalDetailsPage getProposalDetailsPage() {
		return (proposalDetailsPage == null) ? new ProposalDetailsPage(driver) : proposalDetailsPage;
	}

	public SubscriptionsPage getSubscriptionPage() {
		return (subscriptionPage == null) ? new SubscriptionsPage(driver) : subscriptionPage;
	}

	public UserRegistrationPage getUserRegistrationPage() {
		return (userRegistrationPage == null) ? new UserRegistrationPage(driver) : userRegistrationPage;
	}
	public EditionContestPage getEditionContestPage() {
		return (editionContestPage == null) ? new EditionContestPage(driver) : editionContestPage;
	}

	public UploadImagePage getUploadImagePage() {
		return (uploadImagePage == null) ? new UploadImagePage(driver) : uploadImagePage;
	}
}
