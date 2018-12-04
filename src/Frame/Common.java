package Frame;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common {

	public static void LaunchBrowser() {

		String browser = Parameterization.readProperty("browser");
		System.out.println(browser + " :Browser launched");

		switch (browser.toLowerCase()) {
		case "chrome":

			ChromeOptions chromeoptions = new ChromeOptions();
			chromeoptions.addArguments("--ignore-certificate-errors", "--disable-extensions", "--dns-prefetch-disable",
					"lang=en_US.UTF-8", "--new-window");
			chromeoptions.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			HashMap<String, Object> pref = new HashMap<>();
			pref.put("credentials_enable_service", false);
			pref.put("profile.password_manager_enabled", false);
			chromeoptions.setExperimentalOption("prefs", pref);
			Data.Common.driver = new ChromeDriver();
			Data.Common.driver.manage().window().maximize();
			String url = Parameterization.readProperty("URL");
			Data.Common.driver.get(url);
			break;
		case "firefox":

			FirefoxOptions ffo = new FirefoxOptions();
			ffo.addArguments("--ignore-certificate-errors", "--disable-extensions", "--dns-prefetch-disable",
					"lang=en_US.UTF-8", "--new-window");
			ffo.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			HashMap<String, Object> preff = new HashMap<>();
			preff.put("credentials_enable_service", false);
			preff.put("profile.password_manager_enabled", false);

			Data.Common.driver = new FirefoxDriver();
			/*
			 * String url = Parameterization.readProperty("URL"); System.out.println(url);
			 * Data.Common.driver.get(url);
			 */
			break;
		case "iedriver":
			InternetExplorerOptions ieo = new InternetExplorerOptions();
			ieo.ignoreZoomSettings();
			ieo.destructivelyEnsureCleanSession();
			ieo.introduceFlakinessByIgnoringSecurityDomains();

			Utilitymethod.enableProtectedMode();
			/*
			 * Data.Common.driver = new InternetExplorerDriver(); String url =
			 * Parameterization.readProperty("URL"); Data.Common.driver.get(url);
			 */
			break;
		default:
			System.out.println("invalid Browser");
			break;
		}
	}
	//*************************************
	public static void AppLaunchSuccess(String verify) {

		List<WebElement> fileds = Data.Common.driver.findElements(By.xpath(Parameterization.readProperty(verify)));
		if (fileds.size() == 0) {
			System.out.println("FAIL: Application launch Fail");
			System.exit(0);
		} else {
			System.out.println("PASS: Application launch success");
		}

	}
	//*************************************
	public static void ClickElements(String clk_elems) {

		List<WebElement> elems = Data.Common.driver.findElements(By.xpath(Parameterization.readProperty(clk_elems)));

		if (elems.size() != 0) {
			if (elems.get(0).isEnabled()) {
				System.out.println("Element is : " + elems.get(0).isEnabled());
				elems.get(0).click();
			} else {
				System.out.println("FAIL: Unable to click on the element on locator: " + clk_elems + " is disabled");
				System.exit(0);
			}
		} else {
			System.out.println("FAIL: Unable to click on the element on locator: " + clk_elems
					+ "as filed could not find in application");
			System.exit(0);
		}
		/*
		 * if(clk_elems.endsWith("_Xpath")) {
		 * Data.Common.driver.findElement(By.xpath(clk_elems)).click(); boolean clk =
		 * Data.Common.driver.findElement(By.xpath(clk_elems)).isEnabled();
		 * System.out.println("Element is Enabled: "+clk); }else
		 * if(clk_elems.endsWith("_Css")) {
		 * Data.Common.driver.findElement(By.cssSelector(clk_elems)).click(); boolean
		 * clk1 = Data.Common.driver.findElement(By.cssSelector(clk_elems)).isEnabled();
		 * System.out.println("Element is : "+clk1); }
		 */
	}
	//*************************************
	public static void window_Handle(String FrameHeader, String Confirm) {

		Data.Common.driver.switchTo().frame(Parameterization.readProperty(FrameHeader));
		List<WebElement> Frame_Elems = Data.Common.driver
				.findElements(By.xpath(Parameterization.readProperty(Confirm)));
		if (Frame_Elems.size() != 0) {
			System.out.println("PASS: Navigated to next frame");
		} else {
			System.out.println("FAIL: Not navigated to next frame");
		}
	}
	//*************************************
	public static void select(String strValue, String key) {

		WebElement ele = Data.Common.driver.findElement(By.xpath(Parameterization.readProperty(key)));
		ele.click();
		Select list = new Select(ele);
		int itemIndex = getItemIndexFromList(ele, strValue);

		if (itemIndex >= 0) {
			list.selectByIndex(itemIndex);

		} else {
			System.out.println("FAIL : " + strValue + "; the value " + strValue + " is not present in the listbox.");
			System.exit(0);
		}
	}
	//*************************************
	public static int getItemIndexFromList(WebElement ele, String strValue) {

		List<WebElement> options = ele.findElements(By.tagName("option"));
		for (int i = 0; i < options.size(); i++) {
			String srt = options.get(i).getText();
			System.out.println(srt);
		}
		int itemindex = -1;
		for (int i = 0; i < options.size(); i++) {
			String srt = options.get(i).getText();
			System.out.println(srt);
			if (srt.equalsIgnoreCase(strValue)) {
				itemindex = i;
				break;
			}
		}
		System.out.println(itemindex);
		return itemindex;
	}
	//*************************************
	public static void form_Eidt(String locator_path, String value) {

		List<WebElement> ele = Data.Common.driver.findElements(By.xpath((Parameterization.readProperty(locator_path))));

		if (ele.size() != 0) {

			if (ele.get(0).isEnabled()) {
				ele.get(0).clear();
				ele.get(0).sendKeys(Parameterization.readProperty(value));
			} else {
				System.out.println("FAIL : Unable to enter value: " + value + " : " + locator_path);
				System.exit(0);
			}
		} else {
			System.out.println("FAIL: Unable to enter " + value + " : " + locator_path);
			System.exit(0);
		}
	}
	//*************************************
	public static void waitMethod() {

		WebDriverWait wait = new WebDriverWait(Data.Common.driver, 20);
		wait.pollingEvery(Duration.ofMillis(200));
	}
//*************************************
	public static WebElement Wait_for_Element(By by){
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(Data.Common.driver, 30);
		wait.pollingEvery(Duration.ofMillis(300));
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return element;
	}
//******************Wrong code*******************
	public static void radioButton(By by, String strValue, String stemName) {
		
		List<WebElement> radio = Data.Common.driver.findElements(by);
		
		for(int i =0;i<radio.size();i++) {
			WebElement local_radio = radio.get(i);
			String value = local_radio.getAttribute("value");
//			System.out.println("radio values: " + value);
			if(value.equalsIgnoreCase(strValue)) {
				local_radio.click();
			}
		}		
	}
//*******************************************************
	public static void checkBoxButtons(By by, String str, String stepName) {
		
		List<WebElement>  checkBox = Data.Common.driver.findElements(by);
		for(int i =0;i<checkBox.size();i++) {
			WebElement checkElem = checkBox.get(i);
			String lab = checkElem.getAttribute("input");
			if(lab.equalsIgnoreCase(str)) {
				checkElem.click();
				break;
			}
		}
		
	}
}
