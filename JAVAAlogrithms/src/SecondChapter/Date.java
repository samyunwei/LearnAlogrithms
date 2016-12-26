package SecondChapter;

public class Date implements Comparable<Date>{
	private final int day;
	private final int month;
	private final int year;
	
	public Date(int d,int m,int y)
	{
		day = d;
		month = m;
		year = y;
		
	}
	
	public int day()
	{
		return day;
	}
	
	public int month()
	{
		return month;
	}
	
	public int year()
	{
		return year;
	}
	
	
	@Override
	public int compareTo(Date that) {
		// TODO Auto-generated method stub
		if(this.year > that.year)
		{
			return +1;
		}
		if(this.year < that.year)
		{
			return -1;
		}
		if(this.month > that.month)
		{
			return +1;
		}
		if(this.month < that.month)
		{
			return -1;
		}
		if(this.day > that.day)
		{
			return +1;
		}
		if(this.day < that.day)
		{
			return -1;
		}
		return 0;
	}
	
	public String toString()
	{
		return month + "/" + day + "/" + year;
	}
}
