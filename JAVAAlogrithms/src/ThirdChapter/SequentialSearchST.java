package ThirdChapter;
import java.util.Iterator;


/**
 * Author:Sam
 * Mail:samyunwei@163.com
 * Create Time: 2017/1/30
 */
public class SequentialSearchST<Key,Value>{
    private Node first;
    private int size;
    private class Node
    {
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }

    }

    public Value get(Key key){
        for (Node x = first;x != null ;x = x.next){
            if(key.equals(x.equals(x.key))){
                return x.val;
            }
        }
        return null;
    }

    public void put(Key key,Value val)
    {
        for(Node x = first; x != null ; x= x.next)
        {
            if(key.equals(x.key)){
                x.val = val;
                ++size;
                return;
            }
        }
        first = new Node(key,val,first);

    }

    public int getSize() {
        return size;
    }


    public Iterator<Key> keys(){
        return new Iterator<Key>() {
            Node m_current = null;

            @Override
            public boolean hasNext() {
                return m_current.next != null;
            }

            @Override
            public Key next() {
                if(m_current == null){
                    m_current = first;
                    return m_current.key;

                }else {
                    Key res = m_current.key;
                    m_current = m_current.next;
                    return res;
                }
            }
        };
    }


   public void delete(Key key)
   {
        Node last = null;
        for(Node temp = first;temp != null;temp = temp.next)
        {
            if(temp.val.equals(key)){
                last.next = temp.next;
                temp = null;
            }
            last = temp;
        }
   }
}
