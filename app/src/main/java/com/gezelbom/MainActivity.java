package com.gezelbom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

/**
 * Simple app that experiments with AndroidPlot
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //The number of values in the lists
        final int n = 5;

        // When Generate button is clicked. Generate two ArrayLists with n values
        // Start an intent to the GraphActivity with the lists as extra
        Button generateButton = (Button) findViewById(R.id.button_generate);
        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<Integer> values1 = randomArrayList(n);
                ArrayList<Integer> values2 = randomArrayList(n);

                Intent intent = new Intent(getApplicationContext(), GraphActivity.class);
                intent.putExtra("1", values1);
                intent.putExtra("2", values2);
                startActivity(intent);
            }
        });


    }

    /**
     * Method that generates
     * @param n Number of values to create in the ArrayList
     * @return The ArrayList created with random values
     */
    public ArrayList<Integer> randomArrayList(int n)
    {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < n; i++)
        {
            list.add(random.nextInt(255));
        }
        return list;
    }
}
