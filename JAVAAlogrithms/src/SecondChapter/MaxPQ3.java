package SecondChapter;

public class MaxPQ3<Key extends Comparable<Key>> {
	private Key[] pq;
	private int N = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public MaxPQ3(int max)
	{
		pq = (Key[])new Comparable[max];
	}
	
	public void insert(Key newone)
	{
		int index;
		for(index = 0;index<N;index++)
		{
			if(newone.compareTo(pq[index]) > 0)
			{
				index++;
			}else
			{
				break;
			}
		}
		for(int i = N+1;i >= index;i--)
		{
			pq[i] = pq[i-1];
		}
		pq[index] = newone;
	}
	
	
}
