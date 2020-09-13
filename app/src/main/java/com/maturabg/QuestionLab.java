package com.maturabg;

import android.content.Context;
import android.content.res.Resources;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ivaylo on 22-Sep-17.
 */

public class QuestionLab {
    private ArrayList<Question> mQuestions;
    private Random randomOptionIndex = new Random();
    private String[] options = {
            "_08_19",
            "_05_19",
            "_05_18",
            "_05_17",
            "_08_17",
            "_08_16",
            "_05_16",
            "_08_15",
            "_05_15",
            "_08_14",
            "_05_14",
            "_08_13",
            "_05_13",
            "_08_12",
            "_05_12"
    };
    private static QuestionLab sQuestionLab;
    private Context mAppContext;
    Resources res;

    private QuestionLab(Context appContext) {
        mAppContext = appContext;

        }

    public static QuestionLab get(Context c) {
        if (sQuestionLab == null) {
            sQuestionLab = new QuestionLab(c.getApplicationContext());
        }
        return sQuestionLab;
    }

    public void initializeQuestions(){
        mQuestions = new ArrayList<Question>();
        res = mAppContext.getResources();

        String[][] questionArr = new String[22][6];
        questionArr[0] = res.getStringArray(res.getIdentifier("first"+options[randomOptionIndex.nextInt(options.length)], "array", "studio.changer.game.quizbgl"));
        questionArr[1] = res.getStringArray(res.getIdentifier("second"+options[randomOptionIndex.nextInt(options.length)], "array", "studio.changer.game.quizbgl"));
        questionArr[2] = res.getStringArray(res.getIdentifier("third"+options[randomOptionIndex.nextInt(options.length)], "array", "studio.changer.game.quizbgl"));
        questionArr[3] = res.getStringArray(res.getIdentifier("fourth"+options[randomOptionIndex.nextInt(options.length)], "array", "studio.changer.game.quizbgl"));
        questionArr[4] = res.getStringArray(res.getIdentifier("fifth"+options[randomOptionIndex.nextInt(options.length)], "array", "studio.changer.game.quizbgl"));
        questionArr[5] = res.getStringArray(res.getIdentifier("sixth"+options[randomOptionIndex.nextInt(options.length)], "array", "studio.changer.game.quizbgl"));
        questionArr[6] = res.getStringArray(res.getIdentifier("seventh"+options[randomOptionIndex.nextInt(options.length)], "array", "studio.changer.game.quizbgl"));
        questionArr[7] = res.getStringArray(res.getIdentifier("eighth"+options[randomOptionIndex.nextInt(options.length)], "array", "studio.changer.game.quizbgl"));
        questionArr[8] = res.getStringArray(res.getIdentifier("ninth"+options[randomOptionIndex.nextInt(options.length)], "array", "studio.changer.game.quizbgl"));
        questionArr[9] = res.getStringArray(res.getIdentifier("tenth"+options[randomOptionIndex.nextInt(options.length)], "array", "studio.changer.game.quizbgl"));
        questionArr[10] = res.getStringArray(res.getIdentifier("eleventh"+options[randomOptionIndex.nextInt(options.length)], "array", "studio.changer.game.quizbgl"));
        questionArr[11] = res.getStringArray(res.getIdentifier("twelfth"+options[randomOptionIndex.nextInt(options.length)], "array", "studio.changer.game.quizbgl"));
        questionArr[12] = res.getStringArray(res.getIdentifier("thirteenth"+options[randomOptionIndex.nextInt(options.length)], "array", "studio.changer.game.quizbgl"));
        questionArr[13] = res.getStringArray(res.getIdentifier("fourteenth"+options[randomOptionIndex.nextInt(options.length)], "array", "studio.changer.game.quizbgl"));
        questionArr[14] = res.getStringArray(res.getIdentifier("fifteenth"+options[randomOptionIndex.nextInt(options.length)], "array", "studio.changer.game.quizbgl"));
        questionArr[15] = res.getStringArray(res.getIdentifier("sixteenth"+options[randomOptionIndex.nextInt(options.length)], "array", "studio.changer.game.quizbgl"));
        questionArr[16] = res.getStringArray(res.getIdentifier("seventeenth"+options[randomOptionIndex.nextInt(options.length)], "array", "studio.changer.game.quizbgl"));
        questionArr[17] = res.getStringArray(res.getIdentifier("eighteenth"+options[randomOptionIndex.nextInt(options.length)], "array", "studio.changer.game.quizbgl"));
        questionArr[18] = res.getStringArray(res.getIdentifier("nineteenth"+options[randomOptionIndex.nextInt(options.length)], "array", "studio.changer.game.quizbgl"));
        questionArr[19] = res.getStringArray(res.getIdentifier("twentieth"+options[randomOptionIndex.nextInt(options.length)], "array", "studio.changer.game.quizbgl"));
        questionArr[20] = res.getStringArray(res.getIdentifier("twenty_first"+options[randomOptionIndex.nextInt(options.length)], "array", "studio.changer.game.quizbgl"));
        questionArr[21] = res.getStringArray(res.getIdentifier("twenty_second"+options[randomOptionIndex.nextInt(options.length)], "array", "studio.changer.game.quizbgl"));

        mQuestions.add(new Question(questionArr[0][0],questionArr[0][1],questionArr[0][2],questionArr[0][3],questionArr[0][4], Integer.parseInt(questionArr[0][5])));
        mQuestions.add(new Question(questionArr[1][0],questionArr[1][1],questionArr[1][2],questionArr[1][3],questionArr[1][4], Integer.parseInt(questionArr[1][5])));
        mQuestions.add(new Question(questionArr[2][0],questionArr[2][1],questionArr[2][2],questionArr[2][3],questionArr[2][4], Integer.parseInt(questionArr[2][5])));
        mQuestions.add(new Question(questionArr[3][0],questionArr[3][1],questionArr[3][2],questionArr[3][3],questionArr[3][4], Integer.parseInt(questionArr[3][5])));
        mQuestions.add(new Question(questionArr[4][0],questionArr[4][1],questionArr[4][2],questionArr[4][3],questionArr[4][4], Integer.parseInt(questionArr[4][5])));
        mQuestions.add(new Question(questionArr[5][0],questionArr[5][1],questionArr[5][2],questionArr[5][3],questionArr[5][4], Integer.parseInt(questionArr[5][5])));
        mQuestions.add(new Question(questionArr[6][0],questionArr[6][1],questionArr[6][2],questionArr[6][3],questionArr[6][4], Integer.parseInt(questionArr[6][5])));
        mQuestions.add(new Question(questionArr[7][0],questionArr[7][1],questionArr[7][2],questionArr[7][3],questionArr[7][4], Integer.parseInt(questionArr[7][5])));
        mQuestions.add(new Question(questionArr[8][0],questionArr[8][1],questionArr[8][2],questionArr[8][3],questionArr[8][4], Integer.parseInt(questionArr[8][5])));
        mQuestions.add(new Question(questionArr[9][0],questionArr[9][1],questionArr[9][2],questionArr[9][3],questionArr[9][4], Integer.parseInt(questionArr[9][5])));
        mQuestions.add(new Question(questionArr[10][0],questionArr[10][1],questionArr[10][2],questionArr[10][3],questionArr[10][4], Integer.parseInt(questionArr[10][5])));
        mQuestions.add(new Question(questionArr[11][0],questionArr[11][1],questionArr[11][2],questionArr[11][3],questionArr[11][4], Integer.parseInt(questionArr[11][5])));
        mQuestions.add(new Question(questionArr[12][0],questionArr[12][1],questionArr[12][2],questionArr[12][3],questionArr[12][4], Integer.parseInt(questionArr[12][5])));
        mQuestions.add(new Question(questionArr[13][0],questionArr[13][1],questionArr[13][2],questionArr[13][3],questionArr[13][4], Integer.parseInt(questionArr[13][5])));
        mQuestions.add(new Question(questionArr[14][0],questionArr[14][1],questionArr[14][2],questionArr[14][3],questionArr[14][4], Integer.parseInt(questionArr[14][5])));
        mQuestions.add(new Question(questionArr[15][0],questionArr[15][1],questionArr[15][2],questionArr[15][3],questionArr[15][4], Integer.parseInt(questionArr[15][5])));
        mQuestions.add(new Question(questionArr[16][0],questionArr[16][1],questionArr[16][2],questionArr[16][3],questionArr[16][4], Integer.parseInt(questionArr[16][5])));
        mQuestions.add(new Question(questionArr[17][0],questionArr[17][1],questionArr[17][2],questionArr[17][3],questionArr[17][4], Integer.parseInt(questionArr[17][5])));
        mQuestions.add(new Question(questionArr[18][0],questionArr[18][1],questionArr[18][2],questionArr[18][3],questionArr[18][4], Integer.parseInt(questionArr[18][5])));
        mQuestions.add(new Question(questionArr[19][0],questionArr[19][1],questionArr[19][2],questionArr[19][3],questionArr[19][4], Integer.parseInt(questionArr[19][5])));
        mQuestions.add(new Question(questionArr[20][0],questionArr[20][1],questionArr[20][2],questionArr[20][3],questionArr[20][4], Integer.parseInt(questionArr[20][5])));
        mQuestions.add(new Question(questionArr[21][0],questionArr[21][1],questionArr[21][2],questionArr[21][3],questionArr[21][4], Integer.parseInt(questionArr[21][5])));
    }

    public ArrayList<Question> getQuestions() {
        return mQuestions;
    }


}
