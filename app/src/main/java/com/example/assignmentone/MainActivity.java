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
        TextView Counter1 = findViewById(R.id.counter1); //find the counter1 by id

        HappyButton.setOnClickListener(v -> {
            Count1++;
            Counter1.setText(Count1);
            System.out.println("the button is pressed");


        });
    }

}