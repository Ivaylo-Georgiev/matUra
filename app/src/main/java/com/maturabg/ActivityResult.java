package com.maturabg;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityResult extends AppCompatActivity {
    ImageView mEmoji;
    TextView mPoints;
    TextView mMessage;
    Button mCheckAnswers;
    int points=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent launchResult = getIntent();
        points=launchResult.getIntExtra("points",0);

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

        mEmoji=(ImageView) findViewById(R.id.emoji);
        mPoints=(TextView) findViewById(R.id.points);
        mMessage=(TextView) findViewById(R.id.message);
        mCheckAnswers=(Button) findViewById(R.id.check);

        switch (points) {
            case 0:
                mEmoji.setImageResource(R.mipmap.poor);
                mPoints.setText("0 точки от 22");
                mMessage.setText("Май нещо се обърка. Сигурен ли си, че отговори на всички въпроси?");
                break;
            case 1:
                mEmoji.setImageResource(R.mipmap.poor);
                mPoints.setText("1 точка от 22");
                mMessage.setText("Май нещо се обърка. Сигурен ли си, че отговори на всички въпроси?");
                break;
            case 2:
            case 3:
            case 4:
            case 5:
                mEmoji.setImageResource(R.mipmap.poor);
                mPoints.setText(Integer.toString(points) + " точки от 22");
                mMessage.setText("Слаб резултат.");
                break;
            case 6:
            case 7:
            case 8:
            case 9:
                mEmoji.setImageResource(R.mipmap.middle);
                mPoints.setText(Integer.toString(points) + " точки от 22");
                mMessage.setText("Среден резултат.");
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                mEmoji.setImageResource(R.mipmap.good);
                mPoints.setText(Integer.toString(points) + " точки от 22");
                mMessage.setText("Добър резултат.");
                break;
            case 14:
            case 15:
            case 16:
            case 17:
                mEmoji.setImageResource(R.mipmap.very_good);
                mPoints.setText(Integer.toString(points) + " точки от 22");
                mMessage.setText("Много добър резултат.");
                break;
            case 18:
            case 19:
            case 20:
                mEmoji.setImageResource(R.mipmap.excellent);
                mPoints.setText(Integer.toString(points) + " точки от 22");
                mMessage.setText("Отличен резултат.");
                break;
            case 21:
            case 22:
                mEmoji.setImageResource(R.mipmap.perfection);
                mPoints.setText(Integer.toString(points) + " точки от 22");
                mMessage.setText("Перфектен резултат.");
                break;
        }

        mCheckAnswers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

        }
    }

