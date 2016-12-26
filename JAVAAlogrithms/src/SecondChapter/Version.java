package SecondChapter;

import edu.princeton.cs.algs4.StdOut;

public class Version implements Comparable<Version>{

	private String m_versionStr;
	private String[] m_verisonlist;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Version test = new Version("115.1.1");
		Version test2 = new Version("115.10.1");
		StdOut.print(test.compareTo(test2));
	}
	
	public Version(String theVesion)
	{
		m_versionStr = theVesion;
		m_verisonlist = m_versionStr.split(".");
	}
	
	@Override
	public int compareTo(Version that) {
		int thislen = m_verisonlist.length;
		int thatlen = that.m_verisonlist.length;
		if(thislen > thatlen)
		{
			for(int i = 0;i<thatlen;i++)
			{
				Integer a = Integer.parseInt(m_verisonlist[i]);
				Integer b = Integer.parseInt(that.m_verisonlist[i]);
				int res = a.compareTo(b);
				if(res != 0)
				{
					return res;
				}
			}
			return 1;
		}else if(thislen < thatlen)
		{
			for(int i = 0;i<thislen;i++)
			{
				Integer a = Integer.parseInt(m_verisonlist[i]);
				Integer b = Integer.parseInt(that.m_verisonlist[i]);
				int res = a.compareTo(b);
				if(res != 0)
				{
					return res;
				}
			}
			return -1;
		}else
		{
			for(int i = 0;i<thatlen;i++)
			{
				Integer a = Integer.parseInt(m_verisonlist[i]);
				Integer b = Integer.parseInt(that.m_verisonlist[i]);
				int res = a.compareTo(b);
				StdOut.print("a"+a+"b"+b);
				if(res != 0)
				{
					return res;
				}
			}
			StdOut.println("len equal");
			return 0;
		}
	}

}
