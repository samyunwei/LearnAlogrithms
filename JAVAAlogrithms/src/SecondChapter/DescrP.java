package SecondChapter;

import java.util.Arrays;
import java.util.HashMap;

import edu.princeton.cs.algs4.Heap;
import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.Shell;
import edu.princeton.cs.algs4.StdOut;

public class DescrP implements Comparable{

	
	private int m_initIndex;
	private Comparable m_value;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] test = {1,1,1,1,1,1,1};
		Integer[] res = getSortRes(test,"Heap");
		int len = res.length;
		for(int i =0;i<len;i++)
		{
			StdOut.print(res[i]+ " ");
		}
	}
	
	public DescrP(int index,Comparable thevalue)
	{
		m_initIndex = index;
		m_value = thevalue;
	}
	
	
	public static Integer[] getSortRes(Comparable[] a,String alg)
	{
		
		int len = a.length;
		DescrP[] temp = new DescrP[len];
		for(int i =0;i<len;i++)
		{
			temp[i] = new DescrP(i,a[i]);
		}
		Integer[] res = new Integer[len];
		if(alg.equals("Insertion"))
		{
			Insertion.sort(temp);
		}
		if(alg.equals("Selection"))
		{
				Selection.sort(temp);
		}
		if(alg.equals("Shell"))
		{
			Shell.sort(temp);
		}
		if(alg.equals("Merge"))
		{
			Merge.sort(temp);
		}
		if(alg.equals("Quick"))
		{
			Quick.sort(temp);
		}
		if(alg.equals("Heap"))
		{
			Heap.sort(temp);
		}
		
		for(int i =0;i<len;i++)
		{
			res[temp[i].m_initIndex] = i;
		}
		return res;
	}

	public int compareTo(DescrP that) {
		// TODO Auto-generated method stub
		return m_value.compareTo(that.m_value);
	}

	@Override
	public int compareTo(Object that) {
		// TODO Auto-generated method stub
		DescrP temp = (DescrP)that;
		m_value.compareTo(temp.m_value);
		return 0;
	}

}
