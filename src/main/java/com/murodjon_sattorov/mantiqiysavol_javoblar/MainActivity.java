package com.murodjon_sattorov.mantiqiysavol_javoblar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TTTMainActivity";
    private ImageView backBtn, flagImg;
    private TextView answer1, answer2, answer3, answer4;

    private ArrayList<Questions> questions;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createQuestions();
        loadUi();
        loadFlags();

    }

    private void loadUi() {
        backBtn = findViewById(R.id.back_btn);
        flagImg = findViewById(R.id.flag_img);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);
    }

    private void loadFlags() {
        if (count == questions.size()) {
            count = 0;
            loadFlags();
        } else {
            ArrayList<String> answers = new ArrayList<>();
            answers.add(questions.get(count).getAnswer1());
            answers.add(questions.get(count).getAnswer2());
            answers.add(questions.get(count).getAnswer3());
            answers.add(questions.get(count).getAnswer4());

            Collections.shuffle(answers);

            answer1.setText(answers.get(0));
            answer2.setText(answers.get(1));
            answer3.setText(answers.get(2));
            answer4.setText(answers.get(3));
            flagImg.setImageResource(questions.get(count).getImg());
        }
    }

    public void checkAnswer(View view) {
        TextView answer = (TextView) view;
        if (questions.get(count).getANSWER().equals(answer.getText().toString())) {
            Snackbar snackbar = Snackbar.make(view, getString(R.string.correct_answer) + "\n" + getString(R.string.your_answer)
                    + answer.getText().toString(), Snackbar.LENGTH_SHORT);
            snackbar.setBackgroundTint(Color.rgb(30, 154, 17));
            snackbar.show();
        } else {
            Snackbar snackbar = Snackbar.make(view, getString(R.string.incorrect_answer) + "\n" + getString(R.string.your_answer)
                    + answer.getText().toString(), Snackbar.LENGTH_SHORT);
            snackbar.setBackgroundTint(Color.rgb(156, 11, 11));
            snackbar.show();
        }
        count++;
        loadFlags();
    }

    private void createQuestions() {
        questions = new ArrayList<>();
        questions.add(new Questions(R.drawable.afghanistan, "Afg'oniston", "Turkmaniston", "Azarbayjon", "Qizg'iziston", "Afg'oniston"));
        questions.add(new Questions(R.drawable.argentina, "Argentina", "Brazilya", "Kanada", "Sumali", "Argentina"));
        questions.add(new Questions(R.drawable.australia, "Avstraliya", "AQSH", "Rossiya", "Angliya", "Avstraliya"));
        questions.add(new Questions(R.drawable.azerbaijan, "Azarbayjon", "Checheniston", "Qozog'iston", "Turkmaniston", "Azarbayjon"));
        questions.add(new Questions(R.drawable.bangladesh, "Bangladesh", "Kongo", "Somali", "Norvegiya", "Bangladesh"));
        questions.add(new Questions(R.drawable.brazil, "Brazilya", "Argentina", "Portugaliya", "Norvegiya", "Brazilya"));
        questions.add(new Questions(R.drawable.canada, "Kanada", "AQSH", "Avstraliya", "Somali", "Kanada"));
        questions.add(new Questions(R.drawable.china, "Xitoy", "Koreya", "Yaponiya", "Mo'g'uliston", "Xitoy"));
        questions.add(new Questions(R.drawable.cuba, "Kuba", "Kongo", "Bangladesh", "Norvegiya", "Kuba"));
        questions.add(new Questions(R.drawable.germany, "Germaniya", "Portugaliya", "Italiya", "Ispaniya", "Germaniya"));
        questions.add(new Questions(R.drawable.india, "Hindiston", "Ozarbayjon", "Moldava", "Qizg'iziston", "Hindiston"));
        questions.add(new Questions(R.drawable.italy, "Italiya", "Ispaniya", "Portugaliya", "Rossiya", "Italiya"));
        questions.add(new Questions(R.drawable.japan, "Yaponiya", "Sh.Koreya", "J.Koreya", "Xitoy", "Yaponiya"));
        questions.add(new Questions(R.drawable.kazakhstan, "Qozog'iston", "Turkmaniston", "Afg'oniston", "Qirg'iziston", "Qozog'iston"));
        questions.add(new Questions(R.drawable.pakistan, "Pokiston", "Hindiston", "Eron", "Iroq", "Pokiston"));
        questions.add(new Questions(R.drawable.portugal, "Portugaliya", "Italiya", "Angliya", "Shvetsariya", "Portugaliya"));
        questions.add(new Questions(R.drawable.russian, "Rossiya", "Checheniston", "Germaniya", "Shvetsariya", "Rossiya"));
        questions.add(new Questions(R.drawable.tajikistan, "Tojikiston", "Armaniston", "Eron", "Iroq", "Tojikiston"));
        questions.add(new Questions(R.drawable.turkey, "Turkiya", "Armaniston", "Shvetsariya", "Rossiya", "Turkiya"));
        questions.add(new Questions(R.drawable.turkmenistan, "Turkmaniston", "Qizg'iziston", "Hindiston", "Rossiya", "Turkmaniston"));
        questions.add(new Questions(R.drawable.usa, "AQSH", "Kanada", "Gollandiya", "Angliya", "AQSH"));
        questions.add(new Questions(R.drawable.uzbekistan, "O'zbekiston", "Rossiya", "Qozog'iston", "Tojikiston", "O'zbekiston"));
        questions.add(new Questions(R.drawable.niger, "Malayziya", "Nigeriya", "Kongo", "Madagaskar", "Nigeriya"));
        Collections.shuffle(questions);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: ");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onSaveInstanceState222: ");
    }

    public void back_btn(View view) {
        startActivity(new Intent(this, SplashActivity.class));
        finish();
    }
}