package ThirdChapter;


/**
 * Author:Sam
 * Mail:samyunwei@163.com
 * Create Time: 2017/4/25
 */
public class SETMulti<Key extends Comparable<Key>> {
    private LinerProbingHashST<Key,Integer> m_container;

    public SETMulti() {
        m_container = new LinerProbingHashST<>();
    }

    public void add(Key key){
        m_container.put(key,new Integer(0));
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
