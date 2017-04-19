package ThirdChapter;

/**
 * Author:Sam
 * Mail:samyunwei@163.com
 * Create Time: 2017/4/20
 */
public class SparseVector2 {
    private STint<Double>st;

    public SparseVector2() {
        this.st = new STint<>();
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
}
