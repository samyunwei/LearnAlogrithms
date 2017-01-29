package SecondChapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class CatchWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] test = {"after","thought","afterthought","cc","aftercc"};
//		search(test);
		String[] test = {"a","b","c","d","a","c","v"};
//		test = dedup(test);
//		for(int i =0;i<test.length;i++)
//		{
//			StdOut.println(test[i]);
//		}
		Frequency(test);
//		Integer[] test = {1,5,4,8,9,10};
//		StdRandom.shuffle(test);
//		StdOut.println(select(test,1,0,5));
		
	}
	
	
	
	public static void search(String[] words)
	{
		int len = words.length;
		if(len == 0 )
		{
			return;
		}
		Arrays.sort(words);
		String[] startlist = new String[len];
		for(int i = 0;i<len;i++)
		{
			startlist[i] = null;
		}
		for(int i =0;i <len;i++)
		{
			for(int j = 0;j<i;j++)
			{
				if(words[i].startsWith(words[j]))
				{
					startlist[i] =  words[i].substring(words[j].length(),words[i].length());
				}
			}
		}
		for(int i =0;i<len;i++)
		{
			if(startlist[i] != null)
			{
				if(Arrays.binarySearch(words,startlist[i]) != -1)
				{
					StdOut.println(words[i]);
				}
			}
		}
	}
	
	public static String[] dedup(String[]a)
	{
		HashMap<String,Boolean> thehash = new HashMap<>();
		int len = a.length;
		for(int i = 0;i<len;i++)
		{
			thehash.put(a[i],true);
		}
		ArrayList<String> res = new ArrayList<>();
		for(java.util.Map.Entry<String,Boolean> each:thehash.entrySet())
		{
			res.add(each.getKey());
		}
		String[] arrayres = new String[res.size()];
		for(int i = 0;i <res.size();i++)
		{
			arrayres[i] = res.get(i);
		}
		Arrays.sort(arrayres);
		return arrayres;
	}
	
	static public Comparable select(Comparable[] a,int k,int lo,int hi)
	{
		int j = partition(a, lo, hi);
		if(j == k)
		{
			return a[k];
		}else if(j > k)
		{
			select(a, k,lo,j-1);
		}else if(j < k)
		{
			select(a, k,j+1,hi);
		}	
		return a[k];
	}
	
	private static int partition(Comparable[]a ,int lo,int hi)
	{
		int i = lo,j= hi+1;
		Comparable v = a[lo];
		while(true)
		{
			while(less(a[++i],v))
			{

				if(i == hi)
				{
					break;
				}
			}
			while(less(v,a[--j]))
			{
				if(j == lo)
				{
					break;
				}
			}
			if(i >= j)
			{
				
				break;
			}
			exch(a,i,j);
		}
		exch(a,lo,j);
		return j;
	}
	
	private static boolean less(Comparable v,Comparable w)
	{
		return v.compareTo(w) < 0;
	}
	
	private static void exch(Comparable[] a,int i ,int j)
	{
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	
	static public void Frequency(String[] words)
	{
		HashMap<String,Integer> wordsMap = new HashMap<>();
		int len = words.length;
		for(int i = 0;i<len;i++)
		{
			if(wordsMap.containsKey(words[i]))
			{
				wordsMap.put(words[i],wordsMap.get(words[i])+1);
			}else
			{
				wordsMap.put(words[i],1);
			}
		}
		class wordsObj implements Comparable<wordsObj>
		{
			private String value;
			private Integer count;
			public wordsObj(String thevalue,int thecount)
			{
				value = thevalue;
				count = thecount;
			}
			@Override
			public int compareTo(wordsObj that) {
				// TODO Auto-generated method stub
				if(this == that)
				{
					return 0;
				}else
				{
					return this.count.compareTo(that.count);
				}
			}
			
			public String toString()
			{
				return value + ":" + count;
			}
		}
		wordsObj[] wordsList = new wordsObj[wordsMap.keySet().size()];
		int i = 0;
		for(java.util.Map.Entry<String, Integer> each :wordsMap.entrySet())
		{
			wordsList[i] = new wordsObj(each.getKey(),each.getValue());
			i++;
		}
		Arrays.sort(wordsList);
		for(wordsObj each :wordsList)
		{
			StdOut.println(each);
		}
			
	}
}
