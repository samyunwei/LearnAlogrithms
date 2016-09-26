package FirstChapter;

import java.util.Arrays;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class TwoSumFast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = In.readInts(args[0]);
		StdOut.print(count(a));
	}
	
	public static int count(int[]a )
	{
		Arrays.sort(a);
		int N = a.length;
		int cnt = 0;
		for(int i =0;i<N;i++)
		{
			if(BinarySearch.rank(-a[i], a) > i)
			{
				cnt++;
			}
		}
		return cnt;
	}
	


}
