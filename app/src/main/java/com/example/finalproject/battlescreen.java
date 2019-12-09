package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class battlescreen extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private MediaPlayer losesound;
    Random random = new Random();
    int correctAns = random.nextInt(101);




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battlescreen);
        mediaPlayer = MediaPlayer.create(this,R.raw.winsound);
        losesound = MediaPlayer.create(this,R.raw.lose);


        Button bot = findViewById(R.id.exit);
        bot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(battlescreen.this, MainActivity.class);
                startActivity(intent1);

            }
        });



    }

    public void checkAnswer(View view) {
        EditText input = this.findViewById(R.id.input);
        Button checkButton = this.findViewById(R.id.check);
        String text = ((EditText) input).getText().toString();
        String hint = "";
        try {
            int number = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            //hint = "not a Integer";
            System.out.println("Not a Integer!");
            losesound.start();
        }
        int number = Integer.parseInt(text);

        if (number > 100 || number < 1) {
            hint = "Out of range";
            losesound.start();
        }
        if (number == correctAns) {
            checkButton.setEnabled(false);
            hint = "You are correct!!!";
            mediaPlayer.start();
        }
        if (number > correctAns && number < 101) {
            hint = "Too Large!";
            losesound.start();
        }
        if (number < correctAns && number > 0) {
            hint = "Too Small!";
            losesound.start();
        }
        Toast.makeText(this, hint, Toast.LENGTH_LONG).show();
    }






}
