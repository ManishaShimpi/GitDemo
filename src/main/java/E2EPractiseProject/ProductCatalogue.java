package E2EPractiseProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import E2EAbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents
{
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement Animation;
	
	By Product=By.cssSelector(".mb-3");
	By addProdcart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	
	
	public List<WebElement> getProdList()
	{
		waitForElementToAppear(Product);
		return products;
	}
	
	public WebElement getProdByName(String productname)
	{
		WebElement prod =	getProdList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProdToCart(String productname) throws InterruptedException
	{
		WebElement prod = getProdByName(productname);
		prod.findElement(addProdcart).click();
		waitForElementToAppear(toastMessage);
		waitForElementTodisAppear(Animation);
	}
	

}

