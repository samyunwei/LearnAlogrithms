package FirstChapter;


public class CircleQueue <Item>{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircleQueue<Integer> test = new CircleQueue<>();
		for(int i = 0;i<3;i++)
		{
			test.enqueue(i);
		}
		//test.showqueue();
		for(int i = 0;i<2 ;i++)
		{
			System.out.println(test.dequeue());
		}
	}
	private class Node
	{
		Item item;
		Node next;
	}
	private Node last;
	private int N;
	public void enqueue(Item item)
	{
		if(isEmpty())
		{
			last = new Node();
			last.item  = item;
			last.next = last;
			N++;
		}else
		{
			Node newNode = new Node();
			newNode.item = item;
			newNode.next = last.next;
			last.next = newNode;
			N++;
		}
	}
	
	public Item dequeue()
	{
		if (last == null) {
			return null;
		}
		if (last.next == last) {
			Item res = last.item;
			last = null;
			return res;
		}
		Node temp = last.next;
		while (temp.next != last) {
			temp = temp.next;
		}
		Item res = last.item;
		temp.next = last.next;
		last = temp;
		return res;
	}
	
	public boolean isEmpty()
	{
		return last == null;
	}
	
	public void showqueue()
	{
		Node temp = last.next;
		while(temp != last)
		{
			System.out.println(temp.item);
			temp = temp.next;
		}
		System.out.println(last.item);
	}
	
}
