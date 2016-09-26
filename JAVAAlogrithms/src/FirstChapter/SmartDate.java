package FirstChapter;

import java.util.Arrays;
import java.util.Calendar;

import edu.princeton.cs.algs4.StdOut;

public class SmartDate extends edu.princeton.cs.algs4.Date 
{
	private static final int[] months31 = {1,3,5,7,8,10,12};
	private static final int[] moths30 = {4,6,9,11};
	private static final String[] weekdays ={"Sunday","Moday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
	public SmartDate(int m,int d,int y) throws Exception
	{
		super(m, d, y);
		if(!checkMonth(m) )
		{
			throw new Exception("Month error");
		}
		if(!checkDay(m, d, y))
		{
			throw new Exception("Day error");
		}
		
	}
	
	public static boolean checkMonth(int month)
	{
		if(0 < month && month < 13)
		{
			return true;
		}
		return false;
	}
	
	
	public static boolean checkDay(int month ,int day,int year)
	{
		if(Arrays.binarySearch(months31,month) != -1)
		{
			if(0 < day && day < 32)
			{
				return true;
			}else if(Arrays.binarySearch(moths30, month) != -1)
			{
				if(0 < day && day < 31)
				{
					return true;
				}
			}else if( (year % 4) == 0 && (year % 400) != 0)
			{
				if(0 < day && day < 30)
				{
					return true;
				}
			}else
			{
				if(0 < day && day < 29)
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public String DayofWeek()
	{
		Calendar date = Calendar.getInstance();
		date.setFirstDayOfWeek(Calendar.FRIDAY);
		date.set(Calendar.YEAR,year());
		date.set(Calendar.MONTH,month()-1);
		date.set(Calendar.DATE, day()-1);
		StdOut.println(date);
		StdOut.println(date.get(Calendar.DAY_OF_WEEK));
		int w = date.get(Calendar.DAY_OF_WEEK);
		if(w < 0)
		{
			w = 0;
		}
		return weekdays[w];
	}
}
