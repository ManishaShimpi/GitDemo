package E2EPractiseProject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import E2EAbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents
{
		WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List <WebElement> cartProducts;
	
	@FindBy(css=".totalRow button")
	WebElement rowbtn;
	
	public Boolean validateCartItems(String productName)
	{
		Boolean match = cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckOutPage goTOCheckOutPage()
	{
		rowbtn.click();
		
		return new CheckOutPage(driver);
	
	}
	
}
