package SecondChapter;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Transaction;

public class TopM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int M = Integer.parseInt(args[0]);
		StdOut.print(M);
		MinPQ<Transaction> pq = new MinPQ<Transaction>(M+1);
		int count = 0;
		while(StdIn.hasNextLine())
		{
			String a = StdIn.readLine();
			StdOut.println(a);
			pq.insert(new Transaction(a));
			if(pq.size() > M)
			{
				pq.delMin();
			}

		}
		
		Stack<Transaction>stack  = new Stack<Transaction>();
		while(!pq.isEmpty())
		{
			stack.push(pq.delMin());
		}
		for(Transaction t:stack)
		{
			StdOut.println(t);
		}
	}

}
