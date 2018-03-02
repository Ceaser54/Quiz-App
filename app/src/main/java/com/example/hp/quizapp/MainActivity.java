package com.example.hp.quizapp;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity
{
    private static final String AnswerQuestion4 = "object oriented programming";
    private Button submit;
    private RadioGroup radioquestion1;
    private RadioGroup radioquestion2;
    private CheckBox checka;
    private CheckBox checkb;
    private CheckBox checkc;
    private CheckBox checkd;
    private EditText question4;
    private RadioButton radio1;
    private RadioButton radio2;
    private String endline="\n";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                int total = 0;
                String temb = "";
                boolean Status1 = false, Status2 = false, Status3 = false, Status4 = false;
                radioquestion1 = (RadioGroup) findViewById(R.id.Groub1);
                radioquestion2 = (RadioGroup) findViewById(R.id.Groub2);
                checka = (CheckBox) findViewById(R.id.Check1);
                checkb = (CheckBox) findViewById(R.id.Check2);
                checkc = (CheckBox) findViewById(R.id.Check3);
                checkd = (CheckBox) findViewById(R.id.Check4);
                question4 = (EditText) findViewById(R.id.TheQuestion);
                int Q1 = radioquestion1.getCheckedRadioButtonId();
                int Q2 = radioquestion2.getCheckedRadioButtonId();
                if(Q2>-1)
                {
                    radio2 = (RadioButton) findViewById(Q2);
                    if (TextUtils.equals(radio2.getText(), getString(R.string.Q2A1))) {
                        total += 1;
                        Status2 = true;
                        temb = temb + "Answer Of Question2: " + String.valueOf(Status2) + endline;

                    }else{
                        Toast.makeText(getApplicationContext(),"False Answer of Question2", Toast.LENGTH_LONG).show();
                    }
                }
                if (checka.isChecked() && checkb.isChecked() && checkc.isChecked() && !checkd.isChecked())
                {
                    total += 1;
                    Status3 = true;
                    temb = temb + "Answer Of Question3: " + String.valueOf(Status3) + endline;
                }

                if (!TextUtils.isEmpty(question4.getText()) && TextUtils.equals(question4.getText(), AnswerQuestion4))
                {
                    total += 1;
                    Status4 = true;
                    temb = temb + "Answer Of Question4: " + String.valueOf(Status4) + endline;
                }

                if (Q1 > -1)
                {
                    radio1 = (RadioButton) findViewById(Q1);
                    if (TextUtils.equals(radio1.getText(), getString(R.string.Q1A1)))
                    {
                        total += 1;
                        Status1 = true;
                        temb = temb + "Answer Of Question1: " + String.valueOf(Status1) + endline;
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"False Answer of Question1", Toast.LENGTH_LONG).show();
                    }
                }
                temb = temb + "The Total Score Now is: " + Integer.toString(total) + " of The 4 Questions";
                Toast.makeText(getApplicationContext(), temb, Toast.LENGTH_LONG).show();
            }}

            );
    }
}
