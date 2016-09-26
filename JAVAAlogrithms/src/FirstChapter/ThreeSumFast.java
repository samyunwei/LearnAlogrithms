package FirstChapter;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class ThreeSumFast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int a[] = In.readInts(args[0]);
		StdOut.print(count(a));
	}
	
	public static int count(int[]a)
	{
		int N = a.length;
		int cnt = 0;
		for(int i = 0;i< N;i++)
		{
			for(int j = i+1;j< N;j++)
			{
				for(int k = j+1;k < N;k++)
				{
					if(BinarySearch.rank(-a[i]-a[j], a) >j)
					{
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
}
