package Frame;

import java.io.File;
import java.io.IOException;

import com.sun.jna.platform.win32.Advapi32Util;
import static com.sun.jna.platform.win32.WinReg.HKEY_CURRENT_USER;

public class Utilitymethod {

	public static boolean fileExists(String strfilepath) {
		
		File strfile = new File(strfilepath);
		
		boolean blnfileExists = strfile.exists();
		
		return blnfileExists;	
		
	}
	
	public static void enableProtectedMode(){
		
		
	Advapi32Util.registrySetIntValue(HKEY_CURRENT_USER,
		"Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\1", "2500", 0);
	Advapi32Util.registrySetIntValue(HKEY_CURRENT_USER,
		"Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\2", "2500", 0);
	Advapi32Util.registrySetIntValue(HKEY_CURRENT_USER,
		"Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\3", "2500", 0);
	Advapi32Util.registrySetIntValue(HKEY_CURRENT_USER, 
		"Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\4", "2500", 0);
		
	}
	
	public static void closeBrowser() {
		
		
		try {
			Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
			Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
			Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
			Runtime.getRuntime().exec("taskkill /F /IM microsoftedge.exe");
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
			Runtime.getRuntime().exec("tsskkill /F /IM geckodriver.exe");
			Runtime.getRuntime().exec("taskkill /F /IM IEServerdriver.exe");
			Runtime.getRuntime().exec("taskkill /F /IM edgedriver");
		} catch (IOException e) {			
			System.out.println("Exception while closing the browsers.");
		}
	}

}
