package PMS;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

public static WebDriver driver;
public void Launch(String s)
{
System.setProperty("webdriver.chrome.driver", "D:\\Chrom\\chromedriver.exe");
driver =new ChromeDriver();	
driver.manage().window().maximize();
driver.get(s);
	
	
}

public String systemDate() {
	
	   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/dd/yyyy");  
	   LocalDateTime now = LocalDateTime.now(); 
	    String strDate = now.format(dtf);  
	    return strDate;

}



public void tab() throws  Exception {
Robot r =new Robot();
r.keyPress(KeyEvent.VK_TAB);
r.keyRelease(KeyEvent.VK_TAB);
r.delay(400);

}

public void space() throws Exception {

	Robot r =new Robot();
	r.keyPress(KeyEvent.VK_SPACE);
	r.keyRelease(KeyEvent.VK_SPACE);
	r.delay(400);

}	

public void loopTab(int k) throws Exception 
{
	BaseClass b = new BaseClass();

	for (int i=0; i<k; i++ ) 
	{
		b.tab();
	}

}

public void loopSpace(int k) throws Exception 
{
	BaseClass b = new BaseClass();

	for (int i=0; i<k;i++ ) 
	{
		b.space();

	}
}

public static String OutlookMailReader(String mailFolderName,String emailSubjectContent, String emailContent, int lengthOfOTP)
{
    String hostName = "smtp.office365.com";//change it according to your mail

    String username = "sanjayg1993@outlook.com";//username 

    String password = "Cyclone@1993";

    int messageCount;

    int unreadMsgCount;

    String emailSubject;

    Message emailMessage;

    String searchText=null ;

    Properties sysProps = System.getProperties();

    sysProps.setProperty("mail.store.protocol", "imaps");



    try {

        Session session = Session.getInstance(sysProps, null);

        Store store = session.getStore();

        store.connect(hostName, username, password);
        System.out.println("Sanjay");

        Folder emailBox = store.getFolder("Inbox");

        emailBox.open(Folder.READ_WRITE);

        messageCount = emailBox.getMessageCount();

        System.out.println("Total Message Count: " + messageCount);

        unreadMsgCount = emailBox.getNewMessageCount();

        System.out.println("Unread Emails count:" + unreadMsgCount);

        for(int i=messageCount; i>(messageCount-unreadMsgCount); i--)

        {

            emailMessage = emailBox.getMessage(i);

            emailSubject = emailMessage.getSubject();

            if(emailSubject.contains("Easy InnKeeping PMS Account Verification Code - Jordalae - Jordalae"))

            {

                System.out.println("OTP mail found");

                String line;

                StringBuffer buffer = new StringBuffer();

                BufferedReader reader = new BufferedReader(new InputStreamReader(emailMessage.getInputStream()));

                while ((line = reader.readLine()) != null) {

                    buffer.append(line);

                }

                String messageContent="Verification Code: ";

                String result = buffer.toString().substring(buffer.toString().indexOf(messageContent));

                searchText = result.substring(messageContent.length(), messageContent.length()+ 6);

                System.out.println("Text found : "+ searchText);

                emailMessage.setFlag(Flags.Flag.SEEN, true);

                break;

            }

            emailMessage.setFlag(Flags.Flag.SEEN, true);

        }

        emailBox.close(true);

        store.close();


    } catch (Exception mex) {

        mex.printStackTrace();

        System.out.println("OTP Not found ");

    }

     System.out.println(searchText);
	return searchText;
    

	        }


	
}
