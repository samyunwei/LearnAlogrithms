package ThirdChapter;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

/**
 * Author:Sam
 * Mail:samyunwei@163.com
 * Create Time: 2017/1/31
 */
public class Practice31 {
    public static void main(String[] args) {
        //3.1.1
        String[] theGrades = {"A+","A","A-","B+","B","B-","C+","C","C-","D","F"};
        Double[] theMarks = {4.33,4.00,3.67,3.33,3.00,2.67,2.33,2.00,1.67,1.00,0.00};
        Double res = averageMarks(theGrades,theMarks);
        if(res != null){
            StdOut.println("average:" + " " + res);
        }
    }

    public static Double averageMarks(String[] theGrades,Double[] theMarks)
    {
        if(theGrades.length != theMarks.length)
        {
            return null;
        }
        ST<String,Double>CalcT = new ST<>();
        for(int i = 0;i < theGrades.length;i++)
        {
            CalcT.put(theGrades[i],theMarks[i]);
        }
        double sum = 0;
        int count = 0;
        for(String eachGrade:CalcT)
        {
            sum += CalcT.get(eachGrade);
            ++count;
        }
        return sum/count;
    }
}
