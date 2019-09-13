package colabupmtest.steps;


import colabupmtest.pageobjects.AboutPage;
import colabupmtest.pageobjects.ContentPage;
import colabupmtest.pageobjects.MainPage;
import colabupmtest.selenium.TestContext;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class AboutSteps {
	private MainPage mainPage;
	private AboutPage aboutPage;
	private ArrayList<String> sections;
	private ArrayList<String> sectionsInHowTo;
	private String contentHtml;
	private ContentPage contentPage;
	private TestContext testContext;
	
	public AboutSteps(TestContext testContext) {
		this.testContext = testContext;
		mainPage = testContext.getPageObjectManager().getMainPage();
	}
	
	@Given("^la pagina de informacion sobre la plataforma$")

	public void startAndGoToAbout() {
		mainPage.loadMainPage();
		mainPage.goToAbout();
	}

	@When("^se comprueban las secciones principales que contiene$")
	public void getSections() {
		aboutPage = this.testContext.getPageObjectManager().getAboutPage();
		sections = aboutPage.getSections();
	}
    @Then("^son Acerca de CoLab.upm, Origen ,Como funciona, Preguntas frecuentes, Personas, Promotores y Colaboradores, y Contacto$")
    public void checkIfSectionsAreOk(){
    	Assert.assertEquals(sections.get(0),"Acerca de CoLab.upm");
    	Assert.assertEquals(sections.get(1),"Origen");
    	Assert.assertEquals(sections.get(2),"¿Cómo funciona?");
    	Assert.assertEquals(sections.get(3),"Preguntas frecuentes");
    	Assert.assertEquals(sections.get(4),"Personas");
    	Assert.assertEquals(sections.get(5),"Promotores y Colaboradores");
    	Assert.assertEquals(sections.get(6),"Contacto");
    
    }  
    @When("^se comprueban las secciones dentro de la seccion Como funciona$")
   public void getSectionsInHowTo() {
		aboutPage=this.testContext.getPageObjectManager().getAboutPage();
    	sectionsInHowTo=aboutPage.getSectionsInHowTo();
    }
   @Then("^son Retos y Areas de trabajo y Participa$")
   public void checkIfSectionsInHowToAreCorrect() {
	   Assert.assertEquals(sectionsInHowTo.get(0), "Retos y Áreas de trabajo");
	   Assert.assertEquals(sectionsInHowTo.get(1), "Participa");
   }
    @When("^se comprueba el contenido de la seccion Acerca de Madrid CoLab$")
    public void getAboutHtml() {
		aboutPage=this.testContext.getPageObjectManager().getAboutPage();
    	this.contentHtml=aboutPage.getAboutContentHtml();
    }
  
    
    @When("^se comprueba el contenido de la seccion Origen$")
    public void getOriginHtmlHtml() {

		aboutPage=this.testContext.getPageObjectManager().getAboutPage();

		this.contentHtml=aboutPage.getOriginContentHtml();
    }
    
    @When("^se comprueba el contenido de la seccion Concursos y Area de trabajo$")
    public void getContestAndWorkSpaceHtml() {
		aboutPage=this.testContext.getPageObjectManager().getAboutPage();

		this.contentHtml=aboutPage.getContestAndWorkspacesContentHtml();
    }
    
    @When("^se comprueba el contenido de la seccion Participa$")
    public void getTakePartHtml() {
		aboutPage=this.testContext.getPageObjectManager().getAboutPage();

		this.contentHtml=aboutPage.getTakePartContentHtml();
    }
    
   
     
    @When("^se comprueba el contenido de la seccion Preguntas frecuentes$")
   public void frequentQuestionsHtml() {

		aboutPage=this.testContext.getPageObjectManager().getAboutPage();

		this.contentHtml=aboutPage.getFrequentQuestionsContentHtml();
    }
    

    @When("^se comprueba el contenido de la seccion Personas$")
    public void getPeopleHtml() {
		aboutPage=this.testContext.getPageObjectManager().getAboutPage();

		this.contentHtml=aboutPage.getPeopleContentHtml();
    }
  
    
    @When("^se comprueba el contenido de la seccion Equipo$")
    public void getTeamHtml() {
    	this.contentHtml=aboutPage.getTeamContentHtml();
    }
    
    @When("^se comprueba el contenido de la seccion Colaboradores$")
    public void getCollaboratorsHtml() {
		aboutPage=this.testContext.getPageObjectManager().getAboutPage();

		this.contentHtml=aboutPage.getCollaboratorsContentHtml();
    }
    
    @When("^se comprueba el contenido de la seccion Contacto$")
   public void getContactHtml() {

		aboutPage=this.testContext.getPageObjectManager().getAboutPage();

		this.contentHtml=aboutPage.getContactContentHtml();
    }
    @Then("^coincide con el del fichero \"([^\"]*)\"$")
    public void checkIfEqualsThatFile(String fileName) {
    	String htmlContentInFile = "";
    	  try {
        	  
    		  BufferedReader br = new BufferedReader(new InputStreamReader(
    				    new FileInputStream(".\\src\\test\\resources\\colabupmtest\\pageshtmldefinition\\"+fileName), "UTF-8"));
        	  
        	  String st; 
        	  
			while ((st = br.readLine()) != null) {
				htmlContentInFile = htmlContentInFile+st;
			  }
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
    	  System.out.println("-------------------------------------");
    	System.out.println(htmlContentInFile.replaceAll("\\n","").trim().replaceAll(">\\s*<","><"));
	    System.out.println(this.contentHtml.replaceAll("\\n", "").trim().replaceAll(">\\s*<","><"));
    	Assert.assertEquals(htmlContentInFile.replaceAll("\\n", "").trim().replaceAll(">\\s*<","><"), this.contentHtml.replaceAll("\\n", "").trim().replaceAll(">\\s*<","><"));
    }
    
    @Given("^la pagina de terminos de uso$")
    public void loadTermsOfUsePage(){

    	mainPage.goToUrl("http://pruebas.colab.upm.es/wiki/Terms+of+use");
    	contentPage = this.testContext.getPageObjectManager().getContentPage();
    }

    @When("^se comprueba el contenido$")
    public void checkContent(){
    	contentHtml = contentPage.getMainContentHtml();
    }

    @Given("^la pagina de normas de los concursos$")
    public void loadContestsRulesPage() {

    	mainPage.goToUrl("http://pruebas.colab.upm.es/wiki/Contest+rules");
    	contentPage = this.testContext.getPageObjectManager().getContentPage();
    }

    @Given("^la pagina politicas de privacidad$")
    public void loadPrivacyPolicyPage() {

    	mainPage.goToUrl("http://pruebas.colab.upm.es/wiki/Privacy+policy");
    	contentPage = this.testContext.getPageObjectManager().getContentPage();
    }

    @Given("^la pagina de filosofia y politicas comunes$")
    public void loadPhilosophyandCommonPoliticsPage()  {

    	mainPage.goToUrl("http://pruebas.colab.upm.es/wiki/Filosof%C3%ADa+y+Pol%C3%ADticas+Comunes");
    	contentPage = this.testContext.getPageObjectManager().getContentPage();
    }



    
}