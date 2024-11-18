package E2EPractiseProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import E2EAbstractComponents.AbstractComponents;

public class ConfirmationPage extends AbstractComponents
{
WebDriver driver;
	
	public ConfirmationPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement msg;
	
	public String getmsg()
	{
		String msgconf = msg.getText();
		return msgconf;
	}

}
