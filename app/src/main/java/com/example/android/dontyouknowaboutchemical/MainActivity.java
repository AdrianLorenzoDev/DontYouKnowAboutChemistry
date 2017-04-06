package com.example.android.dontyouknowaboutchemical;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void submit (View view){
        int points = 0;
        int[] correctAnswers ={R.id.a11, R.id.a21, R.id.a31, R.id.a42, R.id.a52, R.id.a61, R.id.a71};
        for (int index = 0; index < correctAnswers.length; index++){
            RadioButton answer = (RadioButton) findViewById(correctAnswers[index]);
            if(answer.isChecked()){
                points++;
            }
        }

        Context context = getApplicationContext();
        EditText name = (EditText) findViewById(R.id.name);
        String name1 = name.getText().toString();
        String tip = "";

        if (points < 3) {
            tip = " Maybe you should improve your chemical knowledge. It can be useful!";
        } else if (points < 6) {
            tip = " You did it good, but not perfect!";
        } else {
            tip = " Perfect! You have a really good knowledge about the field!";
        }

        Toast finalScore = Toast.makeText(context, "Hey " + name1 + ", you got " + points +
                    " points!" + tip, Toast.LENGTH_LONG);

        finalScore.setGravity(Gravity.CENTER, 0, 0);
        finalScore.show();
    }
}
