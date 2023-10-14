package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button;
    Button button1;
    Button button2;
    Button button3;
    Button button0;
    TextView textView;
    TextView timeTextView;
    ArrayList <Integer> answers = new ArrayList<>();
    int correct;
    TextView congoTextview;
    int cor=0,count=0;
    TextView scoreTextView;
    Button playagainbutton;
    ConstraintLayout gameLayout;

    public void start(View view)
    {
        playagainbutton.setVisibility(View.INVISIBLE);
        count=0;
        cor=0;
        timeTextView.setText("0:30");
        scoreTextView.setText("0/0");
        next();
        CountDownTimer countDownTimer = new CountDownTimer(30100,1000) {
            @Override
            public void onTick(long l) {
                timeTextView.setText(String.valueOf(l/1000)+"s");
            }
            @Override
            public void onFinish() {
                congoTextview.setText("Done!");
                playagainbutton.setVisibility(View.VISIBLE);
            }
        }.start();
    }

    public void next()
    {
        Random rand = new Random();
        int a = rand.nextInt(21);
        int b = rand.nextInt(21);
        textView.setText(a+"+"+b);
        correct =rand.nextInt(4);
        answers.clear();
        for(int i=0;i<4;i++)
        {
            if(i==correct)
            {
                answers.add(a+b);
            }
            else {
                int wrong = rand.nextInt(41);
                while(wrong==a+b)
                {
                    wrong = rand.nextInt(41);
                }
                answers.add(wrong);
            }
        }
        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));
    }

    public void choose(View view)
    {
        if(Integer.toString(correct).equals(view.getTag().toString()))
        {
            congoTextview.setText("correct");
            cor++;
        }
        else {
            congoTextview.setText("wrong");
        }
        count++;
        scoreTextView.setText(cor+"/"+count);
        next();
    }
    public void click (View view)
    {
        button.setVisibility(View.INVISIBLE);
        gameLayout.setVisibility(View.VISIBLE);
        playagainbutton=findViewById(R.id.playAgainButton);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.Gobutton);
        textView=findViewById(R.id.sumTextView);
        button0 =findViewById(R.id.button0);
        button1 =findViewById(R.id.button1);
        button2 =findViewById(R.id.button2);
        button3 =findViewById(R.id.button3);
        congoTextview =findViewById(R.id.congoTextView);
        scoreTextView= findViewById(R.id.scoreTextView);
        timeTextView = findViewById(R.id.timeTextView);
        gameLayout = findViewById(R.id.gameLayout);
        button.setVisibility(View.VISIBLE);
        playagainbutton=findViewById(R.id.playAgainButton);
        gameLayout.setVisibility(View.INVISIBLE);
        start(button);


        /*CountDownTimer countDownTimer = new CountDownTimer(5100,1000) {
            @Override
            public void onTick(long l) {
                timeTextView.setText(String.valueOf(l/1000)+"s");
            }
            @Override
            public void onFinish() {
                congoTextview.setText("Done!");
                timeTextView.setText("0:30");
                scoreTextView.setText("0/0");
                playagainbutton.setVisibility(View.VISIBLE);
            }
        }.start();
        next();*/

    }
}