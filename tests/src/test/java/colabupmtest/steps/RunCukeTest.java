package colabupmtest.steps;

import colabupmtest.selenium.FileReaderManager;


import cucumber.api.CucumberOptions;
import org.junit.Test;
import org.junit.runner.RunWith;
import cucumber.api.cli.Main;
import cucumber.api.junit.Cucumber;



import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/colabupmtest/features",
		glue = {"colabupmtest.steps"},
		tags = {"@regression"},
		plugin = {"html:target/cucumber"}
)

public class RunCukeTest{
//
//	@AfterClass
/*public static void writeExtentReport() {
	Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
   Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
   Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
   Reporter.setSystemInfo("Machine", "Windows 10" + " 64 Bit");
   Reporter.setSystemInfo("Selenium", "3.13.0");
   Reporter.setSystemInfo("Java Version", "1.8");
	}
@Test
	public void runFeatures() throws Throwable {
		Main.main(new String[]{"--threads", "8", "-p", "html:target/cucumber", "-g", "colabupmtest.steps", "-t", "@regression", "src/test/resources/colabupmtest/features/"});
}*/

}
