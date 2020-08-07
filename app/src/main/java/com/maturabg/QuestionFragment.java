package com.maturabg;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ivaylo on 19-Sep-17.
 */

public class QuestionFragment extends Fragment {
    private ArrayList<Question> mQuestions;
    private int[] mCorrectIndexes = new int[22];
    private int[] mAnswersIds = new int[22];
    private ImageButton mLeftArrow;
    private ImageButton mRightArrow;
    private TextView mQuestionTitle;
    private RadioGroup mRadioGroup;
    private RadioButton mOptionA;
    private RadioButton mOptionB;
    private RadioButton mOptionC;
    private RadioButton mOptionD;
    private HorizontalScrollView mHSL;
    private Button[] mNavigationButtons=new Button[22];
    private Button mSubmit;
    private int mCurrentIndex=0;
    int flag;
    public int points;
    private boolean mIsSubmitted=false;
    View v;


    private void updateQuestion(){

        if (mCurrentIndex==0) {
            mLeftArrow.setVisibility(View.INVISIBLE);
        } else if(mCurrentIndex==21) {
            mRightArrow.setVisibility(View.INVISIBLE);
        } else {
            mLeftArrow.setVisibility(View.VISIBLE);
            mRightArrow.setVisibility(View.VISIBLE);
        }

        mQuestionTitle.setText(mQuestions.get(mCurrentIndex).getTitle());
        mOptionA.setText(mQuestions.get(mCurrentIndex).getA());
        mOptionB.setText(mQuestions.get(mCurrentIndex).getB());
        mOptionC.setText(mQuestions.get(mCurrentIndex).getC());
        mOptionD.setText(mQuestions.get(mCurrentIndex).getD());

        if (mAnswersIds[mCurrentIndex]!=-1){
            switch(mAnswersIds[mCurrentIndex]){
                case 0:
                    mOptionA.setChecked(true);
                    break;
                case 1:
                    mOptionB.setChecked(true);
                    break;
                case 2:
                    mOptionC.setChecked(true);
                    break;
                case 3:
                    mOptionD.setChecked(true);
                    break;
            }
        }else{
            mRadioGroup.clearCheck();
        }

        if (mIsSubmitted){

            mOptionA.setBackgroundResource(R.drawable.grey_border);
            mOptionB.setBackgroundResource(R.drawable.grey_border);
            mOptionC.setBackgroundResource(R.drawable.grey_border);
            mOptionD.setBackgroundResource(R.drawable.grey_border);

            switch(mCorrectIndexes[mCurrentIndex]){
                case 0:
                    mOptionA.setBackgroundResource(R.drawable.green_border);
                    break;
                case 1:
                    mOptionB.setBackgroundResource(R.drawable.green_border);
                    break;
                case 2:
                    mOptionC.setBackgroundResource(R.drawable.green_border);
                    break;
                case 3:
                    mOptionD.setBackgroundResource(R.drawable.green_border);
                    break;
            }
            if (mAnswersIds[mCurrentIndex]!=mCorrectIndexes[mCurrentIndex]){
                switch(mAnswersIds[mCurrentIndex]){
                    case 0:
                        mOptionA.setBackgroundResource(R.drawable.red_border);
                        break;
                    case 1:
                        mOptionB.setBackgroundResource(R.drawable.red_border);
                        break;
                    case 2:
                        mOptionC.setBackgroundResource(R.drawable.red_border);
                        break;
                    case 3:
                        mOptionD.setBackgroundResource(R.drawable.red_border);
                        break;
                }
            }

        }
    }

