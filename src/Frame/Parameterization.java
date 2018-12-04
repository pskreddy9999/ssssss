package Frame;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Parameterization {

	public static String readProperty(String propertyName) {

		String propertyPath = "Config.properties";
		String propertyValue = " ";

		if (Utilitymethod.fileExists(propertyPath)) {
			FileInputStream fi;
			try {
				fi = new FileInputStream(propertyPath);
				Properties pro = new Properties();
				pro.load(fi);

				propertyValue = pro.getProperty(propertyName);
				fi.close();

			} catch (FileNotFoundException e) {
				System.out.println("unable to read the file: " + propertyPath + " file not found");
			} catch (IOException e) {
				System.out.println("unable to read the file: " + propertyPath + " file not found");
			}
		}
		return propertyValue;
	}

}
