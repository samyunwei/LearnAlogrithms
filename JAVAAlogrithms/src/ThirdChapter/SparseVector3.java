package ThirdChapter;

/**
 * Author:Sam
 * Mail:samyunwei@163.com
 * Create Time: 2017/4/20
 */
public class SparseVector3 {
    private STdouble<Double>st;

    public SparseVector3() {
        this.st = new STdouble<>();
    }

    public int size(){
        return st.size();
    }

    public void put(double i,double x){
        st.put(i,x);
    }

    public double get(double i){
        if(!st.contains(i)){
            return 0.0;
        }else{
            return st.get(i);
        }
    }

    public double dot(double[] that){
        double sum = 0.0;
        for(Double i:st.keys()){
            sum += that[i.intValue()] * this.get(i);
        }
        return sum;
    }
}
