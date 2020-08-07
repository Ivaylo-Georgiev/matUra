package com.maturabg;

/**
 * Created by Ivaylo on 17-Sep-17.
 */

public class Question {
    private String mTitle;
    private String mA;
    private String mB;
    private String mC;
    private String mD;
    int mCorrectIndex;

    public Question (String title, String a, String b, String c, String d, int correctIndex){
        mTitle = title;
        mA = a;
        mB = b;
        mC = c;
        mD = d;
        mCorrectIndex=correctIndex;
    }


    public String getTitle() {
        return mTitle;
    }

    public String getA() {
        return mA;
    }

    public String getB() {
        return mB;
    }

    public String getC() {
        return mC;
    }

    public String getD() {
        return mD;
    }

    public int getCorrectIndex() {
        return mCorrectIndex;
    }
}
