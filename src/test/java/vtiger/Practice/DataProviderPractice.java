package vtiger.Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vtiger.GenericUtility.ExcelFileUtility;

public class DataProviderPractice {
@Test(dataProvider="OrgName")
	public void addProductToCartTest(String Orgname,String IndustryType)
	{
		System.out.println(Orgname+"-"+IndustryType);
	}
	

/*
@DataProvider(name="product")
public Object [][] data()
{
	Object[][] d=new Object[4][4];
	
	d[0][0]="samsung";
	d[0][1]="A80";
	d[0][2]=3000;
	d[0][3]="Camera";
	
	d[1][0]="Vivo";
	d[1][1]="A8";
	d[1][2]=300;
	d[1][3]="Camera";
	
	
	d[2][0]="Oppo";
	d[2][1]="v1";
	d[2][2]=3000;
	d[2][3]="Secure";
	
	d[3][0]="iphone";
	d[3][1]="I3Pro";
	d[3][2]=30009;
	d[3][3]="Secure";
	
	return d;
		
	}

}
*/
@DataProvider(name="OrgName")
public Object[][] getData() throws EncryptedDocumentException, IOException
{
	ExcelFileUtility eUil=new ExcelFileUtility();
	Object[][] data=eUil.readMultipeDataFromExcel("Multipleorg");
	return data;
}
}