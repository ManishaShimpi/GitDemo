package E2EPractiseProject;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import E2ETestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest extends BaseTest

{
	
	String productName = "ZARA COAT 3";
	String countryname = "India";
	@Test(dataProvider="getData",groups="purchaseorder")
	public void submitOrder(HashMap<String,String> input) throws InterruptedException, IOException
	{
	
		ProductCatalogue productcatalogue=landingPage.loginAction(input.get("email"),input.get("password"));
		List<WebElement> products=productcatalogue.getProdList();
		productcatalogue.addProdToCart(input.get("product"));
		CartPage cartpage = productcatalogue.goTOCartPage();	
		Thread.sleep(3000);
		Boolean match = cartpage.validateCartItems(input.get("product"));
		Assert.assertTrue(match);
		CheckOutPage chpge = cartpage.goTOCheckOutPage();
		chpge.selectCountry(countryname);	
		ConfirmationPage cnfpage = chpge.submitOrder();
		Assert.assertTrue(cnfpage.getmsg().equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
	}
	
	
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void orderHistoryTest()
	{
		ProductCatalogue productcatalogue=landingPage.loginAction("shimpimanisha21@gmail.com", "Password@123");
		OrderPage orderpage = productcatalogue.goTOOrderPage();
		Assert.assertTrue(orderpage.validateOrderItems(productName));
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		
		List<HashMap<String,String>> data= getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//E2Edata//purchaseOrder.json");
		return new Object[][]  {{data.get(0)}, {data.get(1) } };

	}
	//HashMap<String,String> map = new HashMap<String,String>();
	//map.put("email", "shimpimanisha21@gmail.com");
	//map.put("password","Password@123");
	//map.put("product", "ZARA COAT 3");
	
	//HashMap<String,String> map1 = new HashMap<String,String>();
	//map1.put("email", "vrshimpi5@gmail.com");
	//map1.put("password","Password@123");
	//map1.put("product", "ADIDAS ORIGINAL");
}
