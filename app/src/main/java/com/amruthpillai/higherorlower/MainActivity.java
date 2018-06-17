package com.amruthpillai.higherorlower;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText guessEditText;
    Button guessButton, playAgainButton;

    int randomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guessEditText = (EditText) findViewById(R.id.guessEditText);
        guessButton = (Button) findViewById(R.id.guessButton);
        playAgainButton = (Button) findViewById(R.id.playAgainButton);

        generateRandomNumber();
    }

    void generateRandomNumber() {
        Random random = new Random();

        randomNumber = random.nextInt(20) + 1;
    }

    public void resetGame(View view) {
        generateRandomNumber();

        guessButton.setEnabled(true);
        playAgainButton.setVisibility(View.INVISIBLE);
    }

    void makeToast(int string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    public void guess(View view) {
        if (guessEditText.getText().toString().isEmpty()) {
            makeToast(R.string.enter_number);
        } else {
            int guessedNumber = Integer.parseInt(guessEditText.getText().toString());

            if (guessedNumber < 1 || guessedNumber > 20) {
                makeToast(R.string.enter_within_range);
            }

            if (guessedNumber < randomNumber) {
                makeToast(R.string.guess_lower);
            } else if (guessedNumber > randomNumber) {
                makeToast(R.string.guess_higher);
            } else {
                makeToast(R.string.guess_correct);

                guessButton.setEnabled(false);
                playAgainButton.setVisibility(View.VISIBLE);
            }
        }
    }
}
