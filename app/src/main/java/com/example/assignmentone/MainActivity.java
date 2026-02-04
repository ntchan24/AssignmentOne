package com.example.assignmentone;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    //we make the textviews private variables because they are used twice, one on oncreate and once on the onclick set text
    private TextView Counter1;
    private TextView Counter2;
    private TextView Counter3;
    private TextView Counter4;
    private TextView Counter5;
    private TextView Counter6;

    private int Count1 = 0;
    private int Count2 = 0;
    private int Count3 = 0;
    private int Count4 = 0;
    private int Count5 = 0;
    private int Count6 = 0;
    private int TotalCount = 0;
    //arraylists for the timestamps
    List<String> timestamps1 = new ArrayList<>();
    List<String> timestamps2 = new ArrayList<>();
    List<String> timestamps3 = new ArrayList<>();
    List<String> timestamps4 = new ArrayList<>();
    List<String> timestamps5 = new ArrayList<>();
    List<String> timestamps6 = new ArrayList<>();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //when each button is pressed, we want to show the incremented counter
        //add the timestamp into an arraylist that can be passed to the summary screen

        Button HappyButton = findViewById(R.id.button); //find the button by id
        Counter1 = findViewById(R.id.counter1); //find the counter1 by id

        HappyButton.setOnClickListener(v -> {
            Count1++; //increment the count
            Counter1.setText(String.valueOf(Count1));
            String timestamp1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
                    .format(new Date());
            timestamps1.add(timestamp1); //get timestamp and add it to the list for this button
            TotalCount++;
        });

        Button SadButton = findViewById(R.id.button2); //find the button by id
        Counter2 = findViewById(R.id.counter2); //find the counter1 by id

        SadButton.setOnClickListener(v -> {
            Count2++;
            Counter2.setText(String.valueOf(Count2));
            String timestamp2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
                    .format(new Date());
            timestamps2.add(timestamp2);
            TotalCount++;
        });

        Button GratefulButton = findViewById(R.id.button3); //find the button by id
        Counter3 = findViewById(R.id.counter3); //find the counter1 by id

        GratefulButton.setOnClickListener(v -> {
            Count3++;
            Counter3.setText(String.valueOf(Count3));
            String timestamp3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
                    .format(new Date());
            timestamps3.add(timestamp3);
            TotalCount++;
        });

        Button AngryButton = findViewById(R.id.button4); //find the button by id
        Counter4 = findViewById(R.id.counter4); //find the counter1 by id

        AngryButton.setOnClickListener(v -> {
            Count4++;
            Counter4.setText(String.valueOf(Count4));
            String timestamp4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
                    .format(new Date());
            timestamps4.add(timestamp4);
            TotalCount++;
        });

        Button ExcitedButton = findViewById(R.id.button5); //find the button by id
        Counter5 = findViewById(R.id.counter5); //find the counter1 by id

        ExcitedButton.setOnClickListener(v -> {
            Count5++;
            Counter5.setText(String.valueOf(Count5));
            String timestamp5 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
                    .format(new Date());
            timestamps5.add(timestamp5);
            TotalCount++;
        });

        Button DisappointedButton = findViewById(R.id.button6); //find the button by id
        Counter6 = findViewById(R.id.counter6); //find the counter1 by id

        DisappointedButton.setOnClickListener(v -> {
            Count6++;
            Counter6.setText(String.valueOf(Count6));
            String timestamp6 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
                    .format(new Date());
            timestamps6.add(timestamp6);
            TotalCount++;
        });

        //i need timestamps to be stored in a list for each button so it can be displayed in a list in the listview contained in the summaryscreen

        //summary button
        Button SummaryButton = findViewById(R.id.summaryButton);
        SummaryButton.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this, SummaryScreen.class);
            //navigate to the new screen

            //pass info to the summary screen
            intent.putExtra("HappyButtonCount",Count1);
            intent.putExtra("SadButtonCount",Count2);
            intent.putExtra("GratefulButtonCount",Count3);
            intent.putExtra("AngryButtonCount",Count4);
            intent.putExtra("ExcitedButtonCount",Count5);
            intent.putExtra("DisappointedButtonCount",Count6);

            intent.putExtra("TotalPresses",TotalCount);

            //we need to pass the timestamps
            intent.putStringArrayListExtra("timestamps1", new ArrayList<>(timestamps1));
            intent.putStringArrayListExtra("timestamps2", new ArrayList<>(timestamps2));
            intent.putStringArrayListExtra("timestamps3", new ArrayList<>(timestamps3));
            intent.putStringArrayListExtra("timestamps4", new ArrayList<>(timestamps4));
            intent.putStringArrayListExtra("timestamps5", new ArrayList<>(timestamps5));
            intent.putStringArrayListExtra("timestamps6", new ArrayList<>(timestamps6));


            startActivity(intent);
        });
    }

}