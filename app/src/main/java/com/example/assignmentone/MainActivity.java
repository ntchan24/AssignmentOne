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

        // Restore saved state if available
        if (savedInstanceState != null) {
            Count1 = savedInstanceState.getInt("Count1", 0);
            Count2 = savedInstanceState.getInt("Count2", 0);
            Count3 = savedInstanceState.getInt("Count3", 0);
            Count4 = savedInstanceState.getInt("Count4", 0);
            Count5 = savedInstanceState.getInt("Count5", 0);
            Count6 = savedInstanceState.getInt("Count6", 0);
            TotalCount = savedInstanceState.getInt("TotalCount", 0);
            timestamps1 = savedInstanceState.getStringArrayList("timestamps1");
            timestamps2 = savedInstanceState.getStringArrayList("timestamps2");
            timestamps3 = savedInstanceState.getStringArrayList("timestamps3");
            timestamps4 = savedInstanceState.getStringArrayList("timestamps4");
            timestamps5 = savedInstanceState.getStringArrayList("timestamps5");
            timestamps6 = savedInstanceState.getStringArrayList("timestamps6");
            if (timestamps1 == null) timestamps1 = new ArrayList<>();
            if (timestamps2 == null) timestamps2 = new ArrayList<>();
            if (timestamps3 == null) timestamps3 = new ArrayList<>();
            if (timestamps4 == null) timestamps4 = new ArrayList<>();
            if (timestamps5 == null) timestamps5 = new ArrayList<>();
            if (timestamps6 == null) timestamps6 = new ArrayList<>();
        }

        //when each button is pressed, we want to show the incremented counter
        //add the timestamp into an arraylist that can be passed to the summary screen

        Button HappyButton = findViewById(R.id.button); //find the button by id
        Counter1 = findViewById(R.id.counter1); //find the counter1 by id
        if (Count1 > 0) Counter1.setText(String.valueOf(Count1));

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
        if (Count2 > 0) Counter2.setText(String.valueOf(Count2));

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
        if (Count3 > 0) Counter3.setText(String.valueOf(Count3));

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
        if (Count4 > 0) Counter4.setText(String.valueOf(Count4));

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
        if (Count5 > 0) Counter5.setText(String.valueOf(Count5));

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
        if (Count6 > 0) Counter6.setText(String.valueOf(Count6));

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


    //this part handles the session persistence between screens
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //stores these values in memory to preserve the state
        super.onSaveInstanceState(outState);
        outState.putInt("Count1", Count1); //uses a key val pair
        outState.putInt("Count2", Count2);
        outState.putInt("Count3", Count3);
        outState.putInt("Count4", Count4);
        outState.putInt("Count5", Count5);
        outState.putInt("Count6", Count6);
        outState.putInt("TotalCount", TotalCount);
        outState.putStringArrayList("timestamps1", new ArrayList<>(timestamps1));
        outState.putStringArrayList("timestamps2", new ArrayList<>(timestamps2));
        outState.putStringArrayList("timestamps3", new ArrayList<>(timestamps3));
        outState.putStringArrayList("timestamps4", new ArrayList<>(timestamps4));
        outState.putStringArrayList("timestamps5", new ArrayList<>(timestamps5));
        outState.putStringArrayList("timestamps6", new ArrayList<>(timestamps6));
    }



}