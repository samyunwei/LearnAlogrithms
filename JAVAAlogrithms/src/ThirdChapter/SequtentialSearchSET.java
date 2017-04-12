package ThirdChapter;

import java.util.ArrayList;

/**
 * Author:Sam
 * Mail:samyunwei@163.com
 * Create Time: 2017/4/13
 */
public class SequtentialSearchSET<Key> {
    private Node first;
    private int size;

    private class Node
    {
        Key key;
        Node next;

        public Node(Key key, Node next) {
            this.key = key;
            this.next = next;
        }

    }



    public void put(Key key)
    {
        for(Node x = first; x != null ; x= x.next)
        {
            if(key.equals(x.key)){
                return;
            }
        }
        first = new Node(key,first);
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
            if(temp.key.equals(key)){
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
