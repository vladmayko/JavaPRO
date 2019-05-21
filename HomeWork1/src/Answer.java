import java.util.Arrays;

/**
 * Created by MacUser on 21.05.19.
 */
public class Answer {
    private static double cPlus;
    private static double java;
    private static double js;
    private static double cSharp;
    private double[] val = new double[4];

    public Answer() {
    }

    public static double getcPlus() {
        return cPlus;
    }

    public static void setcPlus(double cPlus) {
        Answer.cPlus = cPlus;
    }

    public static double getJava() {
        return java;
    }

    public static void setJava(double java) {
        Answer.java = java;
    }

    public static double getJs() {
        return js;
    }

    public static void setJs(double js) {
        Answer.js = js;
    }

    public static double getcSharp() {
        return cSharp;
    }

    public static void setcSharp(double cSharp) {
        Answer.cSharp = cSharp;
    }

    public double[] getVal() {
        return val;
    }

    public void setVal(double[] val) {
        this.val = val;
    }

    public double [] statistic(){
        double total = getcPlus() + getcSharp() + getJava() + getJs();
        val[0] = Math.round(getcPlus() / total * 1000) / 1000.0d * 100;
        val[1] = Math.round(getJava() / total * 1000) / 1000.0d * 100;
        val[2] = Math.round(getcSharp() / total * 1000) / 1000.0d * 100;
        val[3] = Math.round(getJs() / total * 1000) / 1000.0d * 100;
        return val;
    }
}
