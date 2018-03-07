package SeleniumProj;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;


/**
 * Unit test for simple App.
 */
public class AppTest { 
@Test
public void launchInFirefoxTest() {
	System.setProperty("webdriver.gecko.driver","E:\\education\\doing\\testing\\selenium\\Java_selenium_workspace\\resourcesSelnium\\drivers\\geckodriver-v0.19.1-win64\\geckodriver.exe");
	//setting logs
	System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "E:\\education\\doing\\testing\\selenium\\Java_selenium_workspace\\eclipse_workspace\\logs\\drivers.log");
	//binary path for Firefox
	FirefoxOptions opts=new FirefoxOptions();
	//Setting path of browser exe
	opts.setBinary("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
	// page load strategy
	opts.setPageLoadStrategy(PageLoadStrategy.NONE);
	// selecting a profile
	ProfilesIni debug= new ProfilesIni();
	FirefoxProfile debugProf=debug.getProfile("DebuggingProfile");
	opts.setProfile(debugProf);
	//using proffile to manage notifications
	debugProf.setPreference("dom.webnotifications.enabled",false);
	//using proffile to manage certificates	
	debugProf.setAcceptUntrustedCertificates(true);
	debugProf.setAssumeUntrustedCertificateIssuer(false);
	
	//proxy serversettings if required
	/*debugProf.setPreference("network.proxy.type",1);
	debugProf.setPreference("network.proxy.socks","");
	debugProf.setPreference("network.proxy.socks_port",);
	*/
	//Profile to options
	opts.setProfile(debugProf);
	
	FirefoxDriver driver=new FirefoxDriver(opts);
	driver.get("http:/team-bhp.com");
	driver.quit();
	
}



@Test
public void launchInChromeTest() {
	System.setProperty("webdriver.chrome.driver","E:\\education\\doing\\testing\\selenium\\Java_selenium_workspace\\resourcesSelnium\\drivers\\chromedriver_win32\\chromedriver.exe");
	System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "E:\\education\\doing\\testing\\selenium\\Java_selenium_workspace\\eclipse_workspace\\logs\\chrome.log");
	ChromeOptions opts=new ChromeOptions();
	
	opts.addArguments("--disable-notifications");
	opts.addArguments("--disable-infobars");
	opts.addArguments("--start-maximaized");
	//opts.addArguments("user-data-dir=C:\\Users\\Navde\\AppData\\Local\\Google\\Chrome\\User Data\\");
	//opts.addArguments("");
	//opts.addArguments("");
	ChromeDriver driver=new ChromeDriver(opts);
	
	driver.get("http:/msn.com");
	driver.quit();
}


@Test
public void launchInIETest() {
	//setting path of driver
	System.setProperty("webdriver.ie.driver","E:\\education\\doing\\testing\\selenium\\Java_selenium_workspace\\resourcesSelnium\\drivers\\IEDriverServer_Win32_3.9.0\\IEDriverServer.exe");
	//setting log properties

	//setting xx properties
	
	InternetExplorerDriver driver=new InternetExplorerDriver();
	driver.get("http://www.msn.com/en-ca/");
	driver.quit();
}

//E:\education\doing\testing\selenium\Java_selenium_workspace\resourcesSelnium\drivers\MicrosoftWebDriver
@Test
public void launchInEdgeTest() {
	System.setProperty("webdriver.edge.driver","E:\\education\\doing\\testing\\selenium\\Java_selenium_workspace\\resourcesSelnium\\drivers\\MicrosoftWebDriver\\MicrosoftWebDriver.exe");
	EdgeDriver driver=new EdgeDriver();
	driver.get("http://www.msn.com/en-ca/");
	driver.quit();
}
}
