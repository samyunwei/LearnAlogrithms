package ThirdChapter;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;

/**
 * Author:Sam
 * Mail:samyunwei@163.com
 * Create Time: 2017/4/24
 */
public class LinearProbingHashMuliST<Key, Value> {
    private int N;
    private int M = 16;
    private Key[] keys;
    private ArrayList<Value>[] vals;

    public LinearProbingHashMuliST() {
        keys = (Key[]) new Object[M];
        vals = (ArrayList<Value>[]) new Object[M];
    }

    public LinearProbingHashMuliST(int m) {
        M = m;
        keys = (Key[]) new Object[M];
        vals = (ArrayList<Value>[]) new Object[M];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int cap) {
        LinearProbingHashMuliST<Key, Value> t;
        t = new LinearProbingHashMuliST<Key, Value>(cap);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                for(Value val :vals[i]){
                    t.put(keys[i], val);
                }

            }
        }
        keys = t.keys;
        vals = t.vals;
        M = t.M;
    }

    public void put(Key key, Value val) {
        if (N >= M / 2) resize(2 * M);
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                vals[i].add(val);
                return;
            }
        }
        keys[i] = key;
        vals[i] = new ArrayList<Value>();
        vals[i].add(val);
        N++;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                return vals[i].get(0);
            }
        }
        return null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public int size() {
        return N;
    }

    public void delete(Key key) {
        if (!contains(key)) {
            return;
        }
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % M;
        }
        keys[i] = null;
        vals[i] = null;
        i = (i + 1) % M;
        while (keys[i] != null) {
            Key keyToRedo = keys[i];
            ArrayList<Value> valToRedo = vals[i];
            keys[i] = null;
            vals[i] = null;
            N--;
            for(Value val :valToRedo){
                put(keyToRedo, val);
            }

            i = (i + 1) % M;
        }
        N--;
        if (N > 0 && N == M / 8) {
            resize(M / 2);
        }
    }


    Iterable<Key> keys() {
        ArrayList<Key> reskeys = new ArrayList<Key>();
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                reskeys.add(keys[i]);
            }
        }
        return reskeys;
    }

    void showST() {
        for (int i = 0; i < M; i++) {
            if (keys[i] == null) {
                StdOut.print(" Null ");
            } else {
                StdOut.print(" " + keys[i] + " ");
            }
        }
    }

    public boolean isEmpty(){
        return N == 0;
    }
}
