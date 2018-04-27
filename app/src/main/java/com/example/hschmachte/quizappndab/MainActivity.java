package com.example.hschmachte.quizappndab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.String.format;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void gradeItAll(View v){
        int totalRight = 0;
        String toastOut = "You got ";
        String wrongAnswers = "";
        // Get the response to question 1
        RadioButton questionOneCorrectKnob = findViewById(R.id.question_one_correct);
        if (questionOneCorrectKnob.isChecked()){
            totalRight += 1;
        } else{
            wrongAnswers += "Q1 ";
        }

        // Get responses to question 2
        CheckBox questionTwoCorrectA = findViewById(R.id.question_two_correct_a);
        CheckBox questionTwoCorrectB = findViewById(R.id.question_two_correct_b);
        CheckBox questionTwoIncorrect = findViewById(R.id.question_two_incorrect);

        // Check if the incorrect box is checked and increment wrong answers if so
        if (questionTwoIncorrect.isChecked()) {
            wrongAnswers += "Q2 ";
        }
        // If correct boxes are checked, increment correct tally
        else if (questionTwoCorrectA.isChecked()) {
            if (questionTwoCorrectB.isChecked()) {
                totalRight += 1;
            }
        }
        // Mark Question Two Wrong if the two correct boxes aren't marked
        else wrongAnswers += "Q2 ";

        // Get the third question text
        TextView questionThreeET = findViewById(R.id.question_three_edit_text);
        // convert to lowercase for ease
        String responseString = questionThreeET.getText().toString().toLowerCase();
        // If the strings match (user should be able to spell peanut correctly), increment right
        if (responseString.equals("peanut")){
            totalRight += 1;
        }else wrongAnswers += format("Q3: %s", responseString);

        // Get the fourth question correct Radio
        RadioButton questionFourCorrectKnob = findViewById(R.id.question_four_correct);
        if (questionFourCorrectKnob.isChecked()){
            totalRight += 1;
        }
        // Mark it wrong if the correct knob isn't checked
        else wrongAnswers += "Q4";

        // Tally total and toast it
        toastOut += format("%d/4 correct.", totalRight);
        Toast toastScore = Toast.makeText(this, toastOut, Toast.LENGTH_LONG);
        toastScore.show();

        if (totalRight == 4){
            wrongAnswers += "Congrats!";
        }else{
            wrongAnswers += " incorrect :(";
        }

        // Report congrats if flawless and wrong questions if incorrect
        Toast toastSummary = Toast.makeText(this, wrongAnswers, Toast.LENGTH_LONG);
        toastSummary.show();

    }

    public void resetItAll(View v){
        // Get a handle on all the fields
        RadioButton qOneCorrectKnob = findViewById(R.id.question_one_correct);
        RadioButton qOneIncorrectKnob = findViewById(R.id.question_one_incorrect);

        CheckBox qTwoCorrectA = findViewById(R.id.question_two_correct_a);
        CheckBox qTwoCorrectB = findViewById(R.id.question_two_correct_b);
        CheckBox qTwoIncorrect = findViewById(R.id.question_two_incorrect);

        EditText qThreeET = findViewById(R.id.question_three_edit_text);

        RadioButton qFourCorrectKnob = findViewById(R.id.question_four_correct);
        RadioButton qFourIncorrectA = findViewById(R.id.question_four_incorrect_a);
        RadioButton qFourIncorrectB = findViewById(R.id.question_four_incorrect_b);

        // Clear all the fields
        qOneCorrectKnob.setChecked(false);
        qOneIncorrectKnob.setChecked(false);

        qTwoCorrectA.setChecked(false);
        qTwoCorrectB.setChecked(false);
        qTwoIncorrect.setChecked(false);

        qThreeET.setText("");

        qFourCorrectKnob.setChecked(false);
        qFourIncorrectA.setChecked(false);
        qFourIncorrectB.setChecked(false);
    }
}
