package vtiger.GenericUtility;

import java.util.Date;
import java.util.Random;

/**
 * This class contains all the java specific generic methods
 * 
 */
public class javaUtility {
	// TODO Auto-generated method stub
	/**
	 * This method will generat random number number for every execution
	 * @return
	 */

		public int getRandomNumber()
		{
			Random r=new Random();
			int ran=r.nextInt(1000);
			return ran;
		
	}
		/**
		 * This method will generate the current and time in specific format
		 * @return
		 */
		public String getSystemDate()
		{
			Date date =new Date();
			String d=date.toString();
			return d;
			
		}
		
		public String getSystemDateInFormat()
		{
			Date d =new Date();
			String[] dArr =d.toString().split(" ");
			String date=dArr[2];
			String month=dArr[1];
			String year=dArr[5];
			String time=dArr[3].replace(":","-");
			String currentDateAndTime=date+" "+year+" "+time;
			return currentDateAndTime;
				
			
		}
		

}
