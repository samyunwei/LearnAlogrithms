package FirstChapter;

public class UF {
	private int[] id;
	private int count;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public UF(int N)
	{
		count = N;
		id = new int[N];
		for(int i = 0;i<N;i++)
		{
			id[i] = i;
		}
	}
	
	public int count()
	{
		return count;
	}
	
	public boolean connected(int p ,int q)
	{
		return find(p) == find(q);
	}
	
	public int find(int p)
	{
		return id[p];
	}
	
	public void union(int p ,int q)
	{
		int pID = find(p);
		int qID = find(q);
		if (pID == qID)
		{
			return;
		}
		for(int i =0;i<id.length;i++)
		{
			if(id[i] == pID)
			{
				id[i] = qID;
			}
		}
		count--;
	}
	
	private int find2(int p)
	{
		while(p != id[p])
		{
			p = id[p];
		}
		return p;
	}
	
	public void union2(int  p ,int q)
	{
		int pRoot = find2(p);
		int qRoot = find2(q);
		if(pRoot == qRoot)
		{
			return;
		}
		id[pRoot] = qRoot;
		count--;
	}
	
}
