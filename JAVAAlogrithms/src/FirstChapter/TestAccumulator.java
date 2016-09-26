package FirstChapter;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class TestAccumulator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int T = 5000;
		//Accumulator a = new Accumulator();
		VisualAccumulator a = new VisualAccumulator(T, 1.0);
		for(int t = 0;t < T;t++)
		{
			a.addDataValue(StdRandom.random());
		}
		StdOut.println(a);
	}

}
