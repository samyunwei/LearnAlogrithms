package ThirdChapter;

import java.util.ArrayList;

/**
 * Author:Sam
 * Mail:samyunwei@163.com
 * Create Time: 2017/2/4
 */
public class NoOrderedArrayST<Key, Value> {
    private int N;
    private Key[] keys;
    private Value[] vals;

    public NoOrderedArrayST(int theCapacity) {
        N = 0;
        keys = (Key[]) new Object[theCapacity];
        vals = (Value[]) new Object[theCapacity];
    }

    public void put(Key key, Value val) {
        for (int i = 0; i < N; i++) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[N] = key;
        vals[N] = val;
        ++N;
    }

    Value get(Key key) {
        for (int i = 0; i < N; i++) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }

    void delete(Key key) {
        for (int i = 0; i < N; i++) {
            if (keys[i].equals(key)) {
                keys[i] = null;
                vals[i] = null;
                for (int j = i; j < N; j++) {
                    keys[j] = keys[j + 1];
                    vals[j] = vals[j + 1];
                }
                --N;
                return;
            }
        }
    }

    boolean contains(Key key) {
        for (int i = 0; i < N; i++) {
            if (keys[i].equals(key)) {
                return true;
            }
        }
        return false;
    }

    boolean isempty() {
        return N == 0;
    }

    int size() {
        return N;
    }

    Iterable<Key> keys() {
        ArrayList<Key> reskeys = new ArrayList<Key>();
        for (int i = 0; i < N; i++) {
            reskeys.add(keys[i]);
        }
        return reskeys;
    }
}
