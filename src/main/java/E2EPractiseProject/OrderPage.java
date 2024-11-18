package E2EPractiseProject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import E2EAbstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents
{
		WebDriver driver;
	
	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List <WebElement> orderpageProducts;
	
	
	public Boolean validateOrderItems(String productName)
	{
		Boolean match = orderpageProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	
	
}
