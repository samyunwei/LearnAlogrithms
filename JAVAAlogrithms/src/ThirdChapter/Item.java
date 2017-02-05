package ThirdChapter;

/**
 * Author:Sam
 * Mail:samyunwei@163.com
 * Create Time: 2017/2/6
 */
public class Item<Key extends Comparable<Key>, Value> implements Comparable<Key> {
    private Key key;
    private Value val;

    public Item(Key key, Value val) {
        this.key = key;
        this.val = val;
    }

    public Key getKey() {
        return key;
    }

    public Value getVal() {
        return val;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public void setVal(Value val) {
        this.val = val;
    }

    @Override
    public int compareTo(Key key) {
        return key.compareTo(key);
    }
}
