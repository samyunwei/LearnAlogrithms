package FirstChapter;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Whitelist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] w = {1,2,3,4,5,6};
		StaticSETofInts set = new StaticSETofInts(w);
		while(!StdIn.isEmpty())
		{
			int key = StdIn.readInt();
			if(!set.contains(key))
			{
				StdOut.println(key);
			}
		}
	}

}
