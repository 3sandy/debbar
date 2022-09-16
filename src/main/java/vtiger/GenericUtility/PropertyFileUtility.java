package vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains generic methods to read data from property file
 * @author Chaita M
 *
 */

public class PropertyFileUtility {
	/**
	 * This method will read the specific key value from the property file
	 * @param key 
	 * @return
	 * @throws IOException
	 */

	public String readDataFromPropertyFile(String key) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream(ConstantsUtility.PropertyFilePath);
		Properties pobj=new Properties();
		pobj.load(fis);
		String value=pobj.getProperty(key);
		return value;
		

	}

}
