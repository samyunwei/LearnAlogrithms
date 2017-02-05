package ThirdChapter;
import java.util.ArrayList;
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

    public Value get(Key key)
    {
        for (Node x = first;x != null ;x = x.next){
            if(key.equals(x.key)){
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
                return;
            }
        }
        first = new Node(key,val,first);
        ++size;

    }

    public int getSize() {
        return size;
    }


    public Iterable<Key> keys(){
        ArrayList<Key> keys = new ArrayList<Key>();
        for(Node temp = first;temp != null;temp = temp.next){
            keys.add(temp.key);
        }
        return keys;
    }


   public void delete(Key key)
   {
        Node last = null;
        for(Node temp = first;temp != null;temp = temp.next)
        {
            if(temp.val.equals(key)){
                if (last != null) {
                    last.next = temp.next;
                }else{
                    first = temp.next;
                }
                temp = null;
            }
            last = temp;
        }
   }

   public boolean contains(Key key)
   {
       for (Node x = first;x != null ;x = x.next){
           if(key.equals(x.key)){
               return true;
           }
       }
       return false;
   }

}
