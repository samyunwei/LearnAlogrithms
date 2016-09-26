package FirstChapter;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Flips {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Roll(100);
	}
	
	
	public static void Roll(int T)
	{
		Counter heads = new Counter("heads");
		Counter tails = new Counter("tails");
		for(int t = 0;t < T;t++)
		{
			if(StdRandom.bernoulli(0.5))
			{
				heads.increment();
			}else
			{
				tails.increment();
			}
		}
		StdOut.println(heads);
		StdOut.print(tails);
		int d = heads.tally() - tails.tally();
		StdOut.println("delta:" + Math.abs(d));
	}

}
