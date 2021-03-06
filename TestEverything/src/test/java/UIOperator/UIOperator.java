package UIOperator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverFactory.BaseTest;
import ObjectRepository.ObjectRepository;

public class UIOperator extends BaseTest
{
	public static WebElement getElement(WebElement element) 
	{
		WebElement webelement = null;
		try{
			webelement = element;
			return webelement;

		} catch (Exception e) 
		{
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		return webelement;
		
	}
	
	public static void setData(WebElement element,String value) 
	{
		getElement(element);
		element.sendKeys(value);
	}
	public static void clickElement(WebElement element) 
	{
		getElement(element);
		element.click();
	}
	public static void waitForElementToDisplay(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(element));	
	}
	public static void waitForPageTitleToBeLoaded()
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(ObjectRepository.BasePageTitle));
	}
	public static void actionClick(WebElement element) 
	{
		getElement(element);
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
	}
	
	
}
