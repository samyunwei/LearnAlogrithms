package ThirdChapter;


import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.Point2D;


/**
 * Author:Sam
 * Mail:samyunwei@163.com
 * Create Time: 2017/4/2
 */
public class MakeHash {


    public int hashCode(Point2D p) {
        int hash = 17;
        hash = 31 * hash + new Double(p.x()).hashCode();
        hash = 31 * hash + new Double(p.y()).hashCode();
        hash = 31 * hash + new Double(p.r()).hashCode();
        return hash;
    }


    public int hashCode(Interval1D i1) {
        int hash = 17;
        hash = 31 * hash + new Double(i1.max()).hashCode();
        hash = 31 * hash + new Double(i1.min()).hashCode();
        hash = 31 * hash + new Double(i1.length()).hashCode();
        return hash;
    }

    public int hashCode(Interval2D i2) {
        int hash = 17;
        hash = 31 * hash + new Double(i2.hashCode()).hashCode();
        return hash;
    }


    public int hashCode(Date date) {
        int hash = 17;
        hash = 31 * hash + new Double(date.day()).hashCode();
        hash = 31 * hash + new Double(date.month()).hashCode();
        hash = 31 * hash + new Double(date.year()).hashCode();
        return hash;
    }
}
