package ThirdChapter;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.StdOut;

import java.util.Objects;

/**
 * Author:Sam
 * Mail:samyunwei@163.com
 * Create Time: 2017/3/20
 */


public class Transaction {
    private final String m_who;
    private final Date m_when;
    private final double m_amount;

    public Transaction(String who, Date date, double amount) {
        m_who = who;
        m_when = new Date(date.month(), date.day(), date.year());
        m_amount = amount;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + m_who.hashCode();
        hash = 31 * hash + m_when.hashCode();
        hash = 31 * hash + ((Double) m_amount).hashCode();
        return hash;
    }

    public String who() {
        return m_who;
    }

    public Date when() {
        return new Date(m_when.month(), m_when.day(), m_when.year());
    }

    public double amount() {
        return m_amount;
    }

    public boolean equals(Object x) {
        if (this == x) {
            return true;
        }
        if (x == null) {
            return false;
        }
        if (this.getClass() != x.getClass()) {
            return false;
        }
        Transaction that = (Transaction) x;
        if (!Objects.equals(this.m_who, that.m_who)) {
            return false;
        }

        if (!this.m_when.equals(that.m_when)) {
            return false;
        }
        StdOut.println("111");
        return !(this.m_amount != that.m_amount);
    }

}