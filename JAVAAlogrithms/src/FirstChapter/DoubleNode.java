package FirstChapter;

public class DoubleNode <Item> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private DoubleNode before;
	private DoubleNode next;
	private Item item;
	
	public DoubleNode(Item theitem) {
		// TODO Auto-generated constructor stub
		item = theitem;
	}
	
	
	public  void inserthead(DoubleNode x)
	{
		DoubleNode temp = before;
		while(temp.before != null)
		{
			temp = temp.before;
		}
		temp.before = x;
		x.next = temp;
	}
	
	public  void removehead(DoubleNode x)
	{
		DoubleNode temp = before;
		while(temp.before != null)
		{
			temp = temp.before;
		}
		temp.next.before = null;
		temp.next = null;
		temp.item = null;
		temp = null;
	}
	
	public void inserttail(DoubleNode x)
	{
		DoubleNode temp = next;
		while(temp.next != null)
		{
			temp = temp.next;
		}
		temp.next = x;
		x.before = temp;
	}
	
	public  void removetail(DoubleNode x)
	{
		DoubleNode temp = next;
		while(temp.next != null)
		{
			temp = temp.next;
		}
		temp.before.next = null;
		temp.before = null;
		x.item = null;
		temp = null;
	}
	
	public  void removeNode(DoubleNode x)
	{
		if(x.next != null)
		{
			x.next.before = x.before;
		}
		if(x.before != null)
		{
			x.before.next = x.next;
		}
		x.item = null;
		x = null;
	}
	
	public  void insertNodebefore(DoubleNode OpNode,DoubleNode x)
	{
		if(OpNode.before != null)
		{
			OpNode.before.next = x;
		}
		x.before = OpNode.before;
		OpNode.before = x;
		x.next = OpNode;
	}
	
	public void insertNodenext(DoubleNode OpNode,DoubleNode x)
	{
		if(OpNode.next != null)
		{
			OpNode.next.before = x;
		}
		x.next = OpNode.next;
		OpNode.next = x;
		x.before = OpNode;
	}
}