    private void centerNavigationBar(){
        int scrollX = (mNavigationButtons[mCurrentIndex].getLeft() - (mHSL.getWidth() / 2)) + (mNavigationButtons[mCurrentIndex].getWidth() / 2);
        mHSL.smoothScrollTo(scrollX, 0);

        if(!mIsSubmitted) {

            for (Button buttons:mNavigationButtons) {
                buttons.setBackgroundResource(R.drawable.grey_border);
            }

            mNavigationButtons[mCurrentIndex].setBackgroundResource(R.drawable.blue_border);
        }

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QuestionLab.get(getActivity()).initializeQuestions();
        mQuestions = QuestionLab.get(getActivity()).getQuestions();

        for(int i=0;i<22;i++){
            mAnswersIds[i]=-1;
        }

        for (int i=0; i<22; i++){
            mCorrectIndexes[i]=mQuestions.get(i).getCorrectIndex();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_question, parent, false);

        mQuestionTitle=(TextView)v.findViewById(R.id.question_title);
        mRadioGroup = (RadioGroup)v.findViewById(R.id.radio_group);
        mOptionA=(RadioButton)v.findViewById(R.id.option_A);
        mOptionB=(RadioButton)v.findViewById(R.id.option_B);
        mOptionC=(RadioButton)v.findViewById(R.id.option_C);
        mOptionD=(RadioButton)v.findViewById(R.id.option_D);
        mLeftArrow=(ImageButton) v.findViewById(R.id.left_arrow);
        mRightArrow=(ImageButton) v.findViewById(R.id.right_arrow);
        mHSL=(HorizontalScrollView)v.findViewById(R.id.HSL);
        mNavigationButtons[0] = (Button) v.findViewById(R.id.button1);
        mNavigationButtons[1] = (Button) v.findViewById(R.id.button2);
        mNavigationButtons[2] = (Button) v.findViewById(R.id.button3);
        mNavigationButtons[3] = (Button) v.findViewById(R.id.button4);
        mNavigationButtons[4] = (Button) v.findViewById(R.id.button5);
        mNavigationButtons[5] = (Button) v.findViewById(R.id.button6);
        mNavigationButtons[6] = (Button) v.findViewById(R.id.button7);
        mNavigationButtons[7] = (Button) v.findViewById(R.id.button8);
        mNavigationButtons[8] = (Button) v.findViewById(R.id.button9);
        mNavigationButtons[9] = (Button) v.findViewById(R.id.button10);
        mNavigationButtons[10] = (Button) v.findViewById(R.id.button11);
        mNavigationButtons[11] = (Button) v.findViewById(R.id.button12);
        mNavigationButtons[12] = (Button) v.findViewById(R.id.button13);
        mNavigationButtons[13] = (Button) v.findViewById(R.id.button14);
        mNavigationButtons[14] = (Button) v.findViewById(R.id.button15);
        mNavigationButtons[15] = (Button) v.findViewById(R.id.button16);
        mNavigationButtons[16] = (Button) v.findViewById(R.id.button17);
        mNavigationButtons[17] = (Button) v.findViewById(R.id.button18);
        mNavigationButtons[18] = (Button) v.findViewById(R.id.button19);
        mNavigationButtons[19] = (Button) v.findViewById(R.id.button20);
        mNavigationButtons[20] = (Button) v.findViewById(R.id.button21);
        mNavigationButtons[21] = (Button) v.findViewById(R.id.button22);
        mSubmit=(Button) v.findViewById(R.id.submitButton);


        mLeftArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex+mQuestions.size()-1)% mQuestions.size();
                centerNavigationBar();
                updateQuestion();
            }
        });

        mRightArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex+1)% mQuestions.size();
                centerNavigationBar();
                updateQuestion();
            }
        });

        mNavigationButtons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex=0;
                centerNavigationBar();
                updateQuestion();
            }
        });

        mNavigationButtons[0].performClick();

        mNavigationButtons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex=1;
                centerNavigationBar();
                updateQuestion();
            }
        });

        mNavigationButtons[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex=2;
                centerNavigationBar();
                updateQuestion();
            }
        });

        mNavigationButtons[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex=3;
                centerNavigationBar();
                updateQuestion();
            }
        });

        mNavigationButtons[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex=4;
                centerNavigationBar();
                updateQuestion();
            }
        });

        mNavigationButtons[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex=5;
                centerNavigationBar();
                updateQuestion();
            }
        });

        mNavigationButtons[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex=6;
                centerNavigationBar();
                updateQuestion();
            }
        });

        mNavigationButtons[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex=7;
                centerNavigationBar();
                updateQuestion();
            }
        });

        mNavigationButtons[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex=8;
                centerNavigationBar();
                updateQuestion();
            }
        });

        mNavigationButtons[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex=9;
                centerNavigationBar();
                updateQuestion();
            }
        });

        mNavigationButtons[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex=10;
                centerNavigationBar();
                updateQuestion();
            }
        });

        mNavigationButtons[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex=11;
                centerNavigationBar();
                updateQuestion();
            }
        });

        mNavigationButtons[12].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex=12;
                centerNavigationBar();
                updateQuestion();
            }
        });

        mNavigationButtons[13].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex=13;
                centerNavigationBar();
                updateQuestion();
            }
        });

        mNavigationButtons[14].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex=14;
                centerNavigationBar();
                updateQuestion();
            }
        });

        mNavigationButtons[15].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex=15;
                centerNavigationBar();
                updateQuestion();
            }
        });

        mNavigationButtons[16].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex=16;
                centerNavigationBar();
                updateQuestion();
            }
        });

        mNavigationButtons[17].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex=17;
                centerNavigationBar();
                updateQuestion();
            }
        });

        mNavigationButtons[18].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex=18;
                centerNavigationBar();
                updateQuestion();
            }
        });

        mNavigationButtons[19].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex=19;
                centerNavigationBar();
                updateQuestion();
            }
        });

        mNavigationButtons[20].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex=20;
                centerNavigationBar();
                updateQuestion();
            }
        });

        mNavigationButtons[21].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex=21;
                centerNavigationBar();
                updateQuestion();
            }
        });



        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                mOptionA.setBackgroundResource(R.drawable.grey_border);
                mOptionB.setBackgroundResource(R.drawable.grey_border);
                mOptionC.setBackgroundResource(R.drawable.grey_border);
                mOptionD.setBackgroundResource(R.drawable.grey_border);

                flag = mRadioGroup.getCheckedRadioButtonId();
                switch(flag) {
                    case R.id.option_A:
                        mAnswersIds[mCurrentIndex]=0;

                        mOptionA.setBackgroundResource(R.drawable.blue_border);
                        break;
                    case R.id.option_B:
                        mAnswersIds[mCurrentIndex]=1;

                        mOptionB.setBackgroundResource(R.drawable.blue_border);
                        break;
                    case R.id.option_C:
                        mAnswersIds[mCurrentIndex]=2;
                        mOptionC.setBackgroundResource(R.drawable.blue_border);
                        break;
                    case R.id.option_D:
                        mAnswersIds[mCurrentIndex]=3;
                        mOptionD.setBackgroundResource(R.drawable.blue_border);
                        break;
                    default:
                        mAnswersIds[mCurrentIndex]=-1;
                }

                mSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mIsSubmitted=true;
                        mCurrentIndex=0;
                        updateQuestion();
                        centerNavigationBar();
                        for (int i=0;i<22;i++){
                            if (mAnswersIds[i]==mCorrectIndexes[i]) {
                                points++;
                                mNavigationButtons[i].setBackgroundResource(R.drawable.green_border);
                            } else {
                                mNavigationButtons[i].setBackgroundResource(R.drawable.red_border);
                            }
                        }
                        mSubmit.setEnabled(false);
                        mSubmit.setBackgroundResource(R.drawable.white_background);
                        mSubmit.setTextColor(Color.parseColor("#E0E0E0"));
                        mOptionA.setEnabled(false);
                        mOptionB.setEnabled(false);
                        mOptionC.setEnabled(false);
                        mOptionD.setEnabled(false);

                        Intent launchResult = new Intent(getActivity(), ActivityResult.class);
                        launchResult.putExtra("points", points);
                        getActivity().startActivity(launchResult);
                    }
                });
            }
        });

        return v;
    }
}