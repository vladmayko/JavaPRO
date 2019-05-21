import java.util.Arrays;

/**
 * Created by MacUser on 21.05.19.
 */
public class Answer {
    private static AtomicInteger cPlus;
    private static AtomicInteger java;
    private static AtomicInteger js;
    private static AtomicInteger cSharp;
    private AtomicDouble[] val = new AtomicDouble[4];

    public Answer() {
    }

    public static AtomicInteger getcPlus() {
        return cPlus;
    }

    public static void setcPlus(AtomicInteger cPlus) {
        Answer.cPlus = cPlus;
    }

    public static AtomicInteger getJava() {
        return java;
    }

    public static void setJava(AtomicInteger java) {
        Answer.java = java;
    }

    public static AtomicInteger getJs() {
        return js;
    }

    public static void setJs(AtomicInteger js) {
        Answer.js = js;
    }

    public static AtomicInteger getcSharp() {
        return cSharp;
    }

    public static void setcSharp(AtomicInteger cSharp) {
        Answer.cSharp = cSharp;
    }

    public AtomicDouble[] getVal() {
        return val;
    }

    public void setVal(AtomicDouble[] val) {
        this.val = val;
    }

    public AtomicDouble [] statistic(){
        double total = getcPlus() + getcSharp() + getJava() + getJs();
        val[0] = Math.round(getcPlus() / total * 1000) / 1000.0d * 100;
        val[1] = Math.round(getJava() / total * 1000) / 1000.0d * 100;
        val[2] = Math.round(getcSharp() / total * 1000) / 1000.0d * 100;
        val[3] = Math.round(getJs() / total * 1000) / 1000.0d * 100;
        return val;
    }
}
