package colabupmtest.steps;

import java.sql.Timestamp;
import java.util.Date;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import colabupmtest.pageobjects.MainPage;
import colabupmtest.pageobjects.UserRegistrationPage;
import colabupmtest.selenium.TestContext;

public class CreateUserSteps {
	private MainPage mainPage;
	
	private UserRegistrationPage registrationPage;
	private TestContext testContext;
	
	public CreateUserSteps(TestContext testContext) {
		this.testContext = testContext;
		this.mainPage = testContext.getPageObjectManager().getMainPage();
	}
	
	@Given("^the user registration page in spanish language$")
	public void the_user_registration_page_in_spanish_language(){
		mainPage.loadMainPage();
		mainPage.goToRegistrationPage();
		this.registrationPage = testContext.getPageObjectManager().getUserRegistrationPage();
	}

	@When("^the field Screen Name is not filled$")
	public void the_field_Screen_Name_is_not_filled(){
	    registrationPage.fillScreenName("");
	}

	@When("^the field email is filled with an valid email$")
	public void the_field_email_is_filled_with_an_valid_email() throws Throwable {
		 registrationPage.fillEmail(new Timestamp(new Date().getTime()).toString().replaceAll("\\.", "").replaceAll(":", "").replaceAll("-", "").replaceAll(" ", "")+"@gmail.com");
	}

	@When("^the field First Name is filled with a valid First Name$")
	public void the_field_First_Name_is_filled_with_a_valid_First_Name()  {
		 registrationPage.fillFirstName(new Timestamp(new Date().getTime()).toString());
	}

	@When("^the field Last Name is filled with a valid Last Name$")
	public void the_field_Last_Name_is_filled_with_a_valid_Last_Name(){
		registrationPage.fillLastName(new Timestamp(new Date().getTime()).toString());
	}

	@When("^the field Password is filled with a valid Password such as \"([^\"]*)\"$")
	public void the_field_Password_is_filled_with_a_valid_Password_such_as(String password)  {
		registrationPage.fillPassword(password);
	}

	@When("^the field Retype Password is filled with the same value that the field Password: \"([^\"]*)\"$")
	public void the_field_Retype_Password_is_filled_with_the_same_value_that_the_field_Password(String password){
		registrationPage.fillRetypePassword(password);
	}

	@When("^the field Country is filled with a valid country selection$")
	public void the_field_Country_is_filled_with_a_valid_country_selection()  {
	    registrationPage.selectCountry("Spain");
	}

	@When("^the field Short bio is filled with a short text such as \"([^\"]*)\"$")
	public void the_field_Short_bio_is_filled_with_a_short_text_such_as(String shortText)  {
		registrationPage.fillBio(shortText);
	}

	@When("^click on the button Create account$")
	public void click_on_the_button_Create_account() {
	    registrationPage.clickOnCreateAccount();
	}

	@Then("^a message appears under screen name field with the next text: \"([^\"]*)\"$")
	public void a_message_appears_under_screen_name_field_with_the_next_text(String errorMessage) {
		if (!errorMessage.equals("Ya existe un miembro con el mismo nombre de usuario.")) {
		String[] aux = errorMessage.split("\\.");
		String auxString= aux[1]+"."+aux[0]+".";
		System.out.println(auxString);
		System.out.println(errorMessage);
		System.out.println(registrationPage.getScreenNameErrorMessage());
	    Assert.assertTrue(errorMessage.equals(registrationPage.getScreenNameErrorMessage())||auxString.equals(registrationPage.getScreenNameErrorMessage()));
		}
		else {
			Assert.assertEquals(errorMessage,registrationPage.getScreenNameErrorMessage());
		}
	}

	@When("^the field Screen Name is filled with a name such as \"([^\"]*)\"$")
	public void the_field_Screen_Name_is_filled_with_a_name_such_as(String screenName) {
		registrationPage.fillScreenName(screenName+new Timestamp(new Date().getTime()).toString().replaceAll("\\.", "").replaceAll(":", "").replaceAll("-", "").replaceAll(" ", ""));
	}
	
