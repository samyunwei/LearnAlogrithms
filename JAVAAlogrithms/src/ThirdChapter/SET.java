package ThirdChapter;

import com.sun.org.apache.xpath.internal.operations.Bool;
import edu.princeton.cs.algs4.ST;

/**
 * Author:Sam
 * Mail:samyunwei@163.com
 * Create Time: 2017/4/10
 */
public class SET<Key extends Comparable<Key>> {
    private ST<Key,Bool> m_container;

    public SET() {
        m_container = new ST<>();
    }

    public void add(Key key){
        m_container.put(key,new Bool());
    }

    public void delete(Key key){
        m_container.delete(key);
    }

    public boolean contains(Key key){
        return m_container.contains(key);
    }

    public boolean isEmpty(){
        return m_container.isEmpty();
    }


    public int size(){
        return m_container.size();
    }

    public String toString(){
        return m_container.toString();
    }

}
