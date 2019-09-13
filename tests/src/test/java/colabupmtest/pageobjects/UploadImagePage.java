package colabupmtest.pageobjects;

import colabupmtest.selenium.FileReaderManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UploadImagePage extends AbstractPageObject{
	@FindBy(id="fileupload1Input")
	WebElement uploadInputCropImages;
	@FindBy(id="fileupload2Input")
	WebElement uploadInputImages;
	@FindBy(id="fileupload1ImageUrl")
	WebElement fileupload1ImageUrl;
	@FindBy(id="fileupload2ImageUrl")
	WebElement fileupload2ImageUrl;
	@FindBy(xpath="//*[@class='noty_message']/span")
	WebElement alertMessage;
	
	
	
	public UploadImagePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}





	public String getAlertMessage() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(alertMessage));
		return this.alertMessage.getText();
	}





	public void uploadDirectImage(String absolutePath) {
		this.uploadInputImages.sendKeys(absolutePath);
		
	}





	public int getWideImageUploadWithCropOption() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(fileupload1ImageUrl));
		this.fileupload1ImageUrl.click();
		return driver.findElement(By.tagName("img")).getSize().width;
	}





	public int getHighImageUploadWithCropOption() {

		return driver.findElement(By.tagName("img")).getSize().height;
	}





	public int getWideImageUploadWithoutCropOption() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(fileupload2ImageUrl));
		this.fileupload2ImageUrl.click();
		return driver.findElement(By.tagName("img")).getSize().width;
	}





	public int getHighImageUploadWithoutCropOption() {
		return driver.findElement(By.tagName("img")).getSize().height;
	}





	public void uploadCropImage(String absolutePath) {
		
		this.uploadInputCropImages.sendKeys(absolutePath);
		
	}





	public void loadUpdateImageTool() {
		String url = FileReaderManager.getInstance().getConfigReader().getWebUrl() +  "/content-editor/imageUpload";
		this.driver.get(url);
		//this.driver.get("http://pruebas.colab.upm.es/content-editor/imageUpload");
		//this.driver.get("localhost:18082/content-editor/imageUpload");
	}


}
