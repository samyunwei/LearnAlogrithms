package ThirdChapter;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;

/**
 * Author:Sam
 * Mail:samyunwei@163.com
 * Create Time: 2017/4/14
 */
public class HashSTint<Value> {
    private int N;
    private int M = 16;
    private int[] keys;
    private Value[] vals;

    public HashSTint() {
        keys =  new int[M];
        vals = (Value[]) new Object[M];
    }

    public HashSTint(int m) {
        M = m;
        keys = new int[M];
        vals = (Value[]) new Object[M];
    }

    private int hash(int key) {
        return (new Integer(key).hashCode() & 0x7fffffff) % M;
    }

    private void resize(int cap) {
        HashSTint<Value> t;
        t = new HashSTint<Value>(cap);
        for (int i = 0; i < M; i++) {
            if (keys[i] != 0) {
                t.put(keys[i], vals[i]);
            }
        }
        keys = t.keys;
        vals = t.vals;
        M = t.M;
    }

    public void put(int key, Value val) {
        if (N >= M / 2) resize(2 * M);
        int i;
        for (i = hash(key); keys[i] != 0; i = (i + 1) % M) {
            if (keys[i] == key) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public Value get(int key) {
        for (int i = hash(key); keys[i] != 0; i = (i + 1) % M) {
            if (keys[i] == key) {
                return vals[i];
            }
        }
        return null;
    }

    public boolean contains(int key) {
        return get(key) != null;
    }

    public int size() {
        return N;
    }

    public void delete(int key) {
        if (!contains(key)) {
            return;
        }
        int i = hash(key);
        while (!(key == keys[i])) {
            i = (i + 1) % M;
        }
        keys[i] = 0;
        vals[i] = null;
        i = (i + 1) % M;
        while (keys[i] != 0) {
            int keyToRedo = keys[i];
            Value valToRedo = vals[i];
            keys[i] = 0;
            vals[i] = null;
            N--;
            put(keyToRedo, valToRedo);
            i = (i + 1) % M;
        }
        N--;
        if (N > 0 && N == M / 8) {
            resize(M / 2);
        }
    }


    Iterable<Integer> keys() {
        ArrayList<Integer> reskeys = new ArrayList<Integer>();
        for (int i = 0; i < M; i++) {
            if (keys[i] != 0) {
                reskeys.add(keys[i]);
            }
        }
        return reskeys;
    }

    void showST() {
        for (int i = 0; i < M; i++) {
            if (keys[i] == 0) {
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
