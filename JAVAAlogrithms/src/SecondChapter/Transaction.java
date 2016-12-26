package SecondChapter;

import java.util.Comparator;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.StdOut;
public class Transaction 
{
	private final String m_who;
	private final Date m_when;
	private final double m_amount;
	public Transaction(String who,Date date,double amount) {
		// TODO Auto-generated constructor stub
		m_who = who;
		m_when = new Date(date.month(),date.day(),date.year());
		m_amount = amount;
	}
	
	public String who()
	{
		return m_who;
	}
	
	public Date when()
	{
		return new Date(m_when.month(),m_when.day(),m_when.year());
	}
	
	public double amount()
	{
		return m_amount;
	}
	
	public boolean equals(Object x)
	{
		if(this == x)
		{
			return true;
		}
		if(x == null)
		{
			return false;
		}
		if(this.getClass() != x.getClass())
		{
			return false;
		}
		Transaction that = (Transaction) x;
		if(this.m_who != that.m_who)
		{
			return false;
		}
		
		if(!this.m_when.equals(that.m_when))
		{
			return false;
		}
		StdOut.println("111");
		if(this.m_amount != that.m_amount)
		{
			return false;
		}
		return true;
	}
	
	public static class WhoOrder implements Comparator<Transaction>
	{
		public int compare(Transaction v,Transaction w)
		{
			return v.who().compareTo(w.who());
		}
	}
	
	public static class WhenOrder implements Comparator<Transaction>
	{
		public int compare(Transaction v,Transaction w)
		{
			return v.when().compareTo(w.when());
		}
	}
	
	public static class HowMuchOrder implements Comparator<Transaction>
	{
		public int compare(Transaction v,Transaction w)
		{
			if(v.amount() < w.amount())
			{
				return -1;
			}
			if(v.amount() > w.amount())
			{
				return +1;
			}
			return 0;
		}
	}

}