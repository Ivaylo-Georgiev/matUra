package com.maturabg;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

public class ActivityQuiz extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#009874")));

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
        Window window = this.getWindow();
        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        // finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.colorPrimaryDark));
        }

        FragmentManager fm=getSupportFragmentManager();
        Fragment questionFragment = fm.findFragmentById(R.id.questionFragmentContainer); //id of question FrameLayout

            if (questionFragment == null) {
                questionFragment = new QuestionFragment();
                fm.beginTransaction()
                        .add(R.id.questionFragmentContainer, questionFragment)
                        .commit();
            }
        }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
