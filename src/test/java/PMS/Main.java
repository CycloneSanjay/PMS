package PMS;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Main extends  Locator_Reservation {
	  Main m =new Main();

@BeforeTest
public void f() throws Exception {


	  m.Launch("https://gracebeta.com/PMSUI-SVN/");
	  Locator_Login l =new Locator_Login();
	  l.sendShortname("Jordalae");
	  l.loginname("Jordalae");
	  l.password("Jordalae@123");
	  l.Login();
	  l.EmailChoose();
	  l.nxt();
	  Thread.sleep(10000);
	  l.otp(BaseClass.OutlookMailReader("Inbox", "EasyInnkeeping PMS Account Verification Code - Jordalae - Jordalae", "Verification Code: ", 6));
	  l.verify();
	  Thread.sleep(1000);

  }
@Test(priority = 1)
void Reservation() throws AWTException, Exception
{
	  BaseClass b = new BaseClass();

	  driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	  driver.navigate().to("https://gracebeta.com/PMSUI-SVN/PMSUI-NG/list");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  Locator_Reservation lr= new Locator_Reservation();
	  Thread.sleep(5000);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  lr.addButton();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  Assert.assertEquals(b.systemDate(), lr.GetArrDate());
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	  b.loopTab(6);
	  b.loopSpace(2);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  b.loopTab(4);
	  b.loopSpace(1);
	  lr.getTotal();
	  lr.firstName("Selenium2");
	  lr.lastName("Test3");
	  lr.email("noemailsss@gracesoft.com");
	  lr.mobile("9874563210");
	  lr.address("no 20. Perunthalaivar Kamarajar Nagar");
	  lr.city("Chennai");
	  lr.state("Tamil Nadu");
	  lr.country("India");
	  lr.zip("6000096");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  lr.acctCode("106");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  b.loopTab(6);
	  b.loopSpace(1);
	  lr.getTotal();

}	  
	  
	  
	  
	  
  
}
