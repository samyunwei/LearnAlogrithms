package FirstChapter;

import edu.princeton.cs.algs4.StdDraw;

public class VisualCounter {
	private final String m_name;
	private int m_count;
	private int m_max;
	private int m_N;
	private int m_opcount;
	public VisualCounter(String name,int N,int max)
	{
		m_name = name;
		m_count = 0;
		m_opcount = 0;
		m_max = max;
		m_N = N;
		
		
		//draw set
		StdDraw.setXscale(0,2*N);
		StdDraw.setYscale(0,2*max);
		StdDraw.setPenRadius(0.005);
	}
	
	public void add()
	{
		if(m_opcount == m_N|| m_count == m_max)
		{
			showcount();
			return;
		}else
		{
			m_count++;
			m_opcount++;
			showcount();
		}
	}
	
	public void sub()
	{
		if(m_opcount == m_N|| m_count == m_max)
		{
			showcount();
			return;
		}else
		{
			m_count--;
			m_opcount++;
			showcount();
		}
	}
	
	public void showcount()
	{
		StdDraw.point(m_opcount, m_count);
	}
}
