package com.project5.snakeintheforest.Models;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class RandomGenerator {
    private Random random = new Random();
    private TextView normalNumber;
    private TextView binaryNumber;

    public void setNumbersViews(TextView normalNumber, TextView binaryNumber) {
        this.normalNumber = normalNumber;
        this.binaryNumber = binaryNumber;
    }

    public void generateRandom(Activity activity) {
        activity.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                int randomNumber = -1;
                while (randomNumber == -1 || Integer.valueOf(normalNumber.getText().toString()) == randomNumber) {
                    randomNumber = random.nextInt(16);
                }
                normalNumber.setText(String.valueOf(randomNumber));
                if (binaryNumber.getVisibility() == View.VISIBLE)
                    binaryNumber.setText(Integer.toBinaryString(randomNumber));
            }
        });
    }
}

