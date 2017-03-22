package ThirdChapter;

/**
 * Author:Sam
 * Mail:samyunwei@163.com
 * Create Time: 2017/3/23
 */
public class SeparateChainingHashSTCount<Key, Value> {
    private int N;

    private int M;

    private class CountVal {
        public Value val;
        public int N;

        public CountVal(Value val, int n) {
            this.val = val;
            N = n;
        }

        public Value getVal() {
            return val;
        }

        public int getN() {
            return N;
        }
    }

    private SequentialSearchST<Key, CountVal>[] st;

    public SeparateChainingHashSTCount() {
        this(997);
    }

    public SeparateChainingHashSTCount(int M) {
        this.M = M;
        st = (SequentialSearchST<Key, CountVal>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST<Key, CountVal>();
        }
    }


    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key) {
        return st[hash(key)].get(key).getVal();
    }

    public void put(Key key, Value val) {
        st[hash(key)].put(key, new CountVal(val, N));
    }

    public void clearByCount(int k) {
        for (SequentialSearchST<Key, CountVal> each : st) {
            for (Key thekey : each.keys()) {
                if (each.get(thekey).getN() < k) {
                    each.delete(thekey);
                }
            }
        }
    }
}
