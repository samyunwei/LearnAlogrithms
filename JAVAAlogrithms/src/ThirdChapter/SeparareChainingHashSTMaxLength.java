package ThirdChapter;

/**
 * Author:Sam
 * Mail:samyunwei@163.com
 * Create Time: 2017/4/1
 */
public class SeparareChainingHashSTMaxLength<Key, Value> {
    private int N;
    private int M;
    private int maxlen;
    private SequentialSearchST<Key, Value>[] st;
    private int[]primes;
    public SeparareChainingHashSTMaxLength() {
        this(997);
    }

    public SeparareChainingHashSTMaxLength(int M) {
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST<Key, Value>();
        }
    }


//    private int hash(Key key) {
//        return (key.hashCode() & 0x7fffffff) % M;
//    }

    public Value get(Key key) {
        return st[hash(key)].get(key);
    }

    public void put(Key key, Value val) {
        st[hash(key)].put(key, val);
        N++;
        if (st[hash(key)].getSize() >= maxlen) {
            resize(2 * M);
        }
    }

    public void delete(Key key) {
        st[hash(key)].delete(key);
        N--;
    }

    public void resize(int len) {
        SeparareChainingHashSTMaxLength<Key, Value> newone = new SeparareChainingHashSTMaxLength<Key, Value>(len);
        for (SequentialSearchST<Key, Value> thest : st) {
            for (Key thekey : thest.keys()) {
                newone.put(thekey, thest.get(thekey));
            }
        }
        newone.N = N;
    }


    private int hash(Key x){
        int t = x.hashCode() & 0x7fffffff;
        if(Math.log(M)< 26){
            t = t % primes[(int)Math.log(M) + 5];
        }
        return  t % M;
    }

}
