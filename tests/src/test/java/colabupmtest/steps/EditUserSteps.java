package colabupmtest.steps;

import java.sql.Timestamp;
import java.util.Date;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import colabupmtest.pageobjects.MainPage;
import colabupmtest.pageobjects.ProfileEditionPage;
import colabupmtest.pageobjects.ProfilePage;
import colabupmtest.selenium.TestContext;

public class EditUserSteps {
	private MainPage mainPage;

	private ProfilePage profilePage;
	private ProfileEditionPage profileEditionPage;
	private String newName;
	private String newLastName;
	private String newCountry;
	private String newEmail;
	private TestContext testContext;
	public EditUserSteps(TestContext testContext) {
		this.testContext = testContext;
		mainPage = testContext.getPageObjectManager().getMainPage();

	}



	@Given("^he has accessed to edition profile page$")
	public void he_has_accessed_to_edition_profile_page()  {
		mainPage.goToProfilePage();
		profilePage = testContext.getPageObjectManager().getProfilePage();
		profilePage.goToProfileEditionPage();
		profileEditionPage = testContext.getPageObjectManager().getProfileEditionPage();
	}

	@When("^he change the name$")
	public void he_change_the_name()  {
		newName = new Timestamp(new Date().getTime()).toString().replaceAll(" ", "");
		profilePage = profileEditionPage.changeFirstName(newName);
	
	}

	@Then("^the name is changed in the profile page$")
	public void the_name_is_changed_in_the_profile_page()  {
		String[] aux = profilePage.getNameWithLastName().split(" ");
		String firstName = aux[0];
		Assert.assertEquals(newName, firstName);
	}

	@When("^he change the last name$")
	public void he_change_the_last_name()  {
		newLastName = new Timestamp(new Date().getTime()).toString().replaceAll(" ", "");
		profilePage = profileEditionPage.changeLastName(newLastName);
	}

	@Then("^the last name is changed in the profile page$")
	public void the_last_name_is_changed_in_the_profile_page()  {
		String[] aux = profilePage.getNameWithLastName().split(" ");
		String lastName = aux[1];
		Assert.assertEquals(newLastName, lastName);
	}

	@When("^he change the country$")
	public void he_change_the_country()  {
		newCountry = "AD";
		profilePage = profileEditionPage.changeCountry(newCountry);
	}

	@Then("^the country is changed in the profile page$")
	public void the_country_is_changed_in_the_profile_page()  {
		Assert.assertEquals("Andorra", profilePage.getCountry());
	}

	@When("^he fill the field Contrasenia actual with the actual password as \"([^\"]*)\"$")
	public void he_fill_the_field_Contrasenia_actual_with_the_actual_password_as(String currentPassword)  {
		profileEditionPage.fillCurrentPasswordField(currentPassword);
	}

	@When("^he fill the field Nueva contrasenia with \"([^\"]*)\"$")
	public void he_fill_the_field_Nueva_contrasenia_with(String newPassword)  {
		profileEditionPage.fillNewPasswordField(newPassword);
	}

	@When("^he fill the field Reescriba la nueva contrasela with \"([^\"]*)\"$")
	public void he_fill_the_field_Reescriba_la_nueva_contrasela_with(String newPassword)  {
		profileEditionPage.fillRetypePasswordField(newPassword);
	}

	@When("^click on Guardar$")
	public void click_on_Guardar()  {
		profileEditionPage.clickOnSave();
	}

	@When("^try to change the password to \"([^\"]*)\" again with the old password \"([^\"]*)\"$")
	public void try_to_change_the_password_again_with_the_old_password(String newPassword, String oldPassword)  {
		profilePage = testContext.getPageObjectManager().getProfilePage();
		profilePage.goToProfileEditionPage();
		profileEditionPage = testContext.getPageObjectManager().getProfileEditionPage();
		profileEditionPage.fillCurrentPasswordField(oldPassword);
		profileEditionPage.fillNewPasswordField(newPassword);
		profileEditionPage.fillRetypePasswordField(newPassword);
		profileEditionPage.clickOnSave();
	}



	@Then("^the password can be changed to \"([^\"]*)\" if use \"([^\"]*)\"$")
	public void the_password_can_be_changed_if_use(String newPassword, String oldPassword)  {
		profileEditionPage.fillCurrentPasswordField(oldPassword);
		profileEditionPage.fillNewPasswordField(newPassword);
		profileEditionPage.fillRetypePasswordField(newPassword);
		profileEditionPage.clickOnSave();
		profilePage=new ProfilePage(profileEditionPage.getDriver());
		Assert.assertEquals("Changes saved",profilePage.getAlertMessage());
	}

	@When("^he fill the field Nuevo correo electronico with a new email$")
	public void he_fill_the_field_Nuevo_correo_electronico_with_a_new_email()  {
		newEmail=new Timestamp(new Date().getTime()).toString().replaceAll(" ", "").replaceAll("\\.","").replaceAll(":", "")+"@gmail.com";
		profileEditionPage.fillNewEmailField(newEmail);
	}

	@Then("^the email is changed in the profile page$")
	public void the_email_is_changed_in_the_profile_page()  {
		Assert.assertEquals(newEmail, profilePage.getEmail());
	}

	@When("^he fill the field Nuevo correo electronico with an already exist mail such as \"([^\"]*)\"$")
	public void he_fill_the_field_Nuevo_correo_electronico_with_an_already_exist_mail_such_as(String email)
			 {
		profileEditionPage.fillNewEmailField(email);
	}


	@When("^he fill the field Contrasenia actual with an incorrect actual password as \"([^\"]*)\"$")
	public void he_fill_the_field_Contrasenia_actual_with_an_incorrect_actual_password_as(String password)
			 {
		profileEditionPage.fillCurrentPasswordField(password);
	}

	@When("^he fill the field Reescriba la nueva contrasenia with \"([^\"]*)\"$")
	public void he_fill_the_field_Reescriba_la_nueva_contrasenia_with(String password)  {
		profileEditionPage.fillRetypePasswordField(password);
	}

	@Then("^next message is shown: \"([^\"]*)\"$")
	public void next_message_is_shown(String message)  {
		if(message.equals("Password change failed: Current password is incorrect.")) {
			Assert.assertEquals(message, profileEditionPage.getMessageError());
		}
		else if (message.equals("Las contrasenias introducidas no coinciden.")) {
			Assert.assertEquals(message.replaceAll("contrasenias", "contraseñas"), profileEditionPage.getMessageError());
		}
		else if (message.equals("La contrasenia debe tener al menos 8 caracteres")) {
			Assert.assertEquals(message.replaceAll("contrasenia", "contraseña"), profileEditionPage.getMessageError());
		}
		else if (message.equals("Ya existe un miembro con la misma direccion de correo electronico.")) {
			Assert.assertEquals(message.replaceAll("direccion", "dirección").replaceAll("electronico", "electrónico"), profileEditionPage.getMessageError());

		}
	}

	@When("^he fill the field Contrasenia actual with actual password as \"([^\"]*)\"$")
	public void he_fill_the_field_Contrasenia_actual_with_actual_password_as(String password)  {
		profileEditionPage.fillCurrentPasswordField(password);
	}


	
}
