package com.example.assignmentone;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.TextView;

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

        System.out.println("the program is running");


        Button HappyButton = findViewById(R.id.button); //find the button by id
        Counter1 = findViewById(R.id.counter1); //find the counter1 by id

        HappyButton.setOnClickListener(v -> {
            Count1++;
            Counter1.setText(String.valueOf(Count1));


        });

        Button SadButton = findViewById(R.id.button2); //find the button by id
        Counter2 = findViewById(R.id.counter2); //find the counter1 by id

        SadButton.setOnClickListener(v -> {
            Count2++;
            Counter2.setText(String.valueOf(Count2));
        });

        Button GratefulButton = findViewById(R.id.button3); //find the button by id
        Counter3 = findViewById(R.id.counter3); //find the counter1 by id

        GratefulButton.setOnClickListener(v -> {
            Count3++;
            Counter3.setText(String.valueOf(Count3));
        });

        Button AngryButton = findViewById(R.id.button4); //find the button by id
        Counter4 = findViewById(R.id.counter4); //find the counter1 by id

        AngryButton.setOnClickListener(v -> {
            Count4++;
            Counter4.setText(String.valueOf(Count4));
        });

        Button ExcitedButton = findViewById(R.id.button5); //find the button by id
        Counter5 = findViewById(R.id.counter5); //find the counter1 by id

        ExcitedButton.setOnClickListener(v -> {
            Count5++;
            Counter5.setText(String.valueOf(Count5));
        });

        Button DisappointedButton = findViewById(R.id.button6); //find the button by id
        Counter6 = findViewById(R.id.counter6); //find the counter1 by id

        DisappointedButton.setOnClickListener(v -> {
            Count6++;
            Counter6.setText(String.valueOf(Count6));
        });
    }

}