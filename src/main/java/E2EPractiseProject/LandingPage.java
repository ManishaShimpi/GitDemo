package E2EPractiseProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import E2EAbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents
{
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	//Page factory
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPwd;
	
	@FindBy(id="login")
	WebElement LoginBtn;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement ErrMessage;
	
	public ProductCatalogue loginAction(String Email, String Pwd)
	{
		userEmail.sendKeys(Email);
		userPwd.sendKeys(Pwd);
		LoginBtn.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;

	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrMsg()
	{
		waitForWebElementToAppear(ErrMessage);
		return ErrMessage.getText();
		
	}
	
}

