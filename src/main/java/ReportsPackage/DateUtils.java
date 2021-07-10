package ReportsPackage;

import java.util.Date;

public class DateUtils {

	public static String getTimeStamp() { 
	
	Date date= new Date();
	String datestring= date.toString().replaceAll(" ", "_");;
	//System.out.println(date);
	return date.toString().replaceAll(" ", "_");
	}
	}
