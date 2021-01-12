package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigFile {
	protected InputStream input = null;
	protected Properties prop = null;

	public ReadConfigFile() {
		try {
			System.out.println("----Starting to ReadConfigFile");
			input = ReadConfigFile.class.getClassLoader().getResourceAsStream(Constants.CONFIG_PROPERTIES_DIRECTORY);
			prop = new Properties();
			prop.load(input);
			System.out.println("----Finished ReadConfigFile");
		} catch (IOException e) {
			System.out.println("----Error at ReadConfigFile");
			e.printStackTrace();
		}
	}

	public String getBrowser() {
		if (prop.getProperty("browser") == null) {
			return "";
		}
		System.out.println("Browser");
			
		return prop.getProperty("browser");
	}
}