	@When("^the field Screen Name is filled with a already used name such as \"([^\"]*)\"$")
	public void the_field_Screen_Name_is_filled_with_a_already_used_name_such_as(String screenName)  {
	   registrationPage.fillScreenName(screenName);
	}

	@When("^the field email is filled with an already used email such as \"([^\"]*)\"$")
	public void the_field_email_is_filled_with_an_already_used_email_such_as(String email)  {
	   registrationPage.fillEmail(email);
	}

	@When("^the field Screen Name is filled with a valid screen name$")
	public void the_field_Screen_Name_is_filled_with_a_valid_screen_name() {
		registrationPage.fillScreenName(new Timestamp(new Date().getTime()).toString().replaceAll("\\.", "").replaceAll(":", "").replaceAll("-", "").replaceAll(" ", ""));
	}

	@When("^the field Password is filled with an invalid Password such as \"([^\"]*)\"$")
	public void the_field_Password_is_filled_with_an_invalid_Password_such_as(String password) {
		
		registrationPage.fillPassword(password);
	}

	@When("^the field Country is not filled with a valid country selection$")
	public void the_field_Country_is_not_filled_with_a_valid_country_selection() throws Throwable {
		registrationPage.selectCountry("Select Country");
	}

	@Then("^a user is created$")
	public void a_user_is_created() {
		mainPage = new MainPage(this.registrationPage.getDriver());
		Assert.assertTrue(mainPage.checkUserLogedIn());
	}

	@When("^click on Terminos de uso$")
	public void click_on_Terminos_de_uso() {
		registrationPage.clickOnUseTerms();
	}



	@When("^click on Filosofia y politica comunitaria$")
	public void click_on_Filosof_a_y_pol_tica_comunitaria() {
		registrationPage.clickOnPhilosophyAndPolicy();
	}


	@Then("^a message appears under email field with: Por favor, introduzca su direccion de correo electronico.$")
	public void a_message_appears_under_email_field_with_the_next_text() {
		Assert.assertEquals("Por favor, introduzca su dirección de correo electrónico.", registrationPage.getEmailMessageError());
	}

	@Then("^a message appears under password field with: La contrasenia debe tener al menos 8 caracteres$")
	public void a_message_appears_under_password_field_with_the_next_text() {
		Assert.assertEquals("La contraseña debe tener al menos 8 caracteres", registrationPage.getPasswordMessageError());
	}

	@Then("^a message appears with the next text: Las contrasenias introducidas no coinciden.$")
	public void a_message_appears_with_the_next_text()  {
		
		Assert.assertEquals("Las contraseñas introducidas no coinciden.", registrationPage.getGeneralErrorMessage());

	}

	@Then("^a message appears under country field with the next text: \"([^\"]*)\"$")
	public void a_message_appears_under_country_field_with_the_next_text(String countryMessageError) {
		Assert.assertEquals(countryMessageError.replaceAll("pais", "país"), registrationPage.getCountryMessageError());

	}

	@Then("^a message appears under screen name with error format message$")
	public void a_message_appears_under_screen_name_with_error_format_message(){
	    Assert.assertEquals("tiene que corresponder a la expresión regular \"^[a-zA-Z0-9]*$\"", this.registrationPage.getScreenNameErrorMessage());
	}

	@Then("^a message appears under email field with: \"([^\"]*)\"\\.$")
	public void a_message_appears_under_email_field_with(String emailMessageError)  {
	  Assert.assertEquals(emailMessageError.replaceAll("direccion", "dirección").replaceAll("electronico", "electrónico"), registrationPage.getEmailMessageError());
	}
	@Then("^the user is redirect to \"([^\"]*)\"$")
	public void the_user_is_redirect_to(String path) {
	 Assert.assertEquals("https://pruebas.colab.upm.es"+path,this.registrationPage.getDriver().getCurrentUrl());
	}
	


}
