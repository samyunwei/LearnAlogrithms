package ThirdChapter;


/**
 * Author:Sam
 * Mail:samyunwei@163.com
 * Create Time: 2017/4/6
 */
public class SparseVector {
    private LinerProbingHashST<Integer,Double>st;

    public SparseVector() {
        this.st = new LinerProbingHashST<>();
    }

    public int size(){
        return st.size();
    }

    public void put(int i,double x){
        st.put(i,x);
    }

    public double get(int i){
        if(!st.contains(i)){
            return 0.0;
        }else{
            return st.get(i);
        }
    }

    public double dot(double[] that){
        double sum = 0.0;
        for(int i:st.keys()){
            sum += that[i] * this.get(i);
        }
        return sum;
    }


    public void sum(SparseVector other){
        for(int key:other.st.keys()){
            Double res = get(key) + other.get(key);
            if(res == 0){
                st.delete(key);
            }else{
                st.put(key,res);
            }
        }
    }
}
