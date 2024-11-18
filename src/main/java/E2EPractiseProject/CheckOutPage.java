package E2EPractiseProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import E2EAbstractComponents.AbstractComponents;

public class CheckOutPage extends AbstractComponents
{
WebDriver driver;
	
	public CheckOutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement Country;
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement selectcountry;
	
	By Element = By.cssSelector(".ta-results");
	
	public void selectCountry(String Countryname)
	{
		Actions a = new Actions(driver);
		a.sendKeys(Country, Countryname).build().perform();
		waitForElementToAppear(Element);
		selectcountry.click();
	}
	
	public ConfirmationPage submitOrder()
	{
		submit.click();
		return new ConfirmationPage(driver);

	}
}
