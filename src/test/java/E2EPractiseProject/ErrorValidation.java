package E2EPractiseProject;

import java.io.IOException;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import E2ETestComponents.*;


public class ErrorValidation extends BaseTest
{
	@Test(groups= {"ErrorHandling"},retryAnalyzer=E2ETestComponents.Retryonce.class)
	public void loginErrorValidation() throws InterruptedException, IOException
	{
		String productName = "ZARA COAT 3";
		String countryname = "India";
		landingPage.loginAction("shimpimanisha@gmail.com", "Password");
		
		Assert.assertEquals("Incorrect email password.", landingPage.getErrMsg());
	}
	

	@Test
	public void prodErrValidation() throws InterruptedException, IOException
	{
		String productName = "ZARA COAT 3";
		ProductCatalogue productcatalogue=landingPage.loginAction("vrshimpi5@gmail.com", "Password@123");
		List<WebElement> products=productcatalogue.getProdList();
		productcatalogue.addProdToCart(productName);
		CartPage cartpage = productcatalogue.goTOCartPage();	
		Boolean match = cartpage.validateCartItems("ZARA COAT 33");
		Assert.assertFalse(match);
	}
	
	
}
