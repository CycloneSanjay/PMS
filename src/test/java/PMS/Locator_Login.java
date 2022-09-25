package PMS;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Locator_Login extends BaseClass{



public Locator_Login()
{
PageFactory.initElements(driver, this);
	
}	

@FindBy(xpath = "//*[@id=\"ShortName\"]")
private WebElement shortname;

@FindBy(xpath = "//*[@id=\"userid\"]")
private WebElement loginname;

@FindBy(xpath = "//*[@id=\"password\"]")
private WebElement password;

@FindBy(xpath = "//*[@id=\"Button1\"]")
private WebElement Login;

@FindBy (xpath = "//*[@id=\"LoginForm\"]/div[3]/div/div/div[1]/div[1]/div/label")
private WebElement Email;

@FindBy(xpath = "//*[@id=\"Next\"]")
private WebElement nextBtn;

@FindBy(xpath = "//*[@id=\"VerificationNumber\"]")
private WebElement otp;

@FindBy(xpath = "//*[@id=\"VerifyAccount\"]")
private WebElement verify;

public void sendShortname(String s)
{
shortname.sendKeys(s);	
}
public void loginname(String s)
{
loginname.sendKeys(s);	
}
public void password(String s)
{
password.sendKeys(s);	
}
public void Login() 
{
Login.click();
}

public void EmailChoose()
{
	Email.click();
}

public void nxt()
{
nextBtn.click();
	
}

public void otp(String string)
{
otp.sendKeys(string);
	
}

public void verify()
{
verify.click();	
}


}
