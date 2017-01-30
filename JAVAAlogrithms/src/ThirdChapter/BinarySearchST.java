package ThirdChapter;

import java.util.Objects;

/**
 * Author:Sam
 * Mail:samyunwei@163.com
 * Create Time: 2017/1/30
 */
public class BinarySearchST<Key extends Comparable<Key>,Value> {
    private Key[] keys;
    private Value[] vals;
    private int N;



    public BinarySearchST(int capacity) {
        N = 0;
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public void resize(int max)
    {
        Key[] tempkeys = (Key[]) new Comparable[max];
        Value[] temvals = (Value[]) new Object[max];
        for(int i = 0;i < N;i++)
        {
            tempkeys[i] = keys[i];
            temvals[i] = vals[i];
        }
        keys = tempkeys;
        vals = temvals;
    }

    public int size()
    {
        return N;
    }

    public Value get(Key key){
        if(isEmpty()){
            return null;
        }
        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0){
            return vals[i];
        }else{
            return null;
        }
    }

    public boolean isEmpty(){
        return N == 0;
    }


    public int rank(Key key)
    {
       int lo = 0,hi = N -1;
       while(lo <= hi){
           int mid = lo + (hi -lo) / 2;
           int cmp = key.compareTo(keys[mid]);
           if(cmp < 0){
               hi = mid - 1;
           }else if(cmp > 0){
               lo = mid + 1;
           }else {
               return mid;
           }
       }
       return lo;
    }

    public void put(Key key,Value val)
    {
        if(N == keys.length){
            resize(2 * keys.length);
        }
        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0){
            vals[i] = val;
            return;
        }
        for(int j = N;j > i;j--)
        {
            keys[j] = keys[j - 1];
            vals[j] = vals[j -1];
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public void delete(Key key)
    {
        int i = rank(key);
        if(i == N)
        {
            return;
        }
        keys[i] = null;
        vals[i] = null;
        for(int j = i;j < N;j++)
        {
            keys[j] = keys[j+1];
            vals[j] = vals[j+1];
        }
        --N;
        if(N > 0 && N == keys.length / 4){
            resize(keys.length / 2);
        }
    }

}
