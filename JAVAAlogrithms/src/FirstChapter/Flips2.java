package FirstChapter;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Flips2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int T = 1000000;
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
		StdOut.println(tails);
		int d = heads.tally() - tails.tally();
		StdOut.println("delta: " + Math.abs(d));
		
	}
	
}


