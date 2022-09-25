package PMS;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Locator_Reservation extends Locator_Login {

	public Locator_Reservation() {
PageFactory.initElements(driver, this);

	}
	
	@FindBy (xpath="/html/body/app-root/app-layout/mat-drawer-container/mat-drawer-content/div/div/div[2]/mat-card/app-reservation-list/div[3]/div[1]/button[1]")
	private WebElement addButton;
	
	@FindBy(xpath = "//*[@id=\"mat-dialog-0\"]/app-reservation-header/div[2]/div/app-quick-reservation/div/div/div[1]/div/mat-card/app-regular-rooms/form/div/div[1]/div/div[1]/mat-form-field/div/div[1]/div[3]/mat-date-range-input/div/div[1]/span")
	private WebElement GetArrDate;
	
	public void addButton() 
	{
		addButton.click();
		
	}
	
	
	@FindBy(xpath="//input[@formcontrolname='firstName']")
	private WebElement firstName;
	
	public void firstName(String s) 
	{
		firstName.sendKeys(s);
	}

	
	@FindBy(xpath="//input[@formcontrolname='lastName']")
	private WebElement lastName;
	
	public void lastName(String s) 
	{
		lastName.sendKeys(s);
	}
	
	
	@FindBy(xpath="//input[@formcontrolname='email']")
	private WebElement eMail;
	
	public void email(String s) 
	{
		eMail.sendKeys(s);
	}

	@FindBy(xpath="//input[@formcontrolname='phone']")
	private WebElement mobile;
	
	public void mobile(String s) 
	{
		mobile.sendKeys(s);
	}
	
	
	@FindBy(xpath="//input[@formcontrolname='address']")
	private WebElement Address;
	
	public void address(String s) 
	{
		Address.sendKeys(s);
	}
	
	@FindBy(xpath="//input[@formcontrolname='city']")
	private WebElement city;
	
	public void city(String s) 
	{
		city.sendKeys(s);
	}
	
	@FindBy(xpath="//input[@formcontrolname='state']")
	private WebElement state;
	
	public void state(String s) 
	{
		state.sendKeys(s);
	}
	
	
	
	@FindBy(xpath="//input[@formcontrolname='country']")
	private WebElement country;
	
	public void country(String s) 
	{
		country.sendKeys(s);
	}
	
	@FindBy(xpath="//input[@formcontrolname='zip']")
	private WebElement zip;
	
	
	public void zip(String s) 
	{
		zip.sendKeys(s);
	}
	
	@FindBy(xpath="//input[@id='mat-input-12']")
	private WebElement acctCode;
	
	
	public void acctCode(String s) 
	{
		acctCode.sendKeys(s);
	}
	
	
	@FindBy(xpath="//*[@id=\"mat-dialog-0\"]/app-reservation-header/div[2]/div/app-quick-reservation/div/div/div[3]/div/button[1]')]/span")
	private WebElement saveBtn;
	
	
	public void saveBtn() 
	{
		saveBtn.click();
	}
	
	

	
	
	
	
	public List<String> getTotal()
	{
		List<WebElement> divs= driver.findElements(By.xpath("//div[@class='row']/div"));
				List<String> l1 = new ArrayList<String>();
				    for(WebElement e : divs){

				      l1.add(e.getText());
				      System.out.println(e.getText());
				    }
					return l1;
	}
	
	
	
	
	public String GetArrDate() {
		return GetArrDate.getAttribute("textContent");
		
		
	}
	
	
		
	
	
}